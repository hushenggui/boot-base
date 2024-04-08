package com.example.saasutil.service.universion;

import static com.example.saasutil.util.RSAUtil.check;
import static com.example.saasutil.util.RSAUtil.decrypt;

import com.example.saasutil.enums.PayTypes;
import com.example.saasutil.enums.PolicyNotifyType;
import com.example.saasutil.enums.ResponseStatus;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 保单回执vo
 * @author: hushenggui
 * @create: 2021-09-13 15:47
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyNotifyVo implements Serializable {
  private static final long serialVersionUID = 1575081757675577509L;

  /**
   * 订单编号
   */
  private String orderId;

  /**
   * 保单号
   */
  private String policyNo;

  /**
   * 附件id
   */
  private String fileId;

  /**
   * 状态
   */
  private PolicyNotifyType type;

  /**
   * 承包单位
   */
  private String company;

  /**
   * 承保单位联系方式
   */
  private String comPhone;

  /**
   * 保险期限
   */
  private String insurTime;

  /**
   * 状态
   */
  private ResponseStatus status;

  /**
   * 实际支付金额
   */
  private BigDecimal premium;
  /**
   * 备注
   */
  private String remark;

  /**
   * 银行账号
   */
  private String accNo;

  /**
   * 银行账户
   */
  private String accName;

  /**
   * 银行名称
   */
  private String bankName;

  /**
   * 支付类型
   */
  private PayTypes payType;

  /**
   * 支付时间
   */
  private String payTime;

  /**
   * 银行流水号
   */
  private String payId;

  /**
   * 提案编号/预 投保单号
   */
  private String proposalNo;

  /**
   * 签章时间
   */
  private String signatureDateTime;

  public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDj2-LKrADbOpkamjDSEPsxm-aHBlqE-AZfiS1uGNrgkMzxUIeQ8P13kc-h_EMdF8AjtMFybYex2_uNurKBNAU3g0hICk9NDlokhk5LYiac58BvaYzcgnAIRAyt5p7_KQsofiBHHn_NuA6Q4QoGOlfr-Z0I-w2TnrVdmLzAkuts8wIDAQAB";
  public static void main(String[] args) {
    String sign = "YSLt7A6tmeOo9zt61whlE3NOPadNDwlBFU0sEhyHr5OgDAAZklQUOAqJwGeDFzEDyT27QCWfXx2NKa39f1eGgLo84/LJTejAcYb6wyHzD6yxrkRpTaifv7eTqH/YkXUhxyZdXdGoqVeSaHr6XKPl+kyHEYKC/kGkgurLQ2+bLIvOmL6FXFgvPmuBK5UpAnLtYH6Vqmdqs8lr7S93P5rXVSF+45POjyO8mOoO+Hn2tmQFEMYVzE+i0vYQUDqJYZqhYaQ0WMDP9TosXfO94FiwbiW8eIHqNka3476U0A16Hyvzh/BGNCoBhdH/1Jq56fuaTfG5dknEqlnEw04bvmQHo6aOoY/xVyUmcOEupH2EtFUcClVOClLC0ubSFtFmI0Fi/RvW3Vo8cSTXBK7sFP8h8hk2pdqE1PG3QRu+baRS+769g6OFJwfPXUZOvGkbnSsrFgVgmpJW0b5Hu2XA86QO6KY/rJEdhnFCYaKGuL7xfL0k8/z8YePS/haDvOYDF+OFaCuiYgVaeYqibfSHTnB1PnXUY7DaSwkVTbOkVCr5tfzI4cXR6Rs9TOOL+TbnDnVur8eoQPtgG7seuCt6VyOFZtmAqQiGXPzaq2ZcAWxnu8Z8kGBoIpFS/FYaIoncXrENI0h+PKM599mTE3cA3hTJY0GMpNvWw6ap0gqOoXZ2P6k=";
    String body = "{\"insCode\":\"10036\",\"cityName\":\"新疆自治区\",\"cityCode\":\"650000\",\"reqBody\":{\"orderId\":\"10199106500002024011216362661863\",\"payTime\":\"20240112163958\",\"accNo\":\"755915676610301\",\"accName\":\"工保科技(浙江)有限公司\",\"bankName\":\"重庆分行\",\"policyNo\":\"HH20240112000065\",\"type\":\"ENCRYPT\",\"comPhone\":\"400-023-5588\",\"proposalNo\":\"M20240112000072\",\"payType\":\"OFFLINE\",\"premium\":800.0,\"company\":\"瀚华融资担保股份有限公司\",\"payId\":\"7559157115109200009360\",\"fileId\":\"09186f14-88ef-4f4c-b113-908895158313\",\"status\":\"SUCCESS\"},\"reqType\":\"GUARANTEE_BID\",\"sign\":\"YSLt7A6tmeOo9zt61whlE3NOPadNDwlBFU0sEhyHr5OgDAAZklQUOAqJwGeDFzEDyT27QCWfXx2NKa39f1eGgLo84/LJTejAcYb6wyHzD6yxrkRpTaifv7eTqH/YkXUhxyZdXdGoqVeSaHr6XKPl+kyHEYKC/kGkgurLQ2+bLIvOmL6FXFgvPmuBK5UpAnLtYH6Vqmdqs8lr7S93P5rXVSF+45POjyO8mOoO+Hn2tmQFEMYVzE+i0vYQUDqJYZqhYaQ0WMDP9TosXfO94FiwbiW8eIHqNka3476U0A16Hyvzh/BGNCoBhdH/1Jq56fuaTfG5dknEqlnEw04bvmQHo6aOoY/xVyUmcOEupH2EtFUcClVOClLC0ubSFtFmI0Fi/RvW3Vo8cSTXBK7sFP8h8hk2pdqE1PG3QRu+baRS+769g6OFJwfPXUZOvGkbnSsrFgVgmpJW0b5Hu2XA86QO6KY/rJEdhnFCYaKGuL7xfL0k8/z8YePS/haDvOYDF+OFaCuiYgVaeYqibfSHTnB1PnXUY7DaSwkVTbOkVCr5tfzI4cXR6Rs9TOOL+TbnDnVur8eoQPtgG7seuCt6VyOFZtmAqQiGXPzaq2ZcAWxnu8Z8kGBoIpFS/FYaIoncXrENI0h+PKM599mTE3cA3hTJY0GMpNvWw6ap0gqOoXZ2P6k=\",\"reqTime\":\"20240112164000\",\"source\":\"瀚华融资担保股份有限公司\"}";
    PolicyNotifyVo policyNotifyVo = GsonUtil.parseObject(body, PolicyNotifyVo.class);
    Boolean check = check(GsonUtil.toJsonSort(policyNotifyVo), sign, publicKey);
    System.out.println(check);
  }

}
