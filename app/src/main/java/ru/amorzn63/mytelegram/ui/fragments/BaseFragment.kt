package ru.amorzn63.mytelegram.ui.fragments


import androidx.fragment.app.Fragment
import ru.amorzn63.mytelegram.MainActivity

// базовый фрагмент для принятия макетов (layout)
open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mAppDrawer.enableDrawer()
    }
}