package com.example.saasutil.service.xian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.saasutil.service.xian.bean.GuangLianDaPolicyStatus;
import com.example.saasutil.service.xian.bean.GuangLianDaUpdatePolicyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-10-19 14:13
 **/
@RestController("xian")
@Slf4j
public class XianService {


  @GetMapping("test")
  public String test() {
    String httpUrl = "http://106.15.48.23:89/ws/busProcess?wsdl";
    IElecGuaranteeLetterService iElecGuaranteeLetterService = new IElecGuaranteeLetterService(httpUrl);
    IElecGuaranteeLetterServicePortType portType = iElecGuaranteeLetterService.getIElecGuaranteeLetterServicePort();
    GuangLianDaUpdatePolicyBean updatePolicyBean = new GuangLianDaUpdatePolicyBean();
    updatePolicyBean.setGuaranteeId("ac891710-d3b1-4861-99c7-8f944fa4db8b");
    updatePolicyBean.setGuaranteeDate("2022-03-03 00:00:00");
    updatePolicyBean.setStatus(GuangLianDaPolicyStatus.ISSUE.getStatus());
    updatePolicyBean.setGuaranteeAmt(60000);
    updatePolicyBean.setGuaranteePath("http://ccicfoss05.oss-cn-shanghai-finance-1-pub.aliyuncs.com/UW/UW_B/2023/03/03/16/TBTP23610100600000001429/88344CB150EB4F2AA24DC63A6724BA28.pdf?Expires=1678078904&OSSAccessKeyId=LTAI4Fp79AxhvrchRfNktx4d&Signature=5dzzqIiVPp%2FWFkBsqscxmj9%2FbTw%3D");
    updatePolicyBean.setTermStartDate("2023-03-09 00:00:00");
    updatePolicyBean.setTermEndDate("2023-09-05 23:59:59");
    JSONObject updateRequest = JSONUtil.parseObj(updatePolicyBean);
    log.info("submitUpdate请求参数{}", updateRequest.toString());
    String updateGuaranteeInfo = portType.updateGuaranteeInfo(updateRequest.toString());
    log.info("submitUpdate响应参数{}", updateGuaranteeInfo);
    return "Success";
  }

  public static void main(String[] args) {
    String httpUrl = "http://124.115.168.54:8883/elecGuaranteeLetterService?wsdl";
    IElecGuaranteeLetterService iElecGuaranteeLetterService = new IElecGuaranteeLetterService(httpUrl);
    IElecGuaranteeLetterServicePortType portType = iElecGuaranteeLetterService.getIElecGuaranteeLetterServicePort();
    GuangLianDaUpdatePolicyBean updatePolicyBean = new GuangLianDaUpdatePolicyBean();
    updatePolicyBean.setGuaranteeId("4f613d45-136c-4d75-93bd-86e81b85bf30");
    updatePolicyBean.setGuaranteeDate("2022-11-24 00:00:00");
    updatePolicyBean.setStatus(GuangLianDaPolicyStatus.ISSUE.getStatus());
    updatePolicyBean.setGuaranteeAmt(150000);
    updatePolicyBean.setGuaranteePath("https://xian-jy.gongbao.cn/ic-service/gongbaoToInsurance/download?policyNo=11744003901848634127");
    updatePolicyBean.setTermStartDate("2022-12-02 00:00:00");
    updatePolicyBean.setTermEndDate("2023-05-31 23:59:59");
    JSONObject updateRequest = JSONUtil.parseObj(updatePolicyBean);
    log.info("submitUpdate请求参数{}", updateRequest.toString());
    String updateGuaranteeInfo = portType.updateGuaranteeInfo(updateRequest.toString());
    log.info("submitUpdate响应参数{}", updateGuaranteeInfo);
  }
}
