package com.glumes.androidkotlinsample.gankio.viewmodel

import com.glumes.androidkotlinsample.gankio.base.BaseViewModel
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.HomeBean
import com.glumes.androidkotlinsample.gankio.net.OpenEyeService
import io.reactivex.Observable

/**
 * @Author glumes
 */
class HomeViewModel(var openEyeService: OpenEyeService) : BaseViewModel {

    fun requestData(): Observable<HomeBean> {
        return openEyeService.getHomeData(OpenEyeService.HomeUrl, System.currentTimeMillis())
    }
}