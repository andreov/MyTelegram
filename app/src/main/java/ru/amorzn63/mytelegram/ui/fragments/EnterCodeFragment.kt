package ru.amorzn63.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*
import ru.amorzn63.mytelegram.MainActivity
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.utilits.*


class EnterCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber // показ номер телефона в заголовке
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string: String = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        //showToast("OK")
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val uid: String = AUTH.currentUser?.uid.toString()  //получем id user
                val dataMap = mutableMapOf<String, Any>()  // map данных полей базы
                dataMap[CHILD_ID] = uid
                dataMap[CHILD_PHONE] = phoneNumber
                dataMap[CHILD_USERNAME] = uid

                REF_DATABASE_ROOT.child(NODE_PHONES).child(phoneNumber).setValue(uid)
                    .addOnFailureListener { showToast(it.message.toString()) }
                    .addOnSuccessListener {
                        REF_DATABASE_ROOT.child(NODE_USERS).child(uid)
                            .updateChildren(dataMap)  // заполняем удаленную базу
                            .addOnSuccessListener {
                                showToast("Добро пожаловать!")
                                (activity as RegisterActivity).replaceActivity(MainActivity())
                            }
                            .addOnFailureListener { showToast(it.message.toString()) }
                    }


            } else showToast(task.exception?.message.toString())  // если есть проблема auth
        }
    }
}
