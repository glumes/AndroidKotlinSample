package com.glumes.androidkotlinsample.gankio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.glumes.androidkotlinsample.R
import com.orhanobut.logger.Logger
import tv.danmaku.ijk.media.player.IjkMediaPlayer

class IJkPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ijk_player)

        IjkMediaPlayer.loadLibrariesOnce {
            Logger.d(it)
        }
        IjkMediaPlayer.native_profileBegin("libijkplayer.so")

    }
}
