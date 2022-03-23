package com.loicz.lydiaproject.data.manager.api

import com.loicz.lydiaproject.data.manager.api.service.LydiaApiService
import com.loicz.lydiaproject.data.model.ResultContact
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ContactManagerImpl @Inject constructor(
    private val lydiaApiService: LydiaApiService
) : ContactManager {
    override fun getContactsByPage(page: Int, pageSize: Int): Single<ResultContact> {
        return Single.defer {
            lydiaApiService.getContactByPage(pageSize, page)
        }
    }
}