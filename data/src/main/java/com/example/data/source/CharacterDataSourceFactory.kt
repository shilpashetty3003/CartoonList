package com.example.data.source

import com.example.data.repository.CharacterCache
import com.example.data.repository.CharacterDataSource
import javax.inject.Inject

open class CharacterDataSourceFactory @Inject constructor(
    private val characterCache: CharacterCache,
    private val remoteDatSource: CharacterRemoteDatSource,
    private val cacheDataSource: CharacterCacheDataSource
) {


    open suspend fun getDatStore(isCached:Boolean):CharacterDataSource{
        return if(isCached && !characterCache.isExpired()){
            getCacheDatSource()
        }else{
            getRemoteDatSource()
        }
    }
     fun getRemoteDatSource():CharacterDataSource{
        return remoteDatSource
    }
     fun getCacheDatSource():CharacterDataSource{
        return cacheDataSource
    }

}