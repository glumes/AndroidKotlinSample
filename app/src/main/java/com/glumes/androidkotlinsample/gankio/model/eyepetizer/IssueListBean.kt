package com.glumes.androidkotlinsample.gankio.model.eyepetizer

/**
 * @Author  glumes
 */
class IssueListBean(val releaseTime: Long,
                    val type: String,
                    val date: Long,
                    val publishTime: Long,
                    val itemList: List<ItemListBean>,
                    val count: Int)