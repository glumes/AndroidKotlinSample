package com.glumes.androidkotlinsample

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @Author glumes
 */
class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context

        fun getContext(): Context {
            return mContext
        }
    }

}