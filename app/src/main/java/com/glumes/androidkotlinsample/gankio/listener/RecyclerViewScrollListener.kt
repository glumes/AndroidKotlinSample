package com.glumes.androidkotlinsample.gankio.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.orhanobut.logger.Logger

/**
 * @Author glumes
 */

abstract class RecyclerViewScrollListener(var mLayoutManager: RecyclerView.LayoutManager,val footerNum:Int = 1) : RecyclerView.OnScrollListener() {


    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {


        var lastVisibleItem = (mLayoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

        Logger.d("last visibel item is " + lastVisibleItem)

        if (lastVisibleItem == (mLayoutManager as LinearLayoutManager).itemCount - footerNum ) {
            loadMore()
        }

    }

    abstract fun loadMore()

}

