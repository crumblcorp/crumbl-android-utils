# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**crumbl-android-utils** is a multi-module Gradle project for Crumbl containing:

1. **`:doppler-secrets`** — A Gradle plugin that wraps the Doppler CLI as a `ValueSource` for build-time secret fetching
2. **`:utils`** — An Android library module (placeholder for future runtime utility code)

Both modules publish via JitPack from the same Git tag, so they always share the same version.

## Build Commands

```bash
# Build everything
./gradlew build

# Build only the Gradle plugin
./gradlew :doppler-secrets:build

# Build only the Android library
./gradlew :utils:build

# Clean build
./gradlew clean
```

## Architecture

### `doppler-secrets/` — Gradle Plugin
- Plugin ID: `com.crumbl.doppler-secrets`
- Source: `doppler-secrets/src/main/kotlin/com/crumbl/gradle/`
- `DopplerSecretsPlugin.kt` — No-op plugin that puts the extension function on the classpath
- `DopplerSecretsValueSource.kt` — Gradle `ValueSource` that shells out to `doppler secrets download`; includes `ProviderFactory.dopplerSecrets()` extension
- Uses `kotlin-dsl`, `java-gradle-plugin`, and `maven-publish` plugins

### `utils/` — Android Library
- Namespace: `crumbl.android.utils`
- Source: `utils/src/main/java/crumbl/android/utils/`
- Currently empty — scaffold for future utility code

## Build Configuration

- **Gradle:** 9.2.1 with Kotlin DSL
- **AGP:** 9.0.1 (for `utils` module)
- **Compile SDK:** 36 | **Min SDK:** 26
- **Java:** 11 (source and target compatibility)
- Dependencies managed via version catalog at `gradle/libs.versions.toml`
- Repository mode is `FAIL_ON_PROJECT_REPOS` — all repositories must be declared in `settings.gradle.kts`, not in module build files

## Consumer Usage

```kotlin
// Consumer's settings.gradle.kts
pluginManagement {
    repositories {
        maven("https://jitpack.io")
    }
}

// Consumer's build.gradle.kts
plugins {
    id("com.crumbl.doppler-secrets") version "<tag>"
}

// Then in build logic:
val secrets = providers.dopplerSecrets(project = "my-project", config = "dev")
```
