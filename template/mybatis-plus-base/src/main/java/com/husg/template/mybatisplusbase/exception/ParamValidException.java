package com.husg.template.mybatisplusbase.exception;

/**
 * description: 参数校验异常
 * @author
 * @since
 */
public class ParamValidException extends RuntimeException {

    public ParamValidException(String message) {
        super(message);
    }
}
