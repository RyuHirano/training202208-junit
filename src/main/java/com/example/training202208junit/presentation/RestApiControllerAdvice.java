package com.example.training202208junit.presentation;

import com.example.training202208junit.domain.response.ErrorResponse;
import java.nio.file.AccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** REST APIのエラー処理. */
// @Primary
@RestControllerAdvice
@Slf4j
public class RestApiControllerAdvice {

  @ExceptionHandler({AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ErrorResponse handleException(AccessDeniedException ex) {
    log.error(ex.getMessage());
    return new ErrorResponse("アクセスエラー", "アクセス権限がありません");
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleException(Exception ex) {
    log.error(ex.getMessage());
    return new ErrorResponse("システムエラー", "予期しないエラーが発生しました");
  }
}
