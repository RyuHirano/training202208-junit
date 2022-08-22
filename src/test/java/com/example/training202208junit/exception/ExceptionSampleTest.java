package com.example.training202208junit.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExceptionSampleTest {
  @InjectMocks private ExceptionSample exceptionSample;

  @Mock private ExceptionInjectSample injectSample;

  @Test
  void getMessage_正常系_メッセージが取得できる() {
    // 準備
    Mockito.when(injectSample.getMessage("Hello")).thenReturn("こんにちは");

    // 実行
    final String actual = exceptionSample.getMessage("Hello");

    // 検証
    Assertions.assertThat(actual).isEqualTo("こんにちは");
  }

  @Test
  void getMessage_異常系_IllegalArgumentExceptionがスローされる() {
    // 準備
    Mockito.when(injectSample.getMessage("Hello")).thenThrow(new IllegalArgumentException("Error"));

    // 実行&検証
    Assertions.assertThatThrownBy(() -> exceptionSample.getMessage("Hello"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Error");

    Mockito.verify(injectSample, Mockito.times(1)).getMessage("Hello");
  }
}
