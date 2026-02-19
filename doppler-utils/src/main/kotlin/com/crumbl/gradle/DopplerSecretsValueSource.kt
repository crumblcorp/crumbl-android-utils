package com.crumbl.gradle

import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.gradle.api.provider.ValueSource
import org.gradle.api.provider.ValueSourceParameters

abstract class DopplerSecretsValueSource : ValueSource<String, DopplerSecretsValueSource.Params> {
    interface Params : ValueSourceParameters {
        val project: Property<String>
        val config: Property<String>
    }

    override fun obtain(): String {
        return try {
            val process = ProcessBuilder(
                "doppler", "secrets", "download",
                "--project", parameters.project.get(),
                "--config", parameters.config.get(),
                "--format", "json",
                "--no-file"
            ).start()
            val output = process.inputStream.bufferedReader().readText()
            if (process.waitFor() == 0) output else "{}"
        } catch (_: Exception) {
            "{}"
        }
    }
}

fun ProviderFactory.dopplerSecrets(project: String, config: String): Provider<Map<String, String>> {
    return of(DopplerSecretsValueSource::class.java) {
        parameters.project.set(project)
        parameters.config.set(config)
    }.map { json ->
        @Suppress("UNCHECKED_CAST")
        (groovy.json.JsonSlurper().parseText(json) as Map<String, Any>)
            .mapValues { (_, value) -> value.toString() }
    }
}
