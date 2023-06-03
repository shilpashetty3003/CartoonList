import dependencies.DomainDep

plugins {
    id("java-library")

    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
dependencies{
    implementation(DomainDep.coroutineCore)
    implementation(DomainDep.javax)
}