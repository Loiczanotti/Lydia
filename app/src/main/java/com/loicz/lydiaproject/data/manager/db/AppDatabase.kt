package com.loicz.lydiaproject.data.manager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.loicz.lydiaproject.data.model.db.*
import com.loicz.lydiaproject.data.model.db.converters.RoomConverters

private const val DATABASE_NAME = "Lydia_Database"

@Database(
    entities = [
        ContactDBEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(AppDatabase::class) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }.also { INSTANCE = it }
        }
    }
}