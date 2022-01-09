package com.arash.altafi.extensionfunction.test4.kotlinextensions

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

//https://stackoverflow.com/questions/51073244/android-mvvm-how-to-make-livedata-emits-the-data-it-has-forcing-to-trigger-th
fun <T> MutableLiveData<T>.forceRefresh() {
    this.value = this.value
}

fun <T> MediatorLiveData<T>.addDirectSource(source: LiveData<T>) {
    addSource(source) { this.value = it }
}

@MainThread
fun <T> LiveData<T>.observeQuietly(
    owner: LifecycleOwner
): androidx.lifecycle.Observer<T> {
    val wrappedObserver = androidx.lifecycle.Observer<T> {
        //do nothing, just need to attach to lifecycle owner
    }
    observe(owner, wrappedObserver)
    return wrappedObserver
}
