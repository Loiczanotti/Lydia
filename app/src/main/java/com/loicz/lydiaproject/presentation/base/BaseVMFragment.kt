package com.loicz.lydiaproject.presentation.base

import android.content.Context
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseVMFragment<T : ViewModel, VB: ViewBinding> : BaseFragment<VB>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: T

    abstract val viewModelClass: KClass<T>

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass.java)
    }
}