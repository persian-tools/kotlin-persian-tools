package dev.persianTools.feature.isPersian

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExperimentalStdlibApi
class FarsiCharactersTest {
    companion object {
        @JvmStatic
        fun provideIsPersianArgs(): Stream<Arguments> =
            Stream.of(
                Arguments.of("این یک متن فارسی است؟", true),
                Arguments.of("آیا سیستم میتواند گزینه های دیگری را به اشتباه به عنوان متن فارسی تشخیص دهد؟", true),
                Arguments.of("Lorem Ipsum Test", false),
                Arguments.of("これはペルシア語のテキストですか", false),
                Arguments.of("Это персидский текст?", false),
                Arguments.of("这是波斯文字吗?", false),
                Arguments.of("هل هذا نص فارسي؟", false),
                Arguments.of("", false),
                Arguments.of("أكد رئيس اللجنة العسكرية الممثلة لحكومة الوفاق الوطني في ليبيا أحمد علي أبو شحمة، أن اللجنة لا تستطيع تنفيذ خطتها لإخراج العناصر الأجنبية من أراضي البلاد.", false),
            )

        @JvmStatic
        fun provideHasPersianArgs(): Stream<Arguments> =
            Stream.of(
                Arguments.of("این یک متن فارسی است؟", true),
                Arguments.of("هل هذا نص فارسي؟", true),
                Arguments.of("آیا سیستم میتواند گزینه های دیگری را به اشتباه به عنوان متن فارسی تشخیص دهد؟", true),
                Arguments.of("This text includes فارسی", true),
                Arguments.of("Это персидский س текст?", true),
                Arguments.of("أكد رئيس اللجنة العسكرية الممثلة لحكومة الوفاق أراضي البلاد.", true),
                Arguments.of("Lorem Ipsum Test", false),
                Arguments.of("これはペルシア語のテキストですか", false),
                Arguments.of("Это персидский текст?", false),
                Arguments.of("这是波斯文字吗?", false),
                Arguments.of("", false),
            )
    }

    @Nested
    inner class IsPersianTest {

        @ParameterizedTest
        @MethodSource("dev.persianTools.feature.isPersian.FarsiCharactersTest#provideIsPersianArgs")
        fun `Is persian test`(input: String, result: Boolean) {
            assertThat(input.isPersian()).isEqualTo(result)
        }

    }

    @Nested
    inner class HasPersianTest {

        @ParameterizedTest
        @MethodSource("dev.persianTools.feature.isPersian.FarsiCharactersTest#provideHasPersianArgs")
        fun ` Has persian test `(input: String, result: Boolean) {
            assertThat(input.hasPersian()).isEqualTo(result)
        }

    }
}