package com.example.saasutil.service.universion;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 文件上传请求vo
 * @author: hushenggui
 * @create: 2021-09-13 09:45
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadRequestVo implements Serializable {

  private static final long serialVersionUID = -4423079324710894479L;

  /**
   * 附件 ID
   */
  private String fileId;

  /**
   *  附件名
   */
  private String filename;

  /**
   *  附件大小
   */
  private Integer fileSize;

  /**
   *  附件 MD5
   */
  private String fileMD5;

  /**
   *  附件地址
   */
  private String fileUrl;

  /**
   *  附件 base64
   */
  private String fileBase64;

  /**
   * 订单编号
   */
  private String orderId;

  public static void main(String[] args) {
    String json = "{\"cityCode\":\"650000\",\"cityName\":\"新疆自治区\",\"insCode\":\"10036\",\"source\":\"瀚华融资担保股份有限公司\",\"reqTime\":\"20240112152946\",\"reqType\":\"GUARANTEE_BID\",\"reqBody\":{\"filename\":\"payFileForBlank.jpg\",\"fileSize\":14,\"fileMD5\":\"d7678f275ff9a12c58c33bcd99eb04a6\",\"fileUrl\":\"https://hhyl-dev.hanhua.com/pfbpapi/api/file/v1/get/download/docid?docId\\u003dhhdoc2307040000002963248850\",\"orderId\":\"10199106500002024011215075068659\"},\"sign\":\"iu/ZV+Vl69kvpcYCKYBRqnGE5+2o1oEYmrxqisIwNxWIV9zCtYzuT02hVGO7pI2jmW/sz+aHR8V2Oo0qwK8iP9pLQx8J7rAsRrVdBaMAvkQbvDJORlzyAZmXWRq0jG5y5143I1nTSYmb5ewPs/QbupeLlrwgES+Tc7bECpsdF+5RiHya53q273ZAhEMqUF0zsywICAUUJIdDse7XM2SBEs/nNuwtDH99eP1SFb/V4P/DIpz1kmx6cCUo9CmazCel2FhwsP86pnaRc5fbH9puhhUbbJixbzN4pfK+vkw3QLbLYkS/0+HQ/bRhx9v8Uiz0Dr0lhJNrQdsR3L+29nOMkw\\u003d\\u003d\"}";
    String privateKey = "MIICXQIBAAKBgQDLdf5HX9iNbNXE4pvCSu33sqaF0qwncA3pOBEiat5TNDMlNSNtHgHy/zhULhshWAorRf7t+YwgnuflDiCddnM2z2f/XDZ5mTHrpE9YhEIvFxV2D04dNvwPhntl+jGKe9ZKoc63G3sFh2P/TqfUDFSeQMphRDdRYz1DpCsVDI3bAQIDAQABAoGAUDe6RIvOhpwFgHXT8Xu3bTSboSGZzIbKhUwcvVQjSezHyYC08f2lyRfFLrNq8O+UOtGDHHKKRAZC6bVzOIIOFDaHx1xA9YsAx+4H723LZLpKbiGeEIuqPFYWsczgqyRqb56FCjUvf+qfK5uP43lQM+m/Zx/XKCWGfvb3Q1VAkQECQQD34sdjRQDvy5enJHnaoGP3nNsmlQhhFlo+4nzzMmdehcbASr2Bl+bcWPjHY4QLJLSqMk48qaVPsD1fVm/K1cIRAkEA0h7xzqKR6pP2dDy38l/pzLjZ4XV2B+SJ/ZaDhO+pVKRm0pkj38wkrkguqAu9hSsQwMwANnZwb7RA23ZLHPaZ8QJBAOM5A6AhXoxwyWCy9OfM4hXVuKUTM40bWjoOjo63Az4HznnxiOjD/yC4hcLvm9hDG0BvwHum3hu/52H+75a0fqECQEpwsBYWvj8u4FdZ04lItZnTu00GwiQVsVVn53xHM+RKwirGGlGFD1G3POBIGIJ/OVY0b7bbywWoBHo7tGy0aOECQQCagRLb2BoBCWini8ru6OxTJlrKIccmcwoThFWtZHA+XT/2lx8gdK0aWQPK59ZiK6rfUT2jthVyBMnBglLkfQa7";
    GongbaoChannelReqBaseVo<FileUploadRequestVo> reqBaseVo = GsonUtil.parseObject(json, GongbaoChannelReqBaseVo.class);
    String sign = RSAUtil.encrypt(GsonUtil.sortObjectToJson(reqBaseVo.getReqBody()), privateKey);
    reqBaseVo.setSign(sign);
    System.out.println(GsonUtil.sortObjectToJson(reqBaseVo));
  }

}
