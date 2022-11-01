package com.example.saasutil.service.universion;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 文件上传请求vo
 * @author: hushenggui
 * @create: 2021-09-13 09:45
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadRequestVo implements Serializable {

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
  private String fileBase64;

  /**
   * 订单编号
   */
  private String orderId;

}
