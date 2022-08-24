package com.example.training202208junit.log;

import lombok.extern.slf4j.Slf4j;

/** ログ出力のサンプル. */
@Slf4j
public class LogSample {

  /** ログを出力する. */
  public void output() {
    log.info("OK");
  }
}
