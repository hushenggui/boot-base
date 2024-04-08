package com.example.saasutil.service.pay;

import com.example.saasutil.service.universion.PaymentVo;
import com.example.saasutil.util.JacksonUtils;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-08-21 16:29
 **/
public class PayOrderService {


  public static void main(String[] args) throws ParseException {
    PaymentVo paymentVo = new PaymentVo();
    String str = "2023-10-12 16:56:39";
    paymentVo.setDealCode("GPLWHF");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    paymentVo.setPayDate(sdf.parse(str));
    paymentVo.setOrderSerialNo("10110103408252023101216474467726");
    paymentVo.setBankName("徽商银行股份有限公司合肥新站支行");
    paymentVo.setBankAccount("1024201021000805880");
    paymentVo.setAccountName("安徽天得建设有限公司");
    paymentVo.setDealAmount(new BigDecimal(1400));
    paymentVo.setTradeCode("20231012165635515P10000001919611");
    paymentVo.setMemo("GPLWHF");
    System.out.println(JacksonUtils.obj2JsonString(paymentVo));
  }

}
