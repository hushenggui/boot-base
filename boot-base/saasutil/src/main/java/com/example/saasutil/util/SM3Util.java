package com.example.saasutil.util;

import java.io.UnsupportedEncodingException;
import org.bouncycastle.crypto.digests.SM3Digest;

public class SM3Util  {


    public static String sign(String sortparam,String appsecret) throws UnsupportedEncodingException {
        //sign签名
        sortparam+="&appsecret="+appsecret;
        byte[] signHash=SM3Util.hash(sortparam.getBytes("UTF-8"));
        StringBuilder signature = new StringBuilder();
        for (byte b : signHash) {
            signature.append(byteToHexString(b));
        }
        String sign=signature.toString();
        System.out.println("签名String值为：" + sign);
        return sign;
    }

    public static byte[] hash(byte[] srcData) {
        SM3Digest digest = new SM3Digest();
        digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        return hash;
    }

    public static String byteToHexString(byte ib) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0f];
        ob[1] = Digit[ib & 0X0F];
        String str = new String(ob);
        return str;
    }
}
