package com.loicz.lydiaproject.data.manager.api.service

import com.loicz.lydiaproject.data.model.ResultContact
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LydiaApiService {
    @GET("?seed=lydia")
    fun getContactByPage(@Query("results") pageSize: Int, @Query("page") page: Int): Single<ResultContact>
}