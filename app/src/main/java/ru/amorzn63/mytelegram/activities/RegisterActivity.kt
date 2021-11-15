package ru.amorzn63.mytelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.amorzn63.mytelegram.R

import ru.amorzn63.mytelegram.databinding.ActivityRegisterBinding
import ru.amorzn63.mytelegram.ui.fragments.EnterPhoneNumberFragment
import ru.amorzn63.mytelegram.utilits.initFirebase
//import ru.amorzn63.mytelegram.utilits.replaceActivity
import ru.amorzn63.mytelegram.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_phone)
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}