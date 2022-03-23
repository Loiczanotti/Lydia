package com.loicz.lydiaproject.data.model.db

data class LoginDBEntity(
    val md5: String = "",
    val password: String = "",
    val salt: String = "",
    val sha1: String = "",
    val sha256: String = "",
    val username: String = ""
)