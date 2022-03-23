package com.loicz.lydiaproject.presentation.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.loicz.lydiaproject.R
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.presentation.di.annotation.PerFragment
import javax.inject.Inject

@PerFragment
class ContactListAdapter @Inject constructor(
    itemCallback: ContactListDiffItemCallback
) : ListAdapter<Contact, ContactViewHolder>(itemCallback) {

    var onContactClickListener: (Contact) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_contact,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position), onContactClickListener)
    }

}