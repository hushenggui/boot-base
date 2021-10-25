package com.example.saasutil.service;

import com.example.saasutil.util.PlatformSignUtil;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-07-06 13:41
 **/
@Slf4j
public class PayPlatfromTrans {

/*  public static void main(String[] args) {
    String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    Gson gson = new Gson();
    Map<String, String> paramMap = new HashMap<>();
    paramMap.put("channelAccountCode", "1000000001073QD8HQD");
    paramMap.put("notifyUrl", "https://kashi-jy.gongbaojin.com/basic-service/transactionNotify/transferAccounts");
    paramMap.put("onlineFlag", "1");
    paramMap.put("oppAccount", "9595117322497230");
    paramMap.put("oppAccountName", "工保网保险经纪有限公司");
    paramMap.put("oppBankNo", "102");
    paramMap.put("orderNo", "1014010653101202106221522081720");
    paramMap.put("remarks", "SEJ25T");
    paramMap.put("returnUrl", "https://kashi-jy.gongbaojin.com/basic-service/transactionNotify/reexchange");
    paramMap.put("tradeAmount", "800");
    paramMap.put("tradeInfo", "10110106531012021070514531530371");
    paramMap.put("transCode", "T000003");
    String sign = PlatformSignUtil.signRSA(paramMap, privateKey);
    paramMap.put("sign", sign);
    paramMap.put("custNo", "10000000010");
    paramMap.put("platNo", "10000000010");
    paramMap.put("version", "1.0");
    log.debug("发送请求参数为：" + gson.toJson(paramMap));
  }*/


  public static void main(String[] args) {
    String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    Gson gson = new Gson();
    Map<String, String> paramMap = new HashMap<>();
    paramMap.put("orderCode", "10110106531012021070514531530371");
    paramMap.put("paymentTransactionNo", "57NRCM");
    paramMap.put("orderTime", "2021-07-06 13:15:22");
    String sign = PlatformSignUtil.signRSA(paramMap, privateKey);
    paramMap.put("sign", sign);
    paramMap.put("method", "order");
    log.info("sign:{}", sign);
    log.debug("发送请求参数为：" + gson.toJson(paramMap));

  }
}
