package com.loicz.lydiaproject.data.model

data class Contact(
    val cell: String,
    val dob: Int,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Int
)