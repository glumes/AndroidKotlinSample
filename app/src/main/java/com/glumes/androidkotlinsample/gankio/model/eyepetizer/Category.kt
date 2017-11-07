package com.glumes.androidkotlinsample.gankio.model.eyepetizer

import java.io.Serializable

/**
 * @Author  glumes
 */
data class Category(val id: Long, val name: String, val description: String, val bgPicture: String, val bgColor: String, val headerImage: String) : Serializable

data class HotCategory(val tabInfo: TabInfo) {
    data class TabInfo(val tabList: ArrayList<Tab>)
    data class Tab(val id: Long, val name: String, val apiUrl: String)
}