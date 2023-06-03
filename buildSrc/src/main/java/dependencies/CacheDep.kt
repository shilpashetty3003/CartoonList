package dependencies

object CacheDep {
    val room = listOf(Dependencies.RoomDep.roomRuntime, Dependencies.RoomDep.roomKtx)
    const val roomKapt = Dependencies.RoomDep.roomCompilerKapt
    const val javax = Dependencies.JavaDep.javax
}