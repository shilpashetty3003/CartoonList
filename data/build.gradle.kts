import dependencies.DataDep

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
dependencies{

    implementation(project(Modules.domain))
    implementation(DataDep.coroutineCore)
    implementation(DataDep.javax)


}