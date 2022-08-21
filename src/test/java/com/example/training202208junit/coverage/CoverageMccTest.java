package com.example.training202208junit.coverage;

import org.junit.jupiter.api.Test;

class CoverageMccTest {
  private final CoverageMcc coverageMcc = new CoverageMcc();

  /*
    テストパターン
    No.  a1    a2    a3    b1    b2
    1    false false false false false
    2    false false true  false true
    3    false true  false true  false
    4    false true  true  true  true
    5    true  false false false false
    6    true  false true  false false
    7    true  true  false true  false
    8    true  true  true  true  true
  */
  @Test
  void execute_正常系_テストパターン1を実行する() {
    coverageMcc.execute(0, 0, 0, 0, 0);
  }

  @Test
  void execute_正常系_テストパターン2を実行する() {
    coverageMcc.execute(0, 0, 1, 0, 1);
  }

  @Test
  void execute_正常系_テストパターン3を実行する() {
    coverageMcc.execute(0, 1, 0, 1, 0);
  }

  @Test
  void execute_正常系_テストパターン4を実行する() {
    coverageMcc.execute(0, 1, 1, 1, 1);
  }

  @Test
  void execute_正常系_テストパターン5を実行する() {
    coverageMcc.execute(1, 0, 0, 0, 0);
  }

  @Test
  void execute_正常系_テストパターン6を実行する() {
    coverageMcc.execute(1, 0, 1, 0, 0);
  }

  @Test
  void execute_正常系_テストパターン7を実行する() {
    coverageMcc.execute(1, 1, 0, 1, 0);
  }

  @Test
  void execute_正常系_テストパターン8を実行する() {
    coverageMcc.execute(1, 1, 1, 1, 1);
  }
}
