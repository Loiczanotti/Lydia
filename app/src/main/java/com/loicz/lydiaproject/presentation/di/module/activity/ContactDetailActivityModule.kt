package com.loicz.lydiaproject.presentation.di.module.activity

import com.loicz.lydiaproject.presentation.di.annotation.PerFragment
import com.loicz.lydiaproject.presentation.ui.contacts.ContactListFragment
import com.loicz.lydiaproject.presentation.ui.contacts.detail.ContactDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [ContactDetailActivityModuleFragmentsModule::class])
class ContactDetailActivityModule {

}

@Module
abstract class ContactDetailActivityModuleFragmentsModule {
    @PerFragment
    @ContributesAndroidInjector
    abstract fun contactDetailFragmentInjector(): ContactDetailFragment
}