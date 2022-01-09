package com.arash.altafi.extensionfunction.test4.kotlinextensions

import android.animation.AnimatorInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimatorRes
import androidx.annotation.IdRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

fun View.visibleWhen(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}

fun View.visibleWhenElseInvisible(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.INVISIBLE
}

fun View.goneWhen(condition: Boolean) {
    visibility = if (condition) View.GONE else View.VISIBLE
}

//lazily bind views
fun <T : View> View.bindView(@IdRes idRes: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        findViewById<T>(idRes)
    }
}

//https://chris.banes.dev/2019/04/12/insets-listeners-to-layouts/
fun View.doOnApplyWindowInsets(f: (View, WindowInsetsCompat, InitialPadding) -> Unit) {
    // Create a snapshot of the view's padding state
    val initialPadding = recordInitialPaddingForView(this)
    // Set an actual OnApplyWindowInsetsListener which proxies to the given
    // lambda, also passing in the original padding state
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        f(v, insets, initialPadding)
        // Always return the insets, so that children can also use them
        insets
    }
    // request some insets
    requestApplyInsetsWhenAttached()
}

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to
        // request when we are
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

data class InitialPadding(val left: Int, val top: Int, val right: Int, val bottom: Int)

private fun recordInitialPaddingForView(view: View) = InitialPadding(
    view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom
)

fun View.setMarginTop(value: Int) = updateLayoutParams<ViewGroup.MarginLayoutParams> {
    topMargin = value
}

fun View.setMarginBottom(value: Int) = updateLayoutParams<ViewGroup.MarginLayoutParams> {
    bottomMargin = value
}

fun View.setMarginLeft(value: Int) = updateLayoutParams<ViewGroup.MarginLayoutParams> {
    leftMargin = value
}

fun View.doAnimatior(@AnimatorRes animRes: Int) {
    AnimatorInflater.loadAnimator(context, animRes)?.apply {
        setTarget(this@doAnimatior)
        start()
    }
}


