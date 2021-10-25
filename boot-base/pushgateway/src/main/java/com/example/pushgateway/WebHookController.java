package com.example.pushgateway;

import com.example.pushgateway.utils.JacksonUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-03-01 16:36
 **/
@RestController
public class WebHookController {

    @RequestMapping(value = "/webhook", produces = "application/json;charset=UTF-8")
    public String receiver(@RequestBody String json){
        System.out.println("webhook +++++++++++++++++++");
        System.out.println(json);
        Map<String, Object> dataMap = JacksonUtils.jsonString2Obj(json, HashMap.class);
        Map<String, Object>  commonLabels = (Map<String, Object> )dataMap.get("commonLabels");
        System.out.println("commonLabels ------");
        System.out.println(commonLabels);
        return "success";
    }


    @RequestMapping(value = "/webhook1", produces = "application/json;charset=UTF-8")
    public String receiver1(@RequestBody String json){
        System.out.println("webhook111111 +++++++++++++++++++");
        System.out.println(json);
        Map<String, Object> dataMap = JacksonUtils.jsonString2Obj(json, HashMap.class);
        Map<String, Object>  commonLabels = (Map<String, Object> )dataMap.get("commonLabels");
        System.out.println("commonLabels ------");
        System.out.println(commonLabels);
        return "success";
    }

}
