package com.glumes.androidkotlinsample.gankio.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.glumes.androidkotlinsample.BR
import com.glumes.androidkotlinsample.databinding.ItemFooterBinding

/**
 * @Author glumes
 */


const val ITEM_CONTENT: Int = 1
const val ITEM_FOOTER: Int = 2


class DataBindingViewHolder(var mBinding: ViewDataBinding) : RecyclerView.ViewHolder(mBinding.root) {

    fun bind(model: Any, handler: Any? = null) {
        mBinding.setVariable(BR.model, model)
        mBinding.setVariable(BR.handler, handler)
        mBinding.executePendingBindings()
    }

}

class FooterItemViewHolder(binding: ItemFooterBinding) : RecyclerView.ViewHolder(binding.root)

abstract class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()