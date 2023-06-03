object Config {
    object Android {
        const val androidMinSDKVersion = 21
        const val androidTargetSdkVersion = 33
        const val androidCompileSdkVersion = 33
    }

    object Plugins {
        const val android = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlin = "kotlin"
        const val jetBrainsLibrary = "org.jetbrains.kotlin.android"
        const val daggerHilt="com.google.dagger.hilt.android"

        //id("com.google.dagger.hilt.android") version "2.44" apply false
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}