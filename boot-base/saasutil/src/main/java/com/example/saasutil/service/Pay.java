package com.example.saasutil.service;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.util.TransferTradeReq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-04-01 10:49
 **/
public class Pay {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"bankBranchName\": \"\",\n" +
                "    \"channelAccountCode\": \"10000000005KFDXUR2U\",\n" +
                "    \"feeAmount\": \"0.00\",\n" +
                "    \"goodsInfo\": \"人工退款（JFK9L6）\",\n" +
                "    \"notifyUrl\": \"notifyUrl\",\n" +
                "    \"onlineFlag\": \"1\",\n" +
                "    \"openBranch\": \"102377100061\",\n" +
                "    \"oppAccount\": \"1317000619200051256\",\n" +
                "    \"oppAccountName\": \"天安财产保险股份有限公司宣城中心支公司\",\n" +
                "    \"oppBankName\": \"工商银行\",\n" +
                "    \"oppBankNo\": \"102\",\n" +
                "    \"oppCityCode\": \"\",\n" +
                "    \"orderNo\": \"JL2021062516000001\",\n" +
                "    \"remarks\": \"人工退款（JFK9L6）\",\n" +
                "    \"returnUrl\": \"returnUrl\",\n" +
                "    \"tradeAmount\": 900.00,\n" +
                "    \"tradeInfo\": \"人工\",\n" +
                "    \"transCode\": \"T000003\"\n" +
                "  }";
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL0O1BeRRLZ4OhXM9Qk3q2AcELE/8Rfxun8iy2DjCP0zp5TZL2IgIi++YwLwi1gtvz6CXse10EG/c8Rmx/ki6i0HBLShwF7He47gIeDHbDF3SZKdlRFxzeQf6Zwt1aoOuM4SxIJ/G0aH3UwGl1IaTth4+0YTb8AKAW2axt8Phpj7AgMBAAECgYAEE37FJ0+o83ylHa8mzLl4MAK4H53OG1sfBJwH8b0u4F87mVcpMXIrP1qZJKCMfSgDbAIpIiVkVYFkeabUG0mbN1/DxGbTmDGXo7q5auXXrzsYhesVGjh2b3Xx918HTR5pwdLr86zSKEyCjomhLDejk8MRR6wncIOlr0xmIUCoWQJBAPbpVmTW7/Upvky754uXLSTwEin0wtzLLnn6tjF3WMAlOqdiV8vKAFe70Hb1KfusysJGOljwUrwK9Tj0hyg1CT8CQQDEBFVUicX2hUxw6MFRtQZNIqZ+7jVYCJHKGWWoH4Jg7UelPIXniXf9R+r5lkBswOP4ibzIjP6qtWR2dd3a2yVFAkBb1j5EE4386iHV+K4OxZQNAR5AbMFtzkTjKdVKYNGp5i8CwxlUuzWVbE4FcPrEmWhxCh35pqmfN5QuMwVydweRAkBZpz28D9PKoEdJMTwSegCq0Rlj3uHpJOpBjIIxdk/0szJcwiTgtMB7ySQRCgbndwYODDmbZNmqDJMpl1lkm20dAkBGJuplsnwlX1SzKVBdcv2SNU/klymD46l3u7is52b15slwcu0aYQbLYG1bLb5dgTYjKtdsoHGy14PkxhTOtCbt";
        Gson gson = new GsonBuilder().create();
        TransferTradeReq ts = gson.fromJson(json, TransferTradeReq.class);
        String sort = GsonUtil.toJsonSort(ts);
        System.out.println(sort);
        System.out.println(RSAUtil.encrypt(sort, privateKey));

    }
}
