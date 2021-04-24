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

    /**
     * removes ordinal suffix from the given alphabetical number
     *
     * @param string [String] number
     *
     * @return Suffix [String]
     *
     * @author Moein
     */
    fun removeOrdinalSuffix(string: String): String {
        var word = string.replace("مین","")
            .replace(" ام", "").replace(" اُم","")

        if (word.endsWith("سوم")) {
            word = word.substring(0,word.length - 3) + "سه"
        } else if (word.endsWith("م")) {
            word = word.substring(0, word.length - 1)
        }

        return word
    }
}

/**
 * Add ordinal suffix extension
 * This extension uses [OrdinalSuffix.addOrdinalSuffix] function
 *
 */
fun String.addOrdinalSuffix(): String = OrdinalSuffix.addOrdinalSuffix(this)


/**
 * Remove ordinal suffix extension
 *
 * This extension uses [OrdinalSuffix.removeOrdinalSuffix] function
 */
fun String.removeOrdinalSuffix(): String = OrdinalSuffix.removeOrdinalSuffix(this)