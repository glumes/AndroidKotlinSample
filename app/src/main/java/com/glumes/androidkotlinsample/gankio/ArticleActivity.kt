package com.glumes.androidkotlinsample.gankio

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.view.Gravity
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.gankio.util.ARTICLE_URL
import com.orhanobut.logger.Logger

// 干货集中营文章加载
class ArticleActivity : AppCompatActivity() {

    var webview: WebView? = null

    var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_article)


        setAnimator()
        url = intent.getStringExtra(ARTICLE_URL)

        if (url == null) {
            url = "http://www.baidu.com/"
        }

        webview = findViewById(R.id.webview)

        webview!!.loadUrl(url)

        webview!!.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view!!.loadUrl(request!!.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Logger.d("onPageStarted")
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                Logger.d("onPageFinished")
                super.onPageFinished(view, url)
            }
        }


        webview!!.webChromeClient = object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                Logger.d("title is " + title!!)
                super.onReceivedTitle(view, title)
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                Logger.d("current progress is " + newProgress)
                super.onProgressChanged(view, newProgress)
            }
        }

    }

    private fun setAnimator() {
        val slide = Slide()
        slide.slideEdge = Gravity.LEFT
        slide.duration = 300
        window.enterTransition = slide
        window.exitTransition = slide
        window.reenterTransition = slide

    }

    override fun onDestroy() {
        super.onDestroy()
        if (webview != null) {
            webview!!.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
            webview!!.clearHistory()
            (webview!!.parent as ViewGroup).removeView(webview)
            webview!!.destroy()
            webview = null
        }
    }
}
