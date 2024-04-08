package com.husg.template.mybatisplusbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("mq_pre_handler")
@ApiModel(value = "MqPreHandler对象", description = "")
public class MqPreHandler implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Long id;

    @ApiModelProperty("主键自增")
    @TableId(value = "row_id", type = IdType.AUTO)
    private Long rowId;

    @ApiModelProperty("业务id")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty("任务处理器")
    @TableField("exchange_name")
    private String exchangeName;

    @ApiModelProperty("队列名")
    @TableField("queue")
    private String queue;

    @ApiModelProperty("json对象")
    @TableField("content")
    private String content;

    @ApiModelProperty("是否直接放入延迟队列")
    @TableField("send_delay_queue")
    private Boolean sendDelayQueue;

    @ApiModelProperty("是否直接弃用消息")
    @TableField("cancel")
    private Boolean cancel;

    @ApiModelProperty("执行次数")
    @TableField("count")
    private Integer count;

    @ApiModelProperty("最新执行时间")
    @TableField("handler_date")
    private LocalDateTime handlerDate;

    @ApiModelProperty("创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    @TableField("update_date")
    private LocalDateTime updateDate;

    @ApiModelProperty("0未删除1已删 除")
    @TableField("is_delete")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty("行政区划")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty("json格式冗余扩展字段")
    @TableField("ext")
    private String ext;


}
