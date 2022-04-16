package com.example.saasutil.util;

import java.nio.charset.Charset;
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
            md.update(data.getBytes(charset));
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
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * MD5加密方法
     *
     * @param content 加密内容
     * @param type    大小写
     * @return
     */
    public static String encrypt(String content, String type) {
        char encryptChar[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] contentBytes = content.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(contentBytes);
            byte[] mdBytes = md.digest();
            int mdBytesLength = mdBytes.length;
            char mdlengthChar[] = new char[mdBytesLength * 2];
            int k = 0;
            for (int i = 0; i < mdBytesLength; i++) {
                byte byte0 = mdBytes[i];
                mdlengthChar[k++] = encryptChar[byte0 >>> 4 & 0xf];
                mdlengthChar[k++] = encryptChar[byte0 & 0xf];
            }

            if ("UCase".equals(type)) {
                return new String(mdlengthChar).toUpperCase();
            } else if ("LCase".equals(type)) {
                return new String(mdlengthChar);
            } else {
                return new String(mdlengthChar);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}