package ru.amorzn63.mytelegram.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// базовый фрагмент для принятия макетов (layout)
open class BaseFragment(val layout: Int) : Fragment() {

    private lateinit var mRootView: View  //ссылка на макеты

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(layout, container, false)
        return mRootView
    }

    override fun onStart() {
        super.onStart()
    }
}