package com.loicz.lydiaproject.presentation.di.module

import com.loicz.lydiaproject.presentation.di.annotation.PerActivity
import com.loicz.lydiaproject.presentation.di.module.activity.ContactActivityModule
import com.loicz.lydiaproject.presentation.di.module.activity.ContactDetailActivityModule
import com.loicz.lydiaproject.presentation.ui.contacts.ContactActivity
import com.loicz.lydiaproject.presentation.ui.contacts.detail.ContactDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [ContactActivityModule::class])
    abstract fun contactActivityInjector(): ContactActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [ContactDetailActivityModule::class])
    abstract fun contactDetailActivityInjector(): ContactDetailActivity

}