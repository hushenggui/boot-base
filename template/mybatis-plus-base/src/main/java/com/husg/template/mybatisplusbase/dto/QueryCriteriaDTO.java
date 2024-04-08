package com.husg.template.mybatisplusbase.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * description: 条件查询类
 *
 * @author yunjiang
 * @since 2022-04-18 13:43:53
 */
@ToString
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "QueryCriteriaDTO对象", description = "查询条件")
public class QueryCriteriaDTO implements Comparable<QueryCriteriaDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性编码")
    private String attributeCode;

    @ApiModelProperty(value = "查询类型（10：查询，20，排序）", example = "1")
    private Integer queryType;

    @ApiModelProperty(value = "排序类型（1：升序，2：降序）", example = "1")
    private Integer orderType;

    @ApiModelProperty(value = "类型（BASE：基础类型）")
    private String type;

    @ApiModelProperty(value = "数据类型（TXT：文本，TXT_AREA：文本域，富文本：RICH_TXT，NUM：数字，MONEY：金额，FLOAT：浮点数，DATE：日期，DATE_RANGE：日期范围，DATE_TIME：时间，DATE_TIME_RANGE：时间范围，TEL：座机，PHONE：手机，PID：身份证，CNO：统一社会信用代码，MAIL：邮箱，ADDRESS：地址，DICT：数据字典，DICT_CASCADE：级联数据字典，FILE：资料字段，IMAGE：图片，GEO：地图选点）")
    private String dataType;

    @ApiModelProperty(value = "条件类型（10：相等，20：包含，30：模糊，31：前模糊，32：后模糊，40：大于，41：大于等于，50：小于，51小于等于）", example = "1")
    private Integer conditionType;

    @ApiModelProperty(value = "实际值")
    private String actualValue;

    @ApiModelProperty(value = "排序", example = "1")
    private Integer sort;

    @Override
    public int compareTo(QueryCriteriaDTO o) {

        if (this.queryType.compareTo(o.queryType) != 0) {
            return this.queryType.compareTo(o.queryType);
        } else {
            return this.sort.compareTo(o.sort);
        }

    }

}
