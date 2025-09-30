plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose) // <-- required for Kotlin 2.x + Compose
}

android {
    namespace = "com.example.sentraedgevaultdemo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.sentraedgevaultdemo"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }
    }

    // <-- These belong at the android{} level (NOT inside defaultConfig)
    buildFeatures { compose = true }
    // With Kotlin 2.x, DO NOT set composeOptions/compilerExtensionVersion.

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions { jvmTarget = "11" }

    externalNativeBuild {
        cmake {
            // CMakeLists.txt is at project root, so go up ONE level from :app
            path = file("../CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    // Compose BOM controls versions for all Compose artifacts below
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.9.2")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
