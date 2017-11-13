package com.glumes.androidkotlinsample.gankio.viewmodel

import com.glumes.androidkotlinsample.gankio.base.BaseViewModel
import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.model.HttpResult
import com.glumes.androidkotlinsample.gankio.net.GankIOApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author  glumes
 */

class FragmentViewModel(var gankService: GankIOApiService) :BaseViewModel{


    fun requestData(type: String, num: Int, page: Int): Observable<List<BaseResult>> {

        return gankService.getDataByType(type, num, page)
                .map { t: HttpResult<List<BaseResult>> ->
                    t.results!!
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}