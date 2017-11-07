package com.glumes.androidkotlinsample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.gankio.ArticleActivity
import com.glumes.androidkotlinsample.gankio.util.ARTICLE_URL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra(ARTICLE_URL, "http://www.baidu.com/")
            startActivity(intent)
        })
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
