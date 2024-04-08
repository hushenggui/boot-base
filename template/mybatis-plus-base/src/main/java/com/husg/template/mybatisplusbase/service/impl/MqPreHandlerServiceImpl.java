package com.husg.template.mybatisplusbase.service.impl;

import static com.husg.template.mybatisplusbase.common.RequestQueryWrapper.getQueryWrapper;

import com.husg.template.mybatisplusbase.common.MqPreHandlerConvert;
import com.husg.template.mybatisplusbase.dto.MqPreHandlerDTO;
import com.husg.template.mybatisplusbase.entity.MqPreHandler;
import com.husg.template.mybatisplusbase.exception.ArgumentException;
import com.husg.template.mybatisplusbase.repository.MqPreHandlerRepository;
import com.husg.template.mybatisplusbase.service.MqPreHandlerService;
import lombok.RequiredArgsConstructor;
import org.ares.margin.api.model.vo.enterprise.MqPreHandlerVO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hushenggui
 * @since 2023-11-03
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MqPreHandlerServiceImpl implements MqPreHandlerService {


    private final MqPreHandlerRepository mqPreHandlerRepository;

    /**
    * 分页条件查询
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandlerDto: DTO对象
    * @param page: 分页入参
    * @return Page<MqPreHandlerVO>
    */
    @Override
    public Page<MqPreHandlerVO> insidePageEnhance(Page<MqPreHandler> page, MqPreHandlerDTO mqPreHandlerDto) {
        queryPageCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertPageQueryMqPreHandler(mqPreHandlerDto);
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildPageQueryWrapper(mqPreHandler, queryWrapper);
        getQueryWrapper(mqPreHandlerDto.getQueryCriterias(), MqPreHandler.class, queryWrapper);
        Page<MqPreHandler> mqPreHandlerPage = mqPreHandlerRepository.page(page, queryWrapper);
        return assignment(convertMqPreHandlerPageVo(mqPreHandlerPage));
    }

    /**
     * 分页条件检查
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     */
    private void queryPageCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
     * 分页查询模型转换
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandler
     */
        private MqPreHandler convertPageQueryMqPreHandler(MqPreHandlerDTO mqPreHandlerDto){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
    }

    /**
     * 构建分页查询条件
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerVoPage: 分页显示VO
     * @return Page<MqPreHandler>
     */
    private Page<MqPreHandlerVO> assignment(Page<MqPreHandlerVO> mqPreHandlerVoPage) {
        mqPreHandlerVoPage.getRecords().forEach(mqPreHandlerVO -> {
        });
        return mqPreHandlerVoPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param page: 分页显示VO
     * @return Page<MqPreHandler>
     */
     private Page<MqPreHandlerVO> convertMqPreHandlerPageVo(Page<MqPreHandler> page){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandlerPageVo(page);
    }

    /**
     * 集合条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return List<MqPreHandlerVO>
     */
    @Override
    public List<MqPreHandlerVO> insideListEnhance(MqPreHandlerDTO mqPreHandlerDto) {
        queryListCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertMqPreHandlerListQuery(mqPreHandlerDto);
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildListQueryWrapper(mqPreHandler, queryWrapper);
        getQueryWrapper(mqPreHandlerDto.getQueryCriterias(), MqPreHandler.class, queryWrapper);
        List<MqPreHandler> mqPreHandlerList = mqPreHandlerRepository.list(queryWrapper);
        List<MqPreHandlerVO> mqPreHandlerVOList = convertMqPreHandlerVoList(mqPreHandlerList);
        return assignment(mqPreHandlerVOList);
    }

    /**
     * 集合条件检查
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     */
     private void queryListCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
    * 列表查询模型转换
    *
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandlerDto: DTO对象
    * @return Page<MqPreHandler>
    */
    private MqPreHandler convertMqPreHandlerListQuery(MqPreHandlerDTO mqPreHandlerDto){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
    }

    /**
    * 构建列表查询条件
    *
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandler:
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerList: 列表
     * @return List<MqPreHandlerVO>
     */
     public List<MqPreHandlerVO> convertMqPreHandlerVoList(List<MqPreHandler> mqPreHandlerList){
         return MqPreHandlerConvert.INSTANCE.convertMqPreHandlerVoList(mqPreHandlerList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author hushenggui
      * @since 2023-11-03
      * @param mqPreHandlerVOList: VO列表
      * @return List<MqPreHandler>
      */
     private List<MqPreHandlerVO> assignment(List<MqPreHandlerVO> mqPreHandlerVOList) {
        mqPreHandlerVOList.forEach(mqPreHandlerVO -> {
        });
        return  mqPreHandlerVOList;
     }

    /**
     * 单条条件查询
     * @author hushenggui
     * @since 2023-11-03
     * @param id: id
     * @return MqPreHandlerVO
     */
    @Override
    public MqPreHandlerVO insideGetEnhanceById(Long id) {
        MqPreHandler mqPreHandler = mqPreHandlerRepository.getById(id);
        MqPreHandlerVO mqPreHandlerVO = convertMqPreHandlerVo(mqPreHandler);
        return assignment(mqPreHandlerVO);
    }

    /**
     * 根据查询参数查询单条结果
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandlerVO
    */
    @Override
    public MqPreHandlerVO insideGetOneEnhanceByParam(MqPreHandlerDTO mqPreHandlerDto) {
        queryParamCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertMqPreHandlerParamQuery(mqPreHandlerDto);
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildParamQueryWrapper(mqPreHandler, queryWrapper);
        getQueryWrapper(mqPreHandlerDto.getQueryCriterias(), MqPreHandler.class, queryWrapper);
        MqPreHandler mqPreHandlerResult = mqPreHandlerRepository.getOne(queryWrapper);
        MqPreHandlerVO mqPreHandlerVO = convertMqPreHandlerVo(mqPreHandlerResult);
        return assignment(mqPreHandlerVO);
    }

    /**
    * 单条结果参数查询条件检查
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandlerDto: DTO对象
    */
    private void queryParamCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
    * 构建统计查询条件
    *
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandler:
    * @param queryWrapper: 查询Wrapper
    */
    private void buildParamQueryWrapper(MqPreHandler mqPreHandler, QueryWrapper<MqPreHandler> queryWrapper) {

    }

    /**
     * 单条查询模型转换
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandler
     */
    public MqPreHandler convertMqPreHandlerParamQuery(MqPreHandlerDTO mqPreHandlerDto){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
    }

    /**
     * 详情显示模型转换
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandler:
     * @return MqPreHandlerVO
     */
     private MqPreHandlerVO convertMqPreHandlerVo(MqPreHandler mqPreHandler){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandlerVo(mqPreHandler);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerVO: VO
     * @return MqPreHandler
     */
    private MqPreHandlerVO assignment(MqPreHandlerVO mqPreHandlerVO) {
        return mqPreHandlerVO;
    }

    /**
     * 总数
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return Long
     */
    @Override
    public Long insideCountEnhance(MqPreHandlerDTO mqPreHandlerDto) {
        countCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertCountQueryMqPreHandler(mqPreHandlerDto);
        QueryWrapper<MqPreHandler> queryWrapper = new QueryWrapper<>(mqPreHandler);
        buildCountQueryWrapper(mqPreHandler, queryWrapper);
        getQueryWrapper(mqPreHandlerDto.getQueryCriterias(), MqPreHandler.class, queryWrapper);
        return mqPreHandlerRepository.count(queryWrapper);
    }

    /**
    * 统计查询检查
    * @author hushenggui
    * @since 2023-11-03
    * @param mqPreHandlerDto: DTO对象
    */
    public void countCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
     * 统计查询模型转换
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandler
     */
     private MqPreHandler convertCountQueryMqPreHandler(MqPreHandlerDTO mqPreHandlerDto){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
    }

    /**
     * 构建统计查询条件
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
     * @param mqPreHandlerDto: DTO对象
     * @return Long
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Long insideSaveEnhance(MqPreHandlerDTO mqPreHandlerDto) {
        saveCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertMqPreHandlerSaveModel(mqPreHandlerDto);
        boolean result = mqPreHandlerRepository.save(mqPreHandler);
        if(result){
            return mqPreHandler.getId();
        }
        throw new ArgumentException("保存失败");
    }

    /**
     * 保存检查
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     */
    private void saveCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
     * 新增模型转换
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandler
     */
     private MqPreHandler convertMqPreHandlerSaveModel(MqPreHandlerDTO mqPreHandlerDto){
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
    }

    /**
     * 修改
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: 修改DTO
     * @return Long
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Long insideUpdateEnhance(MqPreHandlerDTO mqPreHandlerDto) {
        updateCheck(mqPreHandlerDto);
        MqPreHandler mqPreHandler = convertUpdateMqPreHandlerModel(mqPreHandlerDto);
        LambdaUpdateWrapper<MqPreHandler> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(mqPreHandler,lambdaUpdateWrapper);
        boolean result = mqPreHandlerRepository.update(mqPreHandler, lambdaUpdateWrapper);
        if(result){
            return mqPreHandler.getId();
        }
        throw new ArgumentException("保存失败");
    }

    /**
     * 更新检查
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     */
     private void updateCheck(MqPreHandlerDTO mqPreHandlerDto) {

    }

    /**
     * 构建修改条件
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
     * 修改模型转换
     *
     * @author hushenggui
     * @since 2023-11-03
     * @param mqPreHandlerDto: DTO对象
     * @return MqPreHandler
     */
    public MqPreHandler convertUpdateMqPreHandlerModel(MqPreHandlerDTO mqPreHandlerDto){
        if(StringUtils.isEmpty(mqPreHandlerDto.getId())){
            throw new ArgumentException("id不能为空");
        }
        return MqPreHandlerConvert.INSTANCE.convertMqPreHandler(mqPreHandlerDto);
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
    public Boolean insideRemoveEnhanceById(Long id) {
        return mqPreHandlerRepository.removeById(id);
    }
}

