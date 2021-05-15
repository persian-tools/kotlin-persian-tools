package dev.persianTools.feature.isPersian

object FarsiCharacters {

    private val defaultTrimPattern: Regex = Regex("[^A-Za-z0-9 ]")

    fun isPersian(input: String, isComplex: Boolean = false, trimPattern: Regex = defaultTrimPattern): Boolean {
        val rawText = input.replace(trimPattern,"")
        val faRegexExp = getFaRegexExp(isComplex)
        return rawText.matches(faRegexExp)
    }

    fun hasPersian(input: String, isComplex: Boolean = false): Boolean {
        val faRegexExp = getFaRegexExp(isComplex)
        return input.matches(faRegexExp)
    }

    private fun getFaRegexExp(isComplex: Boolean): Regex {
        val faRegexExp = if (isComplex) faComplexText else faText
        return Regex(faRegexExp)
    }
}

/**
 * Check is the input string Persian or not
 * returns true if the input is matched with Farsi char dataset [Regex],
 * if not returns false
 */
fun String.isPersian(isComplex: Boolean = false) = FarsiCharacters.isPersian(this, isComplex)

/**
 * Check is the input string includes Persian alphabet or not
 * returns true if the input is matched with Farsi char dataset [Regex],
 * if not returns false
 */
fun String.hasPersian(isComplex: Boolean = false) = FarsiCharacters.hasPersian(this, isComplex)