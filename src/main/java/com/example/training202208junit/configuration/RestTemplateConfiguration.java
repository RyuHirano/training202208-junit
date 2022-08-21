package com.example.training202208junit.configuration;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** RestTemplateのConfigurationクラス. */
@Configuration
public class RestTemplateConfiguration {
  private static final int CONNECTION_TIMEOUT_SECOND = 10;
  private static final int READ_TIMEOUT_SECOND = 10;

  /**
   * RestTemplate初期化.
   *
   * @return RestTemplate
   */
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT_SECOND))
        .setReadTimeout(Duration.ofSeconds(READ_TIMEOUT_SECOND))
        .build();
  }
}
