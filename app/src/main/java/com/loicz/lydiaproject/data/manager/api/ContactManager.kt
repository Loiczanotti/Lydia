package com.loicz.lydiaproject.data.manager.api

import com.loicz.lydiaproject.data.model.ResultContact
import io.reactivex.rxjava3.core.Single

interface ContactManager {
    fun getContactsByPage(page: Int, pageSize: Int): Single<ResultContact>
}