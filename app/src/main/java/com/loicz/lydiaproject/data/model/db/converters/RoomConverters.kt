package com.loicz.lydiaproject.data.model.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.loicz.lydiaproject.data.model.db.*

object RoomConverters {

    @TypeConverter
    fun nameToStringJson(name: NameDBEntity): String {
        return Gson().toJson(name)
    }

    @TypeConverter
    fun locationToStringJson(location: LocationDBEntity): String {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun loginToStringJson(login: LoginDBEntity): String {
        return Gson().toJson(login)
    }

    @TypeConverter
    fun idToStringJson(id: IdDBEntity): String {
        return Gson().toJson(id)
    }

    @TypeConverter
    fun pictureToStringJson(picture: PictureDBEntity): String {
        return Gson().toJson(picture)
    }

    @TypeConverter
    fun stringJsonToName(json: String): NameDBEntity {
        return Gson().fromJson(json, NameDBEntity::class.java)
    }

    @TypeConverter
    fun stringJsonToLocation(json: String): LocationDBEntity {
        return Gson().fromJson(json, LocationDBEntity::class.java)
    }

    @TypeConverter
    fun stringJsonToLogin(json: String): LoginDBEntity {
        return Gson().fromJson(json, LoginDBEntity::class.java)
    }

    @TypeConverter
    fun stringJsonToId(json: String): IdDBEntity {
        return Gson().fromJson(json, IdDBEntity::class.java)
    }

    @TypeConverter
    fun stringJsonToPicture(json: String): PictureDBEntity {
        return Gson().fromJson(json, PictureDBEntity::class.java)
    }
}