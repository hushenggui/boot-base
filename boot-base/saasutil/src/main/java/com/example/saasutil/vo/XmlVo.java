package com.example.saasutil.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import lombok.Data;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-17 14:53
 **/
@Data
@JacksonXmlRootElement(localName = "correctResponse")
public class XmlVo implements Serializable {

  //private String resultFlag;
  @JsonIgnoreProperties(ignoreUnknown = true)
  private String requestUUID;

}
