package com.example.saasutil.service.yongjia;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @program: saas
 * @description: 优创投保通知bean
 * @author: hushenggui
 * @create: 2024-03-05 15:17
 **/
@Data
@Accessors(chain = true)
@Builder(toBuilder = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class YouchuangApplyNoticeBean implements Serializable {


  private static final long serialVersionUID = 9115718433585808155L;

  /**
   * 业务流水号
   * 长度：64
   * 是否必填：否
   */
  private String businessNo;

  /**
   * 订单编号
   * 长度：64
   * 是否必填：否
   * 说明：3.1接口中传递的订单编号
   */
  private String orderNo;

  /**
   * 请求时间
   * 长度：25
   * 是否必填：否
   * 说明：格式：yyyy-MM-dd HH:mm:ss
   */
  private String applyTime;

  /**
   * 保函编号
   * 长度：60
   * 是否必填：是
   * 说明：applyResult=0，此字段必填
   */
  private String guaranteeNo;

  /**
   * 保函文件
   * 长度：255
   * 是否必填：是
   * 说明：保函文件的base64码，applyResult=0，此字段必填
   */
  private String guaranteeFile;

  /**
   * 支付保费银行账户户名
   * 长度：60
   * 是否必填：是
   */
  private String payerName;

  /**
   * 支付保费银行账户号码
   * 长度：60
   * 是否必填：是
   */
  private String payerAccount;

  /**
   * 出函机构
   * 长度：60
   * 是否必填：是
   * 说明：applyResult=0，此字段必填
   */
  private String instName;

  /**
   * 出函时间
   * 长度：30
   * 是否必填：是
   * 说明：applyResult=0，此字段必填
   */
  private String generateTime;

  /**
   * 费率
   * 长度：6
   * 是否必填：是
   * 说明：applyResult=0，此字段必填
   */
  private String rate;

  /**
   * 费用
   * 长度：8
   * 是否必填：是
   * 说明：applyResult=0，此字段必填
   */
  private String cost;

  /**
   * 保函有效期开始时间
   * 长度：30
   * 是否必填：是
   * 说明：applyResult=0，此字段必填，格式yyyy-MM-dd HH:mm:ss
   */
  private String validBeginTime;

  /**
   * 保函有效期结束时间
   * 长度：30
   * 是否必填：是
   * 说明：applyResult=0，此字段必填，格式yyyy-MM-dd HH:mm:ss
   */
  private String validEndTime;

  /**
   * 申请结果
   * 长度：2
   * 是否必填：否
   * 说明：0.成功 1.失败
   */
  private String applyResult;


}
