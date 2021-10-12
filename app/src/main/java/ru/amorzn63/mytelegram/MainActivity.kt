package ru.amorzn63.mytelegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.databinding.ActivityMainBinding
import ru.amorzn63.mytelegram.ui.fragments.ChatsFragment
import ru.amorzn63.mytelegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding  // объевляем переменную binding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    private lateinit var mAppDrawer: AppDrawer //Drawer

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
        if (false) {
            setSupportActionBar(mToolbar)  //прорисовка
            mAppDrawer.create()
            supportFragmentManager.beginTransaction()
                .replace(R.id.dataContainer, ChatsFragment())
                .commit()  // устанавливаем фрагмент в контейнер default
        } else {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initFileds() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar) // init Drawer
    }

}