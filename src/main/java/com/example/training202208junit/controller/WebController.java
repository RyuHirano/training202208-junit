package com.example.training202208junit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Webサイトのコントローラクラス. */
@Controller
@RequestMapping
public class WebController {

  /**
   * indexページを返すメソッド.
   *
   * @param model Model
   * @return indexページ
   */
  @GetMapping("/")
  public String index(Model model) {

    model.addAttribute("message", "こんにちは");

    return "index";
  }
}
