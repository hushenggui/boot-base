package com.example.saasutil.service.yongjia;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;
import lombok.Data;

/**
 * @Project saas
 * @FileName GuoTaiBidReceive.java
 * @Programmer huacailiang
 * @Version 1.0
 * @Description
 * @Start Date 2023-05-22 16:32:21
 * @Last Update 2023-05-22 16:32:21
 */
@Data
public class GuoTaiBidReceiveReqBean {

  //请求流水号
  private String reqSeriNo;
  //项目名称
  private String projectName;
  //项目编号
  private String projectCode;
  //项目唯一编码
  private String projectUniqueCode;
  //项目所在行政区 域代码
  private String projectArea;
  //项目状态
  private String projectStatus;
  //标段唯一编码
  private String sectionUniqueCode;
  //标段编号
  private String sectionCode;
  //标段名称
  private String sectionName;
  //保证金金额
  private String tenderBond;
  //招标项目业务类 型
  private String tenderType;
  //保证金递交截止 时间
  private String tenderBondEndTime;
  //开标时间
  private String tenderStartTime;
  //投标有效期
  private String tenderExpire;
  //标段状态
  private String sectionStatus;
  //交易码
  private String transCode;
  //招标人名称
  private String tenderer;
  //招标人统一社会 信用代码
  private String tendererCode;
  //招标/采购人地址
  private String tendererAddress;
  //招标人电话
  private String tenderMobile;

  public static void main(String[] args) {
    String json = "{\n"
        + "        \"tenderBond\": 1000.0,\n"
        + "        \"tenderer\": \"乌牛街道\",\n"
        + "        \"tenderBondEndTime\": \"20231202080000\",\n"
        + "        \"tenderMobile\": \"\",\n"
        + "        \"sectionCode\": \"330324008202210280576001-testhsg-06\",\n"
        + "        \"sectionStatus\": \"04\",\n"
        + "        \"tendererCode\": \"\",\n"
        + "        \"tenderStartTime\": \"20230828110000\",\n"
        + "        \"sectionName\": \"【国泰测试】测试标段-testhsg-06\",\n"
        + "        \"projectStatus\": \"01\",\n"
        + "        \"tenderType\": \"A01\",\n"
        + "        \"tendererAddress\": \"\",\n"
        + "        \"projectArea\": \"330324008\",\n"
        + "        \"projectCode\": \"330324008202210280576-testhsg-06\",\n"
        + "        \"projectUniqueCode\": \"330324008202210280576\",\n"
        + "        \"sectionUniqueCode\": \"330324008202210280576001\",\n"
        + "        \"transCode\": \"T000008\",\n"
        + "        \"projectName\": \"【国泰测试】测试标段-testhsg-06\",\n"
        + "        \"tenderExpire\": \"\",\n"
        + "        \"reqSeriNo\": \"20230620115505407\"\n"
        + "    }";

    String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    GuoTaiBidReceiveReqBean bean = GsonUtil.parseObject(json, GuoTaiBidReceiveReqBean.class);
    String encrypt = RSAUtil.encrypt(GsonUtil.toJsonSort(bean), key);
    System.out.println(encrypt);
    System.out.println(json);
    //String encrypt = "xn50h8gti+HI3UZHpOBTVje7qEVtv0FlcREeg3SkfnIUB4BGqGZ/827WOBf+wOlhT7f/qclTFpnBYMg5mEerrgNYBlMXDcau/XETHjrs4C3c6TbgyHfQfE2r06CBB7/4no8efHqCJmGUxXpuvkGCLPIUUHKf1AovJHjJdoyLcK4FgwGx6O3neGMUQPh8fRIL2n6cncx74lhOcRhSWb32ve24CVTIL1/27A8RIr0NepHcGdAei4YWyaP1I2vCK/XTsB0JDxU1ltBA1qRvUz7X5rrx7gwRfePsawbLcNmIqt1zYE3UhoNecNoH/YkfGZCSYOVT6rO+jXIEebAJta5LZz30R01+Q2oBrpMzYdt2UEBPfA55nJTdVdi3nHA5aG72bpf4KcK+BUraL6OXpBuGWQ3ra6Iot1FnqdzKI/clCIwNMFoZyQ3sT6zAEGMd+Opw0RBWrWAn6Sr2Qb4LpNOKTCF40y6xQPylBTeRfjp5YNIV6a8uT3b4V0mlz5EAHNnMHQl1sUMGnPilZ+RV3OXrcuD5R2yKg5ze/PzA2lmwnE7K7LDydRHgtPcf5gHSaDink40/tFJ/kFxsGia50RjFRO/GQG2FcMnVSQ6PpZp4csD9oQffNQLsSs93AEPgwqfjJSijy5N0iuYyDDOYPk34Mc8rVY6AAxzFVAzIgY6nrpeIZwvwiRELfisG/t5s83+9CC3Ob1kHT25MgmN10hm9GMMa9JmzfebiYj+Fqnw0KJGNXQzDbZb4MmX9b7+Og/gNnsWqZUudqrZgF+Mx76pr2sO3zj6I/KZbRVTGhQQYsK43nIwfdsKRjrwR3z8pVhsO/QFT5+9PQMW53getZkkj+jDI44zwi2kEQSjL3+J9NtdK9D8EMjQYNOEi0tulgi0bY/sYSgPGRYl8GF0DHS47vkqbdnPWDqQERmsctdjrZgCx2QYFtzu2qtJAYz13Szm9T3YxfEP0J2dpcnqTklr233JzASzvCKvH7/mmopXTbrBGqTHK2oFRCXyQDiC36sjy";
    String puKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZkpPtGSRku0c4r0pWvVITFIYOgOlbrKVhuIIYW1CVWTv7VlbztZb14r0Wx1C++d7HZgnHNorGjKE7mTtTUqpjtV5KNaJF/nu8dg5iShyKeK7KmIitsBT5UIJb5x9/uj/8q88dUlJewubPE1HJNf6/0R2yuAdOKOkslGn37k/M+wIDAQAB";
    //加签
    System.out.println(RSAUtil.decrypt(encrypt, puKey));
    //验签
    System.out.println(RSAUtil.check(GsonUtil.toJsonSort(bean), encrypt, puKey));
  }
}
