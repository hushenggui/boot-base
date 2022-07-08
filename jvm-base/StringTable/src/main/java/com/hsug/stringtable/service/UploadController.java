package com.hsug.stringtable.service;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: saas
 * @description:
 * @author: hushenggui
 * @create: 2022-04-12 15:40
 **/
@Slf4j(topic = "【upload】： ")
@Controller
@RequestMapping("/upload")
public class UploadController {

  @GetMapping("/openFile")
  public RespBaseEntity openFile(String downloadUrl, HttpServletResponse response) throws IOException {
    response.sendRedirect(downloadUrl);
    RespBaseEntity respBaseEntity = new RespBaseEntity();
    respBaseEntity.setStatus("success");
    return respBaseEntity;
  }

}
