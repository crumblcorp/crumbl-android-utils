plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

gradlePlugin {
    plugins {
        create("dopplerSecrets") {
            id = "com.crumbl.doppler-secrets"
            implementationClass = "com.crumbl.gradle.DopplerSecretsPlugin"
        }
    }
}
