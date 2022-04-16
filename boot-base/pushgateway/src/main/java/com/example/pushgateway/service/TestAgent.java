package com.example.pushgateway.service;

import com.example.pushgateway.dto.AlterDto;
import com.example.pushgateway.utils.AlertUtils;
import com.example.pushgateway.utils.Md5Util;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-03-12 14:34
 **/
@RestController
@Slf4j
public class TestAgent {


  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @RequestMapping("agent")
  public boolean frequency(@RequestBody  AlterDto alterDto) {
    //不报警
    if(alterDto.getAlertTimes() == 9) {
      return false;
    }
    //灰度不报警
    if(StringUtils.isEmpty(alterDto.getAlertArea()) || alterDto.getAlertArea().contains(".gray")) {
      return false;
    }
    //都为空 不报警
    if(StringUtils.isEmpty(alterDto.getOrderSerialNo()) && StringUtils.isEmpty(alterDto.getOrderNo()) && StringUtils.isEmpty(alterDto.getPolicyNo())) {
      return false;
    }
    //测试数据不告警
    if(!StringUtils.isEmpty(alterDto.getOrderNo()) && alterDto.getOrderNo().startsWith("TEST")) {
      return false;
    }
    //测试数据不告警
    if(!StringUtils.isEmpty(alterDto.getOrderSerialNo()) && isTest(alterDto.getOrderSerialNo())) {
      return false;
    }
    try {
      //正常报文
      if (alterDto.getAlertTimes() == 0) {
        alterDto.setAlertTimes(1);
        String json = AlertUtils.getMd5Str(alterDto);
        String redisKey = "push_redisKey_" + Md5Util.MD5(json);
        long times = AlertUtils.increment(stringRedisTemplate, redisKey);
        alterDto.setAlertTimes(0);
        if (times > 1) {
          AlertUtils.decrement(stringRedisTemplate, redisKey);
          //计算正常报文出现的次数
          String redisKeyNomal = "push_redisKey_" + Md5Util.MD5(AlertUtils.getMd5Str(alterDto));
          long timesNomal = AlertUtils.increment(stringRedisTemplate, redisKeyNomal);
          if(timesNomal > 5) {
            return false;
          }
          return true;
        }
        AlertUtils.decrement(stringRedisTemplate, redisKey);
        return false;
      }else {
        //告警报文推送频率
        String json = AlertUtils.getMd5Str(alterDto);
        String redisKey = "push_redisKey_" + Md5Util.MD5(json);
        //出现几次
        long times = AlertUtils.increment(stringRedisTemplate, redisKey);
        String value = "2";
        if (!StringUtils.isEmpty(value)) {
          if (times < Long.valueOf(value)) {
            return true;
          }
        }
      }
    }catch (Exception e){
      e.printStackTrace();
      log.error(e.getMessage(), e);
      return false;
    }
    return false;
  }

  public static Boolean isTest(String serialNo) {
    if("99".equals(serialNo.substring(3, 5))) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

}
