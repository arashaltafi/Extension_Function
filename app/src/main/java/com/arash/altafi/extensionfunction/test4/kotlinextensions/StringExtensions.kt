package com.arash.altafi.extensionfunction.test4.kotlinextensions

import java.util.*

/*
* https://stackoverflow.com/a/50963795
* */
fun String?.toFlagEmoji(): String {
    if (this == null) {
        return "null"
    }

    // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
    if (this.length != 2) {
        return this
    }

    val countryCodeCaps =
        this.toUpperCase(Locale.getDefault()) // upper case is important because we are calculating offset
    val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
    val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6

    // 2. It then checks if both characters are alphabet
    if (!countryCodeCaps[0].isLetter() || !countryCodeCaps[1].isLetter()) {
        return this
    }

    return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
}

/**
 * This pattern is intended for searching for things that look like they
 * might be phone numbers in arbitrary text, not for validating whether
 * something is in fact a phone number.  It will miss many things that
 * are legitimate phone numbers.
 *
 * <p> The pattern matches the following:
 * <ul>
 * <li>Optionally, a + sign followed immediately by one or more digits. Spaces, dots, or dashes
 * may follow.
 * <li>Optionally, sets of digits in parentheses, separated by spaces, dots, or dashes.
 * <li>A string starting and ending with a digit, containing digits, spaces, dots, and/or dashes.
 * </ul>
 */
fun CharSequence.isPhoneNumber(): Boolean {

    //taken from Android SDK file -> Patterns.java for use outside of Android SDK
    val pattern = ("(\\+[0-9]+[\\- \\.]*)?" // +<digits><sdd>*
            + "(\\([0-9]+\\)[\\- \\.]*)?" //(<digits>)<sdd>*
            + "([0-9][0-9\\- \\.]+[0-9])") //<digit><digit|sdd>+<digit>

    val regex = pattern.toRegex()

    return regex.matches(this)
}

fun CharSequence.isEmailAddress(): Boolean {
    //taken from Android SDK file -> Patterns.java for use outside of Android SDK
    val pattern = ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+")

    val regex = pattern.toRegex()

    return regex.matches(this)
}