package com.loicz.lydiaproject.data.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface ContactDao {

    @Query("SELECT * FROM ContactDBEntity")
    fun getContacts(): List<ContactDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllContacts(contacts: List<ContactDBEntity>)

    @Query("DELETE FROM ContactDBEntity")
    fun deleteAll(): Int

    @Query("SELECT * FROM ContactDBEntity WHERE email = :email")
    fun getContactByEmail(email: String): ContactDBEntity
}