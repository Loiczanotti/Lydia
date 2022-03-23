package com.loicz.lydiaproject.data.di.module

import android.content.Context
import com.loicz.lydiaproject.data.manager.db.AppDatabase
import com.loicz.lydiaproject.data.model.db.ContactDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase = AppDatabase.getAppDataBase(context)

    @Provides
    @Singleton
    fun provideContactsDao(database: AppDatabase): ContactDao = database.contactDao()
}