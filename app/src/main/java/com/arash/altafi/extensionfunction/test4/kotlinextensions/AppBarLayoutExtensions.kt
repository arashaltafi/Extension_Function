package com.arash.altafi.extensionfunction.test4.kotlinextensions

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.shape.MaterialShapeDrawable

fun AppBarLayout.setMaterialBackground() {
    if (background is ColorDrawable) {
        val background = background as ColorDrawable
        val materialShapeDrawable = MaterialShapeDrawable().apply {
            fillColor = ColorStateList.valueOf(background.color)
            initializeElevationOverlay(context)
        }
        ViewCompat.setBackground(this, materialShapeDrawable)
    }
}