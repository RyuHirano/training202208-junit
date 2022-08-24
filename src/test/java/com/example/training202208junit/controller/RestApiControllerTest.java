package com.example.training202208junit.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class RestApiControllerTest {
  private final RestApiController restApiController = new RestApiController();
  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(restApiController).build();
  }

  @Test
  public void 正常系_正しいレスポンスを取得できること() throws Exception {
    // 準備
    final String expected = "Hello, message";

    mockMvc
        // 実行
        .perform(MockMvcRequestBuilders.get("/api/v1/getHello").param("message", "message"))
        // HTTPステータス検証
        .andExpect(MockMvcResultMatchers.status().isOk())
        // レスポンスの内容を検証
        .andExpect(MockMvcResultMatchers.content().string(expected));
  }
}
