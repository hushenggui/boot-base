package com.husg.template.mybatisplusbase.dto;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * description: 查询条件属性
 *
 * @author zhouxinlei
 * @since 2022-05-10 15:13:28
 */
public class QueryBaseDTO {

    private List<QueryCriteriaDTO> queryCriterias;

    public QueryBaseDTO(List<QueryCriteriaDTO> queryCriterias) {
        this.queryCriterias = queryCriterias;
    }

    public QueryBaseDTO() {
        this.queryCriterias = Lists.newArrayList();
    }

    public List<QueryCriteriaDTO> getQueryCriterias() {
        return queryCriterias;
    }

    public void setQueryCriterias(List<QueryCriteriaDTO> queryCriterias) {
        this.queryCriterias = queryCriterias;
    }

    @Override
    public String toString() {
        return "QueryBaseDTO{" +
                "queryCriterias=" + queryCriterias +
                '}';
    }
}
