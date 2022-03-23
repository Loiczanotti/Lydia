package com.loicz.lydiaproject.presentation

import android.app.Application
import com.loicz.lydiaproject.data.di.DaggerDataComponent
import com.loicz.lydiaproject.presentation.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LydiaApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory()
            .create(this, DaggerDataComponent.factory().create(this))
            .inject(this@LydiaApplication)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}