package com.example.training202208junit.parameterizedtest;

import java.time.LocalDate;

/** CsvSourceのサンプル. */
public class CsvSourceSample {

  /**
   * 年月日からLocalDateを生成する.
   *
   * @param year 年
   * @param month 月
   * @param day 日
   * @return LocalDate
   */
  public LocalDate generateLocalDate(int year, int month, int day) {
    return LocalDate.of(year, month, day);
  }
}
