package com.example.saasutil.service.universion;

import com.example.saasutil.enums.BusType;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 退保请求Vo
 * @author: hushenggui
 * @create: 2021-09-17 15:29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuitPolicyRequestVo implements Serializable {

  private static final long serialVersionUID = -2548570813233091836L;

  /**
   * 订单编号
   */
  private String orderId;

  /**
   * 注销原因
   */
  private String cancReason;

  /**
   * 银行账号
   */
  private String accNo;

  /**
   * 银行账户
   */
  private String accName;

  /**
   * 银行名称
   */
  private String bankName;

  /**
   * 业务类型
   */
  private BusType busType;


  public static void main(String[] args) {
    String json = "{\n"
        + "    \"cityCode\":\"330324\",\n"
        + "    \"cityName\":\"永嘉县\",\n"
        + "    \"insCode\":\"20009\",\n"
        + "    \"source\":\"电子保函平台司\",\n"
        + "    \"reqTime\":\"1690369235000\",\n"
        + "    \"reqType\":\"BANK_BID\",\n"
        + "    \"reqBody\":{\n"
        + "        \"orderId\":\"10199103303242023071914394690764\",\n"
        + "        \"cancReason\":\"额度释放\",\n"
        + "        \"busType\":\"POLICY_REFUND\"\n"
        + "    },\n"
        + "    \"sign\":\"NXL/3epxHDaZd/uRDeM12xzS/ifj+AnJLYF1N3sFZO9J2Kv8cXyR1Bjg+fPJynRnbWmsrQ3mZ5iP+IYYfxw61xBEEBR5n15ITmFRFN0fLNzJpMWfuDlCoz3rHgVbFiK4gcfjuqD7zY7fCeJrmct7wyQ5owlVxyDmM7QAqzkXb1ePhrXs0hALcVV4cwnwozH41W37qEn/buIE6hKy8Say2YL+C/aqamyI5rhNbFchign+QCV/Dl9Fn/ztiMBe9xxBaAfA3BL5MKrqfwteUU97QLYULCMGdoqtqKH7OLkm4wRSaqbN9SpDYsp22YSB20c2GvMn4xVC2odT46r1u/yDAXjHnQrFZ8767pg7CPQvKAhNeb6cytQ0u4FTcwPKXUL2F5tPQGDbylJvLtYE7vxGO2vzATVeUvaPKaDCpbXSCyp22yb27jWqXcYwGcuPi63guXtNAIwodfkdQUSZObQ4Z1SAPW+9A5z7cN9lmLX7c02IOCcmbHH+J8EzgYLFH5XJ\"\n"
        + "}";
    String privateKey = "MIICXQIBAAKBgQDLdf5HX9iNbNXE4pvCSu33sqaF0qwncA3pOBEiat5TNDMlNSNtHgHy/zhULhshWAorRf7t+YwgnuflDiCddnM2z2f/XDZ5mTHrpE9YhEIvFxV2D04dNvwPhntl+jGKe9ZKoc63G3sFh2P/TqfUDFSeQMphRDdRYz1DpCsVDI3bAQIDAQABAoGAUDe6RIvOhpwFgHXT8Xu3bTSboSGZzIbKhUwcvVQjSezHyYC08f2lyRfFLrNq8O+UOtGDHHKKRAZC6bVzOIIOFDaHx1xA9YsAx+4H723LZLpKbiGeEIuqPFYWsczgqyRqb56FCjUvf+qfK5uP43lQM+m/Zx/XKCWGfvb3Q1VAkQECQQD34sdjRQDvy5enJHnaoGP3nNsmlQhhFlo+4nzzMmdehcbASr2Bl+bcWPjHY4QLJLSqMk48qaVPsD1fVm/K1cIRAkEA0h7xzqKR6pP2dDy38l/pzLjZ4XV2B+SJ/ZaDhO+pVKRm0pkj38wkrkguqAu9hSsQwMwANnZwb7RA23ZLHPaZ8QJBAOM5A6AhXoxwyWCy9OfM4hXVuKUTM40bWjoOjo63Az4HznnxiOjD/yC4hcLvm9hDG0BvwHum3hu/52H+75a0fqECQEpwsBYWvj8u4FdZ04lItZnTu00GwiQVsVVn53xHM+RKwirGGlGFD1G3POBIGIJ/OVY0b7bbywWoBHo7tGy0aOECQQCagRLb2BoBCWini8ru6OxTJlrKIccmcwoThFWtZHA+XT/2lx8gdK0aWQPK59ZiK6rfUT2jthVyBMnBglLkfQa7";
    GongbaoChannelReqBaseVo<QuitPolicyRequestVo> reqBaseVo = GsonUtil.parseObject(json, GongbaoChannelReqBaseVo.class);
    String sign = RSAUtil.encrypt(GsonUtil.toJsonSortDefault(reqBaseVo.getReqBody()), privateKey);
    reqBaseVo.setSign(sign);
    System.out.println(GsonUtil.toJsonSortDefault(reqBaseVo));
  }
}
