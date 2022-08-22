package com.example.training202208junit.mock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** モックのサンプルクラス. */
@Component
@RequiredArgsConstructor
public class MockSample {
  private final InjectSample injectSample;

  /** ハローを取得して返す. */
  public String hello() {
    return injectSample.getHello();
  }
}
