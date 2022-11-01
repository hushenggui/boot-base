package com.example.saasutil.enums;

import java.util.Map;

/**
 * Created by sunwen on 2019/5/14.
 */
public enum BusAddress {

  TIANAN("连云港市朝阳中路168号祥源大厦11楼", "00002"),
  YATAI("长沙市五一大道456号亚大时代大厦20楼", "00003"),
  ZIJIN("连云港市海州区朝阳东路35号登壹大厦13层", "00004"),
  DADI("长沙市天心区书院路9号保利国际广场B3栋13A", "00005"),
  TAIBAO("连云港市海昌北路48号", "00006"),
  PINGAN("长沙市开福区芙蓉中路一段109号华创国际广场C座16楼", "00007"),
  TAIPING("连云港市海州区朝阳东路21-2号楼805室", "00008"),
  YANGGUANG("连云港市海州区郁州南路12号万源花苑B综合楼", "00009"),
  YONGAN("待提供", "00010"),
  HUANONG("待提供", "00014"),
  RENBAO("中国北京市朝阳区建国门外大街2号院2号楼", "00015"),
  ZHAOHANG("广西南宁市青秀区民族大道136-5号华润大厦C座13楼", "20001");

  private String name;
  private String code;

  BusAddress(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public static String getBusAddressByCode(String code) {
    for (BusAddress c : BusAddress.values()) {
      if (c.getCode().equals(code)) {
        return c.getName();
      }
    }
    return "待提供";
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public static void main(String[] args) {
    System.out.println(BusAddress.getBusAddressByCode("00002"));
  }
}
