package com.loicz.lydiaproject.data.di.module

import com.loicz.lydiaproject.data.manager.api.ContactManager
import com.loicz.lydiaproject.data.manager.api.ContactManagerImpl
import com.loicz.lydiaproject.data.manager.db.DBManager
import com.loicz.lydiaproject.data.manager.db.DBManagerImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object DataModule {

    @Provides
    @Reusable
    fun contactManager(contactManagerImpl: ContactManagerImpl): ContactManager = contactManagerImpl

    @Provides
    @Reusable
    fun dbManager(dBManagerImpl: DBManagerImpl): DBManager = dBManagerImpl

}