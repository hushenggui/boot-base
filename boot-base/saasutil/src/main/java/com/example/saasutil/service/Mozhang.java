package com.example.saasutil.service;

import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.MoZhangUtils;
import com.example.saasutil.vo.GgzyListPolicy;
import com.example.saasutil.vo.GgzyPolicy;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

/**
 * @program: boot-base
 * @description: 墨仗还原推送
 * @author: hushenggui
 * @create: 2021-06-29 15:47
 **/
@Slf4j
public class Mozhang {
  public static void main(String[] args) throws UnsupportedEncodingException {
    BASE64Encoder base64Encoder = new BASE64Encoder();
    GgzyListPolicy ggzyListPolicy = new GgzyListPolicy();
    List<GgzyPolicy> ggzyPolicyList = new ArrayList<>();
    GgzyPolicy ggzyPolicy = new GgzyPolicy();
    ggzyPolicy.setAmount(null);
    ggzyPolicy.setOrderNo("202106171426280663");
    ggzyPolicy.setProjectName("长江通信物联网与智慧应用产业园施工总承包项目");
    ggzyPolicy.setBidSectionName("长江通信物联网与智慧应用产业园施工总承包项目");
    ggzyPolicy.setBidSectionCode("202101111439173177");
    ggzyPolicy.setTendereeName("武汉长江通信产业集团股份有限公司");
    ggzyPolicy.setTendereeCode("9142000030019146XY");
    ggzyPolicy.setTendereeAddress("武汉市东湖开发区关东工业园文华路2号");
    ggzyPolicy.setTendereeContact("张子沛");
    ggzyPolicy.setTendereeContactPhoneNumber("13807163686");
    ggzyPolicy.setOpenTime("2021-06-28 10:00:00");
    ggzyPolicy.setCloseTime("2021-06-28 10:00:00");
    ggzyPolicy.setBidtender("180");
    ggzyPolicyList.add(ggzyPolicy);
    ggzyListPolicy.setData(ggzyPolicyList);
    String signKey = "B86C37C1A09E49737E2F3139BCC35D78";
    String authorization = MoZhangUtils
        .getAuthorization(JacksonUtils.obj2JsonString(ggzyListPolicy), signKey);
    ggzyListPolicy.setAuthorization(authorization);
    String requestBody = JacksonUtils.obj2JsonString(ggzyListPolicy);
    log.info("requestBody1 {}", requestBody);
    requestBody = base64Encoder.encode(requestBody.getBytes("UTF-8"));
    log.info("requestBody2 {}", requestBody);


    HttpHeaders headers = new HttpHeaders();
    String area = "wuhan";
    headers.add("area", area);
    headers.setContentType(MediaType.TEXT_PLAIN);

    HttpEntity<String> param = new HttpEntity<>(requestBody, headers);
    String url = "https://wh-jy.gongbaojin.com/tc-service/ggzyApi/baohanrestore";
    String responseMsg = getRestTemplate().postForObject(url, param, String.class);

    log.info("{}落单响应报文={}",area,  responseMsg);
    HashMap respJson = JacksonUtils.jsonString2Obj(responseMsg, HashMap.class);
    System.out.println("处理结果：" + respJson);


    System.out.println(requestBody);
  }

  public static RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(Duration.ofMinutes(3)).setReadTimeout(
        Duration.ofMinutes(3)).build();

    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
        StandardCharsets.UTF_8);
    stringHttpMessageConverter.setWriteAcceptCharset(true);

    List<MediaType> mediaTypeList = new ArrayList<>();
    mediaTypeList.add(MediaType.ALL);

    for (int i = 0; i < restTemplate.getMessageConverters().size(); i++) {
      HttpMessageConverter<?> httpMessageConverter = restTemplate.getMessageConverters().get(i);
      if (httpMessageConverter instanceof StringHttpMessageConverter) {
        restTemplate.getMessageConverters().remove(i);
        restTemplate.getMessageConverters().add(i, stringHttpMessageConverter);
      } else if(httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
        try{
          ((MappingJackson2HttpMessageConverter) httpMessageConverter).setSupportedMediaTypes(mediaTypeList);
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
    ClientHttpRequestFactory requestFactory = null;
    TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
          }
          public void checkClientTrusted(
              java.security.cert.X509Certificate[] certs, String authType) {
          }
          public void checkServerTrusted(
              java.security.cert.X509Certificate[] certs, String authType) {
          }
        }
    };
    SSLContext sslContext = null;
    HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
    try {
      sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
      CloseableHttpClient httpClient = HttpClients.custom()
          .setSSLContext(sslContext)
          .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
          .build();
      customRequestFactory.setHttpClient(httpClient);
    } catch (Exception e) {
      e.printStackTrace();
    }
    requestFactory = (ClientHttpRequestFactory)customRequestFactory;
    restTemplate.setRequestFactory(requestFactory);
    return restTemplate;
  }
}
