package dev.persianTools.feature.ordinalSuffix

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrdinalSuffixTest {
    @Nested
    inner class OrdinalSuffixFunctionTest {
        @ParameterizedTest
        @CsvSource(value = [
            "پنجاه سه,پنجاه سوم",
            "سی دو,سی دوم",
            "شصت,شصتم",
            "سی,سی اُم",
            "سی دو,سی دوم",
            "ده,دهم",
        ])
        fun `ordinal suffix result is true`(input: String, excepted: String) {
            assertThat(OrdinalSuffix.addOrdinalSuffix(input)).isEqualTo(excepted)
        }
    }

    @Nested
    inner class OrdinalSuffixExtensionTest {
        @ParameterizedTest
        @CsvSource(value = [
            "پنجاه سه,پنجاه سوم",
            "سی دو,سی دوم",
            "شصت,شصتم",
            "سی,سی اُم",
            "سی دو,سی دوم",
            "ده,دهم",
        ])
        fun `ordinal suffix result is true`(input: String, excepted: String) {
            assertThat(input.addOrdinalSuffix()).isEqualTo(excepted)
        }
    }
}