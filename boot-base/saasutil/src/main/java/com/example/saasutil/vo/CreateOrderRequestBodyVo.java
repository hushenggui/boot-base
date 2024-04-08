package com.example.saasutil.vo;

import com.example.saasutil.enums.ProjectType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ferkl
 * @date: 2021/8/30
 * @version: 1.0
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestBodyVo implements Serializable {

  private static final long serialVersionUID = 3005732718310626751L;
  /**
   *  订单号
   */
  private String orderId;

  /**
   * 项目名称
   */
  private String projName;

  /**
   * 项目编号
   */
  private String projCode;

  /**
   * 标段名称
   */
  private String bidName;

  /**
   * 项目标段编号
   */
  private String bidCode;

  /**
   * 招标人名称
   */
  private String tendName;

  /**
   * 招标人统一社会信 用证代码
   */
  private String tendCode;

  /**
   *  投保人姓名
   */
  private String biddName;

  /**
   *  投 保 人 统 一 信 用 社 会 代 码
   */
  private String biddCode;

  /**
   *  投标人地址
   */
  private String biddAddr;

  /**
   *  投 标 人 联 系 方 式
   */
  private String biddPhone;

  /**
   *  单位性质
   */
  private String unitProperties;

  /**
   *  项目类型
   */
  private ProjectType projType;

  /**
   *  保费
   */
  private BigDecimal premium;

  /**
   *  保额
   */
  private BigDecimal amount;

  /**
   *  起保日期
   */
  private String startDate;

  /**
   *  终保日期
   */
  private String endDate;

  /**
   *  投 标 有 效 期
   * （天）
   */
  private Integer expireDay;

  /**
   *  特别条款
   */
  private String endorse;
  /**
   *  主体
   */
  private Integer subject;

  /**
   * 审核文件
   */
  private List<FileUploadRequestV1Vo> files;

}
