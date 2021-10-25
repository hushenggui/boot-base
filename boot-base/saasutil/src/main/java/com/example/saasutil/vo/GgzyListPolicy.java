package com.example.saasutil.vo;

import java.util.List;
import lombok.Data;

/**
 * Created by suhao on 2019/11/7.
 */
@Data
public class GgzyListPolicy {

    // 授权码
    private String authorization;
    // 循环体
    private List<GgzyPolicy> data;
}
