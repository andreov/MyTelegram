package ru.amorzn63.mytelegram

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.amorzn63.mytelegram.activities.RegisterActivity
import ru.amorzn63.mytelegram.databinding.ActivityMainBinding
import ru.amorzn63.mytelegram.models.User
import ru.amorzn63.mytelegram.ui.fragments.ChatsFragment
import ru.amorzn63.mytelegram.ui.objects.AppDrawer
import ru.amorzn63.mytelegram.utilits.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding  // объевляем переменную binding
    lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    lateinit var mAppDrawer: AppDrawer //Drawer
    //была создана статическая переменная AUTH in FirebaseHelper
    //private lateinit var mAutht: FirebaseAuth  //аутентификация через firebase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)  // инициализация binding
        setContentView(mBinding.root)
        APP_ACTIVITY = this  //ссылка на kонтекст MainActivity
        initFirebase()
        initUser {  //  читаем базу даных при запуске приложения
            CoroutineScope(Dispatchers.IO).launch {
                initContacts()  //считываем контакты в корутине
            }
            initFileds()   // инициализация переменных
            initFunc()
        }

    }


    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)  //прорисовка
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFileds() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer() // init Drawer

    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }

    override fun onRequestPermissionsResult(   //вызываем окошко предоставления прав
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(
                APP_ACTIVITY,
                READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            initContacts()
        }
    }
}