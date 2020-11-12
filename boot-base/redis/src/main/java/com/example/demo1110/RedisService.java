package com.example.demo1110;

import org.springframework.stereotype.Service;

/**
 * @program: microservice-framework
 * @description:
 * @author: hushenggui
 * @create: 2020-11-09 18:06
 **/
@Service
public class RedisService {
    /**
     * @param redis消息key值
     * @Description TODO 接受监听到的消息
     * @Param
     * @Return
     * @Author
     * @Date 15:05 2020/5/25
     */
    public void receiveMessage(String message) {

        System.out.println("接收redis通道消息：" + message);
        //业务逻辑调用区域
    }

}
