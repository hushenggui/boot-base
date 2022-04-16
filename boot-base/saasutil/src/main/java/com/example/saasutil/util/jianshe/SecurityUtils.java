package com.example.saasutil.util.jianshe;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.UUIDGenUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;


@Slf4j
public class SecurityUtils {


    public static String getSignString(String parameter, String httpMethod, String timeStamp) {
        String strToSign = null;
        try {
            if (null != parameter) {
                parameter = URLDecoder.decode(parameter, "UTF-8");
            }

            strToSign = buildCanonicalString(parameter, httpMethod, timeStamp);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
            return strToSign;
        }

        return strToSign;
    }

    private static String buildCanonicalString(String parameters, String httpMethod, String timeStamp) {
        StringBuilder builder = new StringBuilder();
        builder.append(httpMethod).append("&");

        try {
            builder.append(URLEncoder.encode("/", "utf-8")).append("&");
            if (null != timeStamp) {
                builder.append(URLEncoder.encode(timeStamp, "utf-8")).append("&");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        if (null != parameters) {
            String queryString = parameters;

            // 去除#后面部分
            int fragIdx = parameters.indexOf('#');
            if (fragIdx >= 0) {
                queryString = parameters.substring(0, fragIdx);
            }

            builder.append(buildqueryString(queryString));
        }

        return builder.toString();
    }


    protected static String buildqueryString(String queryString) {
        StringBuilder builder = new StringBuilder("");

        Map<String, String> params = new TreeMap<String, String>();

        if (null != queryString) {
            String[] splits = queryString.split("&");
            for (int i = 0; i< splits.length; i++) {
                String query = splits[i];
                String[] tmpSplit = query.split("=");
                if (tmpSplit.length >= 2) {
                    String name = tmpSplit[0];
                    String value = tmpSplit[1];
                    params.put(name,value);
                }
            }
        }

        if (params.size() > 0) {
            String[] names = params.keySet().toArray(new String[params.size()]);
            Arrays.sort(names);
            char separator='&';
            for (int i=0; i<names.length; i++) {
                String name = names[i];
                if (0 != i) {
                    builder.append(separator);
                }
                builder.append(name);
                String paramValue = params.get(name);
                if (paramValue != null && paramValue.length() > 0) {
                    builder.append("=").append(paramValue);
                }
            }
        }

        String cononiStr = "";
        try {
            cononiStr = URLEncoder.encode(builder.toString(), "utf-8");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return cononiStr;
    }

    protected static byte[] hmacsha256Signature(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            return mac.doFinal(data);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String md5Signature(String message) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(message.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        }
        return null;

    }

    public static String signWithHmac(String strToSign, String accessKey) {

        byte[] crypto = hmacsha256Signature(strToSign.getBytes(), accessKey.getBytes());

        String signature = Base64.encodeBase64String(crypto).trim();

        return signature;
    }


    /**AES加密
     * @param content ?要加密的内容
     * @return
     */
    public static String encryptWithAes(String content, String password) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码?
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始?
            byte[] result = cipher.doFinal(byteContent);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                String hex = Integer.toHexString(result[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**AES解密
     * @param hexStr  待解密内?
     * @return
     */
    public static String decryptWithAes(String hexStr, String password) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] content = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            content[i] = (byte) (high * 16 + low);
        }

        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码?
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始?
            byte[] result = cipher.doFinal(content);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static ApplyDataRequest decryptApplyDataRequest(BaseCommonData requestCommon, String aesKey) {
        String requestData = SecurityUtils.decryptWithAes(requestCommon.getEncrypt(), aesKey);
        log.info("===============解密后的报文:{}", requestData);
        ApplyDataRequest applyDataRequest = JacksonUtils.jsonString2Obj(requestData, ApplyDataRequest.class);
        return applyDataRequest;
    }

    public static PushDataRequest decryptPushDataRequest(BaseCommonData requestCommon, String aesKey) {
        String requestData = SecurityUtils.decryptWithAes(requestCommon.getEncrypt(), aesKey);
        PushDataRequest pushDataRequest = JacksonUtils.jsonString2Obj(requestData, PushDataRequest.class);
        return pushDataRequest;
    }

    public static Map<String, String> decryptHashMap(BaseCommonData requestCommon, String aesKey) {
        String requestData = SecurityUtils.decryptWithAes(requestCommon.getEncrypt(), aesKey);
        Map<String, String> requestMap = JacksonUtils.jsonString2Obj(requestData, HashMap.class);
        return requestMap;
    }



    /**
     * 请求生成
     * @param key
     * @param channel
     * @param appid
     * @param param
     * @return
     * @throws Exception
     */
    public static BaseCommonData generateVerify(String key,String channel ,String appid, Map<String,String> param) throws Exception{
        BaseCommonData commonData = new BaseCommonData();
        //拼接必要字段
        long t1=System.currentTimeMillis();
        String nonce = UUIDGenUtil.createUUID();
        String timeStamp = String.valueOf(t1);
        String jsonStr = JSONObject.toJSONString(param, SerializerFeature.WriteMapNullValue);
        String encrypt = encryptWithAes(jsonStr,key);
        commonData.setChannel(channel);
        commonData.setTimeStamp(timeStamp);
        commonData.setNonce(nonce);
        commonData.setEncrypt(encrypt);
        commonData.setSignature(SHA1Utils.getSHA1(appid,timeStamp,nonce,encrypt));
        return commonData;
    }

    public static void main(String[] args) throws Exception {
//        BaseCommonData yy = SecurityUtils.generateVerify("待定","00001","00002","63f24cb0-e13d-4500-879b-c0d98dec908a","{'key1':'jj'}","1","错误了");
//        System.err.println(yy.toString());
//        String tt = SecurityUtils.decryptWithAes("9F79FBA5955CCD4D314F771995D0F4BB507F08016B8262AF9605B5801D4FDB09867B931CB99B3D6B382F6EF14DE84616BC7B69A83750E9B4285F36C7B8148CF4B8A38242BF90BED2851E74CD2EBDDD5D","待定");
//        System.err.println(tt);
//        String data = "{\"uniqueTrade\":\"caf2d324-33e7-4c23-a966-04f92844e99e\",\"projectType\":\"01\",\"amount\":1.25,\"bidCurrency\":156,\"bidderNm\":\"上海会初建筑有限公司\",\"bidderUnique\":\"d5b84a8d3bb741bdb2aa11f321153d86\",\"bidderOrgNo\":\"MH0578LU2\",\"bidType\":\"02\"}";
    /*    String data = "{\"projUnique\":\"10d66141-e59c-495f-a942-f96b29c7a542\"}";
        JSONObject jsonObject = JSONObject.parseObject(data);
        String cc = SecurityUtils.encryptWithAes(jsonObject.toString(),"test123");
        System.out.println(cc);
        String tt = SecurityUtils.decryptWithAes("0749F899F08DDCCDC5A8D111139DAAC7673F335BCDF366AF400224423FC174C6DD3A232C4FF4D3F53EF928E86D1A52748478B97710A370951916F4315BB61A75","test123");
        System.err.println("---"+tt);
        BaseCommonData commonData = new BaseCommonData();
        Map<String,String> map = new HashMap<>();
        map.put("encrypt",data);
        commonData = SecurityUtils.generateVerify("sccin!123","APP_002","123sccin",map);
        Gson gson = new Gson();
         String s = gson.toJson(commonData);
        System.err.println(s);*/
    String str1 = "{\"channel\":\"GBW-8e0e\",\"encrypt\":\"210DFA4FA2EFA63A2567D5A1AF7E0EA9EE95BD8440E6631C1CFAA9301BBA066B18C584AD357A2C5CA00D64F7D12A5E25F5A5DAD36A644A626C690141D67E576F295693C9806519949507CF9AD09FBE5F4B8ACB042099501198DBD76E8CDE77CEBD831F7D16391E27F2E61F0F054C9F1A321E77EB7AF58E692688D50B18EAB6D8E47D480C9EF5B1CE3B33F8DF87872251897BC077363ED28F24F52E05F8344603E4678B0941B93994FBE86ECEB58E99CF9A3DA9481ECC86EC3DB31CE48C491AA66226C06F9D428E51A7F3EBF38DF399A271EB83888F1D3F166208F12D1C3AC873D2B6BAE49B052D5390362DC003AD52C1ABB96C52D33632C6783FC8F3A7839109FBF92D1304CBA5775796E16A1A4A8BF6172C0B9C15AD7341C101537ACD87777620D95D2ABC19BA3F54539576B45C46EB5641ED342C581B38F8352D20EEB3F124246F89256E8AF97EE4271099512881D0980932CB23DA9EEB860B97A34AE015454CC215385AF295A758FA1C7320E6C2195D17DD113AC12ACF50757F7134FF3FAFB1B87612317B6C2776C99E6A78CDE7316FD02849FFEE368F56874EEF1DECEAA9E47BA19E7707D3F0D173E89A060096F300CF2DE9CADBB9866E2F4C1BC978BBC4345A13AC6EFAFCF19FB6D4D4ED9DF6D2100825F1A5694BA61FDA275F421DB2786EDE70B47F23D3019BA0B6B3BC445C43C58E1BA58C9793E6BE5134C50A4FA126AE119F6073129065BE5DCC7C53DD899325657F090A810AA59FC847986F54D37735509EA95137CC5F2CEC45E378FF44B6F453C4F3A1CF8AF031E728A8C6C1E0B24F3C5A8BFCF130D22D3B6D24F08CD011FF7595A6990798FE4FDDD62FB9C1B5EFA2D963EE8985DD1E4F740BA928062BD40A7BB62FAA23E91B2B2B1F17D02CE847962F7BB5EAA6312A5BA9CD8078FA936018DCE6C4FF3756543267D8A7DACB6F3AB2F7D0D399107DC41349083F1A272179BB730EA4A5E3E199EE6F1AE8D351CA13D96C719F45D50A92C4A584C3ACF0B979F02C24B71611D87E38DA11D98D20DF1D5B67366131141D43A85AEF2F30AE98B0DF1DA79EF2492C0248BF764E9924DACC308AAFA00B5A7D2518DF6DF8ABF5A38414400B1F4FEBA43642918B0D5802A55C1F2ABEE602CBDEEABF979780D311DDC3\",\"nonce\":\"6eb73d3d-3866-457d-b127-931a15c5008a\",\"signature\":\"c442baf5d390680adda1abeb1df4497483f3c904\",\"timeStamp\":\"1636683384483\"}";
        BaseCommonData requestCommon = JacksonUtils.jsonString2Obj(str1, BaseCommonData.class);
        PushDataRequest pushDataRequest = SecurityUtils.decryptPushDataRequest(requestCommon, "e79d8540e9234fddb168f06005ba85ed");
        System.out.println(GsonUtil.toJson(pushDataRequest));
/*
   String str = "{\n"
       + "    \"projUnique\":\"7c83b7c0-ef9c-4a09-b93e-4e61d5b3e077\",\n"
       + "    \"regionCode\":\"511181\",\n"
       + "    \"projectType\":\"01\",\n"
       + "    \"closeTime\":\"20211112093000\",\n"
       + "    \"bidOpenTime\":\"20211112093000\",\n"
       + "    \"amount\":\"200000.00\",\n"
       + "    \"projNm\":\"峨眉南山乡村振兴示范基地建设项目龙门乡至高桥镇段幸福美丽乡村路等六条道路方案设计、初步设计（含概算）、勘察\",\n"
       + "    \"sectionNm\":\"峨眉南山乡村振兴示范基地建设项目龙门乡至高桥镇段幸福美丽乡村路等六条道路方案设计、初步设计（含概算）、勘察招标\",\n"
       + "    \"ownerNm\":\"峨眉山名城产业集团有限公司\",\n"
       + "    \"ownerOrgNO\":\"91511181MA68GP7PXD\",\n"
       + "    \"serialNOS\":\"10110105111812021110215313585165,10110105111812021102909241790088,10110105111812021110311151067675,10110105111812021102910285110774,10110105111812021110210493917758\",\n"
       + "    \"state\":\"0\"\n"
       + "}";

        BaseCommonData requestCommon = JacksonUtils.jsonString2Obj(str, BaseCommonData.class);
        String en = encryptWithAes(str, "e79d8540e9234fddb168f06005ba85ed");
        System.out.println(en);*/




    }
}


