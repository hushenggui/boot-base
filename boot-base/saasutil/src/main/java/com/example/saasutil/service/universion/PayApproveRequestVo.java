package com.example.saasutil.service.universion;

import com.example.saasutil.enums.ResponseStatus;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.vo.GongbaoChannelReqBaseVo;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 渠道订单审核回执请求vo
 * @author: hushenggui
 * @create: 2021-09-10 13:31
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayApproveRequestVo implements Serializable {
  /**
   *订单编号
   */
  private String orderId;

  /**
   * 投保单号
   */
  private String proposalNo;

  /**
   *状态
   */
  private ResponseStatus status;

  /**
   *审核通过原因
   */
  private String message;

  /**
   *支付链接
   */
  private String payUrl;

  public static void main(String[] args) {
    String req = "{\"cityCode\":\"650100\",\"cityName\":\"新疆兵团\",\"insCode\":\"10036\",\"source\":\"瀚华融资担保股份有限公司\",\"reqTime\":\"20230720152034\",\"reqType\":\"GUARANTEE_BID\",\"reqBody\":{\"orderId\":\"10199106501002023072015062768148\",\"proposalNo\":\"M20230720000053\",\"status\":\"SUCCESS\",\"message\":\"审批通过\",\"payUrl\":\"https://hhyl.hanhua.com/cashier-vue/cashier.html#/?message\\u003deb5e55304ff0c011f60abd3701ebc24d\\u0026partnerId\\u003d10002\\u0026businessNo\\u003d10199106501002023072015062768148\"},\"sign\":\"TztSkf3uX7K4bg6sdtL+/LmqEPGc1MrNps7tgQSxZEgZDfpa2BwEM1NbOS3PimxuVsR6htU7loDLMMXah2YGgqprSebN97iep17dg9LlJ9nI6ir76ytlsK25aTglmwSSN9Znp6Ryle29IvHy4Y47OsrQlBpJrDDEE0PFM8SMVu8Tm9SlAvIXfamqbe6IjLWpZDm1PbNvIrnbdLKjYl7iR2J3hnJR/z8XsVcU5YrE7WloTs4fybwSuCu/P7NuD2jJ7TbMWlcfdqOO3HW516Sb1tp6jx+fVS6xsqgAgP8xeDV8vG500zJwNd2vC+QNvxgxtzSezWiw3akO0cA7VEbv0heFC046buHjoGO2ns8lAJD6SU2bE+Qobz4VkcgLS23YDzZbbQjKGfxxIQ8GIOn6UN18YZLgC6FVZaSWYZl5Tggrrp6XbZ+7G0HMMTYY06V9aw4M3aVgTyYx4cAwyeJ79ttghqzvx2rGSygdAiEztlLTmNYLPANQSu4+c60Q15TD\"}";
    String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDj2-LKrADbOpkamjDSEPsxm-aHBlqE-AZfiS1uGNrgkMzxUIeQ8P13kc-h_EMdF8AjtMFybYex2_uNurKBNAU3g0hICk9NDlokhk5LYiac58BvaYzcgnAIRAyt5p7_KQsofiBHHn_NuA6Q4QoGOlfr-Z0I-w2TnrVdmLzAkuts8wIDAQAB";
    String sign = "TztSkf3uX7K4bg6sdtL+/LmqEPGc1MrNps7tgQSxZEgZDfpa2BwEM1NbOS3PimxuVsR6htU7loDLMMXah2YGgqprSebN97iep17dg9LlJ9nI6ir76ytlsK25aTglmwSSN9Znp6Ryle29IvHy4Y47OsrQlBpJrDDEE0PFM8SMVu8Tm9SlAvIXfamqbe6IjLWpZDm1PbNvIrnbdLKjYl7iR2J3hnJR/z8XsVcU5YrE7WloTs4fybwSuCu/P7NuD2jJ7TbMWlcfdqOO3HW516Sb1tp6jx+fVS6xsqgAgP8xeDV8vG500zJwNd2vC+QNvxgxtzSezWiw3akO0cA7VEbv0heFC046buHjoGO2ns8lAJD6SU2bE+Qobz4VkcgLS23YDzZbbQjKGfxxIQ8GIOn6UN18YZLgC6FVZaSWYZl5Tggrrp6XbZ+7G0HMMTYY06V9aw4M3aVgTyYx4cAwyeJ79ttghqzvx2rGSygdAiEztlLTmNYLPANQSu4+c60Q15TD";


    com.example.saasutil.vo.GongbaoChannelReqBaseVo<PayApproveRequestVo> gongbaoChannelReqBaseVo = JacksonUtils.jsonString2Obj(req,
        GongbaoChannelReqBaseVo.class);
    PayApproveRequestVo payApproveRequestVo = GsonUtil.parseObject(
        GsonUtil.toJsonSortDefault(gongbaoChannelReqBaseVo.getReqBody()), PayApproveRequestVo.class);

    boolean check = RSAUtil.check(GsonUtil.toJsonSortDefault(payApproveRequestVo), gongbaoChannelReqBaseVo.getSign(), publicKey);
    System.out.println(check);
  }
}
