plugins {
    id("com.android.library")
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kolinter)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.hazardhunt.homefeature"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    // Pager and Indicators - Accompanist
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.24.2-alpha")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation(libs.splashscreen)
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
    implementation("com.airbnb.android:lottie-compose:4.0.0")
//    implementation(project(":homescreen"))



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

    kapt(libs.androidx.room.compiler)
    kapt(libs.hilt.compiler)
    kapt(libs.square.moshi.kotlin.codegen)
    kaptAndroidTest(libs.hilt.android.compiler)
}
