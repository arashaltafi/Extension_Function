package com.arash.altafi.extensionfunction.test4.kotlinextensions

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/** Convenience for callbacks/listeners whose return value indicates an event was consumed. */
inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}

//use to get types on classes with generics such as wrappers / envelopes / lists
inline fun <reified T> createType(): Type {
    return object : TypeToken<T>() {}.type
}

inline fun <reified T> Iterable<*>.findOfType(): T? {
    return firstOrNull { it is T } as T
}