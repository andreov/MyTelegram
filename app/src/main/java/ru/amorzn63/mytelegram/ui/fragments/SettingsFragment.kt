package ru.amorzn63.mytelegram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import ru.amorzn63.mytelegram.R


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
}