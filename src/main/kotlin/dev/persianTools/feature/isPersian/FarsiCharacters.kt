package dev.persianTools.feature.isPersian

object FarsiCharacters {

    private val defaultTrimPattern: Regex = Regex("[^A-Za-z0-9 ]")

    fun isPersian(input: String, isComplex: Boolean, trimPattern: Regex = defaultTrimPattern): Boolean {
        val rawText = input.replace(trimPattern,"")
        val faRegexExp = getFaRegexExp(isComplex)
        return rawText.matches(faRegexExp)
    }

    fun hasPersian(input: String, isComplex: Boolean): Boolean {
        val faRegexExp = getFaRegexExp(isComplex)
        return input.matches(faRegexExp)
    }

    private fun getFaRegexExp(isComplex: Boolean): Regex {
        val faRegexExp = if (isComplex) faComplexText else faText
        return Regex(faRegexExp)
    }
}