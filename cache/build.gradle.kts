import dependencies.CacheDep
import dependencies.PresentationDep


plugins {
    //id("java-library")
    //id("org.jetbrains.kotlin.jvm")
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.android)
    id(Config.Plugins.jetBrainsLibrary)
//    id("com.android.library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies{
    implementation(project(Modules.data))
    implementation(CacheDep.javax)

    implementation("androidx.room:room-runtime:2.3.0")
    implementation("androidx.room:room-ktx:2.2.4")
    kapt("androidx.room:room-compiler:2.3.0")
    testImplementation(PresentationDep.Test.jUnit)


}