package ru.amorzn63.mytelegram.ui.fragments

import kotlinx.android.synthetic.main.fragment_change_bio.*
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.utilits.*


class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_BIO).setValue(newBio)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast(getString(R.string.toast_data_update))
                    USER.bio = newBio
                    parentFragmentManager.popBackStack()
                }
            }
    }
}