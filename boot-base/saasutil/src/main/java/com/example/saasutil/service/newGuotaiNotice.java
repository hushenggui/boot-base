package com.example.saasutil.service;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.FileUtil;
import com.example.saasutil.util.GuotaiUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.vo.GuoTaiApplyNoticeBean;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
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
 * @create: 2021-12-30 10:57
 **/
@Slf4j
public class newGuotaiNotice {


  public static void main(String[] args) throws Exception {
    /*String json = "{\"appkey\":\"finance_gongbaowang\",\"applyno\":\"TBaoHanGBWBH2022022314223517227\",\"biaoduanname\":\"22yLFrP+hxQKOJe71oMF4Q==\",\"biaoduanno\":\"ZQTlFtJoYGGph9ER3ft7rOynfKUgdTF2gGqvpgvv9fk=\",\"biddercode\":\"123456789987654332\",\"biddername\":\"江苏国泰测试用单位新疆4建\",\"bzjamount\":\"20000.00\",\"jbrname\":\"张三\",\"jbrphone\":\"18118833439\",\"platformcode\":\"A3205650121\",\"sign\":\"0aad4d9c91de0ea47ba9aac295397e96f8b8113577049b0587222fd3c168504c\",\"timestamp\":\"2022-02-23 14:22:13\",\"zbr\":\"XhKYCAmA6IqQvH/eDuTabVrzVPeTmWLluA0X4fkU00k=\",\"zbrorgnum\":\"6ParPCtarP8r5rCLbv3wZ1gIEjlmUW27AOfUxd+85ww=\"}";

    String appKey = "finance_gongbaowang";
    String signKey = "9c821377-9c04-4adb-96ae-c987f06e1b21";
    String sign = GuotaiUtil.encode(json, appKey, signKey);
    System.out.println(json);
    System.out.println(sign);

    String param = "Reason=测试&appkey=finance_gongbaowang&applyno=TBaoHanGBWBH2022022314223517227&applyusername=测试&applyuserphone=18118833439&baohanno=1&filelist=[{\"fileurl\":\"http://www.baidu.com/img/flexible/logo/pc/result.png\"}]&payeraccount=1&payeramount=1&platformcode=A3205650121&timestamp=2022-02-23 16:07:17&appsecret=9c821377-9c04-4adb-96ae-c987f06e1b21";
    byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
    StringBuilder signature = new StringBuilder();
    for (byte b : signHash) {
      signature.append(byteToHexString(b));
    }
    System.out.println(signature.toString());*/
    String json = "{\n"
        + "    \"appkey\":null,\n"
        + "    \"timestamp\":\"2023-05-22 13:30:11\",\n"
        + "    \"applyno\":\"TBaoHanGBS2023051717301699259\",\n"
        + "    \"baohanno\":\"12374003902038471277\",\n"
        + "    \"baohanurl\":\"https://xjbt-jy.gongbao.cn/ic-service/gongbaoToInsurance/download?policyNo=12374003902038471277\",\n"
        + "    \"baohanfile\":null,\n"
        + "    \"payername\":\"石河子开发区宏业建筑安装工程有限责任公司\",\n"
        + "    \"payeraccount\":\"3016028309022500578\",\n"
        + "    \"instname\":\"中国平安财产保险股份有限公司\",\n"
        + "    \"generatetime\":\"2023-05-22 13:30:05\",\n"
        + "    \"rate\":\"0.008\",\n"
        + "    \"cost\":\"600.00\",\n"
        + "    \"applystatus\":\"1\",\n"
        + "    \"sign\":null\n"
        + "}";

    Map<String, String> map = new LinkedHashMap<>();
    map = JacksonUtils.jsonString2Obj(json, Map.class);
    File tempFile = new File("E:\\policyFile\\xinjiang\\12374003902038471277.pdf");
    //String url = "https://textapi.fadada.com/api2/downLoadContract.action?app_id=500825&v=2.0&timestamp=20230523150005&contract_id=PREWL202305220357605768&msg_digest=NjNBQzREMzMxODUyQzcyRURBQzJDNUE4MzI0N0I3QkNEOENGNzE1Qw==";
    //FileUtil.copyURLToFile(url, tempFile);
    String fileToBase64 =  Base64Util.fileToBase64(tempFile);
    map.put("baohanfile", fileToBase64);
    String json1 = JacksonUtils.obj2JsonString(map);
    String appKey = "finance_gbinsure";
    String signKey = "317307f1-781f-40da-9a0f-e5513ca8de64";
    String sign = GuotaiUtil.encode(json1, appKey, signKey);
    System.out.println("=================");
    System.out.println();
    System.out.println(json1);
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(sign);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    GuoTaiApplyNoticeBean noticeBean = JacksonUtils.jsonString2Obj(json, GuoTaiApplyNoticeBean.class);
    log.info("投保申请结果通知 请求参数为:============[" + JacksonUtils.obj2JsonString(noticeBean) + "]============");
    noticeBean.setBaohanfile(fileToBase64);
    noticeBean.setAppkey(appKey);
    noticeBean.setSign(sign);
    HttpEntity<GuoTaiApplyNoticeBean> request = new HttpEntity<>(noticeBean, headers);
    String httpUrl = "http://119.3.37.28:81/epoint-financeproduct-web/rest/gbsapi/baohannotice";
    String resp = getRestTemplate().postForObject(httpUrl, request, String.class);
    log.info("投保申请结果通知 返回参数为:============[" + resp + "]============");
    System.out.println("------------" + resp);

/*    byte[] bytes = Base64Util.decodeImage(str);
    File tempFile1 = new File("E:\\1111.pdf");
    FileUtils.writeByteArrayToFile(tempFile1, bytes);*/

  }

  public static String byteToHexString(byte ib) {
    char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    char[] ob = new char[2];
    ob[0] = Digit[(ib >>> 4) & 0X0f];
    ob[1] = Digit[ib & 0X0F];
    String str = new String(ob);
    return str;
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
