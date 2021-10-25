package com.example.pushgateway.config;

import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: huacailiang
 * @date: 2021/2/4
 * @description:
 **/
@Component
public class Prometheus {

  @Value("${prometheus.pushGateway.address}")
  String address;

  @Bean
  public PushGateway pushgateway() {
    PushGateway pushgateway = new PushGateway(address);
    pushgateway.setConnectionFactory(new CustomHttpConnectionFactory());
    return pushgateway;
  }
}
