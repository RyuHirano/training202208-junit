package com.example.training202208junit.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MockSample.class)
class MockSampleWithSpringTest {
  @Autowired private MockSample mockSample;

  @MockBean private InjectSample injectSample;

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
