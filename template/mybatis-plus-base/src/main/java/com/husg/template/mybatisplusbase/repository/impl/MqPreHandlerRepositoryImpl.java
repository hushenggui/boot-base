package com.husg.template.mybatisplusbase.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.husg.template.mybatisplusbase.entity.MqPreHandler;
import com.husg.template.mybatisplusbase.exception.ArgumentException;
import com.husg.template.mybatisplusbase.mapper.MqPreHandlerMapper;
import com.husg.template.mybatisplusbase.repository.MqPreHandlerRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <p>
 *  仓储实现类
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Slf4j
@Service
public class MqPreHandlerRepositoryImpl extends ServiceImpl<MqPreHandlerMapper, MqPreHandler> implements
    MqPreHandlerRepository {


    /**
     * 集合条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return List<MqPreHandler>
     */
    @Override
    public List<MqPreHandler> listEnhance(MqPreHandler mqPreHandler) {
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildListQueryWrapper(mqPreHandler, queryWrapper);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 构造list查询条件
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 分页条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param page: 分页入参
     * @return Page<MqPreHandler>
     */
    @Override
    public Page<MqPreHandler> pageEnhance(Page<MqPreHandler> page, MqPreHandler mqPreHandler) {
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildPageQueryWrapper(mqPreHandler, queryWrapper);
        return baseMapper.selectPage(page, queryWrapper);
    }

    /**
     * 构造分页查询条件
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param queryWrapper: 查询Wrapper
    */
    private void buildPageQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 单条条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return MqPreHandler
     */
    @Override
    public MqPreHandler getOneEnhanceById(Long id) {
        return assignment(baseMapper.selectById(id));
    }

    /**
     * 根据查询参数查询单条结果
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return MqPreHandler
     */
    @Override
    public MqPreHandler getOneByParam(MqPreHandler mqPreHandler) {
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildOneQueryWrapper(mqPreHandler, queryWrapper);
        return assignment(baseMapper.selectOne(queryWrapper));
    }

    /**
     * 构造单条查询条件
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param queryWrapper: 查询Wrapper
    */
    private void buildOneQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 总数
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Long
     */
    @Override
    public Long countEnhance(MqPreHandler mqPreHandler) {
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildCountQueryWrapper(mqPreHandler, queryWrapper);
        return baseMapper.selectCount(queryWrapper);
    }

    /**
    * 构造单条查询条件
    *
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandler:
    * @param queryWrapper: 查询Wrapper
    */
    private void buildCountQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 新增
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Long saveEnhance(MqPreHandler mqPreHandler) {
        boolean result = baseMapper.insert(mqPreHandler) > 0;
        if(result){
            return mqPreHandler.getId();
        }
        throw new ArgumentException("保存失败");
    }

    /**
     * 修改
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return Boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Long updateEnhance(MqPreHandler mqPreHandler) {
        LambdaUpdateWrapper<MqPreHandler> updateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(mqPreHandler, updateWrapper);
        boolean result = baseMapper.update(mqPreHandler, updateWrapper) > 0;
        if(result){
            return mqPreHandler.getId();
        }
        throw new ArgumentException("保存失败");
    }

    /**
     * 构造更新条件
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(MqPreHandler mqPreHandler, LambdaUpdateWrapper<MqPreHandler> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(MqPreHandler::getId,mqPreHandler.getId());
    }

    /**
     * 删除
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return Boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Boolean removeEnhanceById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return MqPreHandler
     */
    private MqPreHandler assignment(MqPreHandler mqPreHandler) {
        return mqPreHandler;
    }

    /**
     * 分页,增强返回参数追加
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerList:
     * @return Page<MqPreHandler>
     */
    private Page<MqPreHandler> assignment(Page<MqPreHandler> mqPreHandlerList) {
        mqPreHandlerList.getRecords().forEach(mqPreHandler -> {
        });
        return mqPreHandlerList;
    }

    /**
     * 集合,增强返回参数追加
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerList:
     * @return List<MqPreHandler>
     */
    private List<MqPreHandler> assignment(List<MqPreHandler> mqPreHandlerList) {
        mqPreHandlerList.forEach(mqPreHandler -> {
        });
        return mqPreHandlerList;
    }
}
