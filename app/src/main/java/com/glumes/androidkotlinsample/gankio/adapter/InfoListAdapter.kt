package com.glumes.androidkotlinsample.gankio.adapter

import android.app.ActivityOptions
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.ItemFooterBinding
import com.glumes.androidkotlinsample.databinding.ItemInfoMvvmBinding
import com.glumes.androidkotlinsample.gankio.ArticleActivity
import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.util.articleUrl
import com.orhanobut.logger.Logger

/**
 * @Author  glumes
 */

const val ITEM_CONTENT: Int = 1
const val ITEM_FOOTER: Int = 2


interface onItemClickListener {
    fun onItemClick(position: Int)
}

class InfoItemViewHolder(binding: ItemInfoMvvmBinding) : RecyclerView.ViewHolder(binding.root) {

    val mBinding: ItemInfoMvvmBinding = binding

    fun bind(model: BaseResult) {
        mBinding.viewmodel = model
        mBinding.executePendingBindings()
    }
}

class FooterItemViewHolder(binding: ItemFooterBinding) : RecyclerView.ViewHolder(binding.root)

class InfoListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var mData: ArrayList<BaseResult> = ArrayList()

    var mListener: onItemClickListener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (position + 1 != itemCount) {
            if (holder is InfoItemViewHolder) {
                holder.bind(mData[position])
                if (mListener != null) {
                    holder.mBinding.root.setOnClickListener {
                        mListener!!.onItemClick(position)
                    }
                }
            }
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
            Logger.d("item_footer")
            return FooterItemViewHolder(footerBinding)
        }

        val mBinding: ItemInfoMvvmBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent!!.context),
                R.layout.item_info_mvvm,
                parent,
                false
        )
        return InfoItemViewHolder(mBinding)

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

