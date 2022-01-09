package com.arash.altafi.extensionfunction.test4.kotlinextensions

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

fun Fragment.setupToolbarWithNavController(toolbar: Toolbar) {
    toolbar.setupWithNavController(findNavController(), AppBarConfiguration(emptySet()) {
        activity?.onBackPressed()
        true
    })
}

fun Fragment.registerBackPressCallback(callback: OnBackPressedCallback) {
    requireActivity().onBackPressedDispatcher.addCallback(this, callback)
}
