package com.example.saasutil.service.universion;

import com.example.saasutil.enums.RequestType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: saas
 * @description: 工保请求渠道基础vo
 * @author: hushenggui
 * @create: 2021-09-09 15:19
 **/
@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GongbaoChannelReqBaseVo<T> implements Serializable {


  private static final long serialVersionUID = 2530054056558458840L;
  /**
   * 城市编码
   */
  private String cityCode;

  /**
   * 城市名称
   */
  private String cityName;

  /**
   * 渠道编码
   */
  private String insCode;

  /**
   * 来源
   */
  private String source;

  /**
   * 请求时间 例 如 ：
   * 20210801110102
   */
  private String reqTime;

  /**
   * 请求类型
   */
  private RequestType reqType;

  /**
   * 请求体
   */
  private T  reqBody;

  /**
   * 签名
   */
  private String sign;
}
