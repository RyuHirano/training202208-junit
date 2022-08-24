package com.example.training202208junit.parameterizedtest;

import java.time.LocalDate;
import org.apache.commons.lang3.ObjectUtils;

/** MethodSourceのサンプル. */
public class MethodSourceSample {

  /**
   * 年月日からLocalDateを生成する.
   *
   * @param year 年
   * @param month 月
   * @param day 日
   * @return LocalDate
   */
  public LocalDate generateLocalDate(Integer year, Integer month, Integer day) {

    if (ObjectUtils.anyNull(year, month, day)) {
      throw new NullPointerException("引数にnullが含まれています");
    }

    return LocalDate.of(year, month, day);
  }
}
