package ru.amorzn63.mytelegram.ui.fragments

import android.view.*
import kotlinx.android.synthetic.main.fragment_change_user_name.*
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.amorzn63.mytelegram.MainActivity
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.utilits.*
import java.util.*


class ChangeUserNameFragment : BaseChangeFragment(R.layout.fragment_change_user_name) {

    lateinit var mNewUserName: String

    override fun onResume() {
        super.onResume()
        //setHasOptionsMenu(true)
        settings_input_user_name.setText(USER.username)

    }

    override fun change() {
        mNewUserName = settings_input_user_name.text.toString().lowercase(Locale.getDefault())
        if (mNewUserName.isEmpty()) {
            showToast("Поле пустое")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERSNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                    if (it.hasChild(mNewUserName)) {
                        showToast("Такой пользователь уже существует")
                    } else {
                        changeUsername()
                    }
                })

        }
    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERSNAMES).child(mNewUserName).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateCurentUsername()
                }
            }
    }

    private fun updateCurentUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME)
            .setValue(mNewUserName)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUsername()
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUsername() {
        REF_DATABASE_ROOT.child(NODE_USERSNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    parentFragmentManager.popBackStack()
                    USER.username = mNewUserName
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }
}