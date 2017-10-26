package com.glumes.androidkotlinsample

import com.glumes.androidkotlinsample.anko.AnkoActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by zhaoying on 2017/10/17.
 */
class MyActivityUI : AnkoComponent<AnkoActivity> {

    override fun createView(ui: AnkoContext<AnkoActivity>) = ui.apply {
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }.view
}