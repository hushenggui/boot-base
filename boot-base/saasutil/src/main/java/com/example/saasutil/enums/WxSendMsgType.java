package com.example.saasutil.enums;


public enum WxSendMsgType {
  SUCCESS_OPEN_RECEIPT("001","开票成功","CyhKDbi4AQ1tRJjXIwluuFbjVhLU6RooWqHQX4fKfoo"),
  UPDATE_EXPRESS("002","纸质开票成功","jy44eA2TRwc3V7XgWVEJwrnnSqFcJQRKVlCRLxqI4Ig"),
  FAIL_OPEN_RECEIPT("003","开票失败","5sIsTf-9uW4Q8rcdzsipbDsBeYszaQGLtbaaGJanPYQ"),
  INVOICE_EXPIRE("004","发票过期","jy44eA2TRwc3V7XgWVEJwrnnSqFcJQRKVlCRLxqI4Ig"),


  ;

  private String code;
  private String name;
  private String templateId;

  WxSendMsgType(String code, String name,String templateId) {
    this.code = code;
    this.name = name;
    this.templateId = templateId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }
}
