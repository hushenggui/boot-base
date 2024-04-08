package com.husg.template.mybatisplusbase.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.husg.template.mybatisplusbase.dto.QueryCriteriaDTO;
import com.husg.template.mybatisplusbase.enums.ConditionTypeEnum;
import com.husg.template.mybatisplusbase.enums.QueryTypeEnum;
import com.husg.template.mybatisplusbase.exception.ParamValidException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * description: 请求参数中的条件构造器
 *
 * @author zhouxinlei
 * @since 2022-08-02 17:10:18
 */
public class RequestQueryWrapper {

    private static final Logger logger = LoggerFactory.getLogger(RequestQueryWrapper.class);

    /**
     * 从{@link QueryCriteriaDTO}集合中转换为实体对象
     *
     * @param ls     QueryCriteriaDTO集合
     * @param tClass 需要转换的类
     * @param <T>    需要转换的类
     * @return 实体对象
     */
    public static <T> T buildFromQueryCriteriaDTO(List<QueryCriteriaDTO> ls, Class<T> tClass) {
        if (ls == null || ls.size() == 0) {
            return null;
        }
        Map<Integer, List<QueryCriteriaDTO>> map = convertQueryAndSortMap(ls);

        List<QueryCriteriaDTO> queryList = map.get(10);

        Map<String, String> data = new HashMap<>(8);
        for (QueryCriteriaDTO queryCriterion : queryList) {
            String field = queryCriterion.getAttributeCode();
            String value = queryCriterion.getActualValue();
            data.put(field, value);
        }
        return BeanUtil.fillBeanWithMap(data, ReflectUtil.newInstance(tClass), true);

    }

    /**
     * 获取动态查询参数
     *
     * @param ls           QueryCriteriaDTO集合
     * @param clazz        待查实体类
     * @param queryWrapper 动态查询参数构造器
     * @param <T>          待查实体
     * @return 待查实体对应的动态参数构造器
     */
    public static <T> QueryWrapper<T> getQueryWrapper(List<QueryCriteriaDTO> ls,
                                                      Class<T> clazz,
                                                      QueryWrapper<T> queryWrapper) {
        if (ls == null || ls.size() == 0) {
            return queryWrapper;
        }
        Map<Integer, List<QueryCriteriaDTO>> map =
                convertQueryAndSortMap(ls);
        try {
            return buildQuery(map.get(QueryTypeEnum.QUERY.getId()), map.get(QueryTypeEnum.SORT.getId()), clazz, queryWrapper);
        } catch (IllegalArgumentException e) {
            logger.error("构造动态查询参数异常, ", e);
        }
        return new QueryWrapper<>();
    }


    /**
     * 获取动态查询参数
     *
     * @param ls    QueryCriteriaDTO集合
     * @param clazz 待查实体类
     * @param <T>   待查实体
     * @return 待查实体对应的动态参数构造器
     */
    public static <T> QueryWrapper<T> getQueryWrapper(List<QueryCriteriaDTO> ls, Class<T> clazz) {
        if (ls == null || ls.size() == 0) {

            return new QueryWrapper<>();
        }
        Map<Integer, List<QueryCriteriaDTO>> map =
                convertQueryAndSortMap(ls);
        return buildQuery(map.get(10), map.get(20), clazz);
    }

    /**
     * 将{@link QueryCriteriaDTO}集合转换为map，转换依据是{@link QueryCriteriaDTO#getQueryType()}
     *
     * @param ls QueryCriteriaDTO集合
     * @return 转换结果集合
     */
    public static Map<Integer, List<QueryCriteriaDTO>> convertQueryAndSortMap(List<QueryCriteriaDTO> ls) {
        return ls.stream().collect(Collectors.groupingBy(QueryCriteriaDTO::getQueryType));
    }

    /**
     * 构造动态查询参数
     *
     * @param query        用于查询的QueryCriteriaDTO集合
     * @param order        用于排序的QueryCriteriaDTO集合
     * @param clazz        待查实体类
     * @param queryWrapper 动态查询参数构造器
     * @param <T>          待查实体
     * @return 动态查询参数
     */
    private static <T> QueryWrapper<T> buildQuery(List<QueryCriteriaDTO> query,
                                                  List<QueryCriteriaDTO> order,
                                                  Class<T> clazz,
                                                  QueryWrapper<T> queryWrapper) {

        genQueryWrapper(query, order, clazz, queryWrapper);
        return queryWrapper;
    }


