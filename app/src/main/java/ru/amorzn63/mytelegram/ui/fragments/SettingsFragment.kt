package ru.amorzn63.mytelegram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ru.amorzn63.mytelegram.MainActivity
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.utilits.AUTH
import ru.amorzn63.mytelegram.utilits.replaceActivity


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

    }

    // добавление меню во фрагменте (? - безопасный вызов)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.setting_action_menu, menu)
    }

    // выход из профиля
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.setting_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}