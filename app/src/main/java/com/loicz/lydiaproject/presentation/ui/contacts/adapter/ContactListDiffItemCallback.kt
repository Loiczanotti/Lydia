package com.loicz.lydiaproject.presentation.ui.contacts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.loicz.lydiaproject.data.model.Contact
import javax.inject.Inject

class ContactListDiffItemCallback @Inject constructor() : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}