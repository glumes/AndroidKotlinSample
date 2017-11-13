package com.glumes.androidkotlinsample.gankio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.gankio.di.component.DaggerHomeComponent
import com.glumes.androidkotlinsample.gankio.di.module.HomeModule
import com.glumes.androidkotlinsample.gankio.di.module.OpenEyeApiModule
import com.glumes.androidkotlinsample.gankio.viewmodel.HomeViewModel
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * @Author glumes
 */
class HomeFragment : BaseFragment() {


    override fun requestData() {
        (mViewModel as HomeViewModel).requestData()
                .map {
                    Logger.d(it.nextPageUrl)
                    for (bean in it.issueList) {
                        Logger.d(bean.itemList.size)
                        Logger.d(bean.count)
                    }
                    return@map it.issueList
                }
                .flatMap {
                    Logger.d(it.size)
                    return@flatMap Observable.fromIterable(it)
                }
                .map {
                    return@map it.itemList
                }
                .flatMap {
                    return@flatMap Observable.fromIterable(it)
                }
                .filter {
                    it.type == "video"
                }
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Logger.d(it.type)
                }, {
                    Logger.d(it.message)
                })

    }

    override fun refresh() {

    }

    override fun inject() {
        DaggerHomeComponent.builder()
                .appComponent(SampleApp.getInstance().appComponent)
                .homeModule(HomeModule())
                .openEyeApiModule(OpenEyeApiModule())
                .build().inject(this)

    }
}