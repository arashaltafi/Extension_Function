@file:Suppress("NOTHING_TO_INLINE")

package com.arash.altafi.extensionfunction.test5.extensions.preconditions

import com.arash.altafi.extensionfunction.test5.extensions.standard.andThrow
import com.arash.altafi.extensionfunction.test5.extensions.standard.with
import java.math.BigDecimal
import java.math.BigInteger

inline fun <T> T.require(requirement: T.() -> Boolean, noinline throwable: T.() -> Throwable = { IllegalArgumentException("$this does not match requirements") }, noinline elseBlock: T.() -> Unit = {}): T = if (run(requirement)) this else {
    run(elseBlock.with(this).andThrow(throwable()))
}

inline fun <T> T.require(requirement: T.() -> Boolean, throwable: Throwable = IllegalArgumentException("$this does not match requirements"), noinline elseBlock: T.() -> Unit = {}): T = require(requirement, { throwable }, elseBlock)
inline fun <T> T.require(requirement: T.() -> Boolean, message: String = "$this does not match requirements", noinline elseBlock: T.() -> Unit = {}): T = require(requirement, IllegalArgumentException(message), elseBlock)
inline fun <T> T.require(requirement: T.() -> Boolean): T = require(requirement, "$this does not match requirements")

inline fun <T> T?.requireNotNull(throwable: Throwable = IllegalArgumentException("cannot be null"), noinline elseBlock: () -> Unit = {}): T = if (this != null) this else {
    run(elseBlock.andThrow(throwable))
}

inline fun <T> T?.requireNotNull(message: String = "cannot be null", noinline elseBlock: () -> Unit = {}): T = requireNotNull(IllegalArgumentException(message), elseBlock)
inline fun <T> T?.requireNotNull(): T = requireNotNull("cannot be null")

inline fun String?.requireNotBlank(throwable: Throwable = IllegalArgumentException("cannot be blank"), noinline elseBlock: () -> Unit = {}): String = if (!isNullOrBlank()) this!! else {
    run(elseBlock.andThrow(throwable))
}

inline fun String?.requireNotBlank(message: String = "cannot be blank", noinline elseBlock: () -> Unit = {}): String = requireNotBlank(IllegalArgumentException(message), elseBlock)
inline fun String?.requireNotBlank(): String = requireNotBlank("cannot be blank")

inline fun <T> Collection<T>.requireNotEmpty(throwable: Throwable = IllegalArgumentException("cannot be empty"), noinline elseBlock: Collection<T>.() -> Unit = {}): Collection<T> = require({ isNotEmpty() }, throwable, elseBlock)
inline fun <T> Collection<T>.requireNotEmpty(message: String = "cannot be empty", noinline elseBlock: Collection<T>.() -> Unit = {}): Collection<T> = requireNotEmpty(IllegalArgumentException(message), elseBlock)
inline fun <T> Collection<T>.requireNotEmpty(): Collection<T> = requireNotEmpty("cannot be empty")

inline fun <T> Array<T>.requireNotEmpty(throwable: Throwable = IllegalArgumentException("cannot be empty"), noinline elseBlock: Array<T>.() -> Unit = {}): Array<T> = require({ isNotEmpty() }, throwable, elseBlock)
inline fun <T> Array<T>.requireNotEmpty(message: String = "cannot be empty", noinline elseBlock: Array<T>.() -> Unit = {}): Array<T> = requireNotEmpty(IllegalArgumentException(message), elseBlock)
inline fun <T> Array<T>.requireNotEmpty(): Array<T> = requireNotEmpty(IllegalArgumentException("cannot be empty"))

inline fun <T> Collection<T>.requireSize(size: Int, throwable: Throwable = IllegalArgumentException("must be of size $size"), noinline elseBlock: Collection<T>.() -> Unit = {}): Collection<T> = require({ this.size == size }, throwable, elseBlock)
inline fun <T> Collection<T>.requireSize(size: Int, message: String = "must be of size $size", noinline elseBlock: Collection<T>.() -> Unit = {}): Collection<T> = requireSize(size, IllegalArgumentException(message), elseBlock)
inline fun <T> Collection<T>.requireSize(size: Int): Collection<T> = requireSize(size, "must be of size $size")

inline fun <T> Array<T>.requireSize(size: Int, throwable: Throwable = IllegalArgumentException("must be of size $size"), noinline elseBlock: Array<T>.() -> Unit = {}): Array<T> = require({ this.size == size }, throwable, elseBlock)
inline fun <T> Array<T>.requireSize(size: Int, message: String = "must be of size $size", noinline elseBlock: Array<T>.() -> Unit = {}): Array<T> = requireSize(size, IllegalArgumentException(message), elseBlock)
inline fun <T> Array<T>.requireSize(size: Int): Array<T> = requireSize(size, "must be of size $size")

fun Byte.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultByte()}"), elseBlock: () -> Unit = {}): Byte = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultByte() }, throwable, { run(elseBlock) })
fun Byte.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultByte()}", elseBlock: () -> Unit = {}): Byte = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Byte.requireNonDefault(): Byte = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultByte()}")

fun Short.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultShort()}"), elseBlock: () -> Unit = {}): Short = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultShort() }, throwable, { run(elseBlock) })
fun Short.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultShort()}", elseBlock: () -> Unit = {}): Short = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Short.requireNonDefault(): Short = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultShort()}")

fun Int.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultInt()}"), elseBlock: () -> Unit = {}): Int = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultInt() }, throwable, { run(elseBlock) })
fun Int.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultInt()}", elseBlock: () -> Unit = {}): Int = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Int.requireNonDefault(): Int = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultInt()}")

fun Long.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultLong()}"), elseBlock: () -> Unit = {}): Long = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultLong() }, throwable, { run(elseBlock) })
fun Long.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultLong()}", elseBlock: () -> Unit = {}): Long = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Long.requireNonDefault(): Long = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultLong()}")

fun Float.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultFloat()}"), elseBlock: () -> Unit = {}): Float = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultFloat() }, throwable, { run(elseBlock) })
fun Float.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultFloat()}", elseBlock: () -> Unit = {}): Float = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Float.requireNonDefault(): Float = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultFloat()}")

fun Double.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultDouble()}"), elseBlock: () -> Unit = {}): Double = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultDouble() }, throwable, { run(elseBlock) })
fun Double.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultDouble()}", elseBlock: () -> Unit = {}): Double = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun Double.requireNonDefault(): Double = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultDouble()}")

fun String.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultString()}"), elseBlock: () -> Unit = {}): String = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultString() }, throwable, { run(elseBlock) })
fun String.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultString()}", elseBlock: () -> Unit = {}): String = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun String.requireNonDefault(): String = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultString()}")

fun BigInteger.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigInteger()}"), elseBlock: () -> Unit = {}): BigInteger = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigInteger() }, throwable, { run(elseBlock) })
fun BigInteger.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigInteger()}", elseBlock: () -> Unit = {}): BigInteger = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun BigInteger.requireNonDefault(): BigInteger = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigInteger()}")

fun BigDecimal.requireNonDefault(throwable: Throwable = IllegalArgumentException("cannot be  ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigDecimal()}"), elseBlock: () -> Unit = {}): BigDecimal = require({ this != com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigDecimal() }, throwable, { run(elseBlock) })
fun BigDecimal.requireNonDefault(message: String = "cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigDecimal()}", elseBlock: () -> Unit = {}): BigDecimal = requireNonDefault(IllegalArgumentException(message), elseBlock)
inline fun BigDecimal.requireNonDefault(): BigDecimal = requireNonDefault("cannot be ${com.arash.altafi.extensionfunction.test5.extensions.standard.defaultBigDecimal()}")