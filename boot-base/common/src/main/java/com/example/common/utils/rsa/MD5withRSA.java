package com.example.common.utils.rsa;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author YuFeng 2022/6/15
 */
public class MD5withRSA {

    //算法名称
    public static final String ALGO = "RSA";
    //签名算法名称
    private static final String MD5WITHRSA = "MD5withRSA";


    /**
     * MD5withRSA 私钥签名
     *
     * @param data 数据明文
     * @param privateKey 私钥
     * @return 数据签名
     * @throws Exception 加密过程中的异常信息
     * */
    public static String signature(String data, String privateKey) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance(ALGO);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5WITHRSA);
        signature.initSign(key);
        signature.update(data.getBytes());
        return BinaryUtil.toBase64String(signature.sign());
    }

    /**
     * MD5withRSA 私钥签名
     *
     * @param data 数据明文[字节]
     * @param privateKey 私钥
     * @return 数据签名
     * @throws Exception 加密过程中的异常信息
     * */
    public static String signature(byte[] data, String privateKey) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance(ALGO);
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5WITHRSA);
        signature.initSign(key);
        signature.update(data);
        return BinaryUtil.toBase64String(signature.sign());
    }


    /**
     * MD5withRSA - 公钥签名验证
     *
     * @param data 数据明文
     * @param publicKey 公钥
     * @return 是否验证通过
     * @throws Exception 加密过程中的异常信息
     * */
    public static boolean verify(String data, String dataSignature, String publicKey) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance(ALGO);
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5WITHRSA);
        signature.initVerify(key);
        signature.update(data.getBytes());
        return signature.verify(BinaryUtil.fromBase64String(dataSignature));
    }

    public static void main(String[] args) throws Exception {
        String data="{\"account\":\"companyreview\",\"accountType\":\"ACCOUNT\",\"deviceType\":\"WEB\",\"password\":\"Gb123456\"}";
        final String signature = signature(data, "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMEU4oaLlp48zeV4WQXz8sVvvlXZ/4R8YpLvcNMe6PEzOyJcnNCUscZnVCpJVY1xAf4Pv7riyFuaj30AFqaJfdG6DyV/DV+52QWx+haA+1tPuhBgKH8Ca8izDWxSyWnSU2GP6Q/r0zkR9FaKRfWmBmbRQJHncV8qmfX8K/0b3p7FAgMBAAECgYADjxb90+Ta1dQVvrolWfHHod+oRXRoRMKsYq15tsAkcgVNBNf/ID6GobDzdpaVHNgkjrXCBBwdVCQA8dd5Cl+/Tahq6Mi48jk5B4s8MO6NL6RE1GT4l0NIHFxcTk+WTaXpWI5CHuHHz8VqEihbM1xh8nbEzyL8JoVSsXSzZyZwoQJBAPd1BXA5+sj5z0V3MtgVNuxjZtRQK0QV150IWCyPQwKOoC4Fv3cmBeePw/JHDwcPoY1LN8BldVH/JZznD83MH9sCQQDHv02T/WlnFnhhb3Lh9cycrC2k5NVjqSW308WYr9lpJ0y6IXnAJCb4HqwdakTGC694XOxl0ZMQPU/IgqAyjk3fAkBdtmhn1t09jTVMllaf9HDHVuGTWAT6lNcBti5GOb7j0gWhSDX5NmIYDp7jOrvbLbU9oBWt+/5RHjItWGfoxPvvAkEAhi3D9z2rqEw34Xv0OEXdhQFESBhQH/poE+x2N/MooLJ9oCsMlj2yz8oK5FeWi1MeNER3qI33tFj7Vz4oTs25EQJBAMNJJriWd5ycF9T0qdHFVIdecGd7p9IN75iYrvXdEnJ3MxDuncOPIfk+ByF2ko3rCQqpIj5WbHFviOEUoGftnHw=");
        System.out.println(signature);
        final boolean verify = verify(data,
                signature,
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBFOKGi5aePM3leFkF8/LFb75V2f+EfGKS73DTHujxMzsiXJzQlLHGZ1QqSVWNcQH+D7+64shbmo99ABamiX3Rug8lfw1fudkFsfoWgPtbT7oQYCh/AmvIsw1sUslp0lNhj+kP69M5EfRWikX1pgZm0UCR53FfKpn1/Cv9G96exQIDAQAB");
        System.out.println(verify);
    }
}
