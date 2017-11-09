package com.glumes.androidkotlinsample.gankio.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.glumes.androidkotlinsample.gankio.fragment.CategoryFragment
import com.glumes.androidkotlinsample.gankio.fragment.HotFragment
import com.glumes.androidkotlinsample.gankio.fragment.HomeFragment

/**
 * @Author glumes
 */
class OpenEyeFragmentAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {


    lateinit var mContext: Context

    lateinit var mFragmentList: ArrayList<Fragment>

    val titleList: ArrayList<String> = arrayListOf("开眼", "分类", "热门")

    constructor(manager: FragmentManager, content: Context) : this(manager) {
        mContext = content
        mFragmentList = ArrayList()
        mFragmentList.add(HomeFragment())
        mFragmentList.add(CategoryFragment())
        mFragmentList.add(HotFragment())
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}