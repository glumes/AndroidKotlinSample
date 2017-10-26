package com.glumes.androidkotlinsample.anko

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.anko.ui.LoginUI
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.setContentView

class AnkoActivity : AppCompatActivity(), AnkoLogger {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        LoginUI().setContentView(this)

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

//        verticalLayout {
//
//            padding = dip(8)
//
//            val account = textView("account") {
//                id = R.id.account_text
//                textSize = sp(12).toFloat()
//                // 设置自己的属性
//            }.lparams() {
//                // 设置布局的参数
//            }
//
//            var name = editText() // 也可以什么都不设置，使用默认的设置
//
//            textView("password") {
//                id = R.id.password_text
//                onClick {
//                    account.setText("change account")
//                }
//            }
//
//            var pwd = editText {
//                hint = "input"
//            }.lparams(
//                    width = dip(100),
//                    height = ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//
//            button("login") {
//                onClick {
//                    if (name.text.toString().equals("name")
//                            && pwd.text.toString().equals("pwd")) {
//                        longToast("login....")
//                    } else {
//                        longToast("login failed")
//                    }
//                }
//            }
//        }


    }

}
