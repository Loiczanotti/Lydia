package com.loicz.lydiaproject.presentation.extension

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T : Any> Single<T>.subscribeByOnIO(
    onSuccess: (T) -> Unit,
    onError: (Throwable) -> Unit
): Disposable =
    this.subscribeOn(Schedulers.io()).subscribeBy(onSuccess = onSuccess, onError = onError)