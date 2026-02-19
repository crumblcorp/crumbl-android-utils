plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

gradlePlugin {
    plugins {
        create("dopplerUtils") {
            id = "com.crumbl.doppler-utils"
            implementationClass = "com.crumbl.gradle.DopplerUtilsPlugin"
        }
    }
}
