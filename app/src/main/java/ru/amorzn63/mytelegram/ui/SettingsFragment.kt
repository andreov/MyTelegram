package ru.amorzn63.mytelegram.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.databinding.FragmentChatsBinding
import ru.amorzn63.mytelegram.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentSettingsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

    }


}