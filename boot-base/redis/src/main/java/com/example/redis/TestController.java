package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

/**
 * @program: base
 * @description: 测试控制类
 * @author: hushenggui
 * @create: 2020-11-10 14:24
 **/
@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("test")
    public String test1(){
        stringRedisTemplate.opsForValue().set("redis --", "123", Duration.ofSeconds(10));
        System.out.println("redis ------------------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("redis2 2222222222222222222");

        return "success";
    }
}
