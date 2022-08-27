plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    compileSdk = AndroidProjectConfig.compileSdk

    defaultConfig {
        minSdk = AndroidProjectConfig.minSdk
        targetSdk = AndroidProjectConfig.targetSdk

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    flavorDimensions += listOf("default")
    productFlavors {
        create("production") {
            dimension = "default"
            buildConfigField("String", "BASE_URL", "\"http://75.101.213.57/\"")
            buildConfigField("String", "APPLICATION_ID", "\"$AndroidProjectConfig.applicationId\"")
        }
    }
}

dependencies {

    api(AndroidLibraries.coreKtx)
    api(AndroidLibraries.androidxAppCompat)
    api(AndroidLibraries.googleAndroidMaterial)
    api(AndroidLibraries.androidxConstraintLayout)

    testApi(TestingLibraries.jUnit)
    androidTestApi(TestingLibraries.androidJUnit)
    androidTestApi(TestingLibraries.espressoCore)

    //view model and lifecycle stuffs
    api(AndroidLibraries.lifecycleViewModelKtx)
    api(AndroidLibraries.lifecycleLiveDataKtx)
    api(AndroidLibraries.lifecycleRuntimeKtx)

    api(AndroidLibraries.retrofitConverterGson)
    api(AndroidLibraries.retrofit2)

    //coroutine
    api(AndroidLibraries.coroutineCore)
    api(AndroidLibraries.coroutineAndroid)

    //datastore
    api(AndroidLibraries.jetpackDatastore)

    //gson
    api(AndroidLibraries.gson)

    //koin
    api(AndroidLibraries.koinAndroid)

    //coil
    api(AndroidLibraries.coil)


    //core module
    api(project(":styling"))

}