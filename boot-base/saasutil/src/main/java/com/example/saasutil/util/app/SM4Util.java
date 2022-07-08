//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.saasutil.util.app;

import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.KeyGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SM4Util {

    public static final String ALGORITHM_NAME = "SM4";

    public SM4Util() {
    }

    static{
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static final String generateKey() {
        String val = "";
        SecureRandom random = new SecureRandom();

        for(int i = 0; i < 16; ++i) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val = val + (char)(random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val = val + String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }

    public static final String encryptBySM4(String plainText, String key) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        String cipherText = sm4.encryptData_ECB(plainText);
        return cipherText;
    }

    public static final String decryptBySM4(String cipherText, String key) {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = key;
        sm4.hexString = true;
        String plainText = sm4.decryptData_ECB(cipherText);
        return plainText;
    }

//    /**
//     * 自动生成密钥
//     * @explain
//     * @return
//     */
//    public static byte[] generateKey() throws Exception {
//        return generateKey(128);
//    }


    //加密******************************************
    /**
     * @explain 系统产生秘钥
     * @param keySize
     * @return
     * @throws Exception
     */
    public static byte[] generateKey(int keySize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
        kg.init(keySize, new SecureRandom());
        return kg.generateKey().getEncoded();
    }

}
