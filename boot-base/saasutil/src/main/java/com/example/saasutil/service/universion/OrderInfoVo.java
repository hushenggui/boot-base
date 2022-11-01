package com.example.saasutil.service.universion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @author: huacailiang
 * @date: 2020/3/29
 * @description:
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class OrderInfoVo implements Serializable {

  public OrderInfoVo(String serialNo) {
    this.serialNo = serialNo;
  }
  private String id;
  /**
   * 订单编号
   */
  private String serialNo;

  /**
   * 保险公司表id
   */
  private String insCompanyId;

  /**
   * 交易中心业务流水号order_no

   */
  private String orderNo;

  /**
   * 标段编号id
   */
  private String bidSectionInfoId;

  /**
   * 支付表id
   */
  private String paymentId;

  /**
   * 当前节点
   */
  private String node;

  /**
   * 订单状态
   */
  private String status;

  private List<String> statusList;
  /**
   * 接口信息
   */
  private String message;

  /**
   * 业务类型：经纪业务
   */
  private String businessType;


  /**
   * 招标人用户id
   */
  private String tendereeUserInfoId;

  /**
   * 投标人用户id
   */
  private String bidderUserInfoId;

  private Date createDate;

  private Date updateDate;

  /**
   * 0未删除 1已删除
   */
  private Boolean delete = Boolean.FALSE;

  /**
   * 行政区划
   */
  private String cityCode;

  /**
   * 订单来源
   */
  private String orderSource;

  /**
   * 订单渠道1电子保函2工保网
   */
  private Integer channel;


  private PaymentVo payment;

  private String insCode;
  private String insName;

  /**
   * 图形校验码
   */
  private String captcha;

  /**
   * 手机校验码
   */
  private String mobileCaptcha;

  /**
   * 手机号
   */
  private String phone;

  /**
   * 应用名
   */
  private String application;

  /**
   * 保单序列号
   */
  private String policySerialNo;


  /**
   * 担保类型
   */
  private String guaranteeType;
  /**
   * 担保类型中文
   */
  private String guaranteeTypeName;

  /**
   * true重新投保
   */
  private Boolean reaCreate;

  /**
   * 行数，自增
   */
  private Integer rowId;
  /**
   * 扩展字段
   */
  private String ext;

  /**
   * 搜索关键字
   */
  private String keyWord;
  private Integer pageSize;
  private Integer pageNum;
  private String bidderPhone;
  private String askType;
  private String bidderEmail;
  /**
   * 招/投标人联系人(法人)
   */
  private String creditCode;
  /**
   * 标段编号
   */
  private String bidCode;
  /**
   *  投保单号，保险公司提案编号
   */
  private String proposalNo;
  /**
   * 保险期限
   */
  private Integer tenderDay;

  private Integer projectType;

  private String bidName;

  private String policyNo;
  private String bidOpenTime;

  /**
   * 是否重新选择保险公司
   */
  private Boolean reselect = Boolean.FALSE;

  private PaymentVo paymentVo;
  //开标时间起
  private String bidOpenTimeStart;
  //开标时间止期
  private String bidOpenTimeEnd;

  private Boolean isFromUser = Boolean.FALSE;

  private String orderNoOrPolicyNo;

  /**
   * 投标人信息信息
   */

  /**
   * 交易中心业务流水号order_no
   */
  private String orderNoLike;

  private String orderNoOrPolicyNoLike;

  private String statusListString;

  private BigDecimal amountMin;

  private BigDecimal amountMax;

  private String queryInsCode;

  private String platformCode;

  private String payUrl;

  //app查询数据类型


  /**
   * 投保审核资料
   */

  private Boolean confirmPolicy = false;

  private String custToken;

  private String sessionId;



  public OrderInfoVo(String serialNo, String application) {
    this.serialNo = serialNo;
    this.application = application;
  }
}
