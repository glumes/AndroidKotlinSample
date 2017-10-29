package com.glumes.androidkotlinsample.gankio.di.component

import android.app.Application
import android.content.Context
import com.glumes.androidkotlinsample.gankio.di.module.AppModule
import com.glumes.androidkotlinsample.gankio.di.module.HttpModule
import com.google.gson.Gson
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @Author  glumes
 */

@Singleton
@Component(
        // Kotlin 中对 类类型 (class type)的引用，不同之处
        modules = arrayOf(
                AppModule::class,
                HttpModule::class
        )

)
interface AppComponent {

    fun context(): Context

    fun application(): Application

    fun gson(): Gson

    fun retrofit(): Retrofit

    fun okhttp(): OkHttpClient

}