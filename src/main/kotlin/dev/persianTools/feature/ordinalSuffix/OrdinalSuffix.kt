package dev.persianTools.feature.ordinalSuffix


object OrdinalSuffix {
    /**
     * add ordinal suffix to the given string number
     * @param string [String] number
     * @return Suffix [String]
     *
     * @author Moein
     */
    fun addOrdinalSuffix(string: String): String {
        return when {
            string.isBlank() -> {
                ""
            }
            string.endsWith('ی') -> {
                "$string اُم"
            }
            string.endsWith("سه") -> {
                string.substring(0, string.length - 2) + "سوم"
            }
            else -> string + "م"
        }
    }


}

/**
 * Add ordinal suffix extension
 * This extension uses [OrdinalSuffix.addOrdinalSuffix] function
 *
 */
fun String.addOrdinalSuffix(): String = OrdinalSuffix.addOrdinalSuffix(this)