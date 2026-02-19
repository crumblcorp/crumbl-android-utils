package com.crumbl.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class DopplerUtilsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Extension functions on ProviderFactory become available
        // once the plugin is on the classpath.
    }
}
