package com.glumes.androidkotlinsample.gankio

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.glumes.androidkotlinsample.R
import com.glumes.androidkotlinsample.databinding.ActivityGankIoBinding
import com.glumes.androidkotlinsample.gankio.adapter.GankIOFragmentAdapter

class GankIOActivity : AppCompatActivity() {

    // Kotlin 使用 databinding 的方式发生了一些微妙的变化
    private lateinit var mBinding: ActivityGankIoBinding

    private lateinit var mAdapter: GankIOFragmentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_gank_io)

        mAdapter = GankIOFragmentAdapter(supportFragmentManager, this)

        mBinding.viewPager.adapter = mAdapter
        mBinding.viewPager.offscreenPageLimit = 3
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE


    }
}
