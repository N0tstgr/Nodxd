// Copyright 2023 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'package:flutter/material.dart';

import '../shared/common_widgets.dart';
import '../shared/globals.dart';
import 'vs_code/flutter_panel.dart';

/// "Screens" that are intended for standalone use only, likely for embedding
/// directly in an IDE.
///
/// A standalone screen is one that will only be available at a specific route,
/// meaning that this screen will not be part of DevTools' normal navigation.
/// The only way to access a standalone screen is directly from the url.
enum StandaloneScreenType {
  editorSidebar,
  vsCodeFlutterPanel; // Legacy postMessage version, shows an upgrade message.

  Widget get screen {
    return switch (this) {
      StandaloneScreenType.vsCodeFlutterPanel => const Padding(
          padding: EdgeInsets.all(8.0),
          child: CenteredMessage(
            message: 'The Flutter sidebar for this SDK requires v3.96 or '
                'newer of the Dart VS Code extension',
          ),
        ),
      StandaloneScreenType.editorSidebar => ValueListenableBuilder(
          // TODO(dantup): Add a timeout here so if dtdManager.connection
          //  doesn't complete after some period we can give some kind of
          //  useful message.
          valueListenable: dtdManager.connection,
          builder: (context, data, _) {
            return data == null
                ? const CenteredCircularProgressIndicator()
                : DtdEditorSidebarPanel(data);
          },
        ),
    };
  }
}
