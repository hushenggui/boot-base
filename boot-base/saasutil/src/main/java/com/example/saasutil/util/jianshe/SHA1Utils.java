package com.example.saasutil.util.jianshe;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * SHA1Util class
 *
 * 计算公众平台的消息签名接叿.
 */
public class SHA1Utils {

    /**
     * 用SHA1算法生成安全签名
     * @param timestamp 时间房
     * @param nonce 随机字符丿
     * @param encrypt 密文
     * @return 安全签名
     */
    public static String getSHA1(String key, String timestamp, String nonce, String encrypt) throws Exception
    {
        try {
            String[] array = new String[] { key, timestamp, nonce, encrypt };
            StringBuffer sb = new StringBuffer();
            // 字符串排庿
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            throw new Exception("生成签名失败");
        }
    }
}
