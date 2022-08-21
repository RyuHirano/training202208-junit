package com.example.training202208junit.coverage;

import org.junit.jupiter.api.Test;

class CoverageC1Test {
  private final CoverageC1 coverageC1 = new CoverageC1();

  /*
     テストパターン
     No.  a1    a2    a3    b1   b2
     1    false false true  false false
     2    false false false true false
  */
  @Test
  void execute_正常系_テストパターン1を実行する() {
    coverageC1.execute(0, 0, 1, 0, 0);
  }

  @Test
  void execute_正常系_テストパターン2を実行する() {
    coverageC1.execute(0, 0, 0, 1, 0);
  }
}
