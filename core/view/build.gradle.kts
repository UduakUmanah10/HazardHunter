plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.example.core.view"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.version.get()
    }
}

dependencies {
    api(libs.core.ktx)
    api(libs.bundles.compose)
    api(libs.bundles.compose.debug)
    api(libs.bundles.android.x)
    api(platform(libs.compose.bom))
    api(libs.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    debugImplementation(libs.bundles.compose.debug)
    testImplementation(libs.junit)
   androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
