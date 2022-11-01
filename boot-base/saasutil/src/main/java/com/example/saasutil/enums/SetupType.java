package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;

public enum SetupType {

  /**
   * 普通费率
   */
  NOMALL(0),

  /**
   * 固定阶梯费率
   */
  FIXED_LEVEL(1),
  /**
   * 固定动态费率
   */
  FIXED_DYNAMIC(2),
  /**
   * 动态阶梯费率
   */
  DYNAMIC_LEVEL(3),

  /**
   * N单费率
   */
  QUANTITY(4),

  /**
   * 其他
   */
  OTHER(5)

  ;

  Integer type;

  SetupType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  /**
  * @Description: 获取费率类型
  * @Param: [type]
  * @return: 
  * @Author: hushenggui
  * @Date: 2022-03-15
  */
  public static SetupType getSetupType(Integer type) {
   List<SetupType> values = Arrays.asList(SetupType.values());
   List<SetupType> list =  values.stream().filter(setupType -> {
    return setupType.getType() == type;
   }).collect(Collectors.toList());

   if(CollectionUtils.isEmpty(list)){
     return SetupType.NOMALL;
   }
   return list.stream().findFirst().get();
  }
}
