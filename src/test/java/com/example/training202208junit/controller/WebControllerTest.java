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
class WebControllerTest {
  private final WebController webController = new WebController();

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(webController).build();
  }

  @Test
  public void 正常系_webページが正しく表示されること() throws Exception {

    mockMvc
        // 実行
        .perform(MockMvcRequestBuilders.get("/"))
        // HTTPステータス検証
        .andExpect(MockMvcResultMatchers.status().isOk())
        // modelに格納されている内容を検証
        .andExpect(MockMvcResultMatchers.model().attribute("message", "こんにちは"))
        // viewテンプレート(Thymeleaf)の名前を検証
        .andExpect(MockMvcResultMatchers.view().name("index"));
  }
}
