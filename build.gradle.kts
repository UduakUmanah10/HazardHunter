
plugins {
    //kotlin("jvm") version "1.9.0" apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kolinter)
    //alias(libs.plugins.ksp) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false

    alias(libs.plugins.kover)
    id("com.android.library") version "8.1.2" apply false



}



buildscript{
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        maven( url = "https://jitpack.io")
    }


    dependencies {
        //classpath(kotlin("gradle-plugin", version = "1.9.0"))

        classpath(libs.detekt.gradle.plugin)
        classpath ("com.squareup:javapoet:1.13.0")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.9.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
        //classpath ("com.google.protobuf:protobuf-gradle-plugin:0.8.19")

    }


}

subprojects {
    apply(from = "../buildscripts/detekt.gradle")
}






