package com.husg.template.mybatisplusbase.common;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-11-08 15:27
 **/
public class PageConfig {
  public static final Integer MIN_SIZE = 10;
  public static final Integer MAX_SIZE = 100;

  public PageConfig() {
  }

  public static Integer currentPagination(Integer current) {
    return null != current && current >= 1 ? current : 1;
  }

  public static Integer pageSize(Integer pageSize) {
    if (null != pageSize && pageSize >= MIN_SIZE) {
      return pageSize > MAX_SIZE ? MAX_SIZE : pageSize;
    } else {
      return MIN_SIZE;
    }
  }
}
