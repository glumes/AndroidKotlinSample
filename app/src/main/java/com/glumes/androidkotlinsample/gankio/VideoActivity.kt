package com.glumes.androidkotlinsample.gankio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.ItemListBean
import com.glumes.androidkotlinsample.gankio.util.VIDEO_MODEL_INFO
import com.orhanobut.logger.Logger

// 播放开眼视频内容
class VideoActivity : AppCompatActivity() {

    lateinit var data: ItemListBean.Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_video)

        data = intent.extras.getSerializable(VIDEO_MODEL_INFO) as ItemListBean.Data

        Logger.d("output is " + data.toString())

    }
}
