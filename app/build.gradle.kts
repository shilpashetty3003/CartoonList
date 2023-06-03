import dependencies.UiDep

plugins {
    id(Config.Plugins.android)
    id(Config.Plugins.jetBrainsLibrary)
    id(Config.Plugins.kotlinKapt)
}

android {
//    namespace 'com.example.cartooncleanarchitecure'
    compileSdkVersion(Config.Android.androidCompileSdkVersion)

    defaultConfig {
        applicationId = Environments.Release.appId
        minSdkVersion(Config.Android.androidMinSDKVersion)
        targetSdkVersion(Config.Android.androidTargetSdkVersion)
        versionCode = Environments.Release.appVersionCode
        versionName = Environments.Release.appVersionName
        testInstrumentationRunner = Config.testRunner

        buildConfigField("String", "BASE_URL", "\"" + Environments.Release.baseUrl + "\"")
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    implementation(UiDep.coreKtx)
    implementation(UiDep.appCompat)
    implementation(UiDep.material)
    implementation(UiDep.constraint)
    implementation(UiDep.navigationFragmentKtx)
    implementation(UiDep.navigationUiKtx)
    implementation(UiDep.activityKtx)


    // LifeCycle
    UiDep.LifeCycle.forEach {
        implementation(it)
    }
    // Dagger-Hilt
    // Dagger-Hilt
    UiDep.DaggerHilt.forEach {
        implementation(it)
    }
    UiDep.DaggerHiltKapt.forEach {
        kapt(it)
    }
    // Coroutines
    UiDep.Coroutines.forEach {
        implementation(it)
    }
    // Glide
    implementation(UiDep.glide)
    kapt(UiDep.glideKapt)
    // Timber
    implementation(UiDep.timber)
    // Lottie animation
    implementation(UiDep.lottie)


    testImplementation(UiDep.Test.jUnit)
    androidTestImplementation(UiDep.Test.testExtJunit)
    androidTestImplementation(UiDep.Test.testEspresso)
}