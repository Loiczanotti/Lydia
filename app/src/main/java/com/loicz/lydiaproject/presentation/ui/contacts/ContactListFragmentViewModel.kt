package com.loicz.lydiaproject.presentation.ui.contacts

import androidx.lifecycle.MutableLiveData
import com.loicz.lydiaproject.data.exceptions.NetworkConnectException
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.data.model.ResultContact
import com.loicz.lydiaproject.data.repository.ContactRepository
import com.loicz.lydiaproject.presentation.base.EnumStateViewModel
import com.loicz.lydiaproject.presentation.extension.subscribeByOnIO
import com.loicz.lydiaproject.presentation.ui.values.ContactsValues
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class ContactListFragmentViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : EnumStateViewModel<ContactListFragmentViewState>() {

    var page = 1
    override var currentViewState: ContactListFragmentViewState =
        ContactListFragmentViewState.RESULTS

    private val compositeDisposable = CompositeDisposable()
    private val contactResultLiveData = MutableLiveData<List<Contact>>()
    private val errorLiveData = MutableLiveData<Throwable>()

    init {
        getContactsByPage()
    }

    fun getContactsByPage() {
        contactRepository.getContactsByPage(page, ContactsValues.GET_CONTACTS_PAGE_SIZE)
            .subscribeByOnIO(
                onSuccess = {
                    contactResultLiveData.postValue(it)
                },
                onError = {
                    if (it is NetworkConnectException && page == 1) {
                        getContactFromDatabase()
                    } else {
                        errorLiveData.postValue(it)
                    }
                }
            ).addTo(compositeDisposable)
    }

    fun getContactFromDatabase() {
        contactRepository.getContactsFromDatabase()
            .subscribeByOnIO(
                onSuccess = {
                    contactResultLiveData.postValue(it)
                },
                onError = {
                    errorLiveData.postValue(it)
                }
            ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getContactsLiveData() = contactResultLiveData
}
