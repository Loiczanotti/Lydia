package com.loicz.lydiaproject.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity(), HasAndroidInjector {

    /**
     * Add function for ViewBinding
     */
    fun binding(receiver: VB.()-> Unit) {
        receiver(binding)
    }

    private var viewBinding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = viewBinding as VB

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewBinding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(viewBinding).root)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

}