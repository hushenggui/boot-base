/**
 * 
 * cmexico
 *
 */
package com.example.saasutil.util;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类职责：<br/>
 *     转账业务
 * <p>Title: DataConstant.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020 工保科技 </p>
 * <p>Company: 工保科技 </p>
 *  
 * <p>Author:Cmexico.Li</p>
 * <p>CreateTime:2020年10月30日下午4:35:45
 * <p>$LastChangedBy$</p>
 * <p>$LastChangedRevision$ </p>  
 * <p>$LastChangedDate$ </p>
 * <p>$Id$ </p>
 */
@Getter
@Setter
public class TransferTradeReq implements Serializable {

  private static final long serialVersionUID = -7287941647448032256L;

  /** 交易码 */
  protected String transCode;

  protected String channelAccountCode;

  /*** * 商户订单号 */
  protected String orderNo;


  /*** 交易信息(商品名称) */
  protected String tradeInfo;

  /*** 交易金额 */
  protected BigDecimal tradeAmount;


  /** 商品信息 */
  protected String goodsInfo;
  /**
   * 线上交易标志ON_LINE线上 OFF_LINE线下
   */

  protected String onlineFlag;
  /**
   * 备注说明
   */
  protected String remarks;


  /** * 商户同步回调通知地址 */
  protected String returnUrl;


  /** * 商户后台通知地址 */
  protected String notifyUrl;
  /**
   * 交易手续费
   */
  protected BigDecimal feeAmount;

  // /*** * 转账-付方账号 */
  // @ApiModelProperty(value = "转账-付方账号-转账业务必填", required = true, example = "9559980111111111412")
  // private String payAccount;
  //
  // /** 转账-付方账户名称 */
  // @ApiModelProperty(value = "转账-付方账户名-转账业务必填", required = true, example = "王小光")
  // private String payAccountName;
  //
  // /** 转账-付方账户名称 */
  // @ApiModelProperty(value = "转账-付方银行号", example = "305")
  // private String payBankNo;
  //
  // /** 转账-付方账户名称 */
  // @ApiModelProperty(value = "转账-付方银行名称", example = "民生银行")
  // private String payBankName;

  /** 转账-对方账号 */
  private String oppAccount;

  /** 转账-对方名称 */
  private String oppAccountName;


  /** 转账-付方账户名称 */
  private String oppBankNo;

  /** 转账-付方账户名称 */
  private String oppBankName;


  /** 转账-对方银行城市代码 */
  private String oppCityCode;

  /** 渠道编号 */
  // @ApiModelProperty(value = "渠道编号", example = "0000")
  // private String channelCode;
  private String bankBranchName;


  private String openBranch;

}
