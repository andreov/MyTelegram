package ru.amorzn63.mytelegram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.amorzn63.mytelegram.MainActivity
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.utilits.AUTH
import ru.amorzn63.mytelegram.utilits.USER
import ru.amorzn63.mytelegram.utilits.replaceActivity
import ru.amorzn63.mytelegram.utilits.replaceFragment


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

//    private lateinit var mBinding: FragmentSettingsBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        mBinding = FragmentSettingsBinding.inflate(layoutInflater)
//        return mBinding.root
//    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true) // вкл меню в контексте
        initFields()

    }

    private fun initFields() {
        setting_text_bio.text = USER.bio
        setting_username.text = USER.username
        setting_text_phone.text = USER.phone
        setting_user_status.text = USER.status
        setting_fullname.text = USER.fullname
        setting_btn_username.setOnClickListener { replaceFragment(ChangeUserNameFragment()) }
        setting_btn_bio.setOnClickListener { replaceFragment(ChangeBioFragment()) }
    }

    // добавление меню во фрагменте (? - безопасный вызов)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.setting_action_menu, menu)
    }

    // мегю выходф из профиля и смены имени
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.setting_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.setting_menu_ch_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}