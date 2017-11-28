package com.glumes.androidkotlinsample.gankio.eventhandler

import android.app.ActivityOptions
import android.content.Intent
import android.view.View
import com.glumes.androidkotlinsample.gankio.ArticleActivity
import com.glumes.androidkotlinsample.gankio.GankIOActivity
import com.glumes.androidkotlinsample.gankio.VideoActivity
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.ItemListBean
import com.glumes.androidkotlinsample.gankio.util.ARTICLE_URL
import com.glumes.androidkotlinsample.gankio.util.VIDEO_MODEL_INFO

/**
 * @Author glumes
 */
class EventHandler {

    fun showArticle(view: View, url: String) {
        val intent = Intent(view.context, ArticleActivity::class.java)
        intent.putExtra(ARTICLE_URL, url)
        view.context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(GankIOActivity.getInstance()).toBundle())
    }


    fun playVideo(view: View, data: ItemListBean.Data) {
        val intent = Intent(view.context, VideoActivity::class.java)
        intent.putExtra(VIDEO_MODEL_INFO, data)
        view.context.startActivity(intent)
    }

}