package com.example.saasutil.service.universion;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;

/**
 * @program: boot-base
 * @description: 广西密文保单回执
 * @author: hushenggui
 * @create: 2022-11-02 14:44
 **/
public class EecryptPolicyNoticeServiceGuangxi {
  public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";

  public static void main(String[] args) {

    String json = "{\n"
        + "    \"cityCode\":\"450000\",\n"
        + "    \"cityName\":\"广西省\",\n"
        + "    \"insCode\":\"00015\",\n"
        + "    \"source\":\"中国人民财产保险股份有限公司\",\n"
        + "    \"reqTime\":\"1667370952000\",\n"
        + "    \"reqType\":\"BAOXIAN\",\n"
        + "    \"reqBody\":{\n"
        + "        \"orderId\":\"10110104500002022103110565893665\",\n"
        + "        \"policyNo\":\"PBAQ20224500Q000E00327\",\n"
        + "        \"fileId\":\"5cfe2b45-1573-43f8-acaa-de124e2553c5\",\n"
        + "        \"type\":\"ENCRYPT\",\n"
        + "        \"comPhone\":\"+86-10-69008888\",\n"
        + "        \"company\":\"中国人民财产保险股份有限公司\",\n"
        + "        \"insurTime\":\"2022-11-02 00:00:00至2023-03-02 23:59:59\",\n"
        + "        \"status\":\"SUCCESS\"\n"
        + "    },\n"
        + "    \"sign\":\"oAC9AOo2NOQckd2usUPqBCa+91wDFgTwMbZEyMwXSLWC32/URx2AXA5P/AP/iAPLu6JHtEB+6etwYHASsqgho8osGP+AneJulMTGkgS7JO3SBeCJD/PAkxCvNCDrffJYXyS6WxiDYVm360eltwSbBaGjvT8SCsZ1MUZwV+RrAJ6JCyW12sEZtweYgk/n4Jhx1WbUxTLiHn71L0EXdmJxZ7AcRIlgbvc2UEqjdDTZbNP6Yh0Cq3jIsEkqKvYn9ARiUXqYNdfqK5JzPZiRMNlY9Cz8w3Jj5qVlkYWwU/4/vTJecToD9mk8I059gxsnSyzzDjdd190H6wu3nExc1Sw2Z0TVnZ9hfrZ6n94ER5brE1s7XYMdBO7yctWF/3fF3fAC2ZZeXd3VmEkMvXdYQob9cjw6q/k0HbCZGmOySkLwOkogtw1+Anouv0oRuk2a0AcKUrTS7FmKi5v6GJf/pIFgeU4OOQPKdBcPZ9Em8tK2Zw0cP2q0viV3z2sUEpGDfQ1Q\"\n"
        + "}";

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

  }
}
