package com.example.saasutil.util;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Created by wangjun on 2016/7/19.
 */
@Slf4j
public class StringFormatterUtils {

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    /**
     * c 要填充的字符
     * length 填充后字符串的总长度
     * content 要格式化的字符串
     * 格式化字符串，左对齐
     */
    public static String flushLeft(char c, long length, String content) {
        String str = "";
        String cs = "";
        if (content.length() > length) {
            str = content;
        } else {
            for (int i = 0; i < length - content.length(); i++) {
                cs = cs + c;
            }
        }
        str = content + cs;
        return str;
    }


    /**
     * 格式化银行卡号
     *
     * @param input
     * @return
     */
    public static String formBankCard(String input) {
        String result = input.replaceAll("([\\d]{4})(?=\\d)", "$1 ");
        return result;
    }

    /**
     * 在所需值前
     *
     * @param value
     * @param len
     * @param fillValue
     * @return
     */
    public static String beforFillValue(String value, int len, String fillValue) {
        String str = (value == null) ? "" : value.trim();
        StringBuffer result = new StringBuffer();
        int paramLen = str.length();
        if (paramLen < len) {
            for (int i = 0; i < len - paramLen; i++) {
                result.append(fillValue);
            }
        }
        result.append(str);
        return result.toString();
    }

    public static String encode(String req, String accessKey, String secretKey) {
        try {
            JsonObject jsonObject = JsonParser.parseString(req).getAsJsonObject();
            jsonObject.remove("sign");
            jsonObject.addProperty("access_key", accessKey);
            String signStr = StringFormatterUtils.jsonCovertStringGuangLianDa(jsonObject, null, "&", "=");
            String param = signStr + "&" + secretKey;
            log.info("accessKey {} secretKey {} param>> {}", accessKey, secretKey, param);
            System.out.println(param);
            String sign = Md5Utils.MD5(param);
            return sign;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 按照Json数据排列
     *
     * @param jsonObject      Json实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String jsonCovertStringGuangLianDa(JsonObject jsonObject, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value;
            if(jsonObject.get(key).isJsonNull()) {
                value = "";
            } else {
                value = jsonObject.get(key).getAsString();
            }
            content.append((i == 0 ? "" : connectSymlinks) + key + assignment + value);
        }
        String signSrc = content.toString();
        if (signSrc.startsWith(connectSymlinks)) {
            signSrc = signSrc.replaceFirst(connectSymlinks, "");
        }
        return signSrc;
    }
    /**
     * 按照Json数据中首字母大小写正序排列
     *
     * @param map             Map实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String mapCovertString(Map map, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            if(ObjectUtils.isEmpty(map.get(key))) {
                continue;
            }
            String value = map.get(key).toString();
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

    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 按照Json数据排列
     *
     * @param jsonObject      Json实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String jsonCovertString(JsonObject jsonObject, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = jsonObject.get(key).getAsString();
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

    /**
     * 按照Json数据排列
     *
     * @param map             Map实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String mapCovertString2(Map map, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        Map treeMap = new TreeMap<String, String>(map);
        List<String> keys = new ArrayList<>(treeMap.keySet());
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = map.get(key).toString();
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

    /**
     * 按照Json数据排列
     *
     * @param jsonObject      Json实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String jsonCovertString2(JSONObject jsonObject, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = jsonObject.getString(key);
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

    /**
     * 按照Json数据排列
     *
     * @param map             Map实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String zhuLongMapCovertString(Map map, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        Map treeMap = new TreeMap();

        if (map instanceof LinkedMultiValueMap){
            for (Object key : map.keySet()) {
                treeMap.put(key, String.valueOf(map.get(key)).substring(1, String.valueOf(map.get(key)).length() - 1));
            }
        }else {
             treeMap = new TreeMap(map);
        }

        List<String> keys = new ArrayList<>(treeMap.keySet());
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = treeMap.get(key).toString();
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


    /**
     * 按照Json数据排列
     *
     * @param jsonObject      Json实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String jsonCovertStringShaoguan(JsonObject jsonObject, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = jsonObject.get(key).getAsString();
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

    public static byte[] convertString2ByteArray(String content, String charset) {
        if (org.springframework.util.StringUtils.hasText(content)) {
            try {
                return content.getBytes(charset);
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
            }
        } else {
            return content.getBytes();
        }
    }


    /**
     * 按照Json数据排列
     *
     * @param jsonObject      Json实体类
     * @param removeKeyList   不需要拼接的key值
     * @param connectSymlinks 连接符号，连接两个key/value字段之间的符号，例如‘&’、‘,’号
     * @param assignment      赋值符号,例如‘=’号
     * @return
     */
    public static String jsonCovertString(JSONObject jsonObject, List<String> removeKeyList, String connectSymlinks, String assignment) {
        StringBuffer content = new StringBuffer();
        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        boolean flag = false;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            flag = false;
            if (removeKeyList != null && removeKeyList.size() > 0) {
                for (String removeKey : removeKeyList) {
                    if (removeKey.equals(key)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            String value = jsonObject.getString(key);
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