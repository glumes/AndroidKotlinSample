package com.glumes.androidkotlinsample

import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.anko.AnkoActivity
import com.glumes.androidkotlinsample.ankoadapter.Adapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by zhaoying on 2017/10/21.
 */
class LoginActivityUI(val listAdapter: Adapter) : AnkoComponent<AnkoActivity> {

    override fun createView(ui: AnkoContext<AnkoActivity>) = ui.apply {

        relativeLayout {

            val emptyView = textView("Say Something outrageous") {
                textSize = 16f
                typeface = Typeface.MONOSPACE
            }.lparams {
                centerInParent()
            }


            ui.addView(button("button full"), ViewGroup.LayoutParams(matchParent, dip(30)))

            val pushPopButton = button("Push") {
                id = R.id.anko_button
            }.lparams {
                topMargin = dip(8)
                alignParentBottom()
                alignParentRight()
            }

            val inputEditText = editText {
                id = R.id.anko_edittext
            }.lparams(width = matchParent) {
                topMargin = dip(8)
                sameBottom(pushPopButton)
                leftOf(pushPopButton)
            }

            fun updateEmptyViewVisibility(recyclerView: RecyclerView) {
                if (doesListHaveItem(recyclerView)) {
                    emptyView.visibility = View.GONE
                } else {
                    emptyView.visibility = View.VISIBLE
                }
            }

            val list = recyclerView {
                val orientation = LinearLayoutManager.VERTICAL
                layoutManager = LinearLayoutManager(context, orientation, true)
                overScrollMode = View.OVER_SCROLL_NEVER
                adapter = listAdapter
                adapter.registerAdapterDataObserver(

                        object : RecyclerView.AdapterDataObserver() {

                            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                                updateEmptyViewVisibility(this@recyclerView)
                            }

                            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                                updateEmptyViewVisibility(this@recyclerView)
                            }
                        }
                )
            }.lparams(width = matchParent, height = wrapContent) {
                above(inputEditText)
            }

            pushPopButton.onClick {

            }

        }
    }.view


    private fun doesListHaveItem(list: RecyclerView?) = getListItemCount(list) > 0

    private fun getListItemCount(list: RecyclerView?) = list?.adapter?.itemCount ?: 0
}
