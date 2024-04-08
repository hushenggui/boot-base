package com.example.saasutil.service.yongjia;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-06-15 14:43
 **/
public class QueryService {


  public static void main(String[] args) {
    String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    GuoTaiCommonReqBean<GuoTaiQueryPolicyReqBean> guoTaiCommonReqBean = new GuoTaiCommonReqBean<>();
    guoTaiCommonReqBean.setCstNo("00001330324");
    guoTaiCommonReqBean.setPlatNo("00001330324");
    GuoTaiQueryPolicyReqBean bean = new GuoTaiQueryPolicyReqBean();
    bean.setSectionUniqueCode("330324008202307180624001");
    bean.setTransCode("Q000003");
    bean.setGuaranteeNo("8011220230001339");
    guoTaiCommonReqBean.setBody(bean);
    String encrypt = RSAUtil.encrypt(GsonUtil.toJsonSort(guoTaiCommonReqBean), privateKey);
    guoTaiCommonReqBean.setSign(encrypt);
    System.out.println(GsonUtil.toJsonSort(guoTaiCommonReqBean));

    /*String signKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    String sign = RSAUtil.encrypt(GsonUtil.toJsonSort(guoTaiCommonReqBean.getBody()), signKey);
    guoTaiCommonReqBean.setSign(sign);
    System.out.println(JacksonUtils.obj2JsonString(guoTaiCommonReqBean));
    String decrypt = RSAUtil.decrypt(sign,
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZkpPtGSRku0c4r0pWvVITFIYOgOlbrKVhuIIYW1CVWTv7VlbztZb14r0Wx1C++d7HZgnHNorGjKE7mTtTUqpjtV5KNaJF/nu8dg5iShyKeK7KmIitsBT5UIJb5x9/uj/8q88dUlJewubPE1HJNf6/0R2yuAdOKOkslGn37k/M+wIDAQAB");
    System.out.println(decrypt);
    boolean check = RSAUtil.check(
        "{\"page\":1.0,\"pageSize\":100.0,\"sectionUniqueCode\":\"A430100201900052000063\"}", sign,
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZkpPtGSRku0c4r0pWvVITFIYOgOlbrKVhuIIYW1CVWTv7VlbztZb14r0Wx1C++d7HZgnHNorGjKE7mTt  TUqpjtV5KNaJF/nu8dg5iShyKeK7KmIitsBT5UIJb5x9/uj/8q88dUlJewubPE1HJNf6/0R2yuAdOKOkslGn37k/M+wIDAQAB");
    System.out.println(check);*/


  }


}
