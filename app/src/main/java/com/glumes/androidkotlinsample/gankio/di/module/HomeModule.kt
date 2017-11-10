package com.glumes.androidkotlinsample.gankio.di.module

import com.glumes.androidkotlinsample.gankio.adapter.HomeAdapter
import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.net.OpenEyeService
import com.glumes.androidkotlinsample.gankio.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides

/**
 * @Author glumes
 */

@Module
class HomeModule {

    @Provides
    @FragmentScope
    fun provideAdapter(): HomeAdapter {
        return HomeAdapter()
    }

    @Provides
    @FragmentScope
    fun provideViewModel(openEyeService: OpenEyeService): HomeViewModel {
        return HomeViewModel(openEyeService)
    }
}