package com.glumes.androidkotlinsample.anko.ui

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.anko.AnkoActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class LoginUI : AnkoComponent<AnkoActivity> {

    override fun createView(ui: AnkoContext<AnkoActivity>): View = with(ui) {

        return verticalLayout {

            padding = dip(8)

            textView("this is login ui") {
                id = R.id.login_tip
                textSize = sp(12).toFloat()
                typeface = Typeface.MONOSPACE
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView("Account") {
                id = R.id.account_text
                textSize = sp(12).toFloat()
            }

            editText {
                id = R.id.account_input
                textSize = sp(12).toFloat()
                hint = "input"
            }

            textView("Password") {
                id = R.id.password_text
                textSize = sp(12).toFloat()
            }

            editText {
                id = R.id.password_input
                textSize = sp(12).toFloat()
                hint = "input"
            }

            button("login") {
                onClick {
                    toast("please try again")
                }
            }

            rectangleView {
                size = 10
            }.lparams {
                width = dip(100)
                height = dip(100)
            }

        }
    }
}