package com.glumes.androidkotlinsample.anko.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.anko.data.ItemBean
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * @Author glumes
 */

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ItemBean) {
        itemView.item_text.text = item.content
        Glide.with(itemView.context).load(item.url).into(itemView.item_image)
    }

}

class Adapter(private val items: List<ItemBean>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items.get(position))
    }
}