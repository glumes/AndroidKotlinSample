package com.glumes.androidkotlinsample.gankio

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.VitamioVideoPlayerBinding
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.ItemListBean
import com.glumes.androidkotlinsample.gankio.util.VIDEO_MODEL_INFO
import io.vov.vitamio.widget.MediaController

// 播放开眼视频内容
class VideoActivity : AppCompatActivity() {

    lateinit var data: ItemListBean.Data
    lateinit var mBinding: VitamioVideoPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.vitamio_video_player)

        data = intent.extras.getSerializable(VIDEO_MODEL_INFO) as ItemListBean.Data

        play()

    }

    fun play() {
        mBinding.videoView.setVideoPath(data.playUrl)
        mBinding.videoView.setMediaController(MediaController(this))
        mBinding.videoView.requestFocus()
        mBinding.videoView.setOnPreparedListener {
            it.setPlaybackSpeed(1.0f)
        }
    }
}
