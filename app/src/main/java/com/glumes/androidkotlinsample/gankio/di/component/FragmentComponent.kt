package com.glumes.androidkotlinsample.gankio.di.component

import com.glumes.androidkotlinsample.gankio.di.module.FragmentModule
import com.glumes.androidkotlinsample.gankio.di.module.GankApiModule
import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.fragment.InfoFragment
import dagger.Component

/**
 * @Author  glumes
 */


@FragmentScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(FragmentModule::class, GankApiModule::class)
)

interface FragmentComponent {
    fun inject(fragment: InfoFragment)
}