package com.study.excelutil;

import com.alibaba.excel.EasyExcel;
import com.study.excelutil.dto.ExcelDO;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-10-06 22:14:09
 */
 
@Controller
@RequestMapping("/system/excel")
public class ExcelController {
  /**
   * 文件下载（失败了会返回一个有部分数据的Excel）
   * <p>
   * 1. 创建excel对应的实体对象 参照{@link DownloadData}
   * <p>
   * 2. 设置返回的 参数
   * <p>
   * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
   */
  @GetMapping("download")
  public void download(HttpServletResponse response) throws IOException {
    // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setCharacterEncoding("utf-8");
    // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
    String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
    response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    ArrayList<ExcelDO> list = new ArrayList<>();
    ExcelDO excelDO = new ExcelDO();
    excelDO.setAddr("1234");

    ExcelDO excelDO1 = new ExcelDO();
    excelDO1.setAddr("1234656565");
    list.add(excelDO);
    list.add(excelDO1);
    EasyExcel.write(response.getOutputStream(), ExcelDO.class).sheet("模板").doWrite(list);
  }

  /**
   * 文件上传
   * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
   * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
   * <p>3. 直接读即可
   */
/*  @PostMapping("upload")
  @ResponseBody
  public String upload(MultipartFile file) throws IOException {
    EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
    return "success";
  }*/





}
