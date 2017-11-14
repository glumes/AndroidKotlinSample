package com.glumes.androidkotlinsample.gankio.eventhandler

import android.app.ActivityOptions
import android.content.Intent
import android.view.View
import com.glumes.androidkotlinsample.gankio.ArticleActivity
import com.glumes.androidkotlinsample.gankio.GankIOActivity
import com.glumes.androidkotlinsample.gankio.util.ARTICLE_URL

/**
 * @Author glumes
 */
class EventHandler {

    fun showArticle(view: View, url: String) {
        val intent = Intent(view.context, ArticleActivity::class.java)
        intent.putExtra(ARTICLE_URL, url)
        view.context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(GankIOActivity.getInstance()).toBundle())
    }


}