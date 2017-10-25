package com.glumes.androidkotlinsample.anko

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Toast
import com.glumes.androidkotlinsample.anko.ui.LoginUI
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        relativeLayout {
//            button("button in center") {
//                textSize = sp(6).toFloat()
//                onClick {
//                    longToast("you click button")
//                }
//            }.lparams {
//                centerInParent()
//            }
//        }

        verticalLayout {

            padding = dip(8)

            textView("account") {
                // 设置自己的属性
            }.lparams() {
                // 设置布局的参数
            }

            editText {

            }.lparams {
                // 可以不要小括号
            }

            textView("password") // 可以什么都不要，使用默认

            editText {

            }.lparams(
                    width = dip(100), height = ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

    }
}
