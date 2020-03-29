plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

apply(plugin = "com.github.johnrengelman.shadow")

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "net.mamoe.mirai.console.wrapper.WrapperMain"
        attributes["Name"] = "Mirai Console Wrapper"
        attributes["Revision"] = Runtime.getRuntime().exec("git rev-parse HEAD")
            .inputStream.bufferedReader().readText().trim()
    }
}


kotlin {
    sourceSets {
        all {
            languageSettings.enableLanguageFeature("InlineClasses")

            languageSettings.useExperimentalAnnotation("kotlin.Experimental")
            languageSettings.useExperimentalAnnotation("kotlin.OptIn")
        }
    }
}

dependencies {
    api(kotlin("stdlib", Versions.Kotlin.stdlib))
    api(kotlin("reflect", Versions.Kotlin.stdlib))

    api(kotlinx("coroutines-core", Versions.Kotlin.coroutines))
    api(kotlinx("coroutines-swing", Versions.Kotlin.coroutines))

    api(ktor("client-cio", Versions.Kotlin.ktor))
    api(ktor("client-core", Versions.Kotlin.ktor))
    api(ktor("network", Versions.Kotlin.ktor))

    api("commons-cli:commons-cli:1.4")
}

version = Versions.Mirai.consoleWrapper

description = "Console with plugin support for mirai"
