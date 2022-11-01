package com.example.saasutil.service.universion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: huacailiang
 * @date: 2020/3/29
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyInfoVo implements Serializable {

  public PolicyInfoVo(String orderSerialNo) {
    this.orderSerialNo = orderSerialNo;
  }
  private String id;
  private Integer rowId;
  private Date createDateStart;
  private Date createDateEnd;

  private Date bidOpenTimeStart;
  private Date bidOpenTimeEnd;
  /**
   * 解密密钥
   */
  private String decodeKey;


  /**
   * 保单编号
   */
  private String serialNo;

  /**
   * 订单表编号
   */
  private String orderSerialNo;

  /**
   * 投保单号、保险公司提案编号
   */
  private String proposalNo;

  /**
   * 保险公司代码
   */
  private String insCode;

  /**
   * 保险公司名称
   */
  private String insName;

  /**
   * 保险公司联系电话
   */
  private String telephone;

  /**
   * 保额
   */
  private BigDecimal amount;

  /**
   * 保费
   */
  private BigDecimal premium;

  /**
   * 保单号
   */
  private String policyNo;

  /**
   * 保险期限
   */
  private String insuranceTime;

  /**
   * 起保日期起
   */
  private Date startDate;

  /**
   * 保险天数
   */
  private Integer tenderDay;

  /**
   * 保险失效日期
   */
  private Date expireDate;

  /**
   * 保单附件id
   */
  private String fileId;

  /**
   * 保函附件id
   */
  private String guaranteeId;

  /**
   * 保险类型：非共保体
   */
  private String model;

  /**
   * 保险类型：投标保证险
   */
  private String type;

  /**
   * 保单状态
   */
  private String status;

  /**
   *
   */
  private List<String> statusList;
  /**
   * 开发节点
   */
  private String node;

  /**
   * 接口信息
   */
  private String message;

  private Date createDate;

  private Date updateDate;

  /**
   * 0未删除1已删 除
   */
  private Boolean delete = Boolean.FALSE;

  /**
   * 行政区划
   */
  private String cityCode;



  /**
   * 保单附件
   */
  private FileVo file;

  /**
   * 保函附件
   */
  private FileVo guarantee;

  private String dealCode;

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
   * 交易中心订单流水号
   */
  private String orderNo;

  /**
   * 标段编号
   */
  private String bidCode;
  //统一社会信用代码
  private String creditCode;
    /**
     * 项目id
     */
  private String projectCode;

  private Integer pageSize = 10;
  private Integer pageNum = 1;
  //用户信息
  private String userInfoId;
  /**
   * 交易中心订单流水号
   */
  private String orderNoLike;
  /**
   * 保单号
   */
  private String policyNoLike;

  private Boolean isFromUser = Boolean.FALSE;

  /**
   * 更新投标有效期和投保人手机号
   */
  private Boolean updateTenderDayAndBidderUserPhone = Boolean.FALSE;

  /**
   * 审核状态
   */
  private Boolean checkStatus = Boolean.TRUE;

  private OrderInfoVo orderInfo;

  /**
   * 保函类型
   */
  private String guaranteeType;

  /**
   * 出函机构
   */
  private String queryInsCode;

  /**
   * 保证金金额下限
   */
  private BigDecimal amountMin;

  /**
   * 保证金金额上限
   */
  private BigDecimal amountMax;

  private String ext;

  private String projectType;

  private Boolean invoiceWait = Boolean.FALSE;

  private String queryBidOrPolicyNo;

  private Boolean queryEmailIs = Boolean.FALSE;

  /**
   * 验证码
   * */
  private String verifyCode;

}
