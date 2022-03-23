package com.loicz.lydiaproject.presentation.di.module.activity

import com.loicz.lydiaproject.presentation.di.annotation.PerFragment
import com.loicz.lydiaproject.presentation.ui.contacts.ContactListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ContactActivityFragmentsModule::class])
class ContactActivityModule {

}

@Module
abstract class ContactActivityFragmentsModule {
    @PerFragment
    @ContributesAndroidInjector
    abstract fun contactListFragmentInjector(): ContactListFragment
}
