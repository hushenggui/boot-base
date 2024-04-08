package com.example.saasutil.service;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.FileUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.UUIDGenUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.util.ObjectUtils;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-05-10 15:37
 **/
public class FileService {


 /* public static void main(String[] args) {
    try {
      String base64 = "PCFET0NUWVBFIGh0bWw+DQo8aHRtbCBsYW5nPSJlbiI+DQo8aGVhZD4NCiAgICA8bWV0YSBjaGFyc2V0PSJ1dGYtOCI+DQogICAgPG1ldGEgaHR0cC1lcXVpdj0iWC1VQS1Db21wYXRpYmxlIiBjb250ZW50PSJJRT1lZGdlIj4NCiAgICA8IS0tIDxtZXRhIG5hbWU9InZpZXdwb3J0IiBjb250ZW50PSJ3aWR0aD1kZXZpY2Utd2lkdGgsaW5pdGlhbC1zY2FsZT0xLjAiPiAtLT4NCiAgICA8bWV0YSBodHRwLWVxdWl2PSJYLVVBLUNvbXBhdGlibGUiIGNvbnRlbnQ9IklFPTExIiAvPg0KICAgIDxsaW5rIHJlbD0iaWNvbiIgaHJlZj0iZmF2aWNvbi5pY28iPg0KICAgIDx0aXRsZT7kuK3lm73pk7bkv53kv6HnlLXlrZDljJbmnI3liqHlubPlj7A8L3RpdGxlPg0KPGxpbmsgaHJlZj0iMC5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iMS5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iMTAuanMiIHJlbD0icHJlZmV0Y2giPjxsaW5rIGhyZWY9IjExLmpzIiByZWw9InByZWZldGNoIj48bGluayBocmVmPSIxMi5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iMi5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iMy5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iNC5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iNS5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iNi5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iNy5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iOC5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iOS5qcyIgcmVsPSJwcmVmZXRjaCI+PGxpbmsgaHJlZj0iYXBwLmpzIiByZWw9InByZWxvYWQiIGFzPSJzY3JpcHQiPjwvaGVhZD4NCjxib2R5Pg0KPG5vc2NyaXB0Pg0KICAgIDxzdHJvbmc+V2UncmUgc29ycnkgYnV0IG91ciBwcm9qZWN0IGRvZXNuJ3Qgd29yayBwcm9wZXJseSB3aXRob3V0IEphdmFTY3JpcHQgZW5hYmxlZC4gUGxlYXNlIGVuYWJsZSBpdCB0bw0KICAgICAgICBjb250aW51ZS48L3N0cm9uZz4NCjwvbm9zY3JpcHQ+DQo8ZGl2IGlkPSJhcHAiPjwvZGl2Pg0KPCEtLSBidWlsdCBmaWxlcyB3aWxsIGJlIGF1dG8gaW5qZWN0ZWQgLS0+DQo8c2NyaXB0IHR5cGU9InRleHQvamF2YXNjcmlwdCIgc3JjPSJhcHAuanMiPjwvc2NyaXB0PjwvYm9keT4NCjxzY3JpcHQ+DQoNCjwvc2NyaXB0Pg0KPC9odG1sPg0K";
      byte[] decode = Base64Util.decodeImage(base64);
      File localFile = new File("E:\\", "45611.pdf");
      FileOutputStream fileOutputStream = new FileOutputStream(localFile);
      IOUtils.write(decode, fileOutputStream);
  *//*    File tempFile = new File("E:\\1234.pdf");
      String base64Temp =  Base64Util.fileToBase64(tempFile);

      File localFile1 = new File("E:\\", "789.pdf");
      FileOutputStream fileOutputStream1 = new FileOutputStream(localFile1);
      IOUtils.write(Base64Util.decodeImage(base64Temp), fileOutputStream1);*//*

      String ss = getBsae64("E:\\", "http://61.138.246.87:6001/prepro/#/S?d=e1a31d10ece0d604","hu1");
      System.out.println(ss);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }*/

  public static void main(String[] args) {
    File tempFile = null;
    try {
      tempFile = FileUtil.copyURLToFile("D:\\", "12321321", "http://test-tb.cngongbao.net:2080/upload/EP202400034012000123.pdf", "00009");
      String base64 = Base64Util.fileToBase64(tempFile);
      /*byte[] decode = Base64Util.decodeImage(base64);
      File localFile = new File("E:\\", "45611.pdf");
      FileOutputStream fileOutputStream = new FileOutputStream(localFile);
      IOUtils.write(decode, fileOutputStream);*/
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static String getBsae64(String temp, String url, String fileName) {
    File tempFile = null;
    try {
      tempFile = FileUtil.copyURLToFile(temp, UUIDGenUtil.createUUID(), url, "");
    } catch (Exception e) {

    }
    String base64 = Base64Util.fileToBase64(tempFile);
    return base64;
  }

}
