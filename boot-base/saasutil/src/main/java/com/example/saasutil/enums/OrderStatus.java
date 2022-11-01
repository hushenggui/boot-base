package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 订单前端展示节点
 */
public enum OrderStatus {
  /**
   * 已关闭
   */
  CLOSE(0),
  /**
   * 待投保
   */
  ORDER_WAIT(1),
  /**
   * 待风控审核
   */
  RISK_CHECK(2),
  /**
   * 待保险审核
   */
  INSURANCE_CHECK(3),
  /**
   * 待支付
   */
  PAY_WAIT(4),
  /**
   * 已支付
   */
  PAY(5),
  /**
   * 已完成
   */
  FINISH(6),
  ;

  OrderStatus(Integer status) {
    this.status = status;
  }

  Integer status;
  public Integer getStatus() {
    return status;
  }
  public void setStatus() {
    this.status = status;
  }

  public static OrderStatus getOrderStatus(String orderStatus) {
    List<OrderStatus> values = Arrays.asList(OrderStatus.values());
    List<OrderStatus> types = values.stream()
        .filter(channelInfo -> channelInfo.toString().equals(orderStatus)).collect(Collectors.toList());
    Optional<OrderStatus> first = types.stream().findFirst();
    if(first.isPresent()) {
      return first.get();
    } else {
      return OrderStatus.PAY_WAIT;
    }
  }
}
