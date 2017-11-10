package com.glumes.androidkotlinsample.gankio.di.component

import com.glumes.androidkotlinsample.gankio.di.module.FragmentModule
import com.glumes.androidkotlinsample.gankio.di.module.GankApiModule
import com.glumes.androidkotlinsample.gankio.di.module.HomeModule
import com.glumes.androidkotlinsample.gankio.di.module.OpenEyeApiModule
import com.glumes.androidkotlinsample.gankio.di.scope.FragmentScope
import com.glumes.androidkotlinsample.gankio.fragment.HomeFragment
import dagger.Component

/**
 * @Author glumes
 */

@FragmentScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(HomeModule::class, OpenEyeApiModule::class)
)

interface HomeComponent {
    fun inject(fragment: HomeFragment)
}