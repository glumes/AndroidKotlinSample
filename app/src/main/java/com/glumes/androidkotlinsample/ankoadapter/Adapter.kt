package com.glumes.androidkotlinsample.ankoadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalPadding
import org.jetbrains.anko.wrapContent

/**
 * Created by zhaoying on 2017/10/21.
 */

class Holder(val textview: TextView) : RecyclerView.ViewHolder(textview)

class Adapter(val arrayList: ArrayList<String> = ArrayList<String>()) : RecyclerView.Adapter<Holder>() {


    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(TextView(parent.context).apply {
            textSize = 20f
            background = ColorDrawable(Color.GREEN)
            verticalPadding = context.dip(8)
            isClickable = true
            layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
        })
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.textview.text = arrayList[position]
    }
}