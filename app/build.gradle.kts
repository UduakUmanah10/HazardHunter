apply(plugin = "org.jetbrains.kotlin.android")
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kolinter)
    alias(libs.plugins.fire.base)
    alias(libs.plugins.kover)
    alias(libs.plugins.detekt)
    alias(libs.plugins.crashlytics)
    alias(libs.plugins.compose.compiler)
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
    id ("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.hazardhunt.safebuddy"
    compileSdk = libs.versions.target.sdk.version.get().toInt()

    defaultConfig {
        applicationId = "com.hazardhunt.safebuddy"
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
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
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.version.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions.unitTests{
        all { tests ->
            tests.useJUnitPlatform()
            tests.testLogging {
                events("passed", "failed", "skipped")
            }
        }

    }
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

    implementation(libs.bundles.compose)
    implementation(libs.bundles.compose.debug)
    implementation(libs.bundles.android.x)
    implementation(libs.play.services.location)
    implementation(libs.sheets.compose.dialogs.core)

    // CALENDAR
    implementation(libs.calendar)

    // CLOCK
    implementation(libs.clock)
    // 3 implementation (libs.androidx.material3)
    //implementation ("androidx.compose.material3:material3-window-size-class:1.1.2")
    implementation(libs.material3.window)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    // DURATION
    implementation(libs.duration)


    implementation (libs.timber)
   // 1 implementation(libs.activity.compose)
    //implementation("io.appwrite:sdk-for-android:4.0.0")

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.appcompat)
    //implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    annotationProcessor(libs.androidx.room.compiler)

    // To use Kotlin annotation processing tool (kapt)
    ksp(libs.androidx.room.compiler)

    implementation(libs.maps.compose)
    implementation(libs.play.services.maps)

    // Optional Util Library
    implementation (libs.maps.compose.utils)
    implementation(libs.maps.compose.widgets)

    // Optional Accompanist permissions to request permissions in compose
    implementation(libs.accompanist.permissions)

    implementation (libs.charts)
    implementation(libs.androidx.datastore)
    implementation(libs.datastorelib)
    implementation(libs.splashscreen)



   implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.serialization.json)

    // Pager and Indicators - Accompanist
    implementation (libs.accompanist.pager.indicators)

    // DataStore Preferences
    implementation(libs.datastorelib)
//    implementation(libs.splashscreen)
    // implementation(libs.material2)
   // implementation(libs.core.ktx)
    // implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    //implementation(libs.material3)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.square.moshi.kotlin)
    implementation(libs.square.retrofit)
    implementation(libs.square.gsonconverter)
    //implementation(libs.square.retrofit.converter.moshi)
    implementation(libs.hilt.android)
    //implementation(libs.androidx.lifecycle)
    implementation(libs.compose.navigation)
    implementation(libs.hilt.nav)
    implementation(libs.datastorelib)
    implementation(libs.viewmodel.lifecycle)
    implementation(libs.iconextended)
    // 2 implementation(libs.compose.ui.tooling)
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
    androidTestImplementation(libs.hilt.android.test)
    androidTestImplementation(libs.bundles.ui.testing)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(libs.square.leakcanary)

    //ksp(libs.androidx.room.compiler)
    ksp(libs.hilt.compiler)
    ksp(libs.square.moshi.kotlin.codegen)
    kspAndroidTest(libs.hilt.android.compiler)
    implementation( libs.core)
   // ksp(libs.ksp)

    testImplementation(libs.bundles.ui.testing)
    testImplementation(libs.bundles.unit.testing)
    testRuntimeOnly(libs.junit.jupiter.engine)



}

