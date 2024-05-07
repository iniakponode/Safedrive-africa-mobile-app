plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.uoa.deviceprofile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uoa.deviceprofile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    defaultConfig{
        multiDexEnabled=true
    }

    dependencies {

        //    other project modules
        implementation(project(":co"))
//        ksp dependencies
        implementation("com.google.devtools.ksp:symbol-processing-api:1.9.22-1.0.17")

//        Core KTX
        implementation("androidx.core:core-ktx:1.13.1")

// multiDex implementation.
    implementation("androidx.multidex:multidex:2.0.1")

//        UI
        implementation("androidx.compose.ui:ui:1.6.7") // Use the latest version
        implementation("androidx.compose.material:material:1.6.7") // For Material Design components
        implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("androidx.recyclerview:recyclerview:1.3.2")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("com.google.android.material:material:1.12.0")


//    Live Data
//        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
//        implementation("androidx.lifecycle:lifecycle-runtime-ktx library")
//        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
//        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
        implementation ("androidx.compose.runtime:runtime-livedata:1.6.7")


        // Dagar Hilt
        implementation("com.google.dagger:hilt-android:2.51")
        ksp("com.google.dagger:hilt-android-compiler:2.42")
        // https://mvnrepository.com/artifact/androidx.hilt/hilt-lifecycle-viewmodel
        implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

//        implementation("androidx.hilt:hilt-lifecycle-view-model:1.0.0-alpha03")
//        ksp("androidx.hilt:hilt-compiler:1.2.0")
        implementation("com.google.dagger:hilt-android-gradle-plugin:2.51")
        implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

        //    JetPack Compose
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics:1.6.7")
        implementation("androidx.compose.ui:ui-graphics:1.6.7")
        implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
//        implementation("androidx.compose.material3:material3")


// Room dependencies
        implementation("androidx.room:room-runtime:2.6.1")
        ksp("androidx.room:room-compiler:2.6.1")

        // Kotlin Parcelable
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.20")
//        implementation("org.jetbrains.kotlinx:kotlinx-parcelize-runtime:1.5.0")
//        ksp("org.jetbrains.kotlinx:kotlinx-parcelize-compiler:1.5.0")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
        implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
        implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
        implementation("io.reactivex.rxjava2:rxjava:2.2.10")
        implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    }
}
