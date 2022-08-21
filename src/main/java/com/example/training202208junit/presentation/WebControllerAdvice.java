package com.example.training202208junit.presentation;

import java.nio.file.AccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Web サイトのエラー処理. */
// @Primary
@ControllerAdvice
@Slf4j
public class WebControllerAdvice {

  @ExceptionHandler({AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public String handleException(AccessDeniedException ex) {
    log.error(ex.getMessage());
    return "error";
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleException(Exception ex) {
    log.error(ex.getMessage());
    return "error";
  }
}
