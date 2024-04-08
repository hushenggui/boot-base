package com.example.saasutil.service.guotai;

import lombok.Data;

/**
 * @author: huacailiang
 * @date: 2020/2/12
 * @description:
 * 名称  是否必须	说明
 * appkey	是
 * timestamp	是	请求时间，格式:yyyy-MM-dd HH:mm:ss
 * applyno	是	业务流水号
 * baohanno	是	保函编号
 * baohanurl	是	保函文件下载地址
 * baohanfile	是	保函文件的base64码
 * payername	是	付保费银行账户户名
 * payeraccount	是	支付保费银行账户号码
 * instname	否	出函机构（如果是第三方平台必填）
 * generatetime	是	出函时间，格式:yyyy-MM-dd HH:mm:ss
 * rate	是	费率
 * cost	是	费用
 * applystatus	是	是否审核通过  1：审核通过  0：审核未通过
 * sign	是	报文签名
 **/
@Data
public class GuoTaiApplyNoticeBean {
  private String appkey;
  private String timestamp;
  private String applyno;
  private String baohanno;
  private String baohanurl;
  private String baohanfile;
  private String payername;
  private String payeraccount;
  private String instname;
  private String generatetime;
  private String rate;
  private String cost;
  private String applystatus;
  private String sign;
}
