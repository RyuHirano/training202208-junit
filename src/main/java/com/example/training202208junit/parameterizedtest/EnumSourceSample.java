package com.example.training202208junit.parameterizedtest;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public enum EnumSourceSample {
  DOG("dog"),
  CAT("cat"),
  BIRD("bird");

  public final String name;

  /**
   * nameからEnumSourceSampleを生成する.
   *
   * @param name name
   * @return EnumSourceSample
   */
  public static EnumSourceSample of(String name) {
    return Arrays.stream(EnumSourceSample.values())
        .filter(e -> StringUtils.equals(e.name, name))
        .findFirst()
        .orElse(null);
  }
}
