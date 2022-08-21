package com.example.training202208junit.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** RestApiController. */
@Tag(name = "api/v1")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class RestApiController {
  /**
   * get.
   *
   * @return string
   */
  @GetMapping("get")
  @Operation(description = "挨拶を返します")
  public String get() {
    return "Hello";
  }
}
