package com.example.training202208junit.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
class LogSampleTest {
  private final LogSample logSample = new LogSample();

  @Captor private ArgumentCaptor<LoggingEvent> captorLoggingEvent;
  @Mock private Appender<ILoggingEvent> mockAppender;
  Logger logger;

  @BeforeEach
  void setup() {
    logger = (Logger) LoggerFactory.getLogger(LogSample.class);
    logger.addAppender(mockAppender);
  }

  @Test
  void output_正常系_ログが出力されることを検証する() {
    // 実行
    logSample.output();

    // ログ検証の前に必要、但し１回出力にしか対応していない
    Mockito.verify(mockAppender).doAppend(captorLoggingEvent.capture());
    // 複数回ログをキャプチャする場合は以下のように指定する
    // Mockito.verify(mockAppender, Mockito.times(2)).doAppend(captorLoggingEvent.capture());

    // ログレベルを検証
    final String logLevel = captorLoggingEvent.getValue().getLevel().toString();
    Assertions.assertThat(logLevel).isEqualTo("INFO");

    // ログ出力内容を検証
    final boolean isCorrectLog = captorLoggingEvent.getValue().toString().equals("[INFO] OK");
    Assertions.assertThat(isCorrectLog).isTrue();
  }
}
