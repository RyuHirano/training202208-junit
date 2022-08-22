package com.example.training202208junit.resttemplate;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
class QiitaAdaptorTest {
  @Autowired private RestTemplate restTemplate;
  @Autowired private QiitaAdaptor qiitaAdaptor;
  private MockRestServiceServer mockRestServiceServer;

  @BeforeEach
  void setup() {
    mockRestServiceServer = MockRestServiceServer.bindTo(restTemplate).build();
  }

  @Test
  void getQiitaArticleList_正常系_レスポンスを取得できる() {
    // 準備
    final String url = "https://example.com/api/v2/items?page=1&per_page=10&query=java";
    final String responseBody = "[{\"title\":\"123\"}]";

    mockRestServiceServer
        .expect(MockRestRequestMatchers.requestTo(url))
        .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
        .andRespond(MockRestResponseCreators.withSuccess(responseBody, MediaType.APPLICATION_JSON));

    final QiitaResponse response = new QiitaResponse();
    response.setTitle("123");
    final List<QiitaResponse> expected = List.of(response);

    // 実行
    final List<QiitaResponse> actual = qiitaAdaptor.getQiitaArticleList();

    // 検証
    Assertions.assertThat(actual).isEqualTo(expected);
    // モックが全て消化されているか確認
    mockRestServiceServer.verify();
  }

  @Test
  void getQiitaArticleList_異常系_APIサーバーがエラーを返す() {
    // 準備
    final String url = "https://example.com/api/v2/items?page=1&per_page=10&query=java";

    mockRestServiceServer
        .expect(MockRestRequestMatchers.requestTo(url))
        .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
        .andRespond(MockRestResponseCreators.withServerError());

    final QiitaResponse response = new QiitaResponse();
    response.setTitle("123");
    final List<QiitaResponse> expected = List.of(response);

    // 実行&検証
    Assertions.assertThatThrownBy(() -> qiitaAdaptor.getQiitaArticleList())
        .isInstanceOf(RestClientException.class);

    // モックが全て消化されているか確認
    mockRestServiceServer.verify();
  }
}
