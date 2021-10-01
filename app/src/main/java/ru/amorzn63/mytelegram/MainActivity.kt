package ru.amorzn63.mytelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import ru.amorzn63.mytelegram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding  // объевляем переменную binding
    private lateinit var mDrawer: Drawer // леременная выдвижного тулбара
    private lateinit var mHeader: AccountHeader // леременная верхняя часть выдвижки
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

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
        setSupportActionBar(mToolbar)  //прорисовка
        createHeadbar()   // создание верха выдвижки
        createDrawer()   //создание выдвижного меню
    }

    private fun createDrawer() {
        TODO("Not yet implemented")
    }

    private fun createHeadbar() {
        mHeader = AccountHeaderBuilder()  //создание профиля аккаунта
            .withActivity(this)
            .withHeaderBackground(R.drawable.header) // цвет хедара
            .addProfiles(
                ProfileDrawerItem().withName("Yura Petrov")
                    .withEmail("+79108888888")
            ).build()

    }

    private fun initFileds() {
        mToolbar = mBinding.mainToolbar
    }

}