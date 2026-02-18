plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.github.crumbl"

gradlePlugin {
    plugins {
        create("dopplerSecrets") {
            id = "com.crumbl.doppler-secrets"
            implementationClass = "com.crumbl.gradle.DopplerSecretsPlugin"
        }
    }
}
