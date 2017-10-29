package com.glumes.androidkotlinsample

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.glumes.androidkotlinsample.gankio.di.component.AppComponent
import com.glumes.androidkotlinsample.gankio.di.component.DaggerAppComponent
import com.glumes.androidkotlinsample.gankio.di.module.AppModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @Author glumes
 */

class SampleApp : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        mContext = this

        sampleApp = this

        Logger.addLogAdapter(AndroidLogAdapter())

        initAppComponent()
    }


    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var sampleApp: SampleApp

        fun getContext(): Context {
            return mContext
        }

        fun getInstance(): SampleApp {
            return sampleApp
        }

    }


    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this))
                .build()
    }

}