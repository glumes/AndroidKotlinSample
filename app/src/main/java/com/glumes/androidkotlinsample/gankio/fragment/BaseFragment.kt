package com.glumes.androidkotlinsample.gankio.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.FragmentInfoBinding
import com.glumes.androidkotlinsample.gankio.listener.RecyclerViewScrollListener
import com.orhanobut.logger.Logger

/**
 * @Author glumes
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var mBinding: FragmentInfoBinding

    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLayoutManager = LinearLayoutManager(context)
        mBinding.recyclerView.layoutManager = mLayoutManager
        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.addOnScrollListener(object : RecyclerViewScrollListener(mLayoutManager, 1) {
            override fun loadMore() {
                Logger.d("in bottom")
                if (mBinding.refreshLayout.isRefreshing) {
                    mBinding.refreshLayout.isRefreshing = false
                } else {
                    requestData()
                }
            }
        })

        mBinding.refreshLayout.setOnRefreshListener {
            refresh()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData()
    }

    abstract fun requestData()

    abstract fun inject()

    abstract fun refresh()
}