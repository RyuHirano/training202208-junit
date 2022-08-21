package com.example.training202208junit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Spring Bootの起動クラス. */
@SpringBootApplication
@MapperScan("com.example.training202208junit.data.mapper") // Mapper読み込み定義
public class SpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }
}
