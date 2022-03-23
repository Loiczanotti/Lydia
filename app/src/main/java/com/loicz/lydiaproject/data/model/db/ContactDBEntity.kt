package com.loicz.lydiaproject.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.loicz.lydiaproject.data.model.*

@Entity
data class ContactDBEntity(
    val cell: String = "",
    val dob: Int = 0,
    @PrimaryKey
    val email: String= "",
    val gender: String= "",
    val id: IdDBEntity = IdDBEntity(),
    val location: LocationDBEntity = LocationDBEntity(),
    val login: LoginDBEntity = LoginDBEntity(),
    val name: NameDBEntity = NameDBEntity(),
    val nat: String= "",
    val phone: String= "",
    val picture: PictureDBEntity = PictureDBEntity(),
    val registered: Int = 0
)