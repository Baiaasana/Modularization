package com.example.backend.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var id: Int,
    var username: String,
    var firstName: String,
    var lastName: String,
    var age: Int,
    val image: String
) : Parcelable
