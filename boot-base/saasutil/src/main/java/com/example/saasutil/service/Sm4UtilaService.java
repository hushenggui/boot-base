package com.example.saasutil.service;

import com.example.saasutil.util.app.SM4Util;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-06-16 09:33
 **/
public class Sm4UtilaService {


  public static void main(String[] args) {
        String a = "{\"bidCode\":\"E6101003506iFwrMFz8o001\",\"phone\":\"18629457105\",\"creditCode\":\"91611102MA7E6PLR8R\",\"expireTime\":\"1665279543235\"}";
        String s = SM4Util.encryptBySM4(a,"DA6645A95E7ADDFD7DD6B67006F2314B");
        String s1 = SM4Util.decryptBySM4("a1d3ad70e09e90b065c65078e82120b3aaa2d8ec8543bdf26b63d64b2a848f7511be102f1acec9dbf9cf9d0e24934fbda6f25e87f434bb3edd4d779ff767226471ab5707c00aeeba17b896bff9fbcb0fd2d1feb1b84b87bfd923d43f1d952d5bbcedec64df154aa0300db7a39f5aab9d28cb9e8adb44ee4cb9fd4190f1877af0","DA6645A95E7ADDFD7DD6B67006F2314B");
        System.out.println(s);
        //System.out.println(s1);
 /*   String token = "a1d3ad70e09e90b065c65078e82120b3f37ce87cf6f2a8e59d63e28fd781f33edf175c51036f43e8b0fcb9cf4ec13facf6efe14a162d5de2ee678fd8db98f3ce8355159433e9943e784fde0c1dae4c315fc5ed76c4531d0a245c93a40cfccd276bf8ae1225af64ca18df870b306b6fc2dac5f17f839d8aa1cda8fc1f65e8bd26";
    String s1 = SM4Util.decryptBySM4(token,"DA6645A95E7ADDFD7DD6B67006F2314B");
    System.out.println(s1);*/
  }
}
