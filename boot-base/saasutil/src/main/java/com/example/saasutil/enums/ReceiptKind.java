package com.example.saasutil.enums;

/**
 * 发票形式 0 电子 1 纸质
 */
public enum ReceiptKind {

  ELECTRON(0),
  PAPER(1),
  SPECIAL(2);

  private Integer kind;
  ReceiptKind(Integer kind) {
    this.kind = kind;
  }

  public Integer getKind() {
    return kind;
  }

  public static ReceiptKind convertToKind(Integer kind){
    for (ReceiptKind receiptKind : ReceiptKind.values()) {
      if (receiptKind.kind == kind) {
        return receiptKind;
      }
    }
    return null;
  }
}
