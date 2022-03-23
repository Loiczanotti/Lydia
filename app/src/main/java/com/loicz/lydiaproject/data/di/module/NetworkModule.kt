package com.loicz.lydiaproject.data.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.loicz.lydiaproject.BuildConfig
import com.loicz.lydiaproject.data.manager.api.interceptor.NetworkInterceptor
import com.loicz.lydiaproject.data.manager.api.service.LydiaApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {


    @Provides
    @Singleton
    fun retrofitService(
        @Named("lydia") okHttpClient: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
        converter: Converter.Factory
    ): LydiaApiService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converter)
            .build()
            .create(LydiaApiService::class.java)

    @Provides
    @Singleton
    @Named("lydia")
    fun okHttp(
        loggingInterceptor: HttpLoggingInterceptor,
        networkInterceptor: NetworkInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkInterceptor)
            .build()

    @Provides
    @Reusable
    fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

    @Provides
    @Reusable
    fun provideRxCallAdapter(): CallAdapter.Factory = RxJava3CallAdapterFactory.create()

    @Provides
    @Reusable
    fun provideGsonConverter(gson: Gson): Converter.Factory =
        GsonConverterFactory.create(gson)

    @Provides
    @Reusable
    fun gson(): Gson =
        GsonBuilder().create()

}