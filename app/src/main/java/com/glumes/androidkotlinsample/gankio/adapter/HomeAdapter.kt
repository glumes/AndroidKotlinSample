package com.glumes.androidkotlinsample.gankio.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.VideoItemLayoutBinding
import com.glumes.androidkotlinsample.gankio.base.BaseAdapter
import com.glumes.androidkotlinsample.gankio.base.DataBindingViewHolder
import com.glumes.androidkotlinsample.gankio.eventhandler.EventHandler
import com.glumes.androidkotlinsample.gankio.model.eyepetizer.ItemListBean


/**
 * @Author glumes
 */
class HomeAdapter : BaseAdapter() {

    val mData: ArrayList<ItemListBean> = ArrayList()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as DataBindingViewHolder).bind(mData[position], EventHandler())

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mBinding: VideoItemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent!!.context),
                R.layout.video_item_layout,
                parent,
                false
        )
        return DataBindingViewHolder(mBinding)
    }


    fun addData(data: ItemListBean) {
        mData.add(data)
    }


}