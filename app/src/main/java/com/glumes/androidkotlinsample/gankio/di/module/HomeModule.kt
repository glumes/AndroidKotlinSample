package com.glumes.androidkotlinsample.gankio.di.module

import com.glumes.androidkotlinsample.gankio.adapter.HomeAdapter
import com.glumes.androidkotlinsample.gankio.base.BaseAdapter
import com.glumes.androidkotlinsample.gankio.base.BaseViewModel
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
    fun provideAdapter(): BaseAdapter {
        return HomeAdapter()
    }

    @Provides
    @FragmentScope
    fun provideViewModel(openEyeService: OpenEyeService): BaseViewModel {
        return HomeViewModel(openEyeService)
    }
}