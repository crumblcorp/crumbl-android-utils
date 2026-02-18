# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is **crumbl_utils**, an Android utility library project for Crumbl. It is currently a freshly scaffolded project with build infrastructure in place but no utility code implemented yet.

## Build Commands

```bash
# Build the project
./gradlew build

# Run unit tests
./gradlew test

# Run a single unit test class
./gradlew test --tests "crumbl.android.utils.ExampleUnitTest"

# Run instrumented (on-device/emulator) tests
./gradlew connectedAndroidTest

# Clean build
./gradlew clean

# Assemble debug APK
./gradlew assembleDebug
```

## Architecture

- **Single module project** with an `:app` module (namespace: `crumbl.android.utils`)
- Source code goes in `app/src/main/java/crumbl/android/utils/`
- Unit tests in `app/src/test/java/crumbl/android/utils/` (JUnit 4)
- Instrumented tests in `app/src/androidTest/java/crumbl/android/utils/` (AndroidX Test + Espresso)

## Build Configuration

- **Gradle:** 9.2.1 with Kotlin DSL
- **AGP:** 9.0.1
- **Compile SDK:** 36 | **Min SDK:** 26 | **Target SDK:** 36
- **Java:** 11 (source and target compatibility)
- **JVM Toolchain:** Java 21 (for Gradle daemon)
- Dependencies managed via version catalog at `gradle/libs.versions.toml`
- Repository mode is `FAIL_ON_PROJECT_REPOS` — all repositories must be declared in `settings.gradle.kts`, not in module build files