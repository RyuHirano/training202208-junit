package com.example.training202208junit.mock;

import org.springframework.stereotype.Component;

/** DIされるサンプル. */
@Component
public class InjectSample {

  /**
   * ハローを返すメソッド.
   *
   * @return Hello
   */
  public String getHello() {
    return "Hello";
  }
}
