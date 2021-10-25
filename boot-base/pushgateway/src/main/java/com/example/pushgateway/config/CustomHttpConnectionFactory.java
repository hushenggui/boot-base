package com.example.pushgateway.config;

import io.prometheus.client.exporter.HttpConnectionFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: huacailiang
 * @date: 2021/2/4
 * @description:
 **/
public class CustomHttpConnectionFactory implements HttpConnectionFactory {
  @Override
  public HttpURLConnection create(String url) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    // add any connection preparation logic you need
    return connection;
  }
}
