package ru.amorzn63.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_code.*
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.utilits.AppTextWatcher
import ru.amorzn63.mytelegram.utilits.showToast


class EnterCodeFragment(val PhoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string: String = register_input_code.text.toString()
            if (string.length == 6) {
                verificateCode()
            }
        })
    }

    fun verificateCode() {
        showToast("OK")
    }

}
