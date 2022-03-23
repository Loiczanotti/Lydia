package com.loicz.lydiaproject.presentation.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.databinding.FragmentContactListBinding
import com.loicz.lydiaproject.presentation.base.BaseVMFragment
import com.loicz.lydiaproject.presentation.ui.contacts.adapter.ContactListAdapter
import com.loicz.lydiaproject.presentation.ui.contacts.detail.ContactDetailActivity
import com.loicz.lydiaproject.presentation.ui.values.ContactsValues
import javax.inject.Inject
import kotlin.reflect.KClass

class ContactListFragment :
    BaseVMFragment<ContactListFragmentViewModel, FragmentContactListBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentContactListBinding =
        FragmentContactListBinding::inflate
    override val viewModelClass: KClass<ContactListFragmentViewModel> =
        ContactListFragmentViewModel::class

    @Inject
    lateinit var contactListAdapter: ContactListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initLiveDataObservers()

        (requireActivity() as ContactActivity).setSupportActionBar(binding.fragmentContactListToolbar)
        (requireActivity() as ContactActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as ContactActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        binding {
            val linearLayoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.fragmentUserListUsers.layoutManager = linearLayoutManager
            fragmentUserListUsers.adapter = contactListAdapter

            binding.fragmentUserListUsers.addOnScrollListener(object :
                RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val firstVisibleItemPosition: Int =
                        linearLayoutManager.findFirstVisibleItemPosition()
                    if ((linearLayoutManager.childCount + firstVisibleItemPosition) == linearLayoutManager.itemCount
                        && firstVisibleItemPosition >= 0
                        && linearLayoutManager.itemCount >= ContactsValues.GET_CONTACTS_PAGE_SIZE
                    ) {
                        viewModel.page++
                        viewModel.getContactsByPage()
                    }
                }
            })
        }
    }

    private fun initLiveDataObservers() {
        viewModel.getContactsLiveData().observe(viewLifecycleOwner) {
            bindContactList(it)
        }
    }

    private fun bindContactList(contacts: List<Contact>) {
        val list = mutableListOf<Contact>()
        list.addAll(contactListAdapter.currentList)
        list.addAll(contacts)
        contactListAdapter.submitList(list)
        contactListAdapter.onContactClickListener = {
            startActivity(ContactDetailActivity.newIntent(requireContext(), it.email))
        }
    }
}