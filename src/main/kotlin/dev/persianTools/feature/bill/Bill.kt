package dev.persianTools.feature.bill

/**
 * Bill class
 */
@ExperimentalStdlibApi
data class Bill(
    private val _barcode: String? = null,
    val currency: BillCurrency = BillCurrency.TOMAN,
    val billId: Long?,
    val paymentId: Int?
): BillResult {

    companion object {
        /**
         * Find bill ID and payment ID using barcode
         * @sample
         *   val (billID,paymentID) = Bill.findByBarcode(barcode)
         */
        fun findByBarcode(barcode: String): Pair<Long,Int> {
            return Pair(
                barcode.substring(0,13).toLong(),
                barcode.substring(16).toInt()
            )
        }
    }

    override fun amount(): Int? {
        if (paymentId == null) return null

        val currencyAmount = if (currency == BillCurrency.RIAL) 1000 else 100

        return (paymentId / 100000) * currencyAmount
    }

    override fun type(): BillType {
        val billIdStr = billId.toString()

        return billIdStr.substring(billIdStr.length - 2,
            billIdStr.length -1).toInt().billType()
    }

    override fun barcode(): String? {
        if (billId == null || paymentId == null) return null

        return _barcode ?: """${billId}000$paymentId"""
    }

    override fun isValid(): Boolean = isValidBillId() && isValidBillPayment()

    override fun isValidBillId(): Boolean {
        var billIdStr = billId.toString()

        if (billIdStr.length < 6) return false

        val firstControlBit = billIdStr[billIdStr.length - 1]

        billIdStr = billIdStr.substring(0,billIdStr.length - 1)

        return calTheBit(billIdStr) == firstControlBit.toString().toInt() && type() != BillType.UNKNOWN
    }

    override fun isValidBillPayment(): Boolean {
        val billIdStr = billId.toString()
        var paymentIdStr = paymentId.toString()

        if (paymentIdStr.length < 6) return false

        val firstControlBit = paymentIdStr[paymentIdStr.length - 2]
        val secondControlBit = paymentIdStr[paymentIdStr.length - 1]

        paymentIdStr = paymentIdStr.substring(0,paymentIdStr.length - 2)

        return calTheBit(paymentIdStr) == firstControlBit.toString().toInt() &&
                calTheBit(billIdStr + paymentIdStr + firstControlBit) ==
                secondControlBit.toString().toInt()
    }

    private fun calTheBit(number: String): Int {
        var sum = 0
        var base = 2
        number.forEachIndexed { index, _ ->
            if (base == 8) base = 2

            val subString = number.substring(
                number.length - 1 - index,
                number.length - index
            ).toInt()

            sum += subString * base

            base++
        }
        sum %= 11

        sum = if (sum < 2) {
            0
        } else {
            11 - sum
        }
        return sum
    }
}