package com.loicz.lydiaproject.data.manager.db

import com.loicz.lydiaproject.data.model.db.ContactDBEntity
import javax.inject.Inject

class DBManagerImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : DBManager {
    override fun getContactList(): List<ContactDBEntity> {
        return appDatabase.contactDao().getContacts()
    }

    override fun insertAllContacts(list: List<ContactDBEntity>) {
        appDatabase.contactDao().insertAllContacts(list)
    }

    override fun getContactByEmail(email: String): ContactDBEntity {
        return appDatabase.contactDao().getContactByEmail(email)
    }
}