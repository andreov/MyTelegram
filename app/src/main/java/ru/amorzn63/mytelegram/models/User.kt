package ru.amorzn63.mytelegram.models

data class User(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var state: String = "",
    var photoUrl: String = "empty",  //для Picasso
    var phone: String = ""
)
