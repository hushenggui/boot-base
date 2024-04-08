package com.husg.template.mybatisplusbase.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * DTO对象
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "MqPreHandlerDTO", description = "DTO对象")
public class MqPreHandlerDTO extends QueryBaseDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    private String id;

    @ApiModelProperty(value = "主键自增", example = "1")
    private Long rowId;

    @ApiModelProperty(value = "业务id")
    private String businessId;

    @ApiModelProperty(value = "任务处理器")
    private String exchangeName;

    @ApiModelProperty(value = "队列名")
    private String queue;

    @ApiModelProperty(value = "json对象")
    private String content;

    @ApiModelProperty(value = "是否直接放入延迟队列")
    private Boolean sendDelayQueue;

    @ApiModelProperty(value = "是否直接弃用消息")
    private Boolean cancel;

    @ApiModelProperty(value = "执行次数", example = "1")
    private Integer count;

    @ApiModelProperty(value = "最新执行时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime handlerDate;

    @ApiModelProperty(value = "创建时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "修改时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "行政区划")
    private String cityCode;

    @ApiModelProperty(value = "json格式冗余扩展字段")
    private String ext;




}
