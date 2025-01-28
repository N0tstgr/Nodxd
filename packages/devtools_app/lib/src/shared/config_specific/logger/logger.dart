// Copyright 2019 The Flutter Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file or at https://developers.google.com/open-source/licenses/bsd.

export '_logger_io.dart' if (dart.library.js_interop) '_logger_web.dart';

enum LogLevel { debug, warning, error }
