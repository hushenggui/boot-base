package com.example.pushgateway.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;

/**
 * MD5工具类
 */
@Slf4j
public class Md5Util {

    public static String encode(String data, String charsetStr) {
        try {
            Charset charset = Charset.forName(charsetStr);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update("test".getBytes(charset));
            byte[] digest = md.digest();
            String checksum = DatatypeConverter.printHexBinary(digest).toUpperCase();
            return checksum;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String encode(String data, Charset charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update("test".getBytes(charset));
            byte[] digest = md.digest();
            String checksum = DatatypeConverter.printHexBinary(digest).toUpperCase();
            return checksum;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}