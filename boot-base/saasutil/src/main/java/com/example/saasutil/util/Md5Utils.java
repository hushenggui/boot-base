package com.example.saasutil.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by AnthonyPark on 2018/7/24.
 */
@Slf4j
public class Md5Utils {

    private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * 获取MD5校验码，默认为UTF-8
     */
    public static String MD5(String s){
        return MD5(s,"utf-8");
    }
    /**
     * 获得UTF-8，可传入特定编码方式
     */
    public static String MD5(String s,String charset) {

        try {
            byte[] btInput = s.getBytes(charset);
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将LinkedHashMap里的参数拼接后进行MD5
     * @param map
     * @param key 交易中心MD5拼接的密钥
     * @return
     */
    public static String MD5(String key, LinkedHashMap map) {
        if (!ObjectUtils.isEmpty(map)) {
            StringBuffer sb = new StringBuffer(key);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append(entry.getValue());
            }
            log.info("MD5加密前的字符串:{}",sb.toString());
            return MD5(sb.toString());
        }
        return null;
    }
}
