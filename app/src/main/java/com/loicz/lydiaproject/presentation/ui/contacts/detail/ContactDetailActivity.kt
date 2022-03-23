package com.loicz.lydiaproject.presentation.ui.contacts.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.navigation.findNavController
import com.loicz.lydiaproject.R
import com.loicz.lydiaproject.databinding.ActivityDetailContactBinding
import com.loicz.lydiaproject.presentation.base.BaseActivity

class ContactDetailActivity : BaseActivity<ActivityDetailContactBinding>() {

    private val navController by lazy { findNavController(getNavControllerId()) }

    private fun getNavControllerId() = R.id.activity_detail_contact_container

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityDetailContactBinding =
        ActivityDetailContactBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.let {
            navController.setGraph(R.navigation.activity_detail_contact_graph, it)
        }
    }

    companion object {
        const val BUNDLE_KEY_CONTACT_EMAIL = "contactEmail"
        fun newIntent(context: Context, email: String) =
            Intent(context, ContactDetailActivity::class.java).apply {
                putExtra(BUNDLE_KEY_CONTACT_EMAIL, email)
            }
    }
}