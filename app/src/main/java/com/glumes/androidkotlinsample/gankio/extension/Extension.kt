package com.glumes.androidkotlinsample.gankio.extension

import android.content.Context
import android.widget.Toast

/**
 * @Author glumes
 */

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

