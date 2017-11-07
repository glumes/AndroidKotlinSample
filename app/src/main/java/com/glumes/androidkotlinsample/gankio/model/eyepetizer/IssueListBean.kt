package com.glumes.androidkotlinsample.gankio.model.eyepetizer

/**
 * @Author  glumes
 */
class IssueListBean(val releaseTime: Int,
                    val type: String,
                    val date: Int,
                    val publishTime: Int,
                    val itemList: List<ItemListBean>,
                    val count: Int)