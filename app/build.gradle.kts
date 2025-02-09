
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.chaquo.python")
}

android {
    namespace = "apw.sample.android.app"
    compileSdk = 33
    
    flavorDimensions += "pyVersion"
    
    productFlavors {
        create("py38") { dimension = "pyVersion" }
    }
    
    defaultConfig {
        applicationId = "apw.sample.android.app"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        ndk {
            abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
        }
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
    buildFeatures {
        viewBinding = true
        
    }
    
}

chaquopy {
    productFlavors {
        getByName("py38") { version = "3.8" }
    }
    defaultConfig {
        version = "3.8"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
}
