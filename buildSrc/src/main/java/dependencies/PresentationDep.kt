package dependencies

object PresentationDep {
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore
    const val javax = Dependencies.JavaDep.javax
    // Dagger-Hilt
    val daggerHilt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroid
    )
    val daggerHiltKapt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroidKapt,
        Dependencies.DaggerHiltDep.hiltKapt
    )
    val lifeCycle = listOf(
        Dependencies.LifeCycleDep.viewModelKtx,
        Dependencies.LifeCycleDep.liveDataKtx,
        Dependencies.LifeCycleDep.lifeCycleExtension,
        Dependencies.LifeCycleDep.lifeCycleRuntime,
        Dependencies.LifeCycleDep.lifeCycleRuntimeKtx
    )
    object Test{
        const val jUnit = Dependencies.Test.testCore
    }

}