package com.glumes.androidkotlinsample.anko

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.anko.adapter.Adapter
import com.glumes.androidkotlinsample.anko.data.ItemBean
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class RefreshListActivity : AppCompatActivity() {

    lateinit var dataList: List<ItemBean>

    val url: String = "http://pic142.nipic.com/file/20170930/2741225_113250543000_2.jpg"

    lateinit var mainHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        swipeRefreshLayout {

            setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN)
            onRefresh {
                mainHandler.postDelayed(Runnable {
                    isRefreshing = false
                }, 3000)
            }

            recyclerView {
                layoutManager = LinearLayoutManager(SampleApp.mContext)
                setHasFixedSize(true)
                adapter = Adapter(dataList)
            }
        }
    }

    fun initData() {
        dataList = listOf(
                ItemBean("title", url),
                ItemBean("title", url),
                ItemBean("title", url),
                ItemBean("title", url),
                ItemBean("title", url)
        )

        mainHandler = Handler()
    }
}
