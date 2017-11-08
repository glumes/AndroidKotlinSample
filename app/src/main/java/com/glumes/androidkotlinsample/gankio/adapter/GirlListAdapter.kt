package com.glumes.androidkotlinsample.gankio.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.databinding.ItemGirlBinding

/**
 * @Author  glumes
 */

class GirlViewHolder(binding: ItemGirlBinding) : RecyclerView.ViewHolder(binding.root) {

}

class MeiziListAdapter : RecyclerView.Adapter<GirlViewHolder>() {
    override fun onBindViewHolder(holder: GirlViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GirlViewHolder? {
        return null
    }
}