package com.example.saasutil.service;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.jianshe.ApplyDataRequest;
import com.example.saasutil.util.jianshe.BaseCommonData;
import com.example.saasutil.util.jianshe.PushDataRequest;
import com.example.saasutil.util.jianshe.SecurityUtils;

/**
 * @program: boot-base
 * @description: 峨眉山建设
 * @author: hushenggui
 * @create: 2021-11-15 10:00
 **/
public class EmeishanJiansheService {
  public final static String aesKey = "e79d8540e9234fddb168f06005ba85ed";

  public static void main(String[] args) {
    //加密
    String str1 = "{\"channel\":\"GBW-8e0e\",\"encrypt\":\"A2CD8A2E562B27EC0F8EEFD566A54E3D3646D4F042C6A4BD73678F348082D5628F2AE1D6920B77B733BEF8108E932217164FEFC97D228268556FBDF01A065494F589005818D36BD9BF7E281FBF989FDB1628CB36B03982FBD6FEBB564B8DFB661456A4671E545BEBE145AD58FBCA842BFDAC98A8AB8462069DFB818860A77AA742FEB3E935931B948C528621ADED70364B36AF39D2D7D0114C7462FAAAD10700B3649A4DF36B5CA395DB287202416EB80070175A3E1A54E5E7BDB546B9A7AA8D7D6261879196CA1C61B53DEC5DB4DF156987EFF7418388A9A27B94C6C274E31CA9747C50D7F8752B0A09F865440E71749AE3B4198C04EEE8704F02290D98F8AF\",\"nonce\":\"2e8c5fc8-bc77-42a0-a39d-2af53de62370\",\"signature\":\"5c359c8a691cf079453877491349cb4ff2551218\",\"timeStamp\":\"1646276865749\"}";
    BaseCommonData requestCommon = JacksonUtils.jsonString2Obj(str1, BaseCommonData.class);
    ApplyDataRequest dataRequest = SecurityUtils.decryptApplyDataRequest(requestCommon, aesKey);
    //PushDataRequest dataRequest = SecurityUtils.decryptPushDataRequest(requestCommon, aesKey);
    System.out.println(GsonUtil.toJson(dataRequest));
  }

}
