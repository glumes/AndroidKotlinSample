package com.glumes.androidkotlinsample.gankio

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.glumes.androidkotlinsample.R
import com.google.vr.sdk.widgets.video.VrVideoEventListener
import com.google.vr.sdk.widgets.video.VrVideoView
import kotlinx.android.synthetic.main.activity_video_play.*

class VideoPlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)

        val options = VrVideoView.Options()
        options.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER
        var uri = Uri.parse("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=60174&editionType=high&source=qcloud")
        vr_video.loadVideo(uri, options)

        vr_video.setEventListener(object : VrVideoEventListener() {
            override fun onClick() {
                super.onClick()
            }

            override fun onLoadSuccess() {
                super.onLoadSuccess()
            }

            override fun onLoadError(errorMessage: String?) {
                super.onLoadError(errorMessage)
            }

            override fun onDisplayModeChanged(newDisplayMode: Int) {
                super.onDisplayModeChanged(newDisplayMode)
            }
        })
    }


    override fun onPause() {
        super.onPause()
        vr_video.pauseVideo()
    }

    override fun onResume() {
        super.onResume()
        vr_video.resumeRendering()
    }
}
