package com.glumes.androidkotlinsample.gankio.model.eyepetizer

/**
 * @Author  glumes
 */
data class HomeBean(val issueList: List<IssueListBean>,
                    val nextPageUrl: String,
                    val nextPublishTime: Long,
                    val newestIssueType: String,
                    var dialog: Any?)