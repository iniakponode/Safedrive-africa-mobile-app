plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id ("kotlin-parcelize")


}

android {
    namespace = "com.uoa.sensordatacollection"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uoa.sensordatacollection"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose=true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
    implementation("androidx.compose.material3:material3-adaptive:1.0.0-alpha04")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.0.0-alpha02")

    // Dagar Hilt
//    implementation("com.google.dagger:hilt-android:2.48")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.47")
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("androidx.hilt:hilt-work:1.1.0")
//    implementation("androidx.hilt:hilt-common:1.1.0")
    ksp("com.google.dagger:hilt-android-compiler:2.42")
//    implementation("androidx.hilt:hilt-lifecycle-view-model:1.0.0-alpha03")
    ksp("androidx.hilt:hilt-compiler:1.1.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //        View Model Scope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

// Room dependencies
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.hilt:hilt-common:1.1.0")
    ksp("androidx.room:room-compiler:2.6.1")

    // Kotlin Parcelable
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.10")
//    implementation("org.jetbrains.kotlinx:kotlinx-parcelize-runtime:1.5.0")
//    ksp("org.jetbrains.kotlinx:kotlinx-parcelize-compiler:1.5.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

//    other project modules
//    implementation(project(":app"))


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}