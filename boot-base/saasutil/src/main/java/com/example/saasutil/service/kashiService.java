package com.example.saasutil.service;

import com.example.saasutil.util.Md5Util;
import com.example.saasutil.util.Md5Utils;
import com.example.saasutil.util.SignUtil;
import com.example.saasutil.util.StringFormatterUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: boot-base
 * @description: 喀什广联达验证签名
 * @author: hushenggui
 * @create: 2021-11-03 17:43
 **/
@Slf4j
public class kashiService {


  public static final String accessKey = "bc8a7de3-8d0f-11eb-ac48-00163e09c516";
  public static final String secretKey = "bCsOgA3Py48necNPY4o2/Q==";

  public static String encode(String req, String accessKey, String secretKey) {
    try {
      JsonObject jsonObject = JsonParser.parseString(req).getAsJsonObject();
      jsonObject.remove("sign");
      jsonObject.addProperty("access_key", accessKey);
      String signStr = StringFormatterUtils.jsonCovertStringGuangLianDa(jsonObject, null, "&", "=");
      String param = signStr + "&" + secretKey;
      log.info("accessKey {} secretKey {} param>> {}", accessKey, secretKey, param);
      System.out.println(param);
      String sign = Md5Util.MD5(param.trim());
      return sign;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  public static void main(String[] args) throws Exception {
    String requestbody = "{\n"
        + "    \"tenderer\":\"X5qa3zO/NpzLiiDTxWQ0p7b9alq3OSo1sq8j/u92uKCDshK6byb1ng==\",\n"
        + "    \"tender_type\":\"A04\",\n"
        + "    \"tender_start_time\":\"20211110150938\",\n"
        + "    \"agent_name\":\"关羽\",\n"
        + "    \"tender_bond_end_time\":\"20211110000000\",\n"
        + "    \"sign\":\"896a797f508cc3112efd0aaca1739f0b\",\n"
        + "    \"enterprise_performances\":\"企业业绩\",\n"
        + "    \"project_area\":\"x+bhUd\",\n"
        + "    \"agent_phone\":\"13978562898\",\n"
        + "    \"project_name\":\"ZK+MeeAtFYLUAhBnIwRwOMmIoAgVfaRTlKMwLknubGY=\",\n"
        + "    \"business_license_url\":\"https://himg.bdimg.com/sys/portrait/item/pp.1.1bbbb3ee.hvQZWgtsQXO110QFeAqKmA.jpg?tt=1625705071595\",\n"
        + "    \"tenderer_address\":\"x+bhUd5+XOeM5OqM3A6tEBEYipcgyhjV\",\n"
        + "    \"agent_id_type\":\"01\",\n"
        + "    \"enterprise_code\":\"91330782MA2HQQHP1Y\",\n"
        + "    \"basic_bank_code\":\"913302063\",\n"
        + "    \"legal_name\":\"电子一\",\n"
        + "    \"legal_id_no\":\"522725200006010038\",\n"
        + "    \"tenderer_code\":\"rO4V9pVP0AbwvU7kFG0t\",\n"
        + "    \"tender_expire\":\"120\",\n"
        + "    \"method\":\"apply_guarantee\",\n"
        + "    \"agency\":\"dSybFz1mxwfZ3dP1Xsbk/3ztXotgcg\",\n"
        + "    \"basic_account_name\":\"testbank\",\n"
        + "    \"section_name\":\"ZK+MeeAtFYLUAhBnIwRwOMmIoAgVfaRTN1UU5JrV5LMB1iy/YJ98JQkCKk8XV5fC\",\n"
        + "    \"created\":\"20211103175319\",\n"
        + "    \"apply_no\":\"635933199280090393\",\n"
        + "    \"tender_file_url\":\"www.test.com\",\n"
        + "    \"project_code\":\"yYigCBV9pFOUozAuSe5sZg==\",\n"
        + "    \"version\":\"5.0.9\",\n"
        + "    \"enterprise_email\":\"9261042814@qq.com\",\n"
        + "    \"tender_bond\":\"90000.00\",\n"
        + "    \"agent_id_no\":\"11010119850909236X\",\n"
        + "    \"basic_account\":\"913302063169813514 \",\n"
        + "    \"basic_bank_name\":\"testbank\",\n"
        + "    \"access_key\":\"bc8a7de3-8d0f-11eb-ac48-00163e09c516\",\n"
        + "    \"section_code\":\"yYigCBV9pFM7K8j1+Zy19/Q6Wj+6pN\",\n"
        + "    \"basic_need\":\"1\",\n"
        + "    \"enterprise_name\":\"丰泽区触享信息技术服务部\",\n"
        + "    \"legal_id_type\":\"01\"\n"
        + "}";

    String sign = encode(requestbody, accessKey, secretKey);
    System.out.println(sign);
  String str = "access_key=bc8a7de3-8d0f-11eb-ac48-00163e09c516&agency=dSybFz1mxwfZ3dP1Xsbk/3ztXotgcg&agent_id_no=11010119850909236X&agent_id_type=01&agent_name=关羽&agent_phone=13978562898&apply_no=635933199280090393&basic_account=913302063169813514&basic_account_name=testbank&basic_bank_code=913302063&basic_bank_name=testbank&basic_need=1&business_license_url=https://himg.bdimg.com/sys/portrait/item/pp.1.1bbbb3ee.hvQZWgtsQXO110QFeAqKmA.jpg?tt=1625705071595&created=20211103175319&enterprise_code=91330782MA2HQQHP1Y&enterprise_email=9261042814@qq.com&enterprise_name=丰泽区触享信息技术服务部&enterprise_performances=企业业绩&legal_id_no=522725200006010038&legal_id_type=01&legal_name=电子一&method=apply_guarantee&project_area=x+bhUd&project_code=yYigCBV9pFOUozAuSe5sZg==&project_name=ZK+MeeAtFYLUAhBnIwRwOMmIoAgVfaRTlKMwLknubGY=&section_code=yYigCBV9pFM7K8j1+Zy19/Q6Wj+6pN&section_name=ZK+MeeAtFYLUAhBnIwRwOMmIoAgVfaRTN1UU5JrV5LMB1iy/YJ98JQkCKk8XV5fC&tender_bond=90000.00&tender_bond_end_time=20211110000000&tender_expire=120&tender_file_url=www.test.com&tender_start_time=20211110150938&tender_type=A04&tenderer=X5qa3zO/NpzLiiDTxWQ0p7b9alq3OSo1sq8j/u92uKCDshK6byb1ng==&tenderer_address=x+bhUd5+XOeM5OqM3A6tEBEYipcgyhjV&tenderer_code=rO4V9pVP0AbwvU7kFG0t&version=5.0.9&bCsOgA3Py48necNPY4o2/Q==";
    System.out.println(Md5Util.MD5(str));
  }

}
