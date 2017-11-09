package com.glumes.androidkotlinsample.gankio

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.ActivityOpenEyeBinding
import com.glumes.androidkotlinsample.gankio.adapter.OpenEyeFragmentAdapter

// 开眼视频瀑布流加载
class OpenEyeActivity : AppCompatActivity() {


    lateinit var mBinding: ActivityOpenEyeBinding
    lateinit var mAdapter: OpenEyeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_open_eye)
        mAdapter = OpenEyeFragmentAdapter(supportFragmentManager, this)
        mBinding.viewPager.adapter = mAdapter
        mBinding.viewPager.offscreenPageLimit = 3
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
    }
}
