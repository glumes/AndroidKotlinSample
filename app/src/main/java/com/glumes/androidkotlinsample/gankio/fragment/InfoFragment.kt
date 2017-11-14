package com.glumes.androidkotlinsample.gankio.fragment

import android.os.Bundle
import android.view.View
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.gankio.adapter.InfoListAdapter
import com.glumes.androidkotlinsample.gankio.di.component.DaggerFragmentComponent
import com.glumes.androidkotlinsample.gankio.di.module.FragmentModule
import com.glumes.androidkotlinsample.gankio.di.module.GankApiModule
import com.glumes.androidkotlinsample.gankio.viewmodel.FragmentViewModel
import com.orhanobut.logger.Logger

class InfoFragment : BaseFragment() {


    private var mType: String? = null
    private var mNum: Int? = 0
    private var mPage: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mType = arguments.getString(ARG_PARAM1)
            mNum = arguments.getInt(ARG_PARAM2)
            mPage = arguments.getInt(ARG_PARAM3)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerView.adapter = (mAdapter as InfoListAdapter)
    }


    override fun requestData() {
        (mViewModel as FragmentViewModel).requestData(mType!!, mNum!!, mPage!!)
                .doOnTerminate({
                    mBinding.refreshLayout.isRefreshing = false
                })
                .subscribe({
                    (mAdapter as InfoListAdapter).addData(it)
                    (mAdapter as InfoListAdapter).notifyDataSetChanged()
                }, {
                    Logger.e(it.message)
                })
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

    override fun inject() {
        DaggerFragmentComponent.builder()
                .appComponent(SampleApp.getInstance().appComponent)
                .fragmentModule(FragmentModule())
                .gankApiModule(GankApiModule())
                .build()
                .inject(this)
    }

    override fun refresh() {
        mPage!!.inc()
        requestData()
    }


}
