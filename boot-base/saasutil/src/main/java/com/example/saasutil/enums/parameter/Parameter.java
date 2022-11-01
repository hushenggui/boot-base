package com.example.saasutil.enums.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：MiHaiDong
 * @date ：Created in 2022/5/11 15:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

    //所属对象
    private String fromObject;
    //参数
    private String parameter;
    //注释
    private String explain;
    //是否禁止修改
    private Boolean disable;
    //是否隐藏
    private Boolean hidden;
    //是否必填
    private Boolean required;
}
