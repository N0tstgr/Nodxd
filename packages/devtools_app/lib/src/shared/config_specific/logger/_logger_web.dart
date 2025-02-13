// Copyright 2019 The Flutter Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file or at https://developers.google.com/open-source/licenses/bsd.

import 'dart:js_interop';

import 'package:web/web.dart';

import 'logger.dart';

void printToConsole(Object message, [LogLevel level = LogLevel.debug]) {
  final jsMessage = message.jsify();
  switch (level) {
    case LogLevel.debug:
      console.log(jsMessage);
      break;
    case LogLevel.warning:
      console.warn(jsMessage);
      break;
    case LogLevel.error:
      console.error(jsMessage);
  }
}
