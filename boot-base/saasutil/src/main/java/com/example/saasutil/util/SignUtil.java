package com.example.saasutil.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class SignUtil {

  public static final String SHA256 = "sha256";
  /**
   * 验证签名
   */
  public static boolean verify(String xmlStr, String signStr, String key) {
    String xmlValues = XmlUtil.getNodes("requestBody", xmlStr);
    String sign = Md5Utils.MD5(xmlValues + key);
    if (signStr.equals(sign)) {
      return true;
    }
    return false;
  }

  /**
   * 验证签名(交易中心使用)
   *
   * @param xmlStr 请求报文
   * @param signStr 报文签名
   * @param key 密钥
   * @param nodeName 取值节点
   */
  public static boolean verifyForGgzy(String xmlStr, String signStr, String key, String nodeName) {
    //获取指定节点内全部节点的值
    String xmlValues = XmlUtil.getNodes(nodeName, xmlStr);
    //生成签名
    String sign = Md5Utils.MD5(xmlValues + key);
    log.info("交易中心签名为:============[" + sign + "]============");
    if (signStr.equalsIgnoreCase(sign)) {
      return true;
    }
    return false;
  }

  /**
   * 验证签名(交易中心使用)
   *
   * @param xmlStr 请求报文
   * @param signStr 报文签名
   * @param key 密钥
   * @param nodeName 取值节点
   */
  public static boolean verify(String xmlStr, String signStr, String key, String nodeName, String insCode, String ext) {
    //获取指定节点内全部节点的值
    String xmlValues = XmlUtil.getNodes(nodeName, xmlStr);
    //生成签名
    String sign;

      sign = Md5Utils.MD5(xmlValues + key);

    log.info("保险公司/担保公司/银行保函 签名为:============[" + sign + "]============");
    if (signStr.equalsIgnoreCase(sign)) {
      return true;
    }
    return false;
  }

  /**
   * 生成签名(废弃)
   */
  private static String sign(String xmlStr, String key) {
    String xmlValues = XmlUtil.getNodes("requestBody", xmlStr);
    String sign = Md5Utils.MD5(xmlValues + key);
    return sign;
  }

  /**
   * 生成签名
   *
   * @param xmlStr xml报文
   * @param signNodeName 签名节点名称
   * @param bodyNode body节点名称
   * @param key 秘钥
   */
  public static String sign(String xmlStr, String signNodeName, String bodyNode, String key) {
    Document document = null;
    try {
      //String sign = sign(xmlStr,key);
      String xmlValues = XmlUtil.getNodes(bodyNode, xmlStr);
      System.out.println(xmlValues);
      String sign = Md5Utils.MD5(xmlValues + key);

      document = DocumentHelper.parseText(xmlStr);
      Element element = document.getRootElement();

      Element ec = (Element) element.selectSingleNode("//" + signNodeName);
      if (ec == null) {
        //Element bodyElement = (Element)element.selectSingleNode("//"+bodyNode);
        element.addElement(signNodeName);
        ec = (Element) element.selectSingleNode("//" + signNodeName);
      }
      ec.setText(sign);
    } catch (DocumentException e) {
      e.printStackTrace();
      return null;
    }
    return document.asXML();
  }

  public static String getSignFromXml(String xmlStr, String key, String nodeName) {
    try {
      //获取指定节点内全部节点的值
      String xmlValues = XmlUtil.getNodes(nodeName, xmlStr);
      log.info("key {} xmlValues {}", key, xmlValues);
      //生成签名
      String sign = Md5Utils.MD5(xmlValues + key);
      return sign;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  public static String getSignFromXml(String xmlStr, String key, String nodeName, String insCode, String ext) {
    try {
      Gson gson = new Gson();
      //获取指定节点内全部节点的值
      String xmlValues = XmlUtil.getNodes(nodeName, xmlStr);
      log.info("key {} xmlValues {}", key, xmlValues);

        //生成签名
        String sign = Md5Utils.MD5(xmlValues + key);
        return sign;

    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * 组装xml 生成签名
   *
   * @param template xml模版
   * @param dataMap xml数据
   * @param signNodeName 签名节点名称
   * @param bodyNode body节点名称
   * @param key 秘钥
   */
  public static String signMap(String template, Map<String, String> dataMap, String signNodeName,
      String bodyNode, String key) {
    try {
      Document document = DocumentHelper.parseText(template);
      Element element = document.getRootElement();
      String xmlStr = XmlUtil.readElement(element, dataMap, document);
      String sign = SignUtil.sign(xmlStr, signNodeName, bodyNode, key);
      return sign;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  /**
   * 保险公司请求签名生成
   */
  public static String mapSign(Map<String, Object> map, String signKey) {
    Iterator iter = map.keySet().iterator();
    StringBuffer sb = new StringBuffer();
    while (iter.hasNext()) {
      Object key = iter.next();
      if ("requestUUID".equals(String.valueOf(key)) || "sign".equals(String.valueOf(key))
          || "signStr".equals(String.valueOf(key))) {
        continue;
      }
      Object val = map.get(key);
      if (val != null) {
        sb.append(key + "=" + val);
      }
    }
    return Md5Utils.MD5(sb.toString() + signKey);
  }

  public static void main(String[] args) {
   /* String reqXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
        "<claimRequest> \n" +
        "  <requestHead> \n" +
        "    <sign>24B55A2DE893489037618C70105A6C54</sign>  \n" +
        "    <requestUUID>230000-B9C8DF24F2DB45B49EE6EB83BB8EB357</requestUUID> \n" +
        "  </requestHead>  \n" +
        "  <requestBody> \n" +
        "    <policyno>23207000059011190000040</policyno>  \n" +
        "    <claimName>连云港工保工程技术有限公司</claimName>  \n" +
        "    <claimPhone>13776365219</claimPhone>  \n" +
        "    <cliaimReason>模拟理赔</cliaimReason> \n" +
        "  </requestBody> \n" +
        "</claimRequest>";

    String aa = sign(reqXml, "sign", "requestBody", "MeTKJnC3fIAxeer8erADRTlJ");
    System.out.println(aa);
    double sharePercent = 20.0;
    Integer stock = (int) (5000 * sharePercent / 100);
    System.out.println(stock);*/

   List<String> list1 = Arrays.asList("0005", "0006", "0007","0008");

    List<String> list2 = Arrays.asList("0007", "0006", "0008");
    System.out.println(list2);


    Collections.sort(list1, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int O1Index = list2.indexOf(o1);
        if( O1Index == -1){
          O1Index = 100;
        }
        int O2Index = list2.indexOf(o2);
        if( O2Index == -1){
          O2Index = 100;
        }
        return O1Index - O2Index;
      }
    });

    System.out.println(list1);


  }
}
