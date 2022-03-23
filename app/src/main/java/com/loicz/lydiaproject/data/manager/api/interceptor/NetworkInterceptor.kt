package com.loicz.lydiaproject.data.manager.api.interceptor

import com.loicz.lydiaproject.data.exceptions.NetworkConnectException
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.Response
import java.lang.Exception
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@Reusable
class NetworkInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val requestBuilder = chain.request().newBuilder()
            return chain.proceed(requestBuilder.build())
        } catch (exception: Exception) {
            when (exception) {
                is SocketTimeoutException -> throw NetworkConnectException()
                is TimeoutException -> throw NetworkConnectException()
                is ConnectException -> throw NetworkConnectException()
                is UnknownHostException -> throw NetworkConnectException()
                else -> throw exception
            }
        }
    }
}