package com.glumes.androidkotlinsample.anko.ui

import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView

/**
 * @Author glumes
 */


inline fun ViewManager.rectangleView(init: RectangleView.() -> Unit): RectangleView {
    return ankoView({ RectangleView(it) }, theme = 0, init = init)
}

