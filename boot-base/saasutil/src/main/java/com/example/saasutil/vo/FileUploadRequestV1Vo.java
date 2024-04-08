package com.example.saasutil.vo;

import com.example.saasutil.service.universion.FileUploadRequestVo;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 投保时 上传审核文件
 * @author: yangxx
 * @create:
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadRequestV1Vo implements Serializable {

  private static final long serialVersionUID = -4423079324710894479L;

  /**
   * 附件 ID
   */
  private String fileId;

  /**
   *  附件名
   */
  private String filename;

  /**
   *  附件大小
   */
  private Integer fileSize;

  /**
   *  附件 MD5
   */
  private String fileMD5;

  /**
   *  附件地址
   */
  private String fileUrl;

  /**
   *  附件 base64
   */
  private transient  String fileBase64;

  /**
   * 订单编号
   */
  private String orderId;

  public static void main(String[] args) {
    String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDU8c0xyyTk4bx/s7GpPZGNvP4h0ayaPVWEXzWCh02bH6ATmb+6VxRBvjF105HwCod81XR30NPTv8Zu4FfLkVmPimGZPIgERriAUbA4kMmpPoeKfoo7uPnI3mqLHeATg3z2KMxOuPEP1SBjsTwqK0HqZfVvL+/wvXDSEaH/Yw1QOQIDAQAB";
    String req = "{\"cityCode\":\"330324\",\"cityName\":\"永嘉县\",\"insCode\":\"20009\",\"source\":\"电子保函平台\",\"reqTime\":\"20230718171500\",\"reqType\":\"BANK_BID\",\"reqBody\":{\"fileId\":\"\",\"filename\":\"8571220230000177.pdf\",\"fileSize\":433,\"fileMD5\":\"6086f24877f2135eea5694223bfc1454\",\"orderId\":\"10110103303242023071816552570795\"},\"sign\":\"yi5V55s2niwu5Oj2JdbAWC/nF0ScnAAH6nfg9PjPJyAP1590WkLRkH+o+61TD1NhJ0WX8WbsIMoSWjwbrh+sfKK8QORcfeYMWi8SpSQhZ7l0giBWt53MeMPzd7TXQ8rH93hprIA7L58R1huc528jtLo8f2xnggkEWH+HztDEWRluDlmbZkVZXxBisQMRScQ3kkGeBrhcENqrZscEVh/L04YDFPU3tH5iUjkyZIfu6rNbtfttqi29DgEe8P/ZcBnB5RPacEgXXSFwlhQuiQN1wNUZP8JUK2bLg0hnzOfC6Rtv8F8JOhpWHqvc1vhIExaaQ1u0U/U/wGfZeC0Hx7M/ug\"}";
    String sign = "yi5V55s2niwu5Oj2JdbAWC/nF0ScnAAH6nfg9PjPJyAP1590WkLRkH+o+61TD1NhJ0WX8WbsIMoSWjwbrh+sfKK8QORcfeYMWi8SpSQhZ7l0giBWt53MeMPzd7TXQ8rH93hprIA7L58R1huc528jtLo8f2xnggkEWH+HztDEWRluDlmbZkVZXxBisQMRScQ3kkGeBrhcENqrZscEVh/L04YDFPU3tH5iUjkyZIfu6rNbtfttqi29DgEe8P/ZcBnB5RPacEgXXSFwlhQuiQN1wNUZP8JUK2bLg0hnzOfC6Rtv8F8JOhpWHqvc1vhIExaaQ1u0U/U/wGfZeC0Hx7M/ug";

    GongbaoChannelReqBaseVo<FileUploadRequestVo> gongbaoChannelReqBaseVo = JacksonUtils.jsonString2Obj(req,
        GongbaoChannelReqBaseVo.class);
    FileUploadRequestVo fileUploadRequestVo = GsonUtil.parseObject(
        GsonUtil.toJsonSort(gongbaoChannelReqBaseVo.getReqBody()), FileUploadRequestVo.class);
    fileUploadRequestVo.setFileUrl("https://api.zj96596.com/coip/#/result/yjResult");

    boolean check = RSAUtil.check(GsonUtil.toJsonSort(fileUploadRequestVo), gongbaoChannelReqBaseVo.getSign(), publicKey);
    System.out.println(check);

  }

}
