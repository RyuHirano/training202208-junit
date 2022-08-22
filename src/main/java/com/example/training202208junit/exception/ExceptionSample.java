package com.example.training202208junit.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** Exceptionのサンプル. */
@Component
@RequiredArgsConstructor
public class ExceptionSample {
  private final ExceptionInjectSample exceptionInjectSample;

  /** メッセージを取得して返す. */
  public String getMessage(String keyword) {
    return exceptionInjectSample.getMessage(keyword);
  }
}
