package com.glumes.androidkotlinsample.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.anko.ui.RectangleView
import com.glumes.androidkotlinsample.anko.ui.rectangleView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class AnkoFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // 加载 Fragment 的形式
//        linearLayout {
//            id = R.id.fragment_id
//            supportFragmentManager.beginTransaction().replace(id, AnkoFragment.newInstance()).commit()
//        }

        //加载自定义的 View
        relativeLayout {

            var view = rectangleView {
                id = R.id.custom_view_id
                size = 300  // 自定义 View 的属性设置
            }.lparams {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = dip(200)
                centerInParent()
            }

            button("change size") {
                onClick {
                    view.size = Random().nextInt(200) + 100
                    view.invalidate()
                }
            }.lparams {
                below(view)
                centerHorizontally()
            }
        }

    }
}
