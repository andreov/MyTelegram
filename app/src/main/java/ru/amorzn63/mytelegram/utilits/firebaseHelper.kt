package ru.amorzn63.mytelegram.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.amorzn63.mytelegram.models.User

// константы для Firebase

lateinit var AUTH: FirebaseAuth
lateinit var UID: String //уникальный id пользателя
lateinit var REF_DATABASE_ROOT: DatabaseReference  // ссылка на базу данных
lateinit var USER: User

// название полей базы
const val NODE_USERS = "users"
const val CHILD_ID = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"


fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    USER = User()
    UID = AUTH.currentUser?.uid.toString()

}