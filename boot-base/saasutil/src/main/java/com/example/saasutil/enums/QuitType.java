package com.example.saasutil.enums;

import org.springframework.util.ObjectUtils;

/**
 * 交易中心退保状态
 */
public enum QuitType {
  /**
   * 流标
   */
  LOSS(0),
  /**
   * 终止
   */
  TERMINATION(1),
  /**
   * 暂停
   */
  PAUSE(2),
  /**
   * 延期
   */
  DELAY(3),
  /**
   * 交易中心开标前退保
   */
  REFUND(4),
  /**
   * 作废
   */
  INVALID(5);

  private Integer status;

  QuitType(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }

  /**
   * @Description: 获取中文名
   * @Param: [quitType]
   * @return:
   * @Author: hushenggui
   * @Date: 2020/10/20
   */
  public static String getQuitTypeName(QuitType quitType){
    String quitTypeName = "";
    switch (quitType){
      case LOSS: quitTypeName = "流标";
        break;
      case TERMINATION: quitTypeName = "终止";
        break;
      case PAUSE: quitTypeName = "暂停";
        break;
      case DELAY: quitTypeName = "延期";
        break;
      default:quitTypeName = "异常";
    }
    return quitTypeName;
  }

  public static QuitType intToEnum(Integer status){
    QuitType quitType;
    if(ObjectUtils.isEmpty(status)){
      return null;
    }
    switch (status){
      case 0: quitType = QuitType.LOSS;
        break;
      case 1: quitType = QuitType.TERMINATION;
        break;
      case 2: quitType = QuitType.PAUSE;
        break;
      case 3: quitType = QuitType.DELAY;
        break;
      case 4: quitType = QuitType.REFUND;
        break;
      case 5: quitType = QuitType.INVALID;
        break;
      default:quitType = null;
    }
    return quitType;
  }
}
