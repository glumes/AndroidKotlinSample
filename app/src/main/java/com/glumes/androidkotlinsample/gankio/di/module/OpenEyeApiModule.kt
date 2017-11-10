package com.glumes.androidkotlinsample.gankio.di.module

import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.net.OpenEyeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @Author glumes
 */

@Module
class OpenEyeApiModule {

    @Provides
    @FragmentScope
    fun provideOpenEyeApiService(retrofit: Retrofit): OpenEyeService {
        return retrofit.create(OpenEyeService::class.java)
    }
}