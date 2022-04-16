package com.husg.gongbao.nongshang.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.util.CollectionUtils;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-11-08 13:17
 **/
public class NSHttpUtil {

  /**
   * http请求
   *
   * @param url
   * @param params    请求参数
   * @param headers   请求头
   * @param method    请求方式
   * @param mediaType 参数类型,application/json,application/x-www-form-urlencoded
   * @return
   */
  public static String request(String url, String params, Map<String, String> headers, String method) {
    String result = null;
    if (url == null || url.trim().isEmpty()) {
      return null;
    }
    method = method.toUpperCase();
    OutputStreamWriter writer = null;
    InputStream in = null;
    ByteArrayOutputStream resOut = null;
    try {
      URL httpUrl = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
      if (method.equals("POST") || method.equals("PUT")) {
        conn.setDoOutput(true);
        conn.setUseCaches(false);
      }
      conn.setReadTimeout(8000);
      conn.setConnectTimeout(5000);
      conn.setRequestMethod(method);
      conn.setRequestProperty("Accept-Charset", "utf-8");
      // 添加请求头
      if (headers != null) {
        Iterator<String> iterator = headers.keySet().iterator();
        while (iterator.hasNext()) {
          String key = iterator.next();
          conn.setRequestProperty(key, headers.get(key));
        }
      }
      // 添加参数
      if (params != null) {
        conn.setRequestProperty("Content-Length", String.valueOf(params.length()));
        writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(params);
        writer.flush();
      }
      // 判断连接状态
      if (conn.getResponseCode() >= 300) {
        throw new RuntimeException("HTTP Request is not success, Response code is " + conn.getResponseCode());
      }
      // 获取返回数据
      in = conn.getInputStream();
      resOut = new ByteArrayOutputStream();
      byte[] bytes = new byte[1024];
      int len;
      while ((len = in.read(bytes)) != -1) {
        resOut.write(bytes, 0, len);
      }
      result = resOut.toString();
      // 断开连接
      conn.disconnect();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (resOut != null) {
        try {
          resOut.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }


}
