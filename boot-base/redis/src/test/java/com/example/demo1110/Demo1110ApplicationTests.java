package com.example.demo1110;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@SpringBootTest(classes = Demo1110Application.class)
class Demo1110ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("redis --", "123", Duration.ofSeconds(3));
        System.out.println("redis ------------------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("redis2 2222222222222222222");
    }
}
