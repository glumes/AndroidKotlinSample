package com.glumes.androidkotlinsample.gankio.di.module

import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.net.GankIOApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @Author  glumes
 */

@Module
class GankApiModule {


    @Provides
    @FragmentScope
    fun provideGankApiService(retrofit: Retrofit): GankIOApiService {
        return retrofit.create(GankIOApiService::class.java)
    }
}