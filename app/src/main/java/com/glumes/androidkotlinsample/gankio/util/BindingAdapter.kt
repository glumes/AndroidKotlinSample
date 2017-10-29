package com.glumes.androidkotlinsample.gankio.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.glumes.androidkotlinsample.R

/**
 * @Author  glumes
 */


object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageResource(view: ImageView, url: List<String>?) {

        if (url == null) {
            return
        }

        Glide.with(view.context)
                .load(url[0])
                .apply(RequestOptions().placeholder(R.mipmap.image_default).error(R.mipmap.image_default))
                .into(view)

    }
}

