package com.loicz.lydiaproject.presentation.ui.contacts.detail

import androidx.lifecycle.MutableLiveData
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.data.repository.ContactRepository
import com.loicz.lydiaproject.presentation.base.EnumStateViewModel
import com.loicz.lydiaproject.presentation.extension.subscribeByOnIO
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class ContactDetailFragmentViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : EnumStateViewModel<ContactDetailFragmentViewState>() {
    override var currentViewState: ContactDetailFragmentViewState =
        ContactDetailFragmentViewState.RESULTS

    private val contactLiveData = MutableLiveData<Contact>()
    private val compositeDisposable = CompositeDisposable()

    fun getContactByEmail(email: String) {
        contactRepository.getContactFromDatabaseByEmail(email)
            .subscribeByOnIO(
                onSuccess = {
                    contactLiveData.postValue(it)
                },
                onError = {

                }
            ).addTo(compositeDisposable)
    }

    fun getContactLiveData() = contactLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
