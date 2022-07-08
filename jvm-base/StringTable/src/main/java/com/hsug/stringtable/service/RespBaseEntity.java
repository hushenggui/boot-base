package com.hsug.stringtable.service;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: user-opertation
 * @description: 返回基础vo
 * @author: hushenggui
 * @create: 2022-03-30 15:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespBaseEntity<T> implements Serializable {

  private static final long serialVersionUID = -214895577962130260L;
  /**
   * 返回状态
   */
  private String status;

  /**
   * 状态编码
   */
  private String errorCode;

  /**
   * 返回消息
   */
  private String errorMsg;

  /**
   * 返回实体
   */
  private T data;


}
