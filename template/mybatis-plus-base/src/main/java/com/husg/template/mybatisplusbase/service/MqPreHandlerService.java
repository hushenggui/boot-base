package com.husg.template.mybatisplusbase.service;

import com.husg.template.mybatisplusbase.dto.MqPreHandlerDTO;
import com.husg.template.mybatisplusbase.entity.MqPreHandler;
import org.ares.margin.api.model.vo.enterprise.MqPreHandlerVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
public interface MqPreHandlerService {


    /**
    * 分页条件查询
    * @author hushenggui
    * @since 2023-11-03
    * @param page: 分页入参
    * @param mqPreHandlerDto: DTO分页查询对象
    * @return Page<MqPreHandlerVO>
    */
    Page<MqPreHandlerVO> insidePageEnhance(Page<MqPreHandler> page, MqPreHandlerDTO mqPreHandlerDto);


    /**
     * 集合条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO查询对象
     * @return List<MqPreHandlerVO>
     */
    List<MqPreHandlerVO> insideListEnhance(MqPreHandlerDTO mqPreHandlerDto);


    /**
     * 单条条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return MqPreHandlerVO
     */
    MqPreHandlerVO insideGetEnhanceById(Long id);

    /**
     * 根据查询参数查询单条结果
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO查询对象
     * @return MqPreHandlerVO
     */
    MqPreHandlerVO insideGetOneEnhanceByParam(MqPreHandlerDTO mqPreHandlerDto);

    /**
     * 总数
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO
     * @return Long
     */
    Long insideCountEnhance(MqPreHandlerDTO mqPreHandlerDto);


    /**
     * 新增
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: 新增DTO
     * @return Long
     */
     Long insideSaveEnhance(MqPreHandlerDTO mqPreHandlerDto);


    /**
     * 修改
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: 修改DTO
     * @return Long
     */
     Long insideUpdateEnhance(MqPreHandlerDTO mqPreHandlerDto);


    /**
     * 删除
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return Boolean
     */
    Boolean insideRemoveEnhanceById(Long id);
}
