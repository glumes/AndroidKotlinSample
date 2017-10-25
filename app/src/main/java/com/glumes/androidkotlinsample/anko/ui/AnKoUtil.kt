package com.glumes.androidkotlinsample.anko.ui

import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.anko.AnkoActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by zhaoying on 2017/10/23.
 */
class AnKoUtil : AnkoComponent<AnkoActivity> {

    override fun createView(ui: AnkoContext<AnkoActivity>): View = with(ui) {

        return relativeLayout() {

            button("click") {
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
                onClick {
                    toast("click")
                }
            }
        }
    }
}