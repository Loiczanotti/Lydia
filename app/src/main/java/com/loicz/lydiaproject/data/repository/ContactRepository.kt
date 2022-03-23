package com.loicz.lydiaproject.data.repository

import com.loicz.lydiaproject.data.exceptions.NetworkConnectException
import com.loicz.lydiaproject.data.manager.api.ContactManager
import com.loicz.lydiaproject.data.manager.db.DBManager
import com.loicz.lydiaproject.data.mapper.db.ContactDBEntityDataMapper
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.data.model.ResultContact
import dagger.Reusable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Reusable
class ContactRepository @Inject constructor(
    private val contactManager: ContactManager,
    private val dbManager: DBManager,
    private val contactDBEntityDataMapper: ContactDBEntityDataMapper
) {

    fun getContactsByPage(page: Int, pageSize: Int): Single<List<Contact>> {
        return Single.defer {
            contactManager.getContactsByPage(page, pageSize).map {
                it.contacts
            }.doOnSuccess { contacts ->
                dbManager.insertAllContacts(
                    contactDBEntityDataMapper.transformModelListToDBEntity(
                        contacts
                    )
                )
            }
        }
    }

    fun getContactsFromDatabase(): Single<List<Contact>> {
        return Single.defer {
            val contactList = dbManager.getContactList().map {
                contactDBEntityDataMapper.transformDBEntityToModel(it)
            }
            Single.just(contactList)
        }
    }

    fun getContactFromDatabaseByEmail(email: String): Single<Contact> {
        return Single.defer {
            val contact = dbManager.getContactByEmail(email)
            Single.just(contactDBEntityDataMapper.transformDBEntityToModel(contact))
        }
    }


}