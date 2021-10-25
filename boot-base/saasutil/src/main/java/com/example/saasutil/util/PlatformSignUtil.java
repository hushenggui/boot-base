package com.example.saasutil.util;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 平台加密方法
 */
@Slf4j
public class PlatformSignUtil {


    /**
     * RSA加密
     * @param originalMap
     * @param privateKey
     * @return
     */
    public static String signRSA(Map<String, String> originalMap, String privateKey) {
        if (CollectionUtil.isEmpty(originalMap)) {
            return null;
        }
        String originalData = mapCovertString(originalMap, "&", "=");
        log.debug("原始加密数据为：" + originalData);
        String signData = RSAUtil.encrypt(originalData, privateKey);
        log.debug("加密后数据为：" + signData);
        return signData;
    }

    public static boolean checkSign(Map<String, String> originalMap, String publicKey, String originalSignData) {
        String originalData = mapCovertString(originalMap, "&", "=");
        log.debug("原始加密数据为：" + originalData);
        return RSAUtil.check(originalData, originalSignData, publicKey);
    }

    /**
     * 公钥验签
     * @param originalMap
     * @param publicKey
     * @param originalSignData
     * @return
     */
    public static boolean checkSignByPublicSign(Map<String, String> originalMap, String publicKey, String originalSignData) {
        String originalData = mapCovertString(originalMap, "&", "=");
//        log.debug("原始加密数据为：" + originalData);
        return RSAUtil.check(originalData, originalSignData, publicKey);
    }

    /**
     * 按照Json数据中首字母大小写正序排列
     *
     * @param originalMap     Map实体类
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     *
     * @return
     */
    public static String mapCovertString(Map<String, String> originalMap, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<>(originalMap.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = originalMap.get(key);
            // 空串不参与签名
            if (!StringUtils.hasText(value)) {
                continue;
            }
            content.append((i == 0 ? "" : connectSymlinks) + key + assignment + value);
        }
        String signSrc = content.toString();
        if (signSrc.startsWith(connectSymlinks)) {
            signSrc = signSrc.replaceFirst(connectSymlinks, "");
        }
        return signSrc;
    }
}