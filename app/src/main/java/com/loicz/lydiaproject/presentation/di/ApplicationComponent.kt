package com.loicz.lydiaproject.presentation.di

import android.content.Context
import com.loicz.lydiaproject.data.di.DataComponent
import com.loicz.lydiaproject.presentation.LydiaApplication
import com.loicz.lydiaproject.presentation.di.annotation.PerApplication
import com.loicz.lydiaproject.presentation.di.module.ActivityInjectorModule
import com.loicz.lydiaproject.presentation.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityInjectorModule::class,
        ViewModelModule::class
    ], dependencies = [
        DataComponent::class
    ]
)
interface ApplicationComponent {
    fun inject(application: LydiaApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            dataComponent: DataComponent
        ): ApplicationComponent
    }
}