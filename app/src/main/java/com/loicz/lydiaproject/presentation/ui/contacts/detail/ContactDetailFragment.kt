package com.loicz.lydiaproject.presentation.ui.contacts.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.loicz.lydiaproject.R
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.databinding.FragmentDetailContactBinding
import com.loicz.lydiaproject.presentation.base.BaseVMFragment
import java.util.*
import kotlin.reflect.KClass

class ContactDetailFragment :
    BaseVMFragment<ContactDetailFragmentViewModel, FragmentDetailContactBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailContactBinding =
        FragmentDetailContactBinding::inflate
    override val viewModelClass: KClass<ContactDetailFragmentViewModel> =
        ContactDetailFragmentViewModel::class

    private val args: ContactDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as ContactDetailActivity).setSupportActionBar(binding.fragmentDetailContactToolbar)
        (requireActivity() as ContactDetailActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as ContactDetailActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
        (requireActivity() as ContactDetailActivity).supportActionBar?.title = ""

        initLiveDataObservers()
        viewModel.getContactByEmail(args.contactEmail)
    }

    private fun initLiveDataObservers() {
        viewModel.getContactLiveData().observe(viewLifecycleOwner) {
            bindContact(it)
        }
    }

    private fun bindContact(contact: Contact) {
        binding {
            binding.fragmentDetailContactName.text = getString(
                R.string.fragment_detail_contact_name,
                contact.name.first.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                contact.name.last.uppercase(Locale.getDefault())
            )
            fragmentDetailContactItemGender.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_title)
            fragmentDetailContactItemEmail.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_email)
            fragmentDetailContactItemLogin.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_login)
            fragmentDetailContactItemLocation.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_address)
            fragmentDetailContactItemPhone.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_phone)
            fragmentDetailContactItemNat.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_nat)

            fragmentDetailContactItemCell.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_cell)

            fragmentDetailContactItemRegistered.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_registered)

            fragmentDetailContactItemDob.contactDetailItemTitle.text =
                getString(R.string.fragment_detail_contact_gender_dob)

            fragmentDetailContactItemGender.contactDetailItemValue.text = contact.gender
            fragmentDetailContactItemEmail.contactDetailItemValue.text = contact.email
            fragmentDetailContactItemLogin.contactDetailItemValue.text = contact.login.username
            fragmentDetailContactItemLocation.contactDetailItemValue.text =
                requireContext().getString(
                    R.string.fragment_detail_contact_address,
                    contact.location.street,
                    contact.location.postcode,
                    contact.location.city,
                    contact.location.state
                )
            fragmentDetailContactItemPhone.contactDetailItemValue.text = contact.phone
            fragmentDetailContactItemNat.contactDetailItemValue.text = contact.nat
            fragmentDetailContactItemCell.contactDetailItemValue.text = contact.cell
            fragmentDetailContactItemDob.contactDetailItemValue.text = contact.dob.toString()
            fragmentDetailContactItemRegistered.contactDetailItemValue.text = contact.registered.toString()
            Glide.with(requireContext())
                .load(contact.picture.medium)
                .circleCrop()
                .placeholder(R.drawable.ic_account_circle)
                .into(fragmentDetailContactImageProfile)
        }
    }

}