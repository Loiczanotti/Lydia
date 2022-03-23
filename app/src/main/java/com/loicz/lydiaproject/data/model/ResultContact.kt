package com.loicz.lydiaproject.data.model

import com.google.gson.annotations.SerializedName

data class ResultContact(
    @SerializedName("results")
    val contacts: List<Contact>
)