package com.example.training202208junit.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** SwaggerのConfigurationクラス. */
@Configuration
public class SwaggerConfiguration {
  /**
   * OpenAPIの初期化.
   *
   * @return OpenAPI
   */
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI().info(new Info().title("Java 講習会").description("Swagger Sample"));
  }
}
