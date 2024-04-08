package com.example.rabbitmqserial.vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ConcurrentModificationException;
import java.util.Date;
import lombok.Data;

/**
 * @author: huacailiang
 * @date: 2020/10/28
 * @description:
 **/
@Data
public class PayInfoVo implements Externalizable {

  private String id;

  private String tradeSerialNo;

  /**
   * 支付时间
   */
  private Date payDate;

  /**
   * 交易流水号
   */
  private String tradeCode;

  /**
   * 银行编号/转出银行编号
   */
  private String bankCode;

  /**
   * 银行名称/转出银行名称
   */
  private String bankName;

  /**
   * 对方账号/转出账号
   */
  private String bankAccount;

  /**
   * 对方户名/转出户名
   */
  private String accountName;

  /**
   * 银行编号/转出银行编号
   */
  private String recBankCode;

  /**
   * 银行名称/转出银行名称
   */
  private String recBankName;

  /**
   * 对方账号/转出账号
   */
  private String recBankAccount;

  /**
   * 对方户名/转出户名
   */
  private String recAccountName;

  /**
   * 交易金额/转出金额
   */
  private BigDecimal premium;

  /**
   * 银行应收手续费
   */
  private BigDecimal brokerage;

  /**
   * 备注
   */
  private String memo;
  /**
   * 资金渠道
   */
  private String source;

  /**
   * 大额行号
   */
  private String cnapsCode;

  /**
   * 支行信息
   */
  private String cnapsName;

  private Boolean error;

  /**
   * 扩展字段
   */
  private String ext;

  private Date createDate;

  private Date updateDate;

  private Boolean delete;

  private String cityCode;

  private String salt;

  /**
   * 应用名
   */
  private String application;

  private String orderSerialNo;

  private String channelAccountCode;

  private String payNo;

  private String test1;

  private String test3;

  private Integer int4;


  @Override
  public void writeExternal(ObjectOutput out) throws IOException {

  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

  }
}
