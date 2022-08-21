package com.example.training202208junit.coverage;

/** 判定条件/条件網羅(CDC)サンプル. */
public class CoverageCdc {

  /** 判定条件/条件網羅(CDC) を実行する. */
  public void execute(int a1, int a2, int a3, int b1, int b2) {
    // 判定条件A
    if ((a1 > 0 && a2 > 0) || a3 > 0) {
      System.out.println("判定条件A: true");
    } else {
      System.out.println("判定条件A: false");
    }

    // 判定条件B
    if (b1 > 0 || b2 > 0) {
      System.out.println("判定条件B: true");
    }
  }
}
