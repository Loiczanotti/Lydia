package com.loicz.lydiaproject.presentation.ui.contacts

import android.view.LayoutInflater
import android.view.MenuItem
import com.loicz.lydiaproject.databinding.ActivityContactBinding
import com.loicz.lydiaproject.presentation.base.BaseActivity

class ContactActivity : BaseActivity<ActivityContactBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityContactBinding =
        ActivityContactBinding::inflate

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}