package com.example.saasutil.exception;

/**
 * <功能描述> <br>
 *
 * @className: Base64Exception
 * @package: com.cngongbao.nobasic.platform.exception
 * @author: 刘川
 * @date: 2020/11/10 15:32
 */
public class Base64Exception extends Throwable {

  static final long serialVersionUID = 202011101533L;


  public Base64Exception() {
    super();
  }


  public Base64Exception(String message) {
    super(message);
  }


  public Base64Exception(String message, Throwable cause) {
    super(message, cause);
  }


  public Base64Exception(Throwable cause) {
    super(cause);
  }


  protected Base64Exception(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}