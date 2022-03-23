package com.loicz.lydiaproject.data.di

import android.content.Context
import com.loicz.lydiaproject.data.di.module.DataModule
import com.loicz.lydiaproject.data.di.module.NetworkModule
import com.loicz.lydiaproject.data.di.module.RoomModule
import com.loicz.lydiaproject.data.manager.db.AppDatabase
import com.loicz.lydiaproject.data.repository.ContactRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        RoomModule::class
    ]
)
interface DataComponent {

    fun contactRepository(): ContactRepository

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

}