package com.loicz.lydiaproject.presentation.ui.contacts.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.loicz.lydiaproject.R
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.databinding.ItemContactBinding
import java.util.*

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemContactBinding.bind(itemView)

    fun bind(contact: Contact, onContactClickListener: (Contact) -> Unit) {
        with(binding) {
            itemContactName.text = itemView.context.getString(
                R.string.fragment_detail_contact_name,
                contact.name.first.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                contact.name.last.uppercase()
            )
            itemContactEmail.text = contact.email
            Glide.with(itemView.context)
                .load(contact.picture.thumbnail)
                .circleCrop()
                .placeholder(R.drawable.ic_account_circle)
                .into(itemContactIcon)
            itemView.setOnClickListener {
                onContactClickListener(contact)
            }
        }
    }
}
