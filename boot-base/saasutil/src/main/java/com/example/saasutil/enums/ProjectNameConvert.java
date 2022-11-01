package com.example.saasutil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author linxinlei
 * @project saas
 * @description 项目类型映射
 * @date 2022/5/31
 **/
@Getter
@AllArgsConstructor
public enum ProjectNameConvert {

  MINE_PROJECT("矿权交易", "矿业权交易"),
  ;
  private final String originName;
  private final String targetName;

  public static ProjectNameConvert valueOfOriginName(String originName) {
    for (ProjectNameConvert value : ProjectNameConvert.values()) {
      if (value.originName.equals(originName)) {
        return value;
      }
    }
    return null;
  }
}
