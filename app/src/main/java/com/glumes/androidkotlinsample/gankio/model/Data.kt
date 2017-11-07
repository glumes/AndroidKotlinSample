package com.glumes.androidkotlinsample.gankio.model

import com.google.gson.annotations.SerializedName

/**
 * @Author  glumes
 */
data class BaseResult(var createdAt: String = "",
                      var images: List<String>? = null,
                      var publishedAt: String = "",
                      @SerializedName("_id")
                      var Id: String = "",
                      var source: String = "",
                      var used: Boolean = false,
                      var type: String = "",
                      var url: String = "",
                      var desc: String = "",
                      var who: String = "") {

    override fun toString(): String {
        return "BaseResult(createdAt='$createdAt', images=$images, publishedAt='$publishedAt', Id='$Id', source='$source', used=$used, type='$type', url='$url', desc='$desc', who='$who')"
    }
}


data class HttpResult<T>(val error: String? = null, var results: T? = null)

