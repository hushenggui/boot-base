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
    updatePolicyBean.setGuaranteeId("1c19035f-c778-418e-a361-aec82ed83cfa");
    updatePolicyBean.setGuaranteeDate("2022-11-04 00:00:00");
    updatePolicyBean.setStatus(GuangLianDaPolicyStatus.ISSUE.getStatus());
    updatePolicyBean.setGuaranteeAmt(30000);
    updatePolicyBean.setGuaranteePath("https://xian-jy.gongbao.cn/upload/HF5VR22272UBVH4TV00.pdf");
    updatePolicyBean.setTermStartDate("2022-11-04 00:00:00");
    updatePolicyBean.setTermEndDate("2023-05-03 23:59:59");
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
    updatePolicyBean.setGuaranteeId("1c19035f-c778-418e-a361-aec82ed83cfa");
    updatePolicyBean.setGuaranteeDate("2022-11-04 00:00:00");
    updatePolicyBean.setStatus(GuangLianDaPolicyStatus.ISSUE.getStatus());
    updatePolicyBean.setGuaranteeAmt(30000);
    updatePolicyBean.setGuaranteePath("https://xian-jy.gongbao.cn/upload/HF5VR22272UBVH4TV00.pdf");
    updatePolicyBean.setTermStartDate("2022-11-04 00:00:00");
    updatePolicyBean.setTermEndDate("2023-05-03 23:59:59");
    JSONObject updateRequest = JSONUtil.parseObj(updatePolicyBean);
    log.info("submitUpdate请求参数{}", updateRequest.toString());
    String updateGuaranteeInfo = portType.updateGuaranteeInfo(updateRequest.toString());
    log.info("submitUpdate响应参数{}", updateGuaranteeInfo);
  }
}
