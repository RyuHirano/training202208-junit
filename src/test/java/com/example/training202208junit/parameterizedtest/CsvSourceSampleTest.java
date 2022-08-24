package com.example.training202208junit.parameterizedtest;

import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class CsvSourceSampleTest {
  private final CsvSourceSample csvSourceSample = new CsvSourceSample();

  @ParameterizedTest
  @CsvSource(value = {"2022,1,1,2022-01-01", "2022,12,31,2022-12-31"})
  void generateLocalDate_正常系_CsvSource(int year, int month, int day, LocalDate expected) {
    // 実行
    final LocalDate actual = csvSourceSample.generateLocalDate(year, month, day);
    // 検証
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testData.csv")
  void generateLocalDate_正常系_CsvFileSource(int year, int month, int day, LocalDate expected) {
    // 実行
    final LocalDate actual = csvSourceSample.generateLocalDate(year, month, day);
    // 検証
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
