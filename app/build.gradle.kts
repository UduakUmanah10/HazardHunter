@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kolinter)
    //alias(libs.plugins.hilt)
    alias(libs.plugins.kover)
    alias(libs.plugins.detekt)
    id("kotlin-parcelize")
    //id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id ("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.hazardhunt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hazardhunt"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    //hilt {
      //  enableAggregatingTask = true
    //}
}
kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
dependencies {
    implementation("com.maxkeppeler.sheets-compose-dialogs:core:1.2.0")

    // CALENDAR
    implementation("com.maxkeppeler.sheets-compose-dialogs:calendar:1.2.0")

    // CLOCK
    implementation("com.maxkeppeler.sheets-compose-dialogs:clock:1.2.0")

    implementation ("com.jakewharton.timber:timber:5.0.1")

    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.compose.foundation:foundation-android:+")
    implementation("androidx.compose.ui:ui-tooling-preview-android:1.6.0-alpha05")
    annotationProcessor("androidx.room:room-compiler:2.5.2")

    // To use Kotlin annotation processing tool (kapt)
    ksp("androidx.room:room-compiler:2.5.2")

    implementation("com.google.maps.android:maps-compose:2.11.4")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    // Optional Util Library
    implementation ("com.google.maps.android:maps-compose-utils:2.11.4")
    implementation("com.google.maps.android:maps-compose-widgets:2.11.4")

    // Optional Accompanist permissions to request permissions in compose
    implementation("com.google.accompanist:accompanist-permissions:0.31.5-beta")

    implementation (libs.charts)
    implementation(libs.androidx.datastore)
    implementation(libs.datastorelib)
    implementation(libs.androidx.core.splashscreen.v100)



   implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.serialization.json)

    // Pager and Indicators - Accompanist
    implementation (libs.accompanist.pager.indicators)

    // DataStore Preferences
    implementation(libs.datastorelib)
//    implementation(libs.splashscreen)
    implementation(libs.material2)
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.square.moshi.kotlin)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.converter.moshi)
    implementation(libs.hilt.android)
    implementation(libs.androidx.lifecycle)
    implementation(libs.navigation.library)
    implementation(libs.hilt.nav)
    implementation(libs.datastorelib)
    implementation(libs.viewmodel.lifecycle)
    implementation(libs.iconextended)
    implementation(libs.compose.ui.tooling)
    implementation(libs.lottie.compose)
   //implementation(project(":HomeFeature"))


    testImplementation(libs.junit)
    testImplementation(libs.mock.library)
    testImplementation(libs.googleTruth)
    testImplementation(libs.turbine)
    testImplementation(libs.coroutine.test)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.hilt.android.testing)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(libs.square.leakcanary)

    //ksp(libs.androidx.room.compiler)
    ksp(libs.hilt.compiler)
    ksp(libs.square.moshi.kotlin.codegen)
    kspAndroidTest(libs.hilt.android.compiler)
    implementation( libs.core)
    ksp(libs.ksp)

}

