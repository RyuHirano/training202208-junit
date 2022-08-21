package com.example.training202208junit.data.adaptor;

import com.example.training202208junit.data.adaptor.response.QiitaResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/** QiitaのAPI Adaptor. */
@Component
@RequiredArgsConstructor
@Slf4j
public class QiitaAdaptor {
  private final RestTemplate restTemplate;

  @Value("${api.uri}")
  private String apiUri;

  /**
   * Qiitaの記事を取得する.
   *
   * @return List&lt;QiitaResponse&gt;
   */
  public List<QiitaResponse> getQiitaArticleList() {
    final String url = creteUrl();
    try {
      return restTemplate
          .exchange(
              url, HttpMethod.GET, null, new ParameterizedTypeReference<List<QiitaResponse>>() {})
          .getBody();
    } catch (RestClientException ex) {
      log.error(ex.getMessage());
    }
    return null;
  }

  private String creteUrl() {
    return UriComponentsBuilder.fromHttpUrl(apiUri)
        .queryParam("page", 1)
        .queryParam("per_page", 10)
        .queryParam("query", "java")
        .toUriString();
  }
}
