/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.0.2/samples
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.springBoot) version PluginsVer.springBoot
    id(Plugins.springDependencyManagement) version PluginsVer.springDependencyManagement

    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"

    Plugins.kotlin
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
    }
}

group = "co.riiid"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("${Dependencies.javaxAnnotation}:${DependenciesVer.javaxAnnotation}")

    implementation("${Dependencies.kotlinxCoroutineCore}:${DependenciesVer.kotlinxCoroutineCore}")
}

subprojects {
    apply(plugin = Plugins.idea)
    apply(plugin = Plugins.kotlin)
    apply(plugin = Plugins.springDependencyManagement)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
