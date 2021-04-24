package dev.persianTools.feature.ordinalSuffix


object OrdinalSuffix {
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

fun String.addOrdinalSuffix(): String = OrdinalSuffix.addOrdinalSuffix(this)