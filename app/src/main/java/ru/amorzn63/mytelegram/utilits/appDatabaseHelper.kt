package ru.amorzn63.mytelegram.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import ru.amorzn63.mytelegram.models.User

// константы для Firebase

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_UID: String //уникальный id пользателя
lateinit var REF_DATABASE_ROOT: DatabaseReference  // ссылка на базу данных
lateinit var REF_STORAGE_ROOT: StorageReference
lateinit var USER: User

// название полей базы
const val NODE_USERS = "users"
const val NODE_USERSNAMES = "usersmames"

const val FOLDER_PROFILE_IMAGE = "profile_image"


const val CHILD_ID = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"
const val CHILD_BIO = "bio"
const val CHILD_PHOTO_URL = "photoUrl"


fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    USER = User()
    CURRENT_UID = AUTH.currentUser?.uid.toString()
    REF_STORAGE_ROOT = FirebaseStorage.getInstance().reference

}