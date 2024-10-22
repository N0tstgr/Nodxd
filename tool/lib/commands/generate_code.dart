// Copyright 2023 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'dart:io';

import 'package:args/command_runner.dart';
import 'package:devtools_tool/model.dart';
import 'package:io/io.dart';
import 'package:path/path.dart' as path;

import '../utils.dart';

const _upgradeFlag = 'upgrade';

class GenerateCodeCommand extends Command {
  GenerateCodeCommand() {
    argParser.addFlag(
      _upgradeFlag,
      negatable: false,
      help:
          'Run pub upgrade on the DevTools packages before performing the code generation.',
    );
  }

  @override
  String get name => 'generate-code';

  @override
  String get description =>
      'Performs code generation by running `build_runner build` for required packages.';

  @override
  Future run() async {
    final repo = DevToolsRepo.getInstance();
    final processManager = ProcessManager();

    Future<void> runOverPackages(
      CliCommand command, {
      String? commandDescription,
    }) async {
      for (final packageName in ['devtools_app', 'devtools_test']) {
        if (commandDescription != null) {
          print('Running $commandDescription for $packageName...');
        }
        final directoryPath = path.join(repo.repoPath, 'packages', packageName);
        await processManager.runProcess(
          command,
          workingDirectory: directoryPath,
        );
      }
    }

    await runOverPackages(
      CliCommand.git(['clean', '-xfd', '.']),
      commandDescription: 'git clean',
    );

    final upgrade = argResults![_upgradeFlag] as bool;
    await processManager.runProcess(
      CliCommand.tool(['pub-get', '--only-main', if (upgrade) '--upgrade']),
    );

    await runOverPackages(
      CliCommand.flutter(
        [
          'pub',
          'run',
          'build_runner',
          'build',
          '--delete-conflicting-outputs',
        ],
      ),
      commandDescription: 'build_runner build',
    );

    print('Adding lint ignores for mocks');
    final mockFile = File(
      path.join(
        repo.repoPath,
        'packages',
        'devtools_test',
        'lib',
        'src',
        'mocks',
        'generated.mocks.dart',
      ),
    );
    var mockFileContents = mockFile.readAsStringSync();
    if (!mockFileContents.contains('require_trailing_commas')) {
      mockFileContents = mockFileContents.replaceFirst(
        '// ignore_for_file:',
        '// ignore_for_file: require_trailing_commas\n// ignore_for_file:',
      );
      mockFile.writeAsStringSync(mockFileContents);
    }
  }
}
