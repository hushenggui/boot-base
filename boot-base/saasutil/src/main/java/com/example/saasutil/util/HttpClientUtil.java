package com.example.saasutil.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

/**
 * 编写HttpClient发送请求
 */
@Slf4j
public class HttpClientUtil {

  public static final Integer HTTP_POST = 1;
  public static final Integer HTTP_GET = 2;
  public static final Integer HTTP_JSON = 3;

  public static final String UTF8 = "UTF-8";
  public static final String GBK = "gbk";
  public static final String GB2312 = "gb2312";
  public static final String ISO_8859_1 = "ISO-8859-1";


  /**
   * @param url       发送请求地址
   * @param param     发送请求的参数信息
   * @param httpType  发送请求的类型，post为HttpClient.HTTP_POST;get为HttpClient.HTTP_GET
   * @param uriEncode 发送请求的字符集编码，HttpClient.UTF8；HttpClient.GBK；HttpClient.GB2312；HttpClient.ISO_8859_1；
   * @param timeOut   发送请求的相应时间
   * @return 发送请求的返回值或者null
   * @throws RuntimeException
   * @throws Exception        发送异常信息
   */
  public static String sendHttpUrl(String url, Map<String, String> param, Integer httpType,
      String uriEncode, Integer timeOut) throws RuntimeException, Exception {
    CloseableHttpClient client = HttpClients.createDefault();
    RequestConfig config = RequestConfig.custom().setSocketTimeout(timeOut)
        .setConnectTimeout(timeOut).build();
    CloseableHttpResponse response = null;
    if (HttpClientUtil.HTTP_GET.compareTo(httpType) == 0) {
      StringBuilder sb = new StringBuilder();
      String responseUrl;
      sb.append(url);
      if (param != null && param.size() > 0) {
        sb.append("?");
        for (String key : param.keySet()) {
          sb.append(key).append("=").append(param.get(key)).append("&");
        }
        responseUrl = sb.toString().trim().substring(0, sb.toString().trim().length() - 1);
      } else {
        responseUrl = url;
      }
      HttpGet httpGet = new HttpGet(responseUrl);
      httpGet.setConfig(config);
      httpGet.setHeader("User-Agent",
          "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625Firefox/3.6.6 Greatwqs");
      httpGet
          .setHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json");
      httpGet.setHeader("Accept-Language", "zh-cn,zh");
      switch (uriEncode) {
        case HttpClientUtil.UTF8:
          httpGet.setHeader("Accept-Charset", "utf-8");
          break;
        case HttpClientUtil.GBK:
          httpGet.setHeader("Accept-Charset", "gbk");
          break;
        case HttpClientUtil.GB2312:
          httpGet.setHeader("Accept-Charset", "gb2312");
          break;
        case HttpClientUtil.ISO_8859_1:
          httpGet.setHeader("Accept-Charset", "ISO-8859-1");
          break;
        default:
          httpGet.setHeader("Accept-Charset", "utf-8");
          break;
      }
      response = client.execute(httpGet);
    } else if (HttpClientUtil.HTTP_POST.compareTo(httpType) == 0) {
      HttpPost post = new HttpPost(url);
      if (param != null && param.size() > 0) {
        List<NameValuePair> nvpList = new ArrayList<>();
        for (String key : param.keySet()) {
          BasicNameValuePair bnvpObject = new BasicNameValuePair(key, param.get(key));
          nvpList.add(bnvpObject);
        }
        if (uriEncode != null) {
          switch (uriEncode) {
            case HttpClientUtil.UTF8:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new UrlEncodedFormEntity(nvpList, UTF8));
              break;
            case HttpClientUtil.GBK:
              post.setHeader("Accept-Charset", "gbk");
              post.setEntity(new UrlEncodedFormEntity(nvpList, GBK));
              break;
            case HttpClientUtil.GB2312:
              post.setHeader("Accept-Charset", "gb2312");
              post.setEntity(new UrlEncodedFormEntity(nvpList, GB2312));
              break;
            case HttpClientUtil.ISO_8859_1:
              post.setHeader("Accept-Charset", "ISO-8859-1");
              post.setEntity(new UrlEncodedFormEntity(nvpList, ISO_8859_1));
              break;
            default:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new UrlEncodedFormEntity(nvpList));
              break;
          }
        } else {
          post.setHeader("Accept-Charset", "utf-8");
          post.setEntity(new UrlEncodedFormEntity(nvpList));
        }
      }
      post.setConfig(config);
      post.setHeader("User-Agent",
          "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625Firefox/3.6.6 Greatwqs");
      post.setHeader("Accept", "*/*");
      post.setHeader("Accept-Language", "zh-cn,zh");
      response = client.execute(post);
    } else if (HttpClientUtil.HTTP_JSON.compareTo(httpType) == 0) {
      HttpPost post = new HttpPost(url);
      if (param != null && param.size() > 0) {
        Gson gson = new Gson();
        if (uriEncode != null) {
          switch (uriEncode) {
            case HttpClientUtil.UTF8:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new StringEntity(gson.toJson(param), UTF8));
              break;
            case HttpClientUtil.GBK:
              post.setHeader("Accept-Charset", "gbk");
              post.setEntity(new StringEntity(gson.toJson(param), GBK));
              break;
            case HttpClientUtil.GB2312:
              post.setHeader("Accept-Charset", "gb2312");
              post.setEntity(new StringEntity(gson.toJson(param), GB2312));
              break;
            case HttpClientUtil.ISO_8859_1:
              post.setHeader("Accept-Charset", "ISO-8859-1");
              post.setEntity(new StringEntity(gson.toJson(param), ISO_8859_1));
              break;
            default:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new StringEntity(gson.toJson(param), UTF8));
              break;
          }
        } else {
          post.setHeader("Accept-Charset", "utf-8");
          post.setEntity(new StringEntity(gson.toJson(param), UTF8));
        }
      }
      post.setConfig(config);
      post.setHeader("User-Agent",
          "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625Firefox/3.6.6 Greatwqs");
      post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json");
      post.setHeader("Accept-Language", "zh-cn,zh");
      post.setHeader("Content-Type", "application/json");
      response = client.execute(post);
    }
    if (response != null) {
      String responseValue;
      if (uriEncode != null) {
        responseValue = EntityUtils.toString(response.getEntity(), uriEncode);
      } else {
        responseValue = EntityUtils.toString(response.getEntity(), "UTF-8");
      }
      if (response.getStatusLine().getStatusCode() == 200) {
        /** 请求正常*/
        response.close();
        client.close();
        return responseValue;
      } else {
        throw new Exception(responseValue);
      }
    } else {
      if (client != null) {
        client.close();
      }
      return null;
    }

  }

  /**
   * @param url       发送请求地址
   * @param param     发送请求的参数信息
   * @param httpType  发送请求的类型，post为HttpClient.HTTP_POST;get为HttpClient.HTTP_GET
   * @param uriEncode 发送请求的字符集编码，HttpClient.UTF8；HttpClient.GBK；HttpClient.GB2312；HttpClient.ISO_8859_1；
   * @param timeOut   发送请求的相应时间
   * @return 发送请求的返回值或者null
   * @throws RuntimeException
   * @throws Exception        发送异常信息
   */
  public static String sendHttpPostBody(String url, String param, Integer httpType,
      String uriEncode, Integer timeOut) throws RuntimeException, Exception {
    log.info("url {}, param {}, httpType {}, uriEncode {}, timeOut {}", url, param, httpType,
        uriEncode, timeOut);
    enableSSL();
    RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
        .setExpectContinueEnabled(true)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
        .<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory)
        .build();
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
        socketFactoryRegistry);
    CloseableHttpClient client = HttpClients.custom().setConnectionManager(connectionManager)
        .setDefaultRequestConfig(requestConfig).build();

    //CloseableHttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
    RequestConfig config = RequestConfig.custom().setSocketTimeout(timeOut)
        .setConnectTimeout(timeOut).build();
    CloseableHttpResponse response = null;
    if (HttpClientUtil.HTTP_POST.compareTo(httpType) == 0) {
      HttpPost post = new HttpPost(url);

      if (StringUtils.hasText(param)) {
        List<NameValuePair> nvpList = new ArrayList<>();
        if (uriEncode != null) {
          switch (uriEncode) {
            case HttpClientUtil.UTF8:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new UrlEncodedFormEntity(nvpList, UTF8));
              break;
            case HttpClientUtil.GBK:
              post.setHeader("Accept-Charset", "gbk");
              post.setEntity(new UrlEncodedFormEntity(nvpList, GBK));
              break;
            case HttpClientUtil.GB2312:
              post.setHeader("Accept-Charset", "gb2312");
              post.setEntity(new UrlEncodedFormEntity(nvpList, GB2312));
              break;
            case HttpClientUtil.ISO_8859_1:
              post.setHeader("Accept-Charset", "ISO-8859-1");
              post.setEntity(new UrlEncodedFormEntity(nvpList, ISO_8859_1));
              break;
            default:
              post.setHeader("Accept-Charset", "utf-8");
              post.setEntity(new UrlEncodedFormEntity(nvpList));
              break;
          }
        } else {
          post.setHeader("Accept-Charset", "utf-8");
          post.setEntity(new UrlEncodedFormEntity(nvpList));
        }
      }
      post.setConfig(config);
      post.setHeader("User-Agent",
          "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625Firefox/3.6.6 Greatwqs");
      post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json");
      post.setHeader("Accept-Language", "zh-cn,zh");
      post.setHeader("Content-Type", "application/json; charset=UTF-8");
      post.setEntity(new StringEntity(param, "UTF-8"));
      response = client.execute(post);
    }
    if (response != null) {
      String responseValue;
      if (uriEncode != null) {
        responseValue = EntityUtils.toString(response.getEntity(), uriEncode);
      } else {
        responseValue = EntityUtils.toString(response.getEntity(), "UTF-8");
      }
      if (response.getStatusLine().getStatusCode() == 200) {
        /** 请求正常*/
        response.close();
        client.close();
        log.info("responseValue {}", responseValue);
        return responseValue;
      } else {
        throw new Exception(responseValue);
      }
    } else {
      if (client != null) {
        client.close();
      }
      return null;
    }

  }

  private static TrustManager manager = new X509TrustManager() {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
        throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
        throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }
  };

  private static void enableSSL() {
    try {
      SSLContext context = SSLContext.getInstance("TLSv1.2");
      context.init(null, new TrustManager[]{manager}, null);
      socketFactory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    }
  }

  private static SSLConnectionSocketFactory socketFactory;

  public static String doHttpsPost(String url, Map<String, String> param) throws Exception {
    enableSSL();
    RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
        .setExpectContinueEnabled(true)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
        .<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory)
        .build();
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
        socketFactoryRegistry);
    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
        .setDefaultRequestConfig(requestConfig).build();

    HttpPost post = new HttpPost(url);
    List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
    if (param != null && param.size() > 0) {
      for (String key : param.keySet()) {
        BasicNameValuePair bnvpObject = new BasicNameValuePair(key, param.get(key));
        nvpList.add(bnvpObject);
      }
    }

    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvpList, Consts.UTF_8);
    post.setEntity(entity);
    CloseableHttpResponse response = httpClient.execute(post);

    if (response != null) {
      String responseValue;
      responseValue = EntityUtils.toString(response.getEntity(), "UTF-8");
      if (response.getStatusLine().getStatusCode() == 200) {
        return responseValue;
      } else {
        throw new Exception(responseValue);
      }
    } else {
      return null;
    }
  }

  private static void trustAllHttpsCertificates() throws Exception {
    TrustManager[] trustAllCerts = new TrustManager[1];
    TrustManager tm = new miTM();
    trustAllCerts[0] = tm;
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
  }

  static class miTM implements TrustManager, X509TrustManager {

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }

    public boolean isServerTrusted(X509Certificate[] certs) {
      return true;
    }

    public boolean isClientTrusted(X509Certificate[] certs) {
      return true;
    }

    @Override
    public void checkServerTrusted(X509Certificate[] certs, String authType)
        throws CertificateException {
      return;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] certs, String authType)
        throws CertificateException {
      return;
    }
  }


  /**
   * 太保专用
   *
   * @param url
   * @param requestMsg
   * @return
   */
  public static String sentHttpsPostRequestTaiBao(String requestMsg, String url) {

    // 设置超时时间
    int timeout = 60000;
    RequestConfig config = RequestConfig.custom()
        .setConnectTimeout(timeout)
        .setConnectionRequestTimeout(timeout)
        .setSocketTimeout(timeout).build();
    HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

    // 导入数字证书并注册SSLSocketFactory
    try {
      registerSSLSocketFactory(httpclient);
    } catch (Exception e) {
      e.printStackTrace();
    }

/*		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		try {
			trustAllHttpsCertificates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpsURLConnection.setDefaultHostnameVerifier(hv);*/

    // 注意：必须以post方式发送请求
    HttpPost httppost = new HttpPost(url);
    // 设置请求参数
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    // 版本标识
    params.add(new BasicNameValuePair("messageRouter", "3"));
    // 业务伙伴代码
    params.add(new BasicNameValuePair("tradingPartner", "BJDLBX"));
    // 业务协议
    params.add(new BasicNameValuePair("documentProtocol", "CPIC_ECOM"));
    // xml请求报文
    params.add(new BasicNameValuePair("requestMessage", requestMsg));
    // 注意：编码必须是UTF-8
    HttpEntity request = null;
    try {
      request = new UrlEncodedFormEntity(params, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    httppost.setEntity(request);
    // 返回内容为xml，请使用xml解析工具对返回内容进行解析
    HttpResponse httpResponse = null;
    try {
      httpResponse = httpclient.execute(httppost);
    } catch (IOException e) {
      e.printStackTrace();
    }
    HttpEntity entity = httpResponse.getEntity();
    String result = null;
    if (entity != null) {
      try {
        result = EntityUtils.toString(entity);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;

  }

  /**
   * 中华专用
   *
   * @param url
   * @param bodyXml
   * @return
   */
  public static String httpsPostBody(String url, String bodyXml) throws Exception {
    enableSSL();
    RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
        .setExpectContinueEnabled(true)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
        .<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory)
        .build();
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
        socketFactoryRegistry);
    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
        .setDefaultRequestConfig(requestConfig).build();

    HttpPost post = new HttpPost(url);
		/*List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
		if (param != null && param.size() > 0) {
			for (String key : param.keySet()) {
				BasicNameValuePair bnvpObject = new BasicNameValuePair(key, param.get(key));
				nvpList.add(bnvpObject);
			}
		}*/

    //UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvpList, Consts.UTF_8);
    post.setHeader("Accept-Charset", "gbk");
    post.setEntity(new StringEntity(bodyXml, "GBK"));
    CloseableHttpResponse response = httpClient.execute(post);

    if (response != null) {
      String responseValue;
      responseValue = EntityUtils.toString(response.getEntity(), "UTF-8");
      if (response.getStatusLine().getStatusCode() == 200) {
        return responseValue;
      } else {
        throw new Exception(responseValue);
      }
    } else {
      return null;
    }

  }

  /**
   * 太保专用
   *
   * @param requestMsg
   * @return
   * @throws Exception
   */
  public static String sentHttpPostRequestTaiBao(String requestMsg, String url) throws Exception {
    // 设置超时时间
    int timeout = 60000;
    RequestConfig config = RequestConfig.custom()
        .setConnectTimeout(timeout)
        .setConnectionRequestTimeout(timeout)
        .setSocketTimeout(timeout).build();
    HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    // 注意：必须以post方式发送请求
    HttpPost httppost = new HttpPost(url);
    // 设置请求参数
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    // 版本标识
    params.add(new BasicNameValuePair("messageRouter", "3"));
    // 业务伙伴代码
    params.add(new BasicNameValuePair("tradingPartner", "BJDLBX"));
    // 业务协议
    params.add(new BasicNameValuePair("documentProtocol", "CPIC_ECOM"));
    // xml请求报文
    params.add(new BasicNameValuePair("requestMessage", requestMsg));

    // 注意：编码必须是UTF-8
    HttpEntity request = new UrlEncodedFormEntity(params, "UTF-8");
    httppost.setEntity(request);

    // 返回内容为xml，请使用xml解析工具对返回内容进行解析
    HttpResponse httpResponse = httpclient.execute(httppost);
    HttpEntity entity = httpResponse.getEntity();
    String result = null;
    if (entity != null) {
      result = EntityUtils.toString(entity);
    }
    return result;
  }


  /**
   * 中华专用
   *
   * @param url         访问地址
   * @param busCode     业务
   * @param partnerCode
   * @param user
   * @param pwd
   * @param requestMsg
   * @return
   * @throws Exception
   */
  public static String sentHttpPostRequestZhongHua(String url, String busCode, String partnerCode,
      String user, String pwd, String requestMsg) throws Exception {
    // 设置超时时间
    int timeout = 60000;
    RequestConfig config = RequestConfig.custom()
        .setConnectTimeout(timeout)
        .setConnectionRequestTimeout(timeout)
        .setSocketTimeout(timeout).build();
    HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    // 注意：必须以post方式发送请求
    HttpPost httppost = new HttpPost(url);
    httppost.setHeader("Accept-Charset", "gbk");

    httppost.setHeader("GW_CH_TX", busCode);
    httppost.setHeader("GW_CH_CODE", partnerCode);
    httppost.setHeader("GW_CH_USER", user);
    httppost.setHeader("GW_CH_PWD", pwd);
    //httppost.setHeader("GW_FACADE_FLAG", "4");
    httppost.setHeader("Content-Type", "text/xml; charset=GBK");
    httppost.setEntity(new StringEntity(requestMsg, "gbk"));

    // 返回内容为xml，请使用xml解析工具对返回内容进行解析
    HttpResponse httpResponse = httpclient.execute(httppost);
    HttpEntity entity = httpResponse.getEntity();
    String result = null;
    if (entity != null) {
      result = EntityUtils.toString(entity);
    }
		/*if (entity != null){
			InputStream instreams = entity.getContent();
			result = ConvertStreamToString(instreams);
			System.out.println("Response:" + "\n" + result);
		}*/
    return result;
  }

  // Convert stream to string
  private static String ConvertStreamToString(InputStream is) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
    } catch (IOException e) {
      System.out.println("Error=" + e.toString());
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        System.out.println("Error=" + e.toString());
      }
    }
    return sb.toString();

  }


  /**
   * 短信服务用
   *
   * @param url       发送请求地址
   * @param param     发送请求的参数信息
   * @param httpType  发送请求的类型，post为HttpClient.HTTP_POST;get为HttpClient.HTTP_GET
   * @param uriEncode 发送请求的字符集编码，HttpClient.UTF8；HttpClient.GBK；HttpClient.GB2312；HttpClient.ISO_8859_1；
   * @param timeOut   发送请求的相应时间
   * @return 发送请求的返回值或者null
   * @throws RuntimeException
   * @throws Exception        发送异常信息
   */
  public static String sendHttpPostJsonBody(String url, String param, Integer httpType,
      String uriEncode, Integer timeOut) throws RuntimeException, Exception {

    enableSSL();
    RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
        .setExpectContinueEnabled(true)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
        .<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory)
        .build();
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
        socketFactoryRegistry);
    CloseableHttpClient client = HttpClients.custom().setConnectionManager(connectionManager)
        .setDefaultRequestConfig(requestConfig).build();

    //		CloseableHttpClient client = HttpClients.createDefault();
    RequestConfig config = RequestConfig.custom().setSocketTimeout(timeOut)
        .setConnectTimeout(timeOut).build();
    CloseableHttpResponse response = null;
    if (HttpClientUtil.HTTP_POST.compareTo(httpType) == 0) {
      HttpPost post = new HttpPost(url);
      if (StringUtils.hasText(param)) {
        List<NameValuePair> nvpList = new ArrayList<>();
        if (uriEncode != null) {
          switch (uriEncode) {
            case HttpClientUtil.UTF8:
              post.setHeader("Accept-Charset", "utf-8");
              //post.setEntity(new UrlEncodedFormEntity(nvpList, UTF8));
              break;
            case HttpClientUtil.GBK:
              post.setHeader("Accept-Charset", "gbk");
              //post.setEntity(new UrlEncodedFormEntity(nvpList, GBK));
              break;
            case HttpClientUtil.GB2312:
              post.setHeader("Accept-Charset", "gb2312");
              //post.setEntity(new UrlEncodedFormEntity(nvpList, GB2312));
              break;
            case HttpClientUtil.ISO_8859_1:
              post.setHeader("Accept-Charset", "ISO-8859-1");
              //post.setEntity(new UrlEncodedFormEntity(nvpList, ISO_8859_1));
              break;
            default:
              post.setHeader("Accept-Charset", "utf-8");
              //post.setEntity(new UrlEncodedFormEntity(nvpList));
              break;
          }
        } else {
          post.setHeader("Accept-Charset", "utf-8");
          //post.setEntity(new UrlEncodedFormEntity(nvpList));
        }
      }
      post.setConfig(config);
      //post.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625Firefox/3.6.6 Greatwqs");
      //post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml,application/json");
      //post.setHeader("Accept-Language", "zh-cn,zh");
      post.setHeader("Content-Type", "application/json;charset=UTF-8");
      post.setEntity(new StringEntity(param, "UTF-8"));
      response = client.execute(post);
    }
    if (response != null) {
      String responseValue;
      if (uriEncode != null) {
        responseValue = EntityUtils.toString(response.getEntity(), uriEncode);
      } else {
        responseValue = EntityUtils.toString(response.getEntity(), "UTF-8");
      }
      if (response.getStatusLine().getStatusCode() == 200) {
        /** 请求正常*/
        response.close();
        client.close();
        return responseValue;
      } else {
        throw new Exception(responseValue);
      }
    } else {
      if (client != null) {
        client.close();
      }
      return null;
    }
  }


  private static void registerSSLSocketFactory(HttpClient httpclient) throws Exception {
		/*KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream instream = new FileInputStream(new File("/data/work/ins-ssl/cpicJttp.keystore"));

		try {
			trustStore.load(instream, "cpicJttp".toCharArray());
		} finally {
			instream.close();
		}
		SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
		Scheme sch = new Scheme("https",socketFactory,443);
		httpclient.getConnectionManager().getSchemeRegistry().register(sch);*/

  }

  public static String covertRespBean2String(Object obj, String contentType) {
    String respString;
    if (contentType.toLowerCase().contains("xml")) {
      respString = JacksonUtils.obj2XmlString(obj);
    } else {
      respString = JacksonUtils.obj2JsonString(obj);
    }
    return respString;
  }

  public static String buildSignErrorResp(String result, String contentType) {
    return null;
  }

  public static String getHttpUrl(HttpServletRequest request) {
    StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
    String queryString = request.getQueryString();
    if (queryString == null) {
      return requestURL.toString();
    } else {
      return requestURL.append('?').append(queryString).toString();
    }
  }
}
