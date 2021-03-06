package ru.amorzn63.mytelegram.ui.fragments

import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.models.CommonModel
import ru.amorzn63.mytelegram.utilits.APP_ACTIVITY


class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.GONE
    }
}