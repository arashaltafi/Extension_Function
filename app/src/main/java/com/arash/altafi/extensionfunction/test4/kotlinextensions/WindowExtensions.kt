package com.arash.altafi.extensionfunction.test4.kotlinextensions

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager

@Suppress("DEPRECATION")
fun Window.setEdgeToEdgeLayout() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        setDecorFitsSystemWindows(false)
    } else {
        //decorate window to draw under status bar
        this.decorView.systemUiVisibility = this.decorView.systemUiVisibility or
                //we wish to be laid out as if the navigation bar was hidden
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                //we wish to be laid out fullscreen, behind the status bar
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                //we wish to be laid out at the most extreme scenario of any other flags
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

fun Window.adjustScreenBrightness(brightness: Float) {
    val validBrightness = brightness == -1f || brightness in 0f..1f
    if (validBrightness) {
        val params: WindowManager.LayoutParams = attributes
        // range from 0 to 1, specify -1 for default brightness
        params.screenBrightness = brightness
        attributes = params
    }
}