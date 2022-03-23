package com.loicz.lydiaproject.presentation.di.module

import androidx.lifecycle.ViewModel
import com.loicz.lydiaproject.presentation.di.annotation.ViewModelKey
import com.loicz.lydiaproject.presentation.ui.contacts.ContactListFragmentViewModel
import com.loicz.lydiaproject.presentation.ui.contacts.detail.ContactDetailFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactListFragmentViewModel::class)
    abstract fun bindContactListFragmentViewModel(viewModel: ContactListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ContactDetailFragmentViewModel::class)
    abstract fun bindContactDetailFragmentViewModel(viewModel: ContactDetailFragmentViewModel): ViewModel
}