package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author: huacailiang
 * @date: 2020/6/19
 * @description:
 **/
public enum ProjectType {

  CONSTRUCTION_PROJECT(1, "建设工程"),
  GOVERNMENT_PROJECT(2, "政府采购"),
  SOCIETY_PROJECT(3, "社会项目"),
  WATER_PROJECT(4, "水利"),
  TRAFFIC_PROJECT(5, "交通"),
  STATE_PROJECT(6, "国有资产"),
  MINE_PROJECT(7, "矿业权交易"),
  EQUITY_PROJECT(8, "产权交易"),
  COMPREHENSIVE_TRANSACTION(9, "综合交易"),
  PHARMACEUTICAL_PROCUREMENT(10, "医药采购"),
  TAIZHOU_QA(1000,"泰州保司前置")
  ;

  private Integer type;
  private String name;

  ProjectType(Integer type, String name) {
    this.type = type;
    this.name = name;
  }

  public Integer getType() {
    return type;
  }

  public String getName() {
    return name;
  }


}
