package com.loicz.lydiaproject.data.manager.db

import com.loicz.lydiaproject.data.model.db.ContactDBEntity

interface DBManager {
    fun getContactList(): List<ContactDBEntity>
    fun insertAllContacts(list: List<ContactDBEntity>)
    fun getContactByEmail(email: String): ContactDBEntity
}