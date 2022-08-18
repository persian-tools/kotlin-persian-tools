package com.kotlin.persian.tools.lib

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

class MyClass {
}

fun Number.currency():String {
    val formatter: DecimalFormat = NumberFormat.getCurrencyInstance(Locale("en")) as DecimalFormat
    formatter.maximumFractionDigits = 0
    val symbols: DecimalFormatSymbols = formatter.decimalFormatSymbols
    symbols.currencySymbol = "" // Don't use null.
    formatter.decimalFormatSymbols = symbols
    return formatter.format(this)
}
