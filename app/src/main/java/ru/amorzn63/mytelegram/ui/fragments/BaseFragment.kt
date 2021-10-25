package ru.amorzn63.mytelegram.ui.fragments


import androidx.fragment.app.Fragment
import ru.amorzn63.mytelegram.MainActivity
import ru.amorzn63.mytelegram.utilits.APP_ACTIVITY

// базовый фрагмент для принятия макетов (layout)
open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}