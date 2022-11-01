package com.example.saasutil.service;

import com.example.saasutil.util.FileUtil;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-10-28 10:05
 **/
public class FileDownService {


  public static void main(String[] args) throws Exception {

     String filepathUpload = "D:\\";
     FileUtil.copyURLToFile(filepathUpload, "456", "https://www.95505.com.cn/tacapp/tiananapp/epolicy/eCarPolicyDownload?policyNo=6013242184006220000627&type=1&identifyNumber=91430400MA4L70DH3R", "");

  }

}
