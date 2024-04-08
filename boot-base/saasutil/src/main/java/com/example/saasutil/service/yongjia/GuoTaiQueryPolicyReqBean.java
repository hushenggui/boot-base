package com.example.saasutil.service.yongjia;

import lombok.Data;

/**
 * @Project saas
 * @FileName GuoTaiQueryPolicyReqBean.java
 * @Programmer huacailiang
 * @Version 1.0
 * @Description
 * @Start Date 2023-05-23 15:21:44
 * @Last Update 2023-05-23 15:21:44
 */
@Data
public class GuoTaiQueryPolicyReqBean {

  private String orderNo;
  private String guaranteeNo;
  private String sectionUniqueCode;
  private Integer page;
  private Integer pageSize;
  private String transCode;
}