    /**
     * 构造动态查询参数
     *
     * @param query        用于查询的QueryCriteriaDTO集合
     * @param order        用于排序的QueryCriteriaDTO集合
     * @param clazz        待查实体类
     * @param queryWrapper 动态查询参数构造器
     * @param <T>          待查实体
     * @throws IllegalAccessException 参数异常
     */
    private static <T> void genQueryWrapper(List<QueryCriteriaDTO> query,
                                            List<QueryCriteriaDTO> order,
                                            Class<T> clazz,
                                            QueryWrapper<T> queryWrapper) {
        if (queryWrapper == null) {
            throw new ParamValidException("查询条件构造对象不能为空");
        }
        if (clazz == null) {
            throw new ParamValidException("待查询对象类型不能为空");
        }
        Map<String, String> stringStringMap = TableFieldMapping.classMappings.get(clazz);
        if (query != null) {
            for (QueryCriteriaDTO l : query) {
                String dbField = stringStringMap.get(l.getAttributeCode());
                String actualValue = l.getActualValue();

                if (!StringUtils.isEmpty(dbField)) {
                    extracted(l, queryWrapper, actualValue, dbField);
                }
            }
        }
        if (order != null) {
            order.sort(Comparator.comparing(QueryCriteriaDTO::getSort));
            for (QueryCriteriaDTO criteriaDTO : order) {
                String dbField = stringStringMap.get(criteriaDTO.getAttributeCode());
                if (dbField != null) {

                    Integer orderType = criteriaDTO.getOrderType();
                    if (orderType == null) {
                        orderType = 1;
                    }
                    queryWrapper.orderBy(true, orderType == 1,
                            dbField);
                }
            }
        }

    }

    /**
     * 构造动态查询参数
     *
     * @param query 用于查询的QueryCriteriaDTO集合
     * @param order 用于排序的QueryCriteriaDTO集合
     * @param clazz 待查实体类
     * @param <T>   待查实体
     * @return 动态查询参数
     */
    private static <T> QueryWrapper<T> buildQuery(List<QueryCriteriaDTO> query, List<QueryCriteriaDTO> order, Class<T> clazz) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        try {
            genQueryWrapper(query, order, clazz, queryWrapper);
        } catch (IllegalArgumentException e) {
            logger.error("构造动态查询参数异常, ", e);
        }
        return queryWrapper;
    }


    /**
     * 动态条件组装
     *
     * @param queryCriteriaDTO 查询条件
     * @param queryWrapper     动态查询参数构造器
     * @param actualValue      实际数据值
     * @param dbField          数据库字段值
     */
    private static void extracted(QueryCriteriaDTO queryCriteriaDTO,
                                  QueryWrapper<?> queryWrapper,
                                  String actualValue,
                                  String dbField) {

        if (StringUtils.isNotBlank(actualValue)) {
            Integer conditionType = queryCriteriaDTO.getConditionType();
            if (conditionType == null) {
                throw new ParamValidException("条件构造数据缺失");
            }
            ConditionTypeEnum conditionTypeEnum = ConditionTypeEnum.convert(conditionType);
            switch (Objects.requireNonNull(conditionTypeEnum)) {
                case IS_NULL:
                    queryWrapper.isNull(dbField);
                    break;
                case NEQ:
                    queryWrapper.ne(dbField, actualValue);
                    break;
                case EQ:
                    if ("true".equals(actualValue) || "false".equals(actualValue)) {
                        queryWrapper.eq(dbField, Boolean.parseBoolean(actualValue));
                    } else {
                        queryWrapper.eq(dbField, actualValue);
                    }
                    break;
                case IN:
                    // TODO: 2022/3/4 切分字段
                    List<String> actualValueList = stringToList(actualValue);
                    //queryWrapper.in(dbField, CollectionUtils.isNotEmpty(actualValueList), actualValueList);
                    queryWrapper.in(!CollectionUtils.isEmpty(actualValueList), dbField, actualValueList);
                    break;
                case LIKE:
                    queryWrapper.like(dbField, actualValue);
                    break;
                case LIKE_LEFT:
                    queryWrapper.likeLeft(dbField, actualValue);
                    break;
                case LIKE_RIGHT:
                    queryWrapper.likeRight(dbField, actualValue);
                    break;
                case GT:
                    queryWrapper.gt(dbField, actualValue);
                    break;
                case GE:
                    queryWrapper.ge(dbField, actualValue);
                    break;
                case LT:
                    queryWrapper.lt(dbField, actualValue);
                    break;
                case LE:
                    queryWrapper.le(dbField, actualValue);
                    break;
                default:
                    break;
            }
        }
    }

    public static List<String> stringToList(String data) {
        if (StringUtils.isNotEmpty(data)) {
            String[] str = StringUtils.split(data, ",");
            return Arrays.asList(str);
        } else {
            return Collections.emptyList();
        }
    }


    public static void validatedQueryCondition(List<QueryCriteriaDTO> queryCriteriaList, List<String> attributeCodes) {
        if (ArrayUtil.isNotEmpty(attributeCodes)) {
            for (String attributeCode : attributeCodes) {
                boolean result = queryCriteriaList.stream().anyMatch(x -> attributeCode.equals(x.getAttributeCode()));
                ArgumentAssert.isTrue(result, "查询条件字段[{}]不能为空", attributeCode);
            }
        }
    }

    public static void validatedQueryCondition(List<QueryCriteriaDTO> queryCriteriaList, String attributeCode, String errorMsg) {
        boolean result = queryCriteriaList.stream().anyMatch(x -> attributeCode.equals(x.getAttributeCode()));
        ArgumentAssert.isTrue(result, errorMsg, attributeCode);
    }

}
