package ru.amorzn63.mytelegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.databinding.ActivityMainBinding
import ru.amorzn63.mytelegram.ui.fragments.ChatsFragment
import ru.amorzn63.mytelegram.ui.objects.AppDrawer
import ru.amorzn63.mytelegram.utilits.replaceActivity
import ru.amorzn63.mytelegram.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding  // объевляем переменную binding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    private lateinit var mAppDrawer: AppDrawer //Drawer
    private lateinit var mAutht: FirebaseAuth  //аутентификация через firebase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)  // инициализация binding
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFileds()   // инициализация переменных
        initFunc()
    }

    private fun initFunc() {
        if (mAutht.currentUser != null) {
            setSupportActionBar(mToolbar)  //прорисовка
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFileds() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar) // init Drawer
        mAutht = FirebaseAuth.getInstance()
    }
}