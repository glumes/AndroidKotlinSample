package com.glumes.androidkotlinsample.gankio.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.databinding.FragmentInfoBinding
import com.glumes.androidkotlinsample.gankio.adapter.InfoListAdapter
import com.glumes.androidkotlinsample.gankio.di.component.DaggerFragmentComponent
import com.glumes.androidkotlinsample.gankio.di.module.FragmentModule
import com.glumes.androidkotlinsample.gankio.di.module.GankApiModule
import com.glumes.androidkotlinsample.gankio.listener.RecyclerViewScrollListener
import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.viewmodel.FragmentViewModel
import com.orhanobut.logger.Logger
import javax.inject.Inject

class InfoFragment : Fragment() {

    private var mType: String? = null
    private var mNum: Int? = 0
    private var mPage: Int? = 0

    private lateinit var mBinding: FragmentInfoBinding

    @Inject
    lateinit var adapter: InfoListAdapter

    @Inject
    lateinit var viewModel: FragmentViewModel

    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mType = arguments.getString(ARG_PARAM1)
            mNum = arguments.getInt(ARG_PARAM2)
            mPage = arguments.getInt(ARG_PARAM3)
        }
        DaggerFragmentComponent.builder()
                .appComponent(SampleApp.getInstance().appComponent)
                .fragmentModule(FragmentModule())
                .gankApiModule(GankApiModule())
                .build()
                .inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        mLayoutManager = LinearLayoutManager(context)
        mBinding.recyclerView.layoutManager = mLayoutManager
        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.adapter = adapter

        mBinding.viewmodel = viewModel
        mBinding.refreshLayout.setOnRefreshListener {
            mPage!!.inc()
            requestData()
        }
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
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData()
    }


    private fun requestData() {
        viewModel.requestData(mType!!, mNum!!, mPage!!)
                .doOnTerminate({
                    mBinding.refreshLayout.isRefreshing = false
                })
                .subscribe {
                    adapter.addData(it)
                    adapter.notifyDataSetChanged()
                }
    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        private val ARG_PARAM3 = "param3"

        fun newInstance(type: String, num: Int, page: Int): InfoFragment {
            val fragment = InfoFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, type)
            args.putInt(ARG_PARAM2, num)
            args.putInt(ARG_PARAM3, page)
            fragment.arguments = args
            return fragment
        }
    }
}
