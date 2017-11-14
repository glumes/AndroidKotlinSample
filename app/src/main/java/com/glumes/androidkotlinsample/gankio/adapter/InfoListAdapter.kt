package com.glumes.androidkotlinsample.gankio.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.ItemFooterBinding
import com.glumes.androidkotlinsample.databinding.ItemInfoMvvmBinding
import com.glumes.androidkotlinsample.gankio.base.*
import com.glumes.androidkotlinsample.gankio.eventhandler.EventHandler
import com.glumes.androidkotlinsample.gankio.model.BaseResult

/**
 * @Author  glumes
 */

class InfoListAdapter : BaseAdapter() {


    var mData: ArrayList<BaseResult> = ArrayList()

    val handler: EventHandler = EventHandler()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (position + 1 != itemCount) {
            (holder as DataBindingViewHolder).bind(mData[position], handler)
        }
    }

    override fun getItemCount(): Int {
        return if (mData.size == 0) 0 else mData.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_FOOTER) {
            val footerBinding: ItemFooterBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent!!.context),
                    R.layout.item_footer,
                    parent,
                    false
            )
            return FooterItemViewHolder(footerBinding)
        }

        val mBinding: ItemInfoMvvmBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent!!.context),
                R.layout.item_info_mvvm,
                parent,
                false
        )
        return DataBindingViewHolder(mBinding)

    }

    override fun getItemViewType(position: Int): Int {
        return if (position + 1 == itemCount) ITEM_FOOTER else ITEM_CONTENT
    }

    fun addData(data: BaseResult) {
        mData.add(data)
    }

    fun addData(data: List<BaseResult>) {
        mData.addAll(data)
    }
}

