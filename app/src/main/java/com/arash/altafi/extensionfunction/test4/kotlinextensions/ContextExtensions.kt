package com.arash.altafi.extensionfunction.test4.kotlinextensions

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes

@ColorRes
fun Context.resolveAttrToColorRes(@AttrRes colorAttr: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(colorAttr, typedValue, true)

    // resourceId is used if it's a ColorStateList, and data if it's a color reference or a hex color
    return if (typedValue.resourceId != 0) typedValue.resourceId else typedValue.data
}

@Suppress("DEPRECATION")
fun Context.canDrawOverlays(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Settings.canDrawOverlays(this)
    } else {
        true //doesnt happen on lower APIs so skip check
    }
}