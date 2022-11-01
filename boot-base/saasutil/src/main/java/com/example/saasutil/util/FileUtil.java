package com.example.saasutil.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Created by AnthonyPark on 2018/9/13.
 */
@Slf4j
public class FileUtil {

  /**
   * 获得指定文件的byte数组
   *
   * @param filePath 文件绝对路径
   */
  public static byte[] file2Byte(String filePath) {
    ByteArrayOutputStream bos = null;
    BufferedInputStream in = null;
    try {
      File file = new File(filePath);
      if (!file.exists()) {
        throw new FileNotFoundException("file not exists");
      }
      bos = new ByteArrayOutputStream((int) file.length());
      in = new BufferedInputStream(new FileInputStream(file));
      int buf_size = 1024;
      byte[] buffer = new byte[buf_size];
      int len = 0;
      while (-1 != (len = in.read(buffer, 0, buf_size))) {
        bos.write(buffer, 0, len);
      }
      return bos.toByteArray();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    } finally {
      try {
        if (in != null) {
          in.close();
        }
        if (bos != null) {
          bos.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
  }

  /**
   * 根据byte数组，生成文件
   *
   * @param bfile 文件数组
   * @param filePath 文件存放路径
   * @param fileName 文件名称
   */
  public static void byte2File(byte[] bfile, String filePath, String fileName) {
    BufferedOutputStream bos = null;
    FileOutputStream fos = null;
    File file = null;
    try {
      File dir = new File(filePath);
      if (!dir.exists() && !dir.isDirectory()) {//判断文件目录是否存在
        dir.mkdirs();
      }
      file = new File(filePath + fileName);
      fos = new FileOutputStream(file);
      bos = new BufferedOutputStream(fos);
      bos.write(bfile);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        if (bos != null) {
          bos.close();
        }
        if (fos != null) {
          fos.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
  }

  public static void writeFile(String fileName, List<String> contents) throws IOException {
    FileWriter fileWriter = null;
    BufferedWriter bufferWriter = null;
    try {
      File file = new File(fileName);
      if (!file.exists()) {
        file.createNewFile();
      }
      fileWriter = new FileWriter(fileName, true);
      bufferWriter = new BufferedWriter(fileWriter);
      for (String content : contents) {
        bufferWriter.write(content);
      }
    } catch (IOException e) {
      log.error("write file to {} error", fileName, e);
    } finally {
      bufferWriter.close();
      fileWriter.close();
    }
  }

  public static File copyURLToFile(String temp, String fileName, String url, String suffix) throws Exception {
    log.info("temp {} fileName {} url {} suffix {}", temp, fileName, url, suffix);
    //判断文件目录是否存在
    url = getFileSecondUrl(url);
    File dir = new File(temp);
    if (!dir.exists() && !dir.isDirectory()) {
      log.error("temp not exists {}", temp);
      throw new Exception("temp not exists " + temp);
    }
    if(StringUtils.isEmpty(suffix) || suffix.indexOf(".") < 0) {
      suffix = ".pdf";
    }
    File tempFile = new File(temp + "/" + fileName + suffix);
    log.info("fileUrl first: {}",url);
    if(!StringUtils.isEmpty(url) && url.startsWith("https")) {
      FileUtil.copyURLToFile(url, tempFile);
    } else if(!StringUtils.isEmpty(url) && url.startsWith("http")) {
      FileUtils.copyURLToFile(new URL(url), tempFile, 60000, 60000);
    }
    byte[] bytes = FileUtils.readFileToByteArray(tempFile);
    //需要二次跳转链接的情况
    if(bytes.length == 0){
      log.info("fileUrl second: {}",url);
      if(!StringUtils.isEmpty(url) && url.startsWith("https")) {
        FileUtil.copyURLToFile(url, tempFile);
      } else if(!StringUtils.isEmpty(url) && url.startsWith("http")) {
        FileUtils.copyURLToFile(new URL(url), tempFile, 60000, 60000);
      }
    }
    return tempFile;
  }

  public static void main(String[] args) throws Exception {
    File tempFile = new File("E:\\1234.pdf");
    String url = "https://www.95505.com.cn/tacapp/tiananapp/epolicy/eCarPolicyDownload?policyNo=6013242184006220000627&type=1&identifyNumber=91430400MA4L70DH3R";
    FileUtil.copyURLToFile(url, tempFile);
    String str =  Base64Util.fileToBase64(tempFile);
  }

  /**
  * @Description: 获取第二次跳转的链接
  * @Param: [url]
  * @return:
  * @Author: hushenggui
  * @Date: 2020/11/11
  */
  public static String getFileSecondUrl(String url)  throws Exception{
    HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
    urlConnection.setInstanceFollowRedirects(Boolean.FALSE);
    Map<String,List<String>> values = urlConnection.getHeaderFields();
    StringBuffer sb = new StringBuffer();
    values.forEach((k, v) -> {
      v.stream().forEach(value -> {
        if((!ObjectUtils.isEmpty(value) && value.contains("http://")) || !ObjectUtils.isEmpty(value) && value.contains("https://")) {
          sb.append(value);
        }
      });
    });
    if(!StringUtils.isEmpty(sb.toString())) {
      return sb.toString();
    } else {
      return url;
    }
  }
  public static File copyURLToFile(String temp, String fileName, String url) throws Exception {
    String ext = FilenameUtils.getExtension(url);
    //判断文件目录是否存在
    File dir = new File(temp);
    if (!dir.exists() && !dir.isDirectory()) {
      log.error("temp not exists {}", temp);
      throw new Exception("temp not exists " + temp);
    }
    File tempFile = new File(temp + "/" + fileName + ".pdf");
    if(!StringUtils.isEmpty(url) && url.startsWith("https")) {
      log.info("https {}", url);
      FileUtil.copyURLToFile(url, tempFile);
    } else if(!StringUtils.isEmpty(url) && url.startsWith("http")) {
      log.info("http {}", url);
      FileUtils.copyURLToFile(new URL(url), tempFile, 60000, 60000);
    }
    return tempFile;
  }

  public static void copyURLToFile(String httpsUrl, File tempFile) throws Exception {
    TrustManager[] trustAllCerts = new TrustManager[]{
        new X509TrustManager() {
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
          }

          public void checkClientTrusted(
              java.security.cert.X509Certificate[] certs, String authType) {
          }

          public void checkServerTrusted(
              java.security.cert.X509Certificate[] certs, String authType) {
          }
        }
    };

    // Activate the new trust manager
    SSLContext sc = SSLContext.getInstance("TLS");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    // Open connection to the URL
    URL url = new URL(httpsUrl);
    URLConnection connection = url.openConnection();

    // Download the file
    // FileUtils.copyURLToFile(connection.getURL(), new File("/path/to/file"));
    FileUtils.copyURLToFile(connection.getURL(), tempFile, 60000, 60000);
  }

  public static String readFileToString(String fileName) {
    String encoding = "UTF-8";
    File file = new File(fileName);
    Long filelength = file.length();
    byte[] filecontent = new byte[filelength.intValue()];
    try {
      FileInputStream in = new FileInputStream(file);
      in.read(filecontent);
      in.close();
      return new String(filecontent, encoding);
    } catch (Exception e) {
      log.error("readFileToString error", e);
      return null;
    }
  }

  /**
   * 判断文件大小
   * @param len
   * @param size
   * @param unit
   * @return
   */
  public static boolean checkFileSize(Long len, int size, String unit) {
    //long len = file.length();
    double fileSize = 0;
    if ("B".equals(unit.toUpperCase())) {
      fileSize = (double) len;
    } else if ("K".equals(unit.toUpperCase())) {
      fileSize = (double) len / 1024;
    } else if ("M".equals(unit.toUpperCase())) {
      fileSize = (double) len / 1048576;
    } else if ("G".equals(unit.toUpperCase())) {
      fileSize = (double) len / 1073741824;
    }
    if (fileSize > size) {
      return false;
    }
    return true;
  }
  
}

