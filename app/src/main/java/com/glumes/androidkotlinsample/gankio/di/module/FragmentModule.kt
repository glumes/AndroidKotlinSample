package com.glumes.androidkotlinsample.gankio.di.module

import com.glumes.androidkotlinsample.gankio.adapter.InfoListAdapter
import com.glumes.androidkotlinsample.gankio.base.BaseAdapter
import com.glumes.androidkotlinsample.gankio.base.BaseViewModel
import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.net.GankIOApiService
import com.glumes.androidkotlinsample.gankio.viewmodel.FragmentViewModel
import dagger.Module
import dagger.Provides

/**
 * @Author  glumes
 */

@Module
class FragmentModule {

    @Provides
    @FragmentScope
    fun provideAdapter(): BaseAdapter {
        return InfoListAdapter()
    }

    @Provides
    @FragmentScope
    fun provideFragmentViewModel(gankService: GankIOApiService): BaseViewModel {
        return FragmentViewModel(gankService)
    }


}