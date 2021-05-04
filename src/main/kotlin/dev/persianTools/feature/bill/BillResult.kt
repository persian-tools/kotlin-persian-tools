package dev.persianTools.feature.bill

interface BillResult {
    /**
     * calculate the amount of the bill
     */
    fun amount(): Int?

    /**
     * get the [BillType]
     */
    fun type(): BillType

    /**
     * Calculates the barcode string
     */
    fun barcode(): String?

    /**
     * validate the bill
     */
    fun isValid(): Boolean

    /**
     * Validate bill ID
     */
    fun isValidBillId(): Boolean

    /**
     * Validate bill payment
     */
    fun isValidBillPayment(): Boolean
}