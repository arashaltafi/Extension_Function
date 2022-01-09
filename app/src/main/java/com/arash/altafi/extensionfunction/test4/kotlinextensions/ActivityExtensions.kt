package com.arash.altafi.extensionfunction.test4.kotlinextensions

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController

fun FragmentActivity.isFragmentDisplayed(tag: String): Boolean {
    return supportFragmentManager.findFragmentByTag(tag)?.isVisible == true
}

fun Activity.isDestinationCurrentlyDisplayed(@IdRes containerId : Int, id: Int): Boolean {
    return findNavController(containerId).currentBackStackEntry?.destination?.id == id
}