package com.example.saasutil.service.universion;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: huacailiang
 * @date: 2020/3/31
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileVo implements Serializable {

  public FileVo(String id) {
    this.id = id;
  }
  public FileVo(String id, String application) {
    this.id = id;
    this.application = application;
  }
  /**
   * uuid
   */
  private String id;

  /**
   * 附件名
   */
  private String name;

  /**
   * 附件md5值
   */
  private String md5;

  /**
   * 下载地址
   */
  private String downloadUrl;

  private Date createDate;

  private Date updateDate;

  /**
   * 0未删除1已删 除
   */
  private Boolean delete;

  /**
   * 行政区划分
   */
  private String cityCode;

  /**
   * 行数，自增
   */
  private Integer rowId;
  /**
   * 扩展字段
   */
  private String ext;
  private String application;
  private String insCode;

  /**
   * 用户存储韶关发票申请后,平安响应给我们的发票内容
   */
  private String fileValue;

  /**
   * 订单编号
   */
  private String orderNo;

  /**
   * 附件 base64
   */
  private String fileBase64;

  private Integer fileSize;
  
  /**
   * 文件类型
   */
  private String fileType;
  

  private String orderSerialNo;
}
