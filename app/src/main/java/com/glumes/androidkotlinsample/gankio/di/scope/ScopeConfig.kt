package com.glumes.androidkotlinsample.gankio.di.scope

import javax.inject.Scope

/**
 * @Author  glumes
 */


/**
 * 声明注解 也与 java 有所不同
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope