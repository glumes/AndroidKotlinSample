package com.glumes.androidkotlinsample.gankio.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.glumes.androidkotlinsample.gankio.fragment.InfoFragment

/**
 * @Author  glumes
 */

const val num = 10
const val page = 1

class FragmentAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    lateinit var mContext: Context
    lateinit var mFragmentList: ArrayList<Fragment>
    private val titles: ArrayList<String> = arrayListOf("Android", "IOS", "前端")


    constructor(manager: FragmentManager, context: Context) : this(manager) {
        mContext = context
        mFragmentList = ArrayList()
        mFragmentList.add(InfoFragment.newInstance("Android", num, page))
        mFragmentList.add(InfoFragment.newInstance("iOS", num, page))
        mFragmentList.add(InfoFragment.newInstance("前端", num, page))
    }


    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}