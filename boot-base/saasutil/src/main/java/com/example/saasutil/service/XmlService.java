package com.example.saasutil.service;

import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.vo.XmlVo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-17 14:52
 **/
public class XmlService {

  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "\n"
        + "<correctResponse>\n"
        + "  <responseHead>\n"
        + "    <requestUUID>93d1bea7-3a52-4ce4-986e-3afe5ed4dda4</requestUUID>\n"
        + "    <sign>c7becc19c9b80ea2a3ed4a57b9687daf</sign>\n"
        + "  </responseHead>\n"
        + "  <responseBody>\n"
        + "    <responseTime>2021-12-17 02:35:43:565</responseTime>\n"
        + "    <resultFlag>false</resultFlag>\n"
        + "    <resultMessage>失败！批改生效日期不能早于保单PBTP21650110250000000305的起保日期</resultMessage>\n"
        + "    <InsurancePhone>95590</InsurancePhone>\n"
        + "    <downLoadUrl></downLoadUrl>\n"
        + "    <InsuranceTime>2021-05-20 00:00:00至2021-08-17 23:59:59</InsuranceTime>\n"
        + "  </responseBody>\n"
        + "</correctResponse>";

    Map<String, Object> map = multilayerXmlToMap(xml);
    map.forEach((key, value) ->{
      System.out.println(key);
      System.out.println(value);
    });



  }


  /**
   * (多层)xml格式字符串转换为map
   *
   * @param xml xml字符串
   * @return 第一个为Root节点，Root节点之后为Root的元素，如果为多层，可以通过key获取下一层Map
   */
  public static Map<String, Object> multilayerXmlToMap(String xml) {
    Document doc = null;
    try {
      doc = DocumentHelper.parseText(xml);
    } catch (DocumentException e) {
    }
    Map<String, Object> map = new HashMap<>();
    if (null == doc) {
      return map;
    }
    // 获取根元素
    Element rootElement = doc.getRootElement();
    recursionXmlToMap(rootElement,map);
    return map;
  }

  /**
   * multilayerXmlToMap核心方法，递归调用
   *
   * @param element 节点元素
   * @param outmap 用于存储xml数据的map
   */
  @SuppressWarnings("unchecked")
  private static void recursionXmlToMap(Element element, Map<String, Object> outmap) {
    // 得到根元素下的子元素列表
    List<Element> list = element.elements();
    int size = list.size();
    if (size == 0) {
      // 如果没有子元素,则将其存储进map中
      outmap.put(element.getName(), element.getTextTrim());
    } else {
      // innermap用于存储子元素的属性名和属性值
      Map<String, Object> innermap = new HashMap<>();
      // 遍历子元素
      list.forEach(childElement -> recursionXmlToMap(childElement, innermap));
      outmap.put(element.getName(), innermap);
    }
  }
}
