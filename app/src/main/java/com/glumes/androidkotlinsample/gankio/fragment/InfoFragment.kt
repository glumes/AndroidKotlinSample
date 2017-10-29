package com.glumes.androidkotlinsample.gankio.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
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
import com.glumes.androidkotlinsample.gankio.model.BaseResult
import com.glumes.androidkotlinsample.gankio.viewmodel.FragmentViewModel
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

        mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.adapter = adapter

        mBinding.viewmodel = viewModel
        mBinding.refreshLayout.setOnRefreshListener {
            Thread(Runnable {
                Thread.sleep(300)
                mBinding.refreshLayout.isRefreshing = false
            }).start()
        }
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.requestData(mType!!, mNum!!, mPage!!)
                .subscribe {
                    adapter.mData = it as ArrayList<BaseResult>
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
