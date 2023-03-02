package com.example.saasutil.service.pay;

import com.example.saasutil.service.pay.dto.PayNoticeRespDto;
import com.example.saasutil.service.pay.dto.PaymentNoticeReq;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-02-21 16:01
 **/
public class PayRsaService {

  public static void main(String[] args) {

    String json = "{\n"
        + "\t\"channelCode\": \"999999\",\n"
        + "\t\"channelName\": \"民生银行\",\n"
        + "\t\"createTime\": \"20230222093023\",\n"
        + "\t\"orderNo\": \"10140103408812023022309460755321\",\n"
        + "\t\"payFinishTime\": \"20230222093023\",\n"
        + "\t\"payNo\": \"20230223094607470P10000000056771\",\n"
        + "\t\"tradeAmount\": 0.01,\n"
        + "\t\"tradeState\": \"02\"\n"
        + "}";
    PayNoticeRespDto<PaymentNoticeReq> paymentNoticeReqPayNoticeRespDto = new PayNoticeRespDto<PaymentNoticeReq>();
    String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK303yzz0g6J55RMS7JNwr5lK+jDnSUtsGB94RYfNyeWsLQmiU8KP9Pr6CCSD6dPahQuAlbw+VREEb45p2y9YrVxYM0ombIuw8BuZT4lpTTfJkoKQLPzm2f3g/ohj05l1bHVI6pMbtkqWrXIiGOTjEQfnW582h0atGmCWePbA5zBAgMBAAECgYBEZudi27UbdmqTS7TwNdd/2nR7oH+oYODb8GOTuU6MyJpPHGAdrmAOytKKDCUPmxCRQs40tai009dOP4lwHsAzBT/m58SJ7vkQpV4olaK3Qkx/2D4dR9R2s9BAIeZ5MOEv0qOlAeUF+oWYC3qjGefHRUS7Urf9yfDGeK+4qGg0KQJBAO/sD5HOUJXqSNq9dTPaHnvtYUsGAZji8DF77wa0PUL9UXL/1SbXl9TiYhrK0InSG0Lj3WlN9BcxvHE4BwqO6zcCQQC5nSaTPlxWPedo6UVC0n1GMozKS9PkaKcOilazjj8ElRikOfgZbmhhDq7Ib7m8T/4s2k2rYtRgXkD4WtnF7+PHAkA08nSRKeXQ385KL6tw0P8PPFjPVLj/g32cfgxG/3nRkdPqvBjPJJ8GRRt/bCjPcYXAokbXmXN3tusuVT4Aj3/LAkBa+RwkBOeK2XJnKBXrR3FhC3uX1wx2oZhndwRBoxFd9JmMPGFOTZ/ZGjIuSRw2oNpKL4Dr5FeFGA0t7JFaA1aXAkEA5ILd9cYEbmOR438xWjAHDKsoJoCMsvIIUJH7QrZLjAqzx0daggy7XnFkkFx9pHaPOEtIfDftMxzBM+EYWPCytQ==";
    String sign = RSAUtil.encrypt(json, privateKey);
    PaymentNoticeReq paymentNoticeReq = JacksonUtils.jsonString2Obj(json, PaymentNoticeReq.class);
    paymentNoticeReqPayNoticeRespDto.setBody(paymentNoticeReq);
    paymentNoticeReqPayNoticeRespDto.setSign(sign);
    System.out.println(JacksonUtils.obj2JsonString(paymentNoticeReqPayNoticeRespDto));


    String puclicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt9N8s89IOieeUTEuyTcK+ZSvow50lLbBgfeEWHzcnlrC0JolPCj/T6+ggkg+nT2oULgJW8PlURBG+OadsvWK1cWDNKJmyLsPAbmU+JaU03yZKCkCz85tn94P6IY9OZdWx1SOqTG7ZKlq1yIhjk4xEH51ufNodGrRpglnj2wOcwQIDAQAB";
    boolean check = RSAUtil.check(json, sign, puclicKey);
    System.out.println(check);
  }

}
