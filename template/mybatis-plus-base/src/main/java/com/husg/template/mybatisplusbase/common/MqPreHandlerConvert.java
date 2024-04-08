package com.husg.template.mybatisplusbase.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.husg.template.mybatisplusbase.dto.MqPreHandlerDTO;
import com.husg.template.mybatisplusbase.entity.MqPreHandler;
import java.util.List;
import org.ares.margin.api.model.vo.enterprise.MqPreHandlerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 *  转换类
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Mapper
public interface MqPreHandlerConvert {

    MqPreHandlerConvert INSTANCE = Mappers.getMapper(MqPreHandlerConvert.class);

    /**
     * mqPreHandlerDTO转换为MqPreHandler
     *
     * @param mqPreHandlerDTO DTO对象
     * @return MqPreHandler
     */
    MqPreHandler convertMqPreHandler(MqPreHandlerDTO mqPreHandlerDTO);

    /**
     * MqPreHandler转换为MqPreHandlerVO
     *
     * @param mqPreHandler DTO对象
     * @return MqPreHandlerVO
     */
    MqPreHandlerVO convertMqPreHandlerVo(MqPreHandler mqPreHandler);

    /**
     * mqPreHandler列表转换为MqPreHandlerVO列表
     *
     * @param mqPreHandlerList 列表
     * @return List<MqPreHandlerVO>
     */
    List<MqPreHandlerVO> convertMqPreHandlerVoList(List<MqPreHandler> mqPreHandlerList);

    /**
     * 分页对象转换为MqPreHandlerVO分页对象
     *
     * @param mqPreHandlerPage 分页对象
     * @return Page<MqPreHandlerVO>
     */
    Page<MqPreHandlerVO> convertMqPreHandlerPageVo(Page<MqPreHandler> mqPreHandlerPage);
}
