package com.example.saasutil.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 吕林杰
 * @date 2019/12/27 12:31
 **/
@Slf4j
public class JacksonUtils {

    private static String XML_TAG = "<?xml version='1.0' encoding='UTF-8'?> \n";

    private static final ObjectMapper XML_MAPPER = new XmlMapper();
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static String obj2XmlString(Object obj) {
        return XML_TAG + writeValueAsString(obj, XML_MAPPER);
    }

    public static <T> T xmlString2Obj(String xmlString, Class<T> clazz) {
        return readValue(xmlString, clazz, XML_MAPPER);
    }

    public static String obj2JsonString(Object obj) {
        return writeValueAsString(obj, JSON_MAPPER);
    }

    public static String obj2JsonIgnoreNull(Object obj) {
        JSON_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return XML_TAG + writeValueAsString(obj, JSON_MAPPER);
    }

    public static <T> T jsonString2Obj(String jsonString, Class<T> clazz) {
        JSON_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return readValue(jsonString, clazz, JSON_MAPPER);
    }

    public static <T> T readValue(String string, Class<T> clazz, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(string, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String writeValueAsString(Object obj, ObjectMapper objectMapper) {
        String string = null;
        try {
            string = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return string;
    }
}
