package ru.amorzn63.mytelegram.models

data class User(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var status: String = "",
    var photoUrl: String = "empty",
    var phone: String = ""
)
