package com.glumes.androidkotlinsample.gankio.fragment

import android.os.Bundle
import android.view.View
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.gankio.adapter.HomeAdapter
import com.glumes.androidkotlinsample.gankio.di.component.DaggerHomeComponent
import com.glumes.androidkotlinsample.gankio.di.module.HomeModule
import com.glumes.androidkotlinsample.gankio.di.module.OpenEyeApiModule
import com.glumes.androidkotlinsample.gankio.viewmodel.HomeViewModel
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author glumes
 */
class HomeFragment : BaseFragment() {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerView.adapter = (mAdapter as HomeAdapter)
    }


    override fun requestData() {
        (mViewModel as HomeViewModel).requestData()
                .map {
                    return@map it.issueList
                }
                .flatMap {
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    (mAdapter as HomeAdapter).addData(it)
                    mAdapter.notifyDataSetChanged()
                }, {
                    Logger.e(it.message)
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