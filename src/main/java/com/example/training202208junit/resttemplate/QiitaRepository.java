package com.example.training202208junit.resttemplate;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/** Qiita APIのリポジトリ. */
@Component
@RequiredArgsConstructor
@Slf4j
public class QiitaRepository {
  private final QiitaAdaptor qiitaAdaptor;

  /** Qiita APIから値を取得して出力する. */
  public void execute() {
    log.info(Objects.toString(qiitaAdaptor.getQiitaArticleList()));
  }
}
