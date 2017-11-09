package com.glumes.androidkotlinsample.gankio.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.FragmentVideoBinding

/**
 * @Author glumes
 */
class HomeFragment : BaseFragment() {

    lateinit var mBinding: FragmentVideoBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_video, container, false)

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}