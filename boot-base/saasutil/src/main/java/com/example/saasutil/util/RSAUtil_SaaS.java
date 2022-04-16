package com.example.saasutil.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class RSAUtil_SaaS {
    /**
     * 加密
     * @param orgData
     * @param privateKey
     * @return
     */
    public static String encrypt(String orgData, String privateKey) {
        RSA rsa = SecureUtil.rsa(privateKey, null);
        return new String(Base64Util.encode(rsa.encrypt(orgData, KeyType.PrivateKey)));
    }

    /**
     * 解密
     * @param signData
     * @param publicKey
     * @return
     */
    public static String decrypt(String signData, String publicKey) {
        RSA rsa = SecureUtil.rsa(null, publicKey);
        return new String(rsa.decrypt(signData, KeyType.PublicKey));
    }

    /**
     * 验签
     * @param orgData
     * @param signData
     * @param publicKey
     * @return
     */
    public static boolean check(String orgData, String signData, String publicKey) {
        RSA rsa = SecureUtil.rsa(null, publicKey);
        log.debug("参数内容为：" + orgData);
        String data = new String(rsa.decrypt(signData, KeyType.PublicKey));
        log.debug("解密内容为：" + data);
        if (StringUtils.hasText(data) && orgData.equals(data)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 支付平台验签
     * @param o 参数
     * @param signKey   密钥
     * @return
     */
    public static boolean checkSign(Object o, String signKey) {
        try {
            Gson gson = new Gson();
            if (!StringUtils.isEmpty(signKey)) {
                JsonObject jsonObject = JsonParser
                    .parseReader(new JsonReader(new StringReader(gson.toJson(o)))).getAsJsonObject();
                //解密sign
                String sign = RSAUtil
                    .decrypt(jsonObject.get("sign").toString(), signKey);
                log.error("==========[公钥解密参数为：" + sign + "]==========");
                //移除排序参数
                List<String> removeKeyList = new ArrayList<>();
                removeKeyList.add("sign");
                //参数拼接
                String signStr = StringFormatterUtils.jsonCovertString(jsonObject, removeKeyList, "&", "=");
                log.error("==========[拼接后参数为：" + signStr + "]==========");
                if (signStr.equals(sign)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
//        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZkpPtGSRku0c4r0pWvVITFIYOgOlbrKVhuIIYW1CVWTv7VlbztZb14r0Wx1C++d7HZgnHNorGjKE7mTtTUqpjtV5KNaJF/nu8dg5iShyKeK7KmIitsBT5UIJb5x9/uj/8q88dUlJewubPE1HJNf6/0R2yuAdOKOkslGn37k/M+wIDAQAB";
        String a = "zF9M97iOdYGPum1Nj9qp5sXthMvYcCBDeInAdNJhFaGV3yPU94vNl4GlJGBoduM/xdT9h2JyqIFg5kOZaheuzYvdM/USvPcGbv9KY42uFyVqu0mPSPiP+H2VqxFUcSTAvkXAty5td/h48TZodc2qy/Pn19vDBrsKOPEuyAN6WIQ=";
//        System.out.println(RSAUtil.decrypt(a, publicKey));
        System.out.println("basicBankAccount>>>" + encrypt("00014", privateKey));
//        System.out.println("basicBankName>>>" + encrypt("招商银行", privateKey));
//        System.out.println("basicAccountName>>>" + encrypt("张丽君", privateKey));
    }
}