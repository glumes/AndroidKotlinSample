package com.glumes.androidkotlinsample.anko


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.verticalLayout


class AnkoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_anko, container, false)
        return UI {
            verticalLayout {
                editText()
                button("OK")
            }
        }.view
    }

    companion object {
        fun newInstance(): AnkoFragment {
            return AnkoFragment()
        }
    }
}
