package com.example.saasutil.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author: huacailiang
 * @date: 2020/4/8
 * @description:
 **/
@Slf4j
public class RestTemplateUtil {

  public static ResponseEntity<String> postForEntity(String template, Map<String, String> dataMap, String url) throws Exception {

    Document document = DocumentHelper.parseText(template);
    Element element = document.getRootElement();
    String requestEntity = XmlUtil.readElement(element, dataMap, document);
    byte[] bytes = requestEntity.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

    log.info("url {}, data {}", url, utf8EncodedString);
    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, getHttpHeaders());
    ResponseEntity<String> stringResponseEntity = getRestTemplate().postForEntity(url, request, String.class);
    return stringResponseEntity;
  }

  public static ResponseEntity<String> postForEntity(String playLoad, String url) throws Exception {

    byte[] bytes = playLoad.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
    log.info("request url {}, data {}", url, utf8EncodedString);

    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, getHttpHeaders());
    ResponseEntity<String> stringResponseEntity = getRestTemplate().postForEntity(url, request, String.class);
    log.info("response url {}, data {}, response {}", url, utf8EncodedString, stringResponseEntity.getBody());
    return stringResponseEntity;
  }

  public static ResponseEntity<String> postForEntity(String playLoad, String url, String insCode) throws Exception {

    byte[] bytes = playLoad.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
    log.info("request url {}, data {}", url, utf8EncodedString);

    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, getHttpHeaders(insCode));
    ResponseEntity<String> stringResponseEntity = getRestTemplate().postForEntity(url, request, String.class);
    log.info("response url {}, data {}, response {}", url, utf8EncodedString, stringResponseEntity.getBody());
    return stringResponseEntity;
  }

  public static ResponseEntity<String> postForEntity(String playLoad, String url, HttpHeaders headers) throws Exception {
    byte[] bytes = playLoad.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
    log.info("url {}, data {}", url, utf8EncodedString);

    headers.setContentType(MediaType.APPLICATION_XML);
    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, headers);
    ResponseEntity<String> stringResponseEntity = getRestTemplate().postForEntity(url, request, String.class);
    return stringResponseEntity;
  }

  public static ResponseEntity<String> getForEntity(String url) throws Exception {
    log.info("url {}", url);

    ResponseEntity<String> stringResponseEntity = getRestTemplate().getForEntity(url, String.class);
    return stringResponseEntity;
  }

  static HttpHeaders getHttpHeaders() {

    HttpHeaders headers = new HttpHeaders();
    Charset utf8 = Charset.forName("UTF-8");
    MediaType mediaTypeXmlUtf8 = new MediaType("application", "xml", utf8);
    MediaType mediaTypeXml = new MediaType("application", "xml");
    MediaType mediaTypeJson = new MediaType("application", "json");
    MediaType mediaTypeHtml = new MediaType("text", "html");
    MediaType mediaTypeXHtml = new MediaType("application", "xhtml+xml");

    headers.setContentType(mediaTypeXmlUtf8);
    headers.setAccept(Arrays.asList(mediaTypeXml, mediaTypeJson, mediaTypeHtml, mediaTypeXHtml));
    headers.setAcceptCharset(Arrays.asList(utf8));
    return headers;
  }

  public static HttpHeaders getJsonHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    Charset utf8 = Charset.forName("UTF-8");
    MediaType mediaTypeXmlUtf8 = new MediaType("application", "xml", utf8);
    MediaType mediaTypeXml = new MediaType("application", "xml");
    MediaType mediaTypeJson = new MediaType("application", "json");
    MediaType mediaTypeHtml = new MediaType("text", "html");
    MediaType mediaTypeXHtml = new MediaType("application", "xhtml+xml");

    headers.setContentType(mediaTypeJson);
    headers.setAccept(Arrays.asList(mediaTypeXml, mediaTypeJson, mediaTypeHtml, mediaTypeXHtml));
    headers.setAcceptCharset(Arrays.asList(utf8));
    return headers;
  }

  static HttpHeaders getHttpHeaders(String insCode) {

    HttpHeaders headers = new HttpHeaders();
    Charset utf8 = Charset.forName("UTF-8");

    if(Company.PINGAN.getCode().equals(insCode)) {
      MediaType mediaTypeHtml = new MediaType("text", "html");
      MediaType mediaTypeJson = new MediaType("application", "json", utf8);
      headers.setAccept(Arrays.asList(mediaTypeHtml, mediaTypeJson));
    } else {
      MediaType mediaTypeXml = new MediaType("application", "xml");
      MediaType mediaTypeJson = new MediaType("application", "json");
      MediaType mediaTypeHtml = new MediaType("text", "html");
      MediaType mediaTypeXHtml = new MediaType("application", "xhtml+xml");
      headers.setAccept(Arrays.asList(mediaTypeXml, mediaTypeJson, mediaTypeHtml, mediaTypeXHtml));
    }

    MediaType mediaTypeXmlUtf8 = new MediaType("application", "xml", utf8);
    headers.setContentType(mediaTypeXmlUtf8);
    headers.setAcceptCharset(Arrays.asList(utf8));
    return headers;
  }

  public static RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(Duration.ofMinutes(3)).setReadTimeout(
        Duration.ofMinutes(3)).build();

    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
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

  public static String postForString(String playLoad, String url) throws Exception {
    byte[] bytes = playLoad.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
    log.info("request url {}, data {}", url, utf8EncodedString);

    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, getHttpHeaders());
    String stringResponseEntity = getRestTemplate().postForObject(url, request, String.class);
    log.info("response url {}, data {}, response {}", url, utf8EncodedString, stringResponseEntity);
    return stringResponseEntity;
  }

  public static String postForString(String playLoad, String url, HttpHeaders httpHeaders) throws Exception {
    byte[] bytes = playLoad.getBytes(StandardCharsets.UTF_8);
    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
    log.info("request url {}, data {}", url, utf8EncodedString);

    HttpEntity<String> request = new HttpEntity<>(utf8EncodedString, httpHeaders);
    String stringResponseEntity = getRestTemplate().postForObject(url, request, String.class);
    log.info("response url {}, data {}, response {}", url, utf8EncodedString, stringResponseEntity);
    return stringResponseEntity;
  }

  public static void main(String[] args) throws Exception {
    //接口参数
    Map<String, String> dataMap = new LinkedHashMap<>();
    dataMap.put("requestUUID", "320581-4092DC4FEFB5419B9DEEF52BD1E424EA");
    dataMap.put("name", "工保科技（浙江）有限公司");
    dataMap.put("mobile", "13627116142");
    dataMap.put("ProjectName", "y6Y10id9CaQ");
    dataMap.put("idNumber", "91430105MA4Q4UU10E");
    dataMap.put("BidSectionCode", "NGeaiVj5wol");
    dataMap.put("TendereeName", "dv2rAgYOmLh");
    dataMap.put("TendereeCode", "siDnioaZJK9");
    dataMap.put("TendereeAddress", "gE05AtJO1Im");
    dataMap.put("sumPremium", "0.01");
    dataMap.put("sumAmount", "1.25");
    dataMap.put("endorseText", "一、本特别约定，作为投标保证保险合同的有效组成部分，与保险保单或其它保险凭证具有同等法律效力。 二、保险单生效时间为投保项目投标截止时间，保险期间为投保项目《招标文件》中载明的投标有效期。 三、投保人违反所投项目《招标文件》规定要求导致投标保证金不予退还情形的均属于本保单保险责任。 四、退保处理 1.开标前投保人放弃投保或项目发生中止、暂停的，可进行退保； 2.开标前项目发生流标、终止的，可进行退保； 3.开标后项目发生流标的，可进行退保； 4.除上述3种情形外均不予退保。 5.投保人办理退保事宜，满足退保条件的，保险费全额退还。 五、线下理赔材料提供如下： 1.索赔申请书； 2.招标文件和投标文件； 3.投保人违约证明材料。 六、保险公司应在收到索赔申请书相关材料后10个工作日内完成理赔。 七、保险人向被保险人赔偿后，保险人享有向投保人追偿的权利。");

    String reqTemplate = "<?xml version=\"1.0\" encoding=\"utf-8\"?><insureRequest>   <requestHead>     <requestUUID>#requestUUID#</requestUUID>      <sign>#sign#</sign>   </requestHead>    <requestBody>     <applicantInfo>       <name>#name#</name>        <mobile>#mobile#</mobile>        <idNumber>#idNumber#</idNumber>        <ProjectName>#ProjectName#</ProjectName>        <BidSectionCode>#BidSectionCode#</BidSectionCode>        <TendereeName>#TendereeName#</TendereeName>        <TendereeCode>#TendereeCode#</TendereeCode>        <TendereeAddress>#TendereeAddress#</TendereeAddress>      <TendereeContactPhoneNumber>#TendereeContactPhoneNumber#</TendereeContactPhoneNumber>     </applicantInfo>      <policyInfo>       <sumPremium>#sumPremium#</sumPremium>        <sumAmount>#sumAmount#</sumAmount>       <endorseText>#endorseText#</endorseText>     </policyInfo>   </requestBody> </insureRequest>";
    String signXml = XmlUtil.getXml(reqTemplate, dataMap);
    String signKey = "ygNBYzHK31EXIK2sKu1eqEl29hKEEN";
    String signValue = SignUtil.getSignFromXml(signXml, signKey, "requestBody");
    dataMap.put("sign", signValue);
    String xml = XmlUtil.getXml(reqTemplate, dataMap);
    String httpUrl = "https://api.yongcheng.com:19090/apigateway/extra/workPlyController/callOrderApp";
    ResponseEntity<String> stringResponseEntity = RestTemplateUtil.postForEntity(xml, httpUrl);
    log.info("resp {}", stringResponseEntity.getBody());
    System.out.println(stringResponseEntity.getBody());
  }
}
