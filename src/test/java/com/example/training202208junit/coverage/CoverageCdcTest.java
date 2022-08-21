package com.example.training202208junit.coverage;

import org.junit.jupiter.api.Test;

class CoverageCdcTest {
  private final CoverageCdc coverageCdc = new CoverageCdc();

  /*
    テストパターン
    No.  a1    a2    a3    b1    b2
    1    false true  false false false
    2    true  false true  true  true
  */
  @Test
  void execute_正常系_テストパターン1を実行する() {
    coverageCdc.execute(0, 1, 0, 0, 0);
  }

  @Test
  void execute_正常系_テストパターン2を実行する() {
    coverageCdc.execute(1, 0, 1, 1, 1);
  }
}
