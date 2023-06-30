// Top-level build file where you can add configuration options common to all sub-projects/modules.
//@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kolinter)
    alias(libs.plugins.ksp) apply false

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
    }


}

subprojects {
    apply(from = "../buildscripts/detekt.gradle")
}


