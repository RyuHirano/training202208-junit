package com.example.training202208junit.parameterizedtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class EnumSourceSampleTest {

  @ParameterizedTest
  @EnumSource(value = EnumSourceSample.class)
  void 正常系_通常パターン(EnumSourceSample enumSourceSample) {
    // 実行
    final EnumSourceSample actual = EnumSourceSample.of(enumSourceSample.name);
    // 検証
    Assertions.assertThat(actual).isEqualTo(enumSourceSample);
  }

  @ParameterizedTest
  @EnumSource(
      value = EnumSourceSample.class,
      names = {"DOG"},
      mode = EnumSource.Mode.INCLUDE)
  void 正常系_特定のEnumのみをテストする(EnumSourceSample enumSourceSample) {
    // 実行
    final EnumSourceSample actual = EnumSourceSample.of(enumSourceSample.name);
    // 検証
    Assertions.assertThat(actual).isEqualTo(enumSourceSample);
  }

  @ParameterizedTest
  @EnumSource(
      value = EnumSourceSample.class,
      names = {"DOG"},
      mode = EnumSource.Mode.EXCLUDE)
  void 正常系_特定のEnum以外をテストする(EnumSourceSample enumSourceSample) {
    // 実行
    final EnumSourceSample actual = EnumSourceSample.of(enumSourceSample.name);
    // 検証
    Assertions.assertThat(actual).isEqualTo(enumSourceSample);
  }

  @Test
  void 正常系_不正な値の場合はnullになる() {
    // 実行
    final EnumSourceSample actual = EnumSourceSample.of("dummy");
    // 検証
    Assertions.assertThat(actual).isNull();
  }
}
