package com.example.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {


     private fun createLoggingInterceptor(isDebug:Boolean):HttpLoggingInterceptor{
         return HttpLoggingInterceptor().apply {
             level=if(isDebug){
                 HttpLoggingInterceptor.Level.BASIC
             }else{
                 HttpLoggingInterceptor.Level.NONE
             }
         }
     }

    private fun createOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return  OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(OK_HTTP_TIMEOUT,TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT,TimeUnit.SECONDS)
            .build()
    }

    private fun createRetrofit(isDebug: Boolean,baseUrl:String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(createOkHttpClient(createLoggingInterceptor(isDebug)))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun create(isDebug:Boolean,baseUrl:String):CharacterService{
        return createRetrofit(isDebug,baseUrl).create(CharacterService::class.java)
    }
    private const val OK_HTTP_TIMEOUT=60L

}