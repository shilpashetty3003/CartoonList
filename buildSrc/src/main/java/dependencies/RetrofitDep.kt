package dependencies

object RetrofitDep {

    val retrofit= listOf(
        Dependencies.RetrofitDep.retrofit,
        Dependencies.RetrofitDep.moshiConverter,
        Dependencies.RetrofitDep.loggingInterceptor
    )
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore
    const val javax=Dependencies.JavaDep.javax


}