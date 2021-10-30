package ru.amorzn63.mytelegram.utilits

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import ru.amorzn63.mytelegram.R


//функции-расширения

// показ сообщений во фрагментах
fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}

// переход между активити
fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

// вызов фрагмента из активити
fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.dataContainer, fragment)
            .commit()  // устанавливаем фрагмент в контейнер default
    } else {
        supportFragmentManager.beginTransaction()
            //.addToBackStack(null)
            .replace(R.id.dataContainer, fragment)
            .commit()


    }
}

// переход между фрагментами
fun Fragment.replaceFragment(fragment: Fragment) {
    this.parentFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.dataContainer, fragment)
        .commit()
}

fun hideKeyboard() {
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken, 0)
}

// Extension fun для загрузки фото
fun ImageView.downloadAndSetImage(url: String) {
    Picasso.get()  // загрузка картинки
        .load(url)
        .fit()
        .placeholder(R.drawable.default_photo)
        .into(this)
}