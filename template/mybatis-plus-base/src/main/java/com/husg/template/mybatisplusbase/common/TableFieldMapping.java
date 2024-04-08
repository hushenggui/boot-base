package com.husg.template.mybatisplusbase.common;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * description: 数据库table与实体对象映射
 *
 * @author zhouxinlei
 * @since 2022-03-04 15:29:43
 */
public class TableFieldMapping {

    public static Map<Class, Map<String, String>> classMappings;

    static {
        classMappings = Maps.newHashMap();
        Set<Class<?>> classSet = Sets.newHashSet();
        Set<Class<?>> tableSet =
                ClassUtil.scanPackageByAnnotation("org.ares.margin.entity",
                        TableName.class);
        classSet.addAll(tableSet);
        Set<Class<?>> insuranceClassSet =
                ClassUtil.scanPackageByAnnotation("org.ares.margin.entity",
                        TableName.class);
        classSet.addAll(insuranceClassSet);
        classSet.forEach(classz -> {
            Map<String, Field> fieldMap = ReflectUtil.getFieldMap(classz);
            Map<String, String> fieldMappings = Maps.newHashMap();
            fieldMap.forEach((key, value) -> {
                Field field = fieldMap.get(key);
                String fieldName = ReflectUtil.getFieldName(field);
                String val = null;
                TableField tf = field.getAnnotation(TableField.class);
                if (tf != null && StrUtil.isNotEmpty(tf.value())) {
                    val = tf.value();
                }
                TableId ti = field.getAnnotation(TableId.class);
                if (ti != null && StrUtil.isNotEmpty(ti.value())) {
                    val = ti.value();
                }
                fieldMappings.put(fieldName, val);
            });
            classMappings.put(classz, fieldMappings);
        });
    }
}
