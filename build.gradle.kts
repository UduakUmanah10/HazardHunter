
plugins {
  //  kotlin("jvm") version "1.9.22" apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kolinter)
    alias(libs.plugins.compose.compiler) apply false

    //alias(libs.plugins.ksp) apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.25" apply false
    alias(libs.plugins.kover)
    id("com.android.library") version "8.1.4" apply false
    alias(libs.plugins.fire.base) apply false
    alias(libs.plugins.crashlytics) apply false


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
        classpath (libs.javapoet)
        classpath ("org.jetbrains.kotlin:kotlin-serialization:2.0.20")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51")
        //classpath ("com.google.protobuf:protobuf-gradle-plugin:0.8.19")

    }




}



subprojects {
    apply(from = "../buildscripts/detekt.gradle")
}






