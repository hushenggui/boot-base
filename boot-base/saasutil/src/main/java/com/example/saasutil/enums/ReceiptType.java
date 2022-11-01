package com.example.saasutil.enums;

/**
 *  0增值税普通发票1增值 税专用发票
 */
public enum ReceiptType {

  ORDINARY(0),
  SPECIAL(1);

  private Integer type;
  ReceiptType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public static String getInvoiceType(ReceiptType type, ReceiptKind kind) {
    if (ReceiptType.ORDINARY == type && ReceiptKind.ELECTRON == kind) {
      return "1";
    }
    else if (ReceiptType.ORDINARY == type && ReceiptKind.PAPER == kind) {
      return "2";
    }
    else if (ReceiptType.SPECIAL == type && ReceiptKind.PAPER == kind) {
      return "3";
    } else {
      return "1";
    }
  }

  public static ReceiptType convertToType(Integer type){
    for (ReceiptType receiptType : ReceiptType.values()) {
      if (receiptType.type == type) {
        return receiptType;
      }
    }
    return null;
  }
}
