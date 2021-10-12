package ru.amorzn63.mytelegram.utilits

import android.text.Editable
import android.text.TextWatcher

// пишем свой TextWatcher

class AppTextWatcher(val onSuccess: (Editable?) -> Unit) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        onSuccess(s)

    }
}