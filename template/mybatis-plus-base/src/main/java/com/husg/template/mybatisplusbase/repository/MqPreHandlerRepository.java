package com.husg.template.mybatisplusbase.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.husg.template.mybatisplusbase.entity.MqPreHandler;
import java.util.List;


/**
 * <p>
 *  仓储类
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
public interface MqPreHandlerRepository extends IService<MqPreHandler> {


    /**
     * 集合条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return List<MqPreHandler>
     */
    List<MqPreHandler> listEnhance(MqPreHandler mqPreHandler);


    /**
     * 分页条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param page: 分页入参
     * @param mqPreHandler:
     * @return Page<MqPreHandler>
     */
    Page<MqPreHandler> pageEnhance(Page<MqPreHandler> page, MqPreHandler mqPreHandler);


    /**
     * 单条条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return MqPreHandler
     */
    MqPreHandler getOneEnhanceById(Long id);

    /**
     * 根据查询参数查询单条结果
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return MqPreHandler
     */
    MqPreHandler getOneByParam(MqPreHandler mqPreHandler);

    /**
     * 总数
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Long
     */
    Long countEnhance(MqPreHandler mqPreHandler);


    /**
     * 新增
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Long
     */
    Long saveEnhance(MqPreHandler mqPreHandler);


    /**
     * 修改
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Long
     */
    Long updateEnhance(MqPreHandler mqPreHandler);


    /**
     * 删除
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return Boolean
     */
    Boolean removeEnhanceById(Long id);
}
