package com.study.rabbitmq.model;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SysUser implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String routingKey;
}