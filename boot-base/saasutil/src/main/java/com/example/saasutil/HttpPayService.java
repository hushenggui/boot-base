package com.example.saasutil;

import com.example.saasutil.util.JacksonUtils;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-04-18 17:16
 **/
public class HttpPayService {

  public static void main(String[] args) {
    String ids = "ND6KRB\n"
             + "38EEH7\n"
             + "ND6KRB\n"
             + "WF9E7L\n"
             + "WF9E7L\n"
             + "T72RAQ\n"
             + "T72RAQ\n"
             + "QC6SHS\n"
             + "QC6SHS\n"
             + "AYMSTQ\n"
             + "AYMSTQ\n"
             + "R5TF33\n"
             + "R5TF33\n"
             + "45QJTY\n"
             + "TA23GD\n"
             + "45QJTY\n"
             + "TA23GD\n"
             + "9F4656\n"
             + "KCD7NW\n"
             + "9F4656\n"
             + "KCD7NW\n"
             + "CGFAA3\n"
             + "CYL6BR\n"
             + "CGFAA3\n"
             + "CYL6BR\n"
             + "L6P25S\n"
             + "N6WATQ\n"
             + "L6P25S\n"
             + "N6WATQ\n"
             + "XL7J3A\n"
             + "XL7J3A\n"
             + "5DLHRQ\n"
             + "5DLHRQ\n"
             + "C4KFA7\n"
             + "C4KFA7\n"
             + "J7BKX8\n"
             + "WD99X6\n"
             + "J7BKX8\n"
             + "WD99X6\n"
             + "373N73\n"
             + "R2D5XQ\n"
             + "373N73\n"
             + "R2D5XQ\n"
             + "WBXSPX\n"
             + "WBXSPX\n"
             + "XLY8QF\n"
             + "XLY8QF\n"
             + "5EANQW\n"
             + "5EANQW\n"
             + "QTRG7W\n"
             + "QTRG7W\n"
             + "CDDLH5\n"
             + "CDDLH5\n"
             + "WQFFWT\n"
             + "37T9RT\n"
             + "WQFFWT\n"
             + "37T9RT\n"
             + "6L64R5\n"
             + "D377G4\n"
             + "6L64R5\n"
             + "D377G4\n"
             + "T3SAXT\n"
             + "T3SAXT\n"
             + "A7QCN9\n"
             + "A7QCN9\n"
             + "LYDDWD\n"
             + "LYDDWD\n"
             + "5N2DMK\n"
             + "5N2DMK\n"
             + "6694LK\n"
             + "6694LK\n"
             + "75F6C8\n"
             + "75F6C8\n"
             + "DFBLP2\n"
             + "BDYA2X\n"
             + "DFBLP2\n"
             + "BDYA2X\n"
             + "64T5N6\n"
             + "L75F4D\n"
             + "64T5N6\n"
             + "L75F4D\n"
             + "2GTLY6\n"
             + "2GTLY6\n"
             + "FEDSGF\n"
             + "FEDSGF\n"
             + "KMA486\n"
             + "MH26B7\n"
             + "KMA486\n"
             + "MH26B7\n"
             + "XT8M9B\n"
             + "ACP959\n"
             + "XT8M9B\n"
             + "ACP959\n"
             + "DY4C6B\n"
             + "DY4C6B\n"
             + "QBQ3NP\n"
             + "QBQ3NP\n"
             + "H7RQ43\n"
             + "H7RQ43\n"
             + "S2MHMQ\n"
             + "S2MHMQ\n"
             + "74EDGM\n"
             + "74EDGM\n"
             + "X2MRA5\n"
             + "X2MRA5\n"
             + "ACL6DW\n"
             + "ACL6DW\n"
             + "W63A86\n"
             + "W63A86\n"
             + "H3KPCF\n"
             + "H3KPCF\n"
             + "P7EHMC\n"
             + "P7EHMC\n"
             + "HHJ2XW\n"
             + "GD2Y2Q\n"
             + "HHJ2XW\n"
             + "GD2Y2Q\n"
             + "5FFHSX\n"
             + "WRM5EX\n"
             + "5FFHSX\n"
             + "WRM5EX\n"
             + "Y493J5\n"
             + "Y493J5\n"
             + "6792AN\n"
             + "6792AN\n"
             + "RJT6CF\n"
             + "RJT6CF\n"
             + "PPMTEG\n"
             + "PPMTEG\n"
             + "XSJDHF\n"
             + "XSJDHF\n"
             + "DLFNBX\n"
             + "2BTLAX\n"
             + "DLFNBX\n"
             + "2BTLAX\n"
             + "QQ56NY\n"
             + "R53DD8\n"
             + "QQ56NY\n"
             + "R53DD8\n"
             + "Q77B7N\n"
             + "LRYJQ2\n"
             + "Q77B7N\n"
             + "LRYJQ2\n"
             + "HSY4FX\n"
             + "HSY4FX\n"
             + "QBKR47\n"
             + "QBKR47\n"
             + "HQ3QQP\n"
             + "HQ3QQP\n"
             + "R4B553\n"
             + "R4B553\n"
             + "44CPPB\n"
             + "44CPPB\n"
             + "PJEYJW\n"
             + "PJEYJW\n"
             + "7APCEY\n"
             + "7APCEY\n"
             + "6E4RYB\n"
             + "6E4RYB\n"
             + "4LKWJ6\n"
             + "8HCRS7\n"
             + "4LKWJ6\n"
             + "8HCRS7\n"
             + "NLX738\n"
             + "NLX738\n"
             + "BAESAB\n"
             + "FF7PRC\n"
             + "BAESAB\n"
             + "FF7PRC\n"
             + "J7BW2J\n"
             + "J7BW2J\n"
             + "MGN78K\n"
             + "MGN78K\n"
             + "P2GJHW\n"
             + "P2GJHW\n"
             + "GE5C7R\n"
             + "GE5C7R\n"
             + "SGRBKA\n"
             + "SGRBKA\n"
             + "3H35XA\n"
             + "3H35XA\n"
             + "RLN54P\n"
             + "TTJK94\n"
             + "RLN54P\n"
             + "TTJK94\n"
             + "K429G6\n"
             + "K429G6\n"
             + "G3P95B\n"
             + "G3P95B\n"
             + "5M6Q4T\n"
             + "9YMCC4\n"
             + "5M6Q4T\n"
             + "9YMCC4\n"
             + "NT43Y6\n"
             + "W9XPPW\n"
             + "NT43Y6\n"
             + "W9XPPW\n"
             + "2Y86JL\n"
             + "2Y86JL\n"
             + "G7YR5M\n"
             + "G7YR5M\n"
             + "W2W4LD\n"
             + "W2W4LD\n"
             + "XJLQ86\n"
             + "XJLQ86\n"
             + "GQAA8W\n"
             + "GQAA8W\n"
             + "7WCSEY\n"
             + "7WCSEY\n"
             + "FXQW55\n"
             + "FXQW55\n"
             + "Y5ME74\n"
             + "Y5ME74\n"
             + "3SF2KX\n"
             + "3SF2KX\n"
             + "KPT6QJ\n"
             + "XG5SGJ\n"
             + "KPT6QJ\n"
             + "XG5SGJ\n"
             + "R7FQBM\n"
             + "R7FQBM\n"
             + "XSHP9X\n"
             + "XSHP9X\n"
             + "NFCHDG\n"
             + "NFCHDG\n"
             + "TK97DR\n"
             + "TK97DR";


    Arrays.stream(ids.split("\n")).forEach(memo -> {
    HashMap hashMap = new HashMap();
    hashMap.put("memo", memo);
    String requestBody = JacksonUtils.obj2JsonString(hashMap);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<>(requestBody, headers);
    String url = "https://wangjiang-jy.gongbao.cn/eg-service/tool/transferAccountsFailSharing";
    String responseMsg = getRestTemplate().postForObject(url, param, String.class);
    System.out.println("memo ========" + memo);
    System.out.println("res ===== " + responseMsg);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });





    /*HashMap hashMap = new HashMap();
    hashMap.put("tradeSerialNo","");
    String requestBody = JacksonUtils.obj2JsonString(hashMap);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<>(requestBody, headers);
    String url = "https://mas-jy.gongbao.cn/eg-service/payInfo/transferAccountsFail";
    String responseMsg = getRestTemplate().postForObject(url, param, String.class);
    System.out.println(responseMsg);*/
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
          public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
          }
          public void checkClientTrusted(
              X509Certificate[] certs, String authType) {
          }
          public void checkServerTrusted(
              X509Certificate[] certs, String authType) {
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
