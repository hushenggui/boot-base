package com.example.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: ares-margin
 * @description: 分布式锁配置类
 * @author: hushenggui
 * @create: 2024-02-21 10:51
 **/
@Configuration
public class LockConfig {


  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private String port;

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.database}")
  private String database;
  @Bean
  public RedissonClient getClient() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://" + host + ":" + port).setDatabase(Integer.parseInt(database)).setPassword(password);
    return Redisson.create(config);
  }
}
