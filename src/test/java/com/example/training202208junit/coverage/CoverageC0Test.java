package com.example.training202208junit.coverage;

import org.junit.jupiter.api.Test;

class CoverageC0Test {
  private final CoverageC0 coverageC0 = new CoverageC0();

  /*
   テストパターン
   No.  a1    a2    a3    b1   b2
   1    false false true  true false
   2    false false false true false
  */
  @Test
  void execute_正常系_テストパターン1を実行する() {
    coverageC0.execute(0, 0, 1, 1, 0);
  }

  @Test
  void execute_正常系_テストパターン2を実行する() {
    coverageC0.execute(0, 0, 0, 1, 0);
  }
}
