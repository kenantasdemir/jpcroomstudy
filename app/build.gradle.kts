import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.kenant42.jpcroomstudy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kenant42.jpcroomstudy"
        minSdk = 24
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    sourceSets {
        getByName("main") {
            assets {
                srcDirs("src/main/assets")
            }
        }
    }
}

dependencies {

    implementation ("androidx.room:room-runtime:2.6.0-alpha01")
    kapt ("androidx.room:room-compiler:2.6.0-alpha01")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


    //ViewModel
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha02")
//Live data
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.0-beta08")
    //Room
    implementation("androidx.room:room-runtime:2.4.0-rc01")
    //Coroutine
    implementation("androidx.room:room-ktx:2.4.0-rc01")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    //Preferences DataStore
// Lifecycle component & Kotlin coroutines components
//ViewModel & Live data




}