package com.example.training202208junit.parameterizedtest;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MethodSourceSampleTest {
  private final MethodSourceSample methodSourceSample = new MethodSourceSample();

  @ParameterizedTest
  @MethodSource("source")
  void generateLocalDate_正常系_LocalDateが生成される(
      Integer year, Integer month, Integer day, LocalDate expected) {
    // 実行
    final LocalDate actual = methodSourceSample.generateLocalDate(year, month, day);
    // 検証
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("sourceContainsNull")
  void generateLocalDate_異常系_例外がスローされる(Integer year, Integer month, Integer day) {
    // 実行&検証
    Assertions.assertThatThrownBy(() -> methodSourceSample.generateLocalDate(year, month, day))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("引数にnullが含まれています");
  }

  static Stream<Arguments> source() {
    return Stream.of(
        Arguments.arguments(2022, 1, 1, "2022-01-01"),
        Arguments.arguments(2022, 12, 31, "2022-12-31"));
  }

  static Stream<Arguments> sourceContainsNull() {
    return Stream.of(Arguments.arguments(null, 1, 1), Arguments.arguments(2022, null, 31));
  }
}
