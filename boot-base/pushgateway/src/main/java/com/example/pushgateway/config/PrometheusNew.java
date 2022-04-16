package com.example.pushgateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: huacailiang
 * @date: 2021/2/4
 * @description:
 **/
@Component
public class PrometheusNew {

  @Value("${prometheus.pushGateway.address}")
  String address;

  @Bean(name = "GBPushGateway")
  public GBPushGateway pushgateway() {
    GBPushGateway pushgateway = new GBPushGateway(address);
    pushgateway.setConnectionFactory(new CustomHttpConnectionFactory());
    return pushgateway;
  }
}
