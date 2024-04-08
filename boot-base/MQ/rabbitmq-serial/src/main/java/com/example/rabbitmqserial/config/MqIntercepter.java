package com.example.rabbitmqserial.config;

import java.util.Date;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-01-06 16:42
 **/
public class MqIntercepter {

  /** 解决问题
   * 1 主要针对延迟队列中无脑延迟的消息，能随时关或者启用
   * 2 修改延迟队列实体内容
   */

  /**
   * 执行逻辑
   * 查库 ->  有数据，用DB数据处理，没有数据,新增一条 -> 走原逻辑
   */

  /**
   * 任务id   uuid
   */
  private String jobId;

  /**
   * 业务id
   */
  private String businessId;

  /**
   * 任务处理器
   */
  private String exchangeName;


  private String queue;

  /**
   * json对象
   */
  private String content;

  /**
   * 是否直接放入延迟队列
   */
  private Boolean sendDelayQueue = Boolean.FALSE;

  /**
   * 是否直接弃用消息
   */
  private Boolean cancel = Boolean.FALSE;

  /**
   * 执行次数
   */
  private Long count;

  /**
   * 最新执行时间
   */
  private Date handlerDate;


}
