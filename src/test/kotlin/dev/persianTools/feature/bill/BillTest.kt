package dev.persianTools.feature.bill

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BillTest {

    companion object {
        @JvmStatic
        fun provideRialAmountValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    1117753200140, 12070160, 120000
                ),
                Arguments.of(
                    1177809000142,570108,5000
                ),
                Arguments.of(
                    1117753200140,1770165,17000
                )
            )

        @JvmStatic
        fun provideTomanAmountValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    1117753200140, 12070160, 12000
                ),
                Arguments.of(
                    1177809000142,570108,500
                ),
                Arguments.of(
                    1117753200140,1770165,1700
                )
            )
    }
    @Nested
    inner class BillResultTest {

        @Nested
        inner class BillAmountTest {

            @ParameterizedTest
            @MethodSource("dev.persianTools.feature.bill.BillTest#provideRialAmountValues")
            fun `Rial bill amount is correct`(billId: Long, paymentId: Int, amount: Int) {
                assertThat(
                    Bill(
                        billId = billId,
                        paymentId = paymentId,
                        currency = BillCurrency.RIAL
                    ).amount()
                ).isEqualTo(
                    amount
                )
            }

            @ParameterizedTest
            @MethodSource("dev.persianTools.feature.bill.BillTest#provideTomanAmountValues")
            fun `Toman bill amount is correct`(billId: Long, paymentId: Int, amount: Int) {
                assertThat(
                    Bill(
                        billId = billId,
                        paymentId = paymentId,
                        currency = BillCurrency.TOMAN
                    ).amount()
                ).isEqualTo(
                    amount
                )
            }
        }


    }

    @Nested
    inner class BarcodeTest {}
}