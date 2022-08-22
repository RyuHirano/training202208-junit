package com.example.training202208junit.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockSampleTest {
  @InjectMocks private MockSample mockSample;

  @Mock private InjectSample injectSample;

  @Test
  void hello_正常系_こんばんはが返される() {
    // 準備
    Mockito.when(injectSample.getHello()).thenReturn("こんばんは");

    // 実行
    final String actual = mockSample.hello();

    // 検証
    Assertions.assertThat(actual).isEqualTo("こんばんは");
    Mockito.verify(injectSample, Mockito.times(1)).getHello();
  }
}
