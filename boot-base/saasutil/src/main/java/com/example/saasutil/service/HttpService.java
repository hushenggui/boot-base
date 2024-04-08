package com.example.saasutil.service;

import com.example.saasutil.service.universion.OrderInfoVo;
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
public class HttpService {

  public static void main(String[] args) {
    String ids =
         "10150103405002023060615115161768\n"
        + "1014010340500202306061511518207\n"
        + "10150103405002023060615115725769\n"
        + "10140103405002023060615115711348\n"
        + "10150103405002023060615120119422\n"
        + "10150103405002023060615120246309\n"
        + "10140103405002023060615120186647\n"
        + "10140103405002023060615120235879\n"
        + "10150103405002023060615125794530\n"
        + "10140103405002023060615125757581\n"
        + "1015010340500202306061513043913\n"
        + "10140103405002023060615130423938\n"
        + "10150103405002023060615133431474\n"
        + "10140103405002023060615133451273\n"
        + "10150103405002023060615134764126\n"
        + "10140103405002023060615134719918\n"
        + "10150103405002023060615151970950\n"
        + "1014010340500202306061515192795\n"
        + "10150103405002023060615154341392\n"
        + "1014010340500202306061515436022\n"
        + "10150103405002023060615164163783\n"
        + "10140103405002023060615164162642\n"
        + "10150103405002023060615164992309\n"
        + "10140103405002023060615164969216\n"
        + "10150103405002023060615190453234\n"
        + "10140103405002023060615190415227\n"
        + "10150103405002023060615193593205\n"
        + "10140103405002023060615193522499\n"
        + "10150103405002023060615204033949\n"
        + "10140103405002023060615204035719\n"
        + "10150103405002023060615232640748\n"
        + "10140103405002023060615232650612\n"
        + "10150103405002023060615234787049\n"
        + "10140103405002023060615234735803\n"
        + "10150103405002023060615235329918\n"
        + "10140103405002023060615235398274\n"
        + "10150103405002023060615272273722\n"
        + "10140103405002023060615272278539\n"
        + "10150103405002023060615282090092\n"
        + "10140103405002023060615282080749\n"
        + "1015010340500202306061530445622\n"
        + "10140103405002023060615304459369\n"
        + "10150103405002023060615314085430\n"
        + "10140103405002023060615314063011\n"
        + "10150103405002023060615315476346\n"
        + "10140103405002023060615315493041\n"
        + "10150103405002023060615315771151\n"
        + "10150103405002023060615315922889\n"
        + "10140103405002023060615315817106\n"
        + "10140103405002023060615315993654\n"
        + "10150103405002023060615321612945\n"
        + "10140103405002023060615321611486\n"
        + "10150103405002023060615362896979\n"
        + "10140103405002023060615362852398\n"
        + "10150103405002023060615363295869\n"
        + "10140103405002023060615363263055\n"
        + "10150103405002023060615384629308\n"
        + "10140103405002023060615384612997\n"
        + "10150103405002023060615405083905\n"
        + "10140103405002023060615405070896\n"
        + "10150103405002023060615412334992\n"
        + "10140103405002023060615412385988\n"
        + "10150103405002023060615425799299\n"
        + "10140103405002023060615425721805\n"
        + "10150103405002023060615444117426\n"
        + "10140103405002023060615444149782\n"
        + "10150103405002023060615465528502\n"
        + "10150103405002023060615465527202\n"
        + "10140103405002023060615465540513\n"
        + "10140103405002023060615465531870\n"
        + "10150103405002023060615465951160\n"
        + "1014010340500202306061546595269\n"
        + "10150103405002023060615491967800\n"
        + "10150103405002023060615492050557\n"
        + "10140103405002023060615491937590\n"
        + "10140103405002023060615492010194\n"
        + "10150103405002023060615494159907\n"
        + "10140103405002023060615494175227\n"
        + "10150103405002023060615501774452\n"
        + "10140103405002023060615501738739\n"
        + "10150103405002023060615503938070\n"
        + "10140103405002023060615503944128\n"
        + "10150103405002023060615530210139\n"
        + "10140103405002023060615530256781\n"
        + "10150103405002023060615535486205\n"
        + "10140103405002023060615535419263\n"
        + "10140103405002023060615540519928\n"
        + "10150103405002023060615544296060\n"
        + "1014010340500202306061554426655\n"
        + "10150103405002023060615555580596\n"
        + "10150103405002023060615555633743\n"
        + "10140103405002023060615555580962\n"
        + "10140103405002023060615555698327\n"
        + "10150103405002023060615555964202\n"
        + "10140103405002023060615555988753\n"
        + "10150103405002023060615562166423\n"
        + "10140103405002023060615562176206\n"
        + "10150103405002023060615563066208\n"
        + "10140103405002023060615563017673\n"
        + "10150103405002023060615571684370\n"
        + "10150103405002023060615571742377\n"
        + "10140103405002023060615571611602\n"
        + "1014010340500202306061557174517\n"
        + "10150103405002023060616062748592\n"
        + "10140103405002023060616062763062\n"
        + "10150103405002023060616070679673\n"
        + "10140103405002023060616070670993\n"
        + "10150103405002023060616074611758\n"
        + "10140103405002023060616074675823\n"
        + "10150103405002023060616101425811\n"
        + "10140103405002023060616101493615\n"
        + "10150103405002023060616110997737\n"
        + "10140103405002023060616110915509\n"
        + "10150103405002023060616115565182\n"
        + "10140103405002023060616115564534\n"
        + "10150103405002023060616135769312\n"
        + "10140103405002023060616135788858\n"
        + "10140103405002023060616152331881\n"
        + "10150103405002023060616155049052\n"
        + "10150103405002023060616155110212\n"
        + "10140103405002023060616155078003\n"
        + "1014010340500202306061615513230\n"
        + "10150103405002023060616160596890\n"
        + "10140103405002023060616160545390\n"
        + "10150103405002023060616172212578\n"
        + "10140103405002023060616172232945\n"
        + "10150103405002023060616211747133\n"
        + "10140103405002023060616211774655\n"
        + "10150103405002023060616251723356\n"
        + "10140103405002023060616251763477\n"
        + "10150103405002023060616261221474\n"
        + "10140103405002023060616261295769\n"
        + "1015010340500202306061626141754\n"
        + "10140103405002023060616261421313\n"
        + "10150103405002023060616310549218\n"
        + "10140103405002023060616310550194\n"
        + "10150103405002023060616353462227\n"
        + "101401034050020230606163534606";


    Arrays.stream(ids.split("\n")).forEach(tradeSerialNo -> {
    HashMap hashMap = new HashMap();
    hashMap.put("tradeSerialNo", tradeSerialNo);
    String requestBody = JacksonUtils.obj2JsonString(hashMap);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<>(requestBody, headers);
    String url = "https://mas-jy.gongbao.cn/eg-service/payInfo/transferAccountsFail";
    String responseMsg = getRestTemplate().postForObject(url, param, String.class);
    System.out.println("tradeSerialNo ========" + tradeSerialNo);
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
