package com.example.saasutil.service.universion;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-09-21 17:07
 **/
public class DecryptPolicyNoticeService {

  public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";

  public static void main(String[] args) {

    String json = "{\n"
        + "    \"cityCode\": \"430400\",\n"
        + "    \"cityName\": \"衡阳市\",\n"
        + "    \"insCode\": \"00009\",\n"
        + "    \"source\": \"阳光财产保险股份有限公司\",\n"
        + "    \"reqTime\": \"1667187750000\",\n"
        + "    \"reqType\": \"BAOXIAN\",\n"
        + "    \"reqBody\": {\n"
        + "        \"orderId\": \"10110104304002022103016310016276\",\n"
        + "        \"policyNo\": \"H43VQ2227DVJRMM2V00\",\n"
        + "        \"fileId\": \"edac32ce-9b51-4ef6-8cfa-1d0c89768ca5\",\n"
        + "        \"type\": \"DECRYPT\",\n"
        + "        \"insurTime\": \"2022-10-30 00: 00: 00至2023-04-28 23: 59: 59\",\n"
        + "        \"status\": \"SUCCESS\"\n"
        + "    },\n"
        + "    \"sign\": \"Xv3BeUPpIlBzL396JBodhvrmDdfxbAKoUlgAZClhLOk+EeXG2MASe2LMZ0cdvHiWMRQicATkB44ND9xFzlpTsNkLSB3xaDTrod+lo7gb0bpy01nvr/GwHH0d5Miw1tZbI0D21VboCmmk9e06Mx5a5xcVWTv8NTz68HoECKJjlldZf9wbuiCi7SWJRXXzwcCitylR4VnYgRZvR2kj6WH1zjfDbL0BKmTzZdIX8ypf/iA+THtjGXqWfH9xGrpO/FTp/oC7vrhWligL/N3a6f1oXPgXKpLMoZHJ30nFiiRaH9xIE6+cRHZswRvDkEIqkSkASsHhx7ngh4wimFqDfoH4sg\\u003d\\u003d\"\n"
        + "}\n";

    String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALn6hIGskkVmlrVC\n"
        + "zzJwtBiesHbCfHI1yUBausgTKJysqX64AVyNMNlkbFfxQoeayE7/0p22aKdAJH4j\n"
        + "CspS2a5cOMGcujNDOEUjQ87IDIh0WjgqjgCnOicLGq+Yw1BreHiX7uXHbcn1mPeW\n"
        + "w9pa9tCAmDSP/NhF6ey11d1eKCvdAgMBAAECgYEAr7KGYGOCRGJo2pFlYYer/N5e\n"
        + "Y7PVEajSmiOc9ctzwKA1+GspjiAtGBORb3uTmLyXpFp2xVxAflFQqIG+fenLjxsC\n"
        + "qIpSxpesW+IH1Ik0YZCbtgBptFbRHZfXmBK07u4y/BD7MBTboS6vI8CL1Qb56+Jc\n"
        + "3UzGXeY3GV1eOZ1MHVkCQQDkn6/XdvQXf7eAInDTjzuC+xFp6d64G/7M91qHhBDH\n"
        + "FMxleW4rMR8XVUzKh9sLZ9cB9MbdDP/1WjB6sehJvzIHAkEA0D+R8b0zu27oGJeN\n"
        + "iJ4rNRPOHGBV9rx+BuSCTOyUXfudsUZ3kZqCjY1lhFUdGCPyW12gc1qTu6f1Xx92\n"
        + "ghkp+wJAXdU0hIhr8mEW3V5FVG9LC50kLoYwRPwofdNfspL/l9Xvdg56qvuEOT1n\n"
        + "QRC1VF8QHdtq6zr0qqyTjSgLoIj6bQJAInXyk7tIfULMG42wuSPbaIwfdmimsQ7e\n"
        + "GAvmWA5qOucxYC2WCb00z3HPk8d16hHAwEfNDmm1ur7/hr8xIDRD0wJBAN6RBpLw\n"
        + "cHibzaxu7Mt6uKS6pN/wHytKzr6e6Ku/oy7WNVDFlBpVqncfHgCQvdRUXHDTh7dt\n"
        + "2th1A5DF9oTfcGk=";
    GongbaoChannelReqBaseVo<PolicyNotifyVo> reqBaseVo = GsonUtil.parseObject(json, GongbaoChannelReqBaseVo.class);

    String sign = RSAUtil.encrypt(GsonUtil.toJsonSort(reqBaseVo.getReqBody()), privateKey);
    reqBaseVo.setSign(sign);
    System.out.println(GsonUtil.toJsonSort(reqBaseVo));
/*
    PolicyInfoVo policyInfoVo = setPolicyInfoVo(GsonUtil.parseObject(GsonUtil.toJsonSort(reqBaseVo.getReqBody()), PolicyNotifyVo.class));
    System.out.println(GsonUtil.toJsonSort(policyInfoVo));*/
  }


  public static PolicyInfoVo setPolicyInfoVo(PolicyNotifyVo policyNotifyVo){
    PolicyInfoVo policyInfoVo = new PolicyInfoVo();
    policyInfoVo.setFileId(policyNotifyVo.getFileId());
    policyInfoVo.setOrderSerialNo(policyNotifyVo.getOrderId());
    policyInfoVo.setPolicyNo(policyNotifyVo.getPolicyNo());
    policyInfoVo.setInsuranceTime(policyNotifyVo.getInsurTime());
    policyInfoVo.setInsName(policyNotifyVo.getCompany());
    policyInfoVo.setTelephone(policyNotifyVo.getComPhone());


    OrderInfoVo orderInfoVo = new OrderInfoVo();
    PaymentVo paymentVo = new PaymentVo();

    paymentVo.setBankAccount(policyNotifyVo.getAccNo());
    paymentVo.setAccountName(policyNotifyVo.getAccName());
    paymentVo.setBankName(policyNotifyVo.getBankName());

    if(ObjectUtil.isNotEmpty(policyNotifyVo.getPayType())){
      paymentVo.setType(policyNotifyVo.getPayType());
    }
    if(ObjectUtil.isNotEmpty(policyNotifyVo.getPayTime())){
      paymentVo.setPayDate(fmtStrToDate(policyNotifyVo.getPayTime(), DEFAULT_FORMAT));
    }

    paymentVo.setDealCode(policyNotifyVo.getPayId());
    orderInfoVo.setPayment(paymentVo);
    policyInfoVo.setOrderInfo(orderInfoVo);
    return policyInfoVo;
  }

  /**
   * Description:按指定格式 格式化日期
   *
   * @param date
   * @param dtFormat
   * @return
   * @since：2007-12-10 上午11:25:07
   */
  public static Date fmtStrToDate(String date, String dtFormat) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
      return dateFormat.parse(date);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
