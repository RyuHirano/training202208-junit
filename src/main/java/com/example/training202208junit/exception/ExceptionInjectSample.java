package com.example.training202208junit.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/** DIされるサンプル. */
@Component
public class ExceptionInjectSample {

  /**
   * メッセージを返すメソッド.
   *
   * @return メッセージ
   * @throws IllegalArgumentException 例外
   */
  public String getMessage(String keyword) {
    if (StringUtils.equals("Hello", keyword)) {
      return "こんにちは！";
    }

    throw new IllegalArgumentException("keywordが正しくありません");
  }
}
