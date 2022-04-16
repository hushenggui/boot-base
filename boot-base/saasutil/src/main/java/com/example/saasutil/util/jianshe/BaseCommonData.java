package com.example.saasutil.util.jianshe;

import lombok.Data;

@Data
public class BaseCommonData {
    private String channel;
    private String timeStamp;
    private String nonce;
    private String encrypt;
    private String signature;


}
