package dev.persianTools.feature.bill

/**
 * Bill type enum class
 *
 * [faName] contains farsi name of the bill
 */
enum class BillType(val faName: String) {
    WATER("آب"),
    ELECTRICITY("برق"),
    GAS("گاز"),
    PHONE("تلفن ثابت"),
    CELLPHONE("تلفن همراه"),
    MUNICIPALITY_TAX("عوارض شهرداری"),
    TAX_OFFICE("سازمان مالیات"),
    DRIVING_TICKET("جرایم راهنمایی و رانندگی"),
    UNKNOWN("ناشناس")
}

/**
 * Convert int to [BillType]
 */
fun Int.billType(): BillType {
    return when (this) {
        1 -> BillType.WATER
        2 -> BillType.ELECTRICITY
        3 -> BillType.GAS
        4 -> BillType.PHONE
        5 -> BillType.CELLPHONE
        6 -> BillType.MUNICIPALITY_TAX
        7 -> BillType.TAX_OFFICE
        8 -> BillType.DRIVING_TICKET
        else -> BillType.UNKNOWN
    }
}