// Copyright 2022 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'package:collection/collection.dart';
import 'package:file_selector/file_selector.dart';
import 'package:vm_service/vm_service.dart';

import '../../../../shared/analytics/analytics.dart' as ga;
import '../../../../shared/analytics/constants.dart' as gac;
import '../../../../shared/analytics/metrics.dart';
import '../../../../shared/memory/adapted_heap_data.dart';
import '../../../../shared/memory/class_name.dart';
import '../../../../shared/primitives/utils.dart';
import '../primitives/memory_timeline.dart';
import '../primitives/memory_utils.dart';

/// Heap path represented by classes only, without object details.
class ClassOnlyHeapPath {
  ClassOnlyHeapPath(HeapPath heapPath)
      : classes =
            heapPath.objects.map((o) => o.heapClass).toList(growable: false);
  final List<HeapClassName> classes;

  String toShortString({String? delimiter, bool inverted = false}) => _asString(
        data: classes.map((e) => e.className).toList(),
        delimiter: _delimiter(
          delimiter: delimiter,
          inverted: inverted,
          isLong: false,
        ),
        inverted: inverted,
        skipObject: true,
      );

  String toLongString({
    String? delimiter,
    bool inverted = false,
    bool hideStandard = false,
  }) {
    final List<String> data;
    bool justAddedEllipsis = false;
    if (hideStandard) {
      data = [];
      for (var item in classes.asMap().entries) {
        if (item.key == 0 ||
            item.key == classes.length - 1 ||
            !item.value.isCreatedByGoogle) {
          data.add(item.value.fullName);
          justAddedEllipsis = false;
        } else if (!justAddedEllipsis) {
          data.add('...');
          justAddedEllipsis = true;
        }
      }
    } else {
      data = classes.map((e) => e.fullName).toList();
    }

    return _asString(
      data: data,
      delimiter: _delimiter(
        delimiter: delimiter,
        inverted: inverted,
        isLong: true,
      ),
      inverted: inverted,
    );
  }

  static String _delimiter({
    required String? delimiter,
    required bool inverted,
    required bool isLong,
  }) {
    if (delimiter != null) return delimiter;
    if (isLong) {
      return inverted ? '\n← ' : '\n→ ';
    }
    return inverted ? ' ← ' : ' → ';
  }

  static String _asString({
    required List<String> data,
    required String delimiter,
    required bool inverted,
    bool skipObject = false,
  }) {
    data = data.joinWith(delimiter).toList();
    if (skipObject) data.removeAt(data.length - 1);
    if (inverted) data = data.reversed.toList();
    return data.join().trim();
  }

  late final _listEquality = const ListEquality<HeapClassName>().equals;

  @override
  bool operator ==(Object other) {
    if (other.runtimeType != runtimeType) {
      return false;
    }
    return other is ClassOnlyHeapPath && _listEquality(classes, other.classes);
  }

  @override
  late final int hashCode = Object.hashAll(classes);
}

abstract class SnapshotTaker {
  Future<AdaptedHeapData?> take();
}

/// This class is needed to make the snapshot taking operation mockable.
class SnapshotTakerRuntime extends SnapshotTaker {
  SnapshotTakerRuntime(this._timeline);

  final MemoryTimeline? _timeline;

  @override
  Future<AdaptedHeapData?> take() async {
    final snapshot = await snapshotMemoryInSelectedIsolate();
    _timeline?.addSnapshotEvent();
    if (snapshot == null) return null;
    final result = await _adaptSnapshotGaWrapper(snapshot);
    return result;
  }
}

class SnapshotTakerFromFile implements SnapshotTaker {
  SnapshotTakerFromFile(this._file);

  final XFile _file;

  @override
  Future<AdaptedHeapData?> take() async {
    final bytes = await _file.readAsBytes();
    return AdaptedHeapData.fromBytes(bytes);
  }
}

Future<AdaptedHeapData> _adaptSnapshotGaWrapper(HeapSnapshotGraph graph) async {
  late final AdaptedHeapData result;
  await ga.timeAsync(
    gac.memory,
    gac.MemoryTime.adaptSnapshot,
    asyncOperation: () async =>
        result = await AdaptedHeapData.fromHeapSnapshot(graph),
    screenMetricsProvider: () => MemoryScreenMetrics(
      heapObjectsTotal: graph.objects.length,
    ),
  );
  return result;
}

/// Mark the object as deeply immutable.
///
/// There is no strong protection from mutation, just some asserts.
mixin Sealable {
  /// See doc for the mixin [Sealable].
  void seal() {
    _isSealed = true;
  }

  /// See doc for the mixin [Sealable].
  bool get isSealed => _isSealed;
  bool _isSealed = false;
}
