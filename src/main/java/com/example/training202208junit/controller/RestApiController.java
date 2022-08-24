package com.example.training202208junit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** RestApiController. */
@Tag(name = "api/v1")
@RestController
@RequestMapping("api/v1")
public class RestApiController {
  /**
   * 挨拶を返す.
   *
   * @param message メッセージ
   * @return string 挨拶
   */
  @GetMapping("getHello")
  @Operation(description = "挨拶を返します")
  public String getHello(@ParameterObject String message) {
    return "Hello, " + message;
  }
}
