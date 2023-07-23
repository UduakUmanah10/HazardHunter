// Top-level build file where you can add configuration options common to all sub-projects/modules.
//@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kolinter)
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kover)
    id("com.android.library") version "8.0.2" apply false

}//true



buildscript{
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }

    dependencies {

        classpath(libs.detekt.gradle.plugin)
        classpath ("com.squareup:javapoet:1.13.0")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
        //classpath ("com.google.protobuf:protobuf-gradle-plugin:0.8.19")

    }


}

subprojects {
    apply(from = "../buildscripts/detekt.gradle")
}






