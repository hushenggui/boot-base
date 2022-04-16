package com.study.paasclient.controller;


import com.cngongbao.paas.client.build.PassClient;
import com.cngongbao.paas.client.dto.resp.FeignResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: components
 * @description: kafka控制类0.
 *
 * @author: hushenggui
 * @create: 2020-12-01 17:20
 **/
@RestController
@Slf4j
public class TestController {
    private static String domain = "http://127.0.0.1:8089/";
    @GetMapping(value = "test", produces = "application/json;charset=UTF-8")
    public String sendMessage() {
        String mehtod = "/msg/smsSender";
        String data = "{\n" +
                "    \"phone\": \"15026994738\",\n" +
                "    \"tempCode\": \"SMS_205126654\",\n" +
                "    \"sign\": \"【连云港市保证金平台】\"   \n" +
                "}";

        //String data = "{\"platform\":\"test\",\"key\":\"put1\"}";

        FeignResponse feignResponse = PassClient.custom(domain, mehtod, data)
                .setHttpMethod(HttpMethod.POST)
                .build();
        System.out.println(feignResponse);
        return "success";
    }
}
