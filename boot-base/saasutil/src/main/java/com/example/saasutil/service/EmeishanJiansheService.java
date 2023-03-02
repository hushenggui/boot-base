package com.example.saasutil.service;

import com.example.saasutil.util.DateUtil;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.jianshe.ApplyDataRequest;
import com.example.saasutil.util.jianshe.BaseCommonData;
import com.example.saasutil.util.jianshe.PushDataRequest;
import com.example.saasutil.util.jianshe.SecurityUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: boot-base
 * @description: 峨眉山建设
 * @author: hushenggui
 * @create: 2021-11-15 10:00
 **/
public class EmeishanJiansheService {
  public final static String aesKey = "e79d8540e9234fddb168f06005ba85ed";

  public static void main(String[] args) throws ParseException {
    //加密
   /* String str1 = "{\"channel\":\"GBW-8e0e\",\"encrypt\":\"A2CD8A2E562B27EC0F8EEFD566A54E3D3646D4F042C6A4BD73678F348082D5628F2AE1D6920B77B733BEF8108E932217164FEFC97D228268556FBDF01A065494F589005818D36BD9BF7E281FBF989FDB1628CB36B03982FBD6FEBB564B8DFB661456A4671E545BEBE145AD58FBCA842BFDAC98A8AB8462069DFB818860A77AA742FEB3E935931B948C528621ADED70364B36AF39D2D7D0114C7462FAAAD10700B3649A4DF36B5CA395DB287202416EB80070175A3E1A54E5E7BDB546B9A7AA8D7D6261879196CA1C61B53DEC5DB4DF156987EFF7418388A9A27B94C6C274E31CA9747C50D7F8752B0A09F865440E71749AE3B4198C04EEE8704F02290D98F8AF\",\"nonce\":\"2e8c5fc8-bc77-42a0-a39d-2af53de62370\",\"signature\":\"5c359c8a691cf079453877491349cb4ff2551218\",\"timeStamp\":\"1646276865749\"}";
    BaseCommonData requestCommon = JacksonUtils.jsonString2Obj(str1, BaseCommonData.class);
    ApplyDataRequest dataRequest = SecurityUtils.decryptApplyDataRequest(requestCommon, aesKey);
    //PushDataRequest dataRequest = SecurityUtils.decryptPushDataRequest(requestCommon, aesKey);
    System.out.println(GsonUtil.toJson(dataRequest));
    String str = "{\"hezhou\":\"huanan\",\"liuzhou\":\"huanan\",\"yulin.gray\":\"huanan\",\"yulin\":\"huanan\",\"yunnan.gray\":\"huanan\",\"shaoguan\":\"huanan\",\"shaoguan.gray\":\"huanan\",\"yunnan\":\"huanan\",\"guilin\":\"huanan\",\"guilin.gray\":\"huanan\",\"hezhou.gray\":\"huanan\",\"liuzhou.gray\":\"huanan\",\"bozhou\":\"huadong2\",\"bozhou.gray\":\"huadong2\",\"changzhou\":\"huadong2\",\"changzhou.gray\":\"huadong2\",\"hangzhou\":\"huadong2\",\"hangzhou.gray\":\"huadong2\",\"huainan\":\"huadong2\",\"huainan.gray\":\"huadong2\",\"jinan\":\"huadong2\",\"jinan.gray\":\"huadong2\",\"longwan\":\"huadong2\",\"longwan.gray\":\"huadong2\",\"maanshan\":\"huadong2\",\"maanshan.gray\":\"huadong2\",\"quzhou\":\"huadong2\",\"quzhou.gray\":\"huadong2\",\"suzhou\":\"huadong2\",\"suzhou.gray\":\"huadong2\",\"taizhou.router\":\"huadong2\",\"taizhou3.5\":\"huadong2\",\"taizhou3.5.gray\":\"huadong2\",\"wuhan\":\"huadong2\",\"wuhan.gray\":\"huadong2\",\"xiangtan\":\"huadong2\",\"xiangtan.gray\":\"huadong2\",\"xiangtan_bankgua\":\"huadong2\",\"xiangtan_bankgua.gray\":\"huadong2\",\"yangzhou\":\"huadong2\",\"yangzhou.gray\":\"huadong2\",\"yongjia\":\"huadong2\",\"yongjia.gray\":\"huadong2\",\"yueyang\":\"huadong2\",\"yueyang.gray\":\"huadong2\",\"zhangjiajie\":\"huadong2\",\"zhangjiajie.gray\":\"huadong2\",\"zhangjiajie_gld\":\"huadong2\",\"zhangjiajie_gld.gray\":\"huadong2\",\"baotou\":\"huabei\",\"baotou.gray\":\"huabei\",\"benxi\":\"huabei\",\"benxi.gray\":\"huabei\",\"changchun\":\"huabei\",\"changchun.gray\":\"huabei\",\"changzhi\":\"huabei\",\"changzhi.gray\":\"huabei\",\"chifeng\":\"huabei\",\"chifeng.gray\":\"huabei\",\"dingxi\":\"huabei\",\"dingxi.gray\":\"huabei\",\"eerduosi\":\"huabei\",\"eerduosi.gray\":\"huabei\",\"hlbeier_yatai\":\"huabei\",\"hlbeier_yatai.gray\":\"huabei\",\"hlbeier_zijin\":\"huabei\",\"hlbeier_zijin.gray\":\"huabei\",\"huhehaote\":\"huabei\",\"huhehaote.gray\":\"huabei\",\"jilin\":\"huabei\",\"jilin.gray\":\"huabei\",\"jiuquan\":\"huabei\",\"jiuquan.gray\":\"huabei\",\"lvliang\":\"huabei\",\"lvliang.gray\":\"huabei\",\"panjin\":\"huabei\",\"panjin.gray\":\"huabei\",\"panjin_inde\":\"huabei\",\"panjin_inde.gray\":\"huabei\",\"tianjin\":\"huabei\",\"tianjin.gray\":\"huabei\",\"wlcb\":\"huabei\",\"wlcb.gray\":\"huabei\",\"xilinguole\":\"huabei\",\"xilinguole.gray\":\"huabei\",\"xingtai\":\"huabei\",\"xingtai.gray\":\"huabei\",\"yingkou\":\"huabei\",\"yingkou.gray\":\"huabei\",\"anqing\":\"huadong1\",\"anqing.gray\":\"huadong1\",\"cangnan\":\"huadong1\",\"cangnan.gray\":\"huadong1\",\"changshu\":\"huadong1\",\"changshu.gray\":\"huadong1\",\"chizhou\":\"huadong1\",\"chizhou.gray\":\"huadong1\",\"fuyang\":\"huadong1\",\"fuyang.gray\":\"huadong1\",\"fuyang_second\":\"huadong1\",\"fuyang_second.gray\":\"huadong1\",\"hengyang\":\"huadong1\",\"hengyang.bank\":\"huadong1\",\"hengyang.bank.gray\":\"huadong1\",\"hengyang.danbao\":\"huadong1\",\"hengyang.danbao.gray\":\"huadong1\",\"hengyang.gray\":\"huadong1\",\"hengyang.guotai\":\"huadong1\",\"hengyang.guotai.gray\":\"huadong1\",\"heze\":\"huadong1\",\"heze.gray\":\"huadong1\",\"huaian\":\"huadong1\",\"huaian.gray\":\"huadong1\",\"huaihua\":\"huadong1\",\"huaihua.gray\":\"huadong1\",\"huangshan\":\"huadong1\",\"huangshan.gray\":\"huadong1\",\"hunansheng\":\"huadong1\",\"hunansheng.gray\":\"huadong1\",\"jining\":\"huadong1\",\"jining.gray\":\"huadong1\",\"jining_second\":\"huadong1\",\"jining_second.gray\":\"huadong1\",\"lianyungang\":\"huadong1\",\"lianyungang.gray\":\"huadong1\",\"longgang\":\"huadong1\",\"longgang.gray\":\"huadong1\",\"nantong\":\"huadong1\",\"nantong.gray\":\"huadong1\",\"nantong_ta\":\"huadong1\",\"nantong_ta.gray\":\"huadong1\",\"taishun\":\"huadong1\",\"taishun.gray\":\"huadong1\",\"tongcheng\":\"huadong1\",\"tongcheng.gray\":\"huadong1\",\"wangjiang\":\"huadong1\",\"wangjiang.gray\":\"huadong1\",\"wencheng\":\"huadong1\",\"wencheng.gray\":\"huadong1\",\"xuancheng\":\"huadong1\",\"xuancheng.gray\":\"huadong1\",\"xuzhou\":\"huadong1\",\"xuzhou.gray\":\"huadong1\",\"yiyang\":\"huadong1\",\"yiyang.gray\":\"huadong1\",\"yuexi\":\"huadong1\",\"yuexi.gray\":\"huadong1\",\"baiyin\":\"xibu\",\"baiyin.gray\":\"xibu\",\"emeishan\":\"xibu\",\"emeishan.gray\":\"xibu\",\"hetian\":\"xibu\",\"hetian.gray\":\"xibu\",\"kashi\":\"xibu\",\"kashi.gray\":\"xibu\",\"kashi_old\":\"xibu\",\"kashi_old.gray\":\"xibu\",\"lanzhou\":\"xibu\",\"lanzhou.gray\":\"xibu\",\"leshan\":\"xibu\",\"leshan.gray\":\"xibu\",\"longnan\":\"xibu\",\"longnan.gray\":\"xibu\",\"meishan\":\"xibu\",\"meishan.gray\":\"xibu\",\"tianshui\":\"xibu\",\"tianshui.gray\":\"xibu\",\"weiwuer\":\"xibu\",\"weiwuer.gray\":\"xibu\",\"wulumuqi\":\"xibu\",\"wulumuqi.gray\":\"xibu\",\"xian\":\"xibu\",\"xian.gray\":\"xibu\",\"xinjiang\":\"xibu\",\"xinjiang.gray\":\"xibu\",\"xixian\":\"xibu\",\"xixian.gray\":\"xibu\",\"yibin\":\"xibu\",\"yibin.gray\":\"xibu\"}";
     Gson gson = new Gson();
    Map<String, String> map = StringUtils.isEmpty(str) ? new HashMap() : gson.fromJson(str, new TypeToken<Map<String, String>>() {
    }.getType());*/

    String str = "2022-11-30";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //System.out.println(sdf.parse(str).before(DateUtil.addDay(new Date(), -1)));
    System.out.println(new Date().compareTo(DateUtil.addMins(DateUtil.addHour(sdf.parse(str),23), 59)));



  }

}
