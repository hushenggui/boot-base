package com.example.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-06-06 15:06
 **/
public class RedissonMain {

  public static void main(String[] args) {
    Config config = new Config();
    config.useSingleServer()
        .setAddress("redis://127.0.0.1:6379")
        .setPassword("123456")
        .setDatabase(0);
    //获取客户端
    RedissonClient redissonClient = Redisson.create(config);
    //获取所有的key
    redissonClient.getKeys().getKeys().forEach(key -> System.out.println(key));
    //关闭客户端
    redissonClient.shutdown();
  }

}
