package com.glumes.androidkotlinsample.gankio.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * @Author glumes
 */

abstract class RecyclerViewScrollListener(var mLayoutManager: RecyclerView.LayoutManager, val footerNum: Int = 1) : RecyclerView.OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {


        var lastVisibleItem = (mLayoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

        if (lastVisibleItem == (mLayoutManager as LinearLayoutManager).itemCount - footerNum) {
            loadMore()
        }

    }

    abstract fun loadMore()

}

