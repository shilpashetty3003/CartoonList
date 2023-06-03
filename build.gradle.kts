// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Config.Plugins.android) version(Versions.androidApplicationVersion) apply false
    id(Config.Plugins.androidLibrary) version(Versions.androidLibrary) apply false
    id(Config.Plugins.jetBrainsLibrary)  version(Versions.kotlinAndroid) apply false
    id(Config.Plugins.daggerHilt)  version(Versions.daggerHilt) apply false



}


