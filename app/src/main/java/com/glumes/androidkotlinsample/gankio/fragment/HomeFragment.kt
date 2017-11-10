package com.glumes.androidkotlinsample.gankio.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.SampleApp
import com.glumes.androidkotlinsample.gankio.adapter.HomeAdapter
import com.glumes.androidkotlinsample.gankio.di.component.DaggerHomeComponent
import com.glumes.androidkotlinsample.gankio.di.module.HomeModule
import com.glumes.androidkotlinsample.gankio.di.module.OpenEyeApiModule
import com.glumes.androidkotlinsample.gankio.viewmodel.HomeViewModel
import javax.inject.Inject

/**
 * @Author glumes
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var mAdapter: HomeAdapter

    @Inject
    lateinit var mViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_video, container, false)

        return mBinding.root
    }


    override fun requestData() {
    }

    override fun refresh() {

    }

    override fun inject() {
        DaggerHomeComponent.builder()
                .appComponent(SampleApp.getInstance().appComponent)
                .homeModule(HomeModule())
                .openEyeApiModule(OpenEyeApiModule())
                .build().inject(this)

    }
}