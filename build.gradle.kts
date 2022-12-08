@file:Suppress("SpellCheckingInspection", "GradleDependency", "AndroidGradlePluginVersion")

/*
 * This file configures the build system that creates your Android app.
 * The syntax is Kotlin, but many of the idioms are likely unfamiliar.
 * You do not need to understand the contents of this file, nor should you modify it.
 * Any changes will be overwritten during official grading.
 */

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}
plugins {
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
tasks.register<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}
