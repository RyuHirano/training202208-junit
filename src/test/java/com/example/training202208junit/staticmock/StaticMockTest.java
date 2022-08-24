package com.example.training202208junit.staticmock;

import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StaticMockTest {
  private MockedStatic<LocalDate> localDateMockedStatic;

  // LocalDateがモック化される前に宣言する必要あり
  final LocalDate expected = LocalDate.of(2022, 1, 1);

  @BeforeEach
  void setup() {
    localDateMockedStatic = Mockito.mockStatic(LocalDate.class);
  }

  @AfterEach
  void tearDown() {
    // 必ずclose
    localDateMockedStatic.close();
  }

  @Test
  void 正常系_モック化された現在日付を返す() {
    // 準備
    localDateMockedStatic.when(LocalDate::now).thenReturn(expected);

    // 実行
    final LocalDate actual = LocalDate.now();

    // 検証
    Assertions.assertThat(actual).isEqualTo(expected);
    localDateMockedStatic.verify(LocalDate::now, Mockito.times(1));
  }
}
