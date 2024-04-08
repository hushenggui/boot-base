package com.example.saasutil.service.yongjia;

import lombok.Data;

/**
 * @Project saas
 * @FileName GuoTaiCommonBean.java
 * @Programmer huacailiang
 * @Version 1.0
 * @Description
 * @Start Date 2023-05-22 16:30:11
 * @Last Update 2023-05-22 16:30:11
 */
@Data
public class GuoTaiCommonReqBean<T> implements java.io.Serializable {

  //签名方式 支持 RSA、SM4 必须大写,默认值:RSA
  private String signType;
  //数据签名
  private String sign;
  //平台编号
  private String platNo;
  //中心编号
  private String cstNo;
  //接口版本
  private String version;
  //业务参数体
  private T body;
}
