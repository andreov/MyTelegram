package ru.amorzn63.mytelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.amorzn63.mytelegram.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}