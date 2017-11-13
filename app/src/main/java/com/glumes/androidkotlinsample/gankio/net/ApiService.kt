package com.glumes.androidkotlinsample.gankio.net

import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.model.HttpResult
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * @Author  glumes
 */


interface GankIOApiService {


    @GET("data/{type}/{num}/{page}")
    fun getDataByType(@Path("type") type: String, @Path("num") num: Int, @Path("page") page: Int)
            : Observable<HttpResult<List<BaseResult>>>

    @GET("data/福利/{num}/{page}")
    fun getMeiZiImaga(@Path("num") num: Int, @Path("page") page: Int)
            : Observable<HttpResult<List<BaseResult>>>
}

interface OpenEyeService {


    companion object {
        val BaseUrl: String
            get() = "http://baobab.kaiyanapp.com/api/"

        val HomeUrl:String
            get() = "http://baobab.kaiyanapp.com/api/v2/feed?&num=1/"
    }


    /**
     * 获取分类
     */
    @GET("v4/categories")
    fun getCategory(): Observable<ArrayList<Category>>


    /**
     * 获取分类下的全部数据
     */
    @GET("v4/categories/videoList")
    fun getCategoryItemList(@Url url: String, @Query("id") id: Long): Observable<ItemListBean>


    /**
     * 热门的类别
     */
    @GET
    fun getHotCategory(@Url url: String): Observable<HotCategory>


    /**
     * 根据item id获取相关视频
     */
    @GET("v4/video/related?")
    fun getRelatedData(@Url url: String, @Query("id") id: Long): Observable<IssueListBean>


    /**
     * 根据nextpageurl请求数据
     */
    @GET
    fun getMoreHomeData(@Url url: String): Observable<HomeBean>


    /**
     * banner+一页数据，num=1
     */
    @GET
    fun getHomeData(@Url url:String,@Query("date") date: Long): Observable<HomeBean>


}