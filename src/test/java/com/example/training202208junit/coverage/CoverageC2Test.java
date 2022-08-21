package com.example.training202208junit.coverage;

import org.junit.jupiter.api.Test;

class CoverageC2Test {
  private final CoverageC2 coverageC2 = new CoverageC2();

  /*
    テストパターン
    No.  a1    a2    a3    b1    b2
    1    true  true  false true  false
    2    false false true  false true
  */
  @Test
  void execute_正常系_テストパターン1を実行する() {
    coverageC2.execute(1, 1, 0, 1, 0);
  }

  @Test
  void execute_正常系_テストパターン2を実行する() {
    coverageC2.execute(0, 0, 1, 0, 1);
  }
}
