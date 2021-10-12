package ru.amorzn63.mytelegram.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_enter_code.*
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.utilits.AppTextWatcher
import ru.amorzn63.mytelegram.utilits.showToast


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

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
