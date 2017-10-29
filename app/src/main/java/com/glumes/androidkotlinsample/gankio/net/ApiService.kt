package com.glumes.androidkotlinsample.gankio.net

import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.model.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author  glumes
 */
interface GankIOApiService {


    @GET("data/{type}/{num}/{page}")
    fun getDataByType(@Path("type") type: String, @Path("num") num: Int, @Path("page") page: Int)
            : Observable<HttpResult<List<BaseResult>>>

}