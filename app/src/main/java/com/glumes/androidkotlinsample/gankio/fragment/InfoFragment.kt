package com.glumes.androidkotlinsample.gankio.fragment

import android.app.ActivityOptions
import android.content.Intent
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
import com.glumes.androidkotlinsample.gankio.ArticleActivity
import com.glumes.androidkotlinsample.gankio.adapter.InfoListAdapter
import com.glumes.androidkotlinsample.gankio.adapter.onItemClickListener
import com.glumes.androidkotlinsample.gankio.di.component.DaggerFragmentComponent
import com.glumes.androidkotlinsample.gankio.di.module.FragmentModule
import com.glumes.androidkotlinsample.gankio.di.module.GankApiModule
import com.glumes.androidkotlinsample.gankio.listener.RecyclerViewScrollListener
import com.glumes.androidkotlinsample.gankio.util.ARTICLE_URL
import com.glumes.androidkotlinsample.gankio.viewmodel.FragmentViewModel
import com.orhanobut.logger.Logger
import javax.inject.Inject

class InfoFragment : BaseFragment() {


    private var mType: String? = null
    private var mNum: Int? = 0
    private var mPage: Int? = 0

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
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.mListener = object : onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(mBinding.root.context, ArticleActivity::class.java)
                intent.putExtra(ARTICLE_URL, adapter.mData[position].url)
                mBinding.root.context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
            }
        }

        mBinding.recyclerView.adapter = adapter

    }


    override fun requestData() {
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
