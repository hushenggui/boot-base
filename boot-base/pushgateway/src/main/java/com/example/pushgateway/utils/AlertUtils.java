package com.example.pushgateway.utils;

import com.example.pushgateway.dto.AlterDto;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import lombok.Synchronized;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @program: saas
 * @description: 预警工具类
 * @author: hushenggui
 * @create: 2021-03-23 16:22
 **/
public class AlertUtils {

    @Synchronized
    public static long increment(StringRedisTemplate stringRedisTemplate, String redisKey) {
        return stringRedisTemplate.opsForValue().increment(redisKey);
    }

    @Synchronized
    public static long decrement(StringRedisTemplate stringRedisTemplate, String redisKey) {
        return stringRedisTemplate.opsForValue().decrement(redisKey);
    }

    /**
    * @Description: 生成预警Md5数据
    * @Param: [alterDto]
    * @return:
    * @Author: hushenggui
    * @Date: 2021/3/23
    */
    public static String getMd5Str(AlterDto alterDto){
        StringBuffer sb = new StringBuffer();
        sb.append("webhook_redisKey_");
        sb.append(alterDto.getOrderSerialNo());
        sb.append(alterDto.getOrderNo());
        sb.append(alterDto.getPolicyNo());
        sb.append(alterDto.getErrorCode());
        sb.append(alterDto.getAlertLevel());
        sb.append(alterDto.getAlertTimes());
        try {
            String result = Md5Util.MD5(sb.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return UUIDGenUtil.createUUID();
        }
    }

    public static String getMd5StrWebHook(AlterDto alterDto){
        StringBuffer sb = new StringBuffer();
        sb.append("webhook_redisKey_");
        sb.append(alterDto.getOrderSerialNo());
        sb.append(alterDto.getOrderNo());
        sb.append(alterDto.getPolicyNo());
        sb.append(alterDto.getErrorCode());
        sb.append(alterDto.getAlertLevel());
        try {
            String result = Md5Util.MD5(sb.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return UUIDGenUtil.createUUID();
        }
    }


    public static String getMd5Str(Map<String, Object> lables){
        StringBuffer sb = new StringBuffer();
        sb.append("webhook_redisKey_");
        sb.append((String)lables.get("orderSerialNo"));
        sb.append((String)lables.get("orderNo"));
        sb.append((String)lables.get("policyNo"));
        sb.append((String)lables.get("errorCode"));
        sb.append((String)lables.get("alertLevel"));
        try {
            String result = Md5Util.MD5(sb.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return UUIDGenUtil.createUUID();
        }
    }


    public static String getMd5StrLabels(Map<String, Object> lables){
        StringBuffer sb = new StringBuffer();
        sb.append("labels");
        if(ObjectUtils.isEmpty(lables.get("orderSerialNo"))){
            sb.append("");
        }else{
            sb.append((String)lables.get("orderSerialNo"));
        }

        if(ObjectUtils.isEmpty(lables.get("orderNo"))){
            sb.append("");
        }else{
            sb.append((String)lables.get("orderNo"));
        }

        if(ObjectUtils.isEmpty(lables.get("policyNo"))){
            sb.append("");
        }else{
            sb.append((String)lables.get("policyNo"));
        }
        sb.append((String)lables.get("errorCode"));
        sb.append((String)lables.get("alertArea"));
        try {
            String result = Md5Util.MD5(sb.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return UUIDGenUtil.createUUID();
        }
    }

    public static boolean isTime(){
        long start = getMillisOfSet(new Date().getTime(),8,0,0);
        long end = getMillisOfSet(new Date().getTime(),18,0,0);
        if(new Date().getTime() >= start && new Date().getTime() <= end){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Description: 获取指定时间戳当天指定的小时分钟的时间戳
     * @Param: [millis, hour, minute, second]
     * @return:
     * @Author: hushenggui
     * @Date: 2020/8/11
     */
    public static long getMillisOfSet(long millis, int hour, int minute,int second)
    {
        long milliSecond= millis% 1000L;
        millis= millis/ 1000L * 1000L;

        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        long millisOfNextHour= calendar.getTimeInMillis()+ milliSecond;
        return millisOfNextHour;
    }

    public static String getSubString(String str){
        if(StringUtils.isEmpty(str)){
            return "";
        }
        if(str.length() > 400){
            String res = str.substring(0, 398);
            return res;
        }
        return str;
    }

    public static void main(String[] args) {
        String temp = "{\"updateDate\":\"2021-06-22 10:37:50\",\"responseBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n\\n<insureResponse>\\n  <responseHead>\\n    <requestUUID>2874a0c2-cff3-4dd7-a701-1c32d8bde092</requestUUID>\\n    <sign>34e00238f9ec3709385aefaf1e057b4e</sign>\\n  </responseHead>\\n  <responseBody>\\n    <responseTime>2021-06-22 10:37:50:744</responseTime>\\n    <resultFlag>false</resultFlag>\\n    <resultMessage>联共保中的保费不能低于1分钱</resultMessage>\\n<proposalNo></proposalNo>\\n  </responseBody>\\n</insureResponse>\\n\",\"alertArea\":\"wulumuqi\",\"cityCode\":\"650100\",\"errorCode\":\"IC00001\",\"orderSerialNo\":\"1019910650100202106221037294392\",\"policyNo\":\"\",\"content\":\"{\\\"id\\\":\\\"0b09664f-482b-4f7e-a67a-b3ab1db2ec00\\\",\\\"serialNo\\\":\\\"1019910650100202106221037294392\\\",\\\"orderNo\\\":\\\"TEST-TBaoHanGB20210622103729702\\\",\\\"bidSectionInfoId\\\":\\\"780dc1fe-aa19-45e2-ab03-175939e23c6b\\\",\\\"paymentId\\\":\\\"\\\",\\\"node\\\":\\\"ORDER_WAIT\\\",\\\"status\\\":\\\"ORDER_WAIT\\\",\\\"message\\\":\\\"\\\",\\\"businessType\\\":\\\"经纪业务\\\",\\\"createDate\\\":1624329450000,\\\"updateDate\\\":1624329453000,\\\"delete\\\":false,\\\"cityCode\\\":\\\"650100\\\",\\\"orderSource\\\":\\\"乌鲁木齐市工程投标保证金电子保函（保证保险）系统\\\",\\\"channel\\\":1,\\\"guaranteeType\\\":\\\"GUARANTEE\\\",\\\"guaranteeTypeName\\\":\\\"保证保险\\\",\\\"phone\\\":\\\"15026994738\\\",\\\"rowId\\\":1277,\\\"ext\\\":\\\"{\\\\\\\"confirm\\\\\\\":true}\\\",\\\"bidSectionInfo\\\":{\\\"id\\\":\\\"780dc1fe-aa19-45e2-ab03-175939e23c6b\\\",\\\"amount\\\":1.00,\\\"bidName\\\":\\\"iUUta6jT+3GT+E9DwswH4KLr4jqnwJXUio0MzwsEXrpRiPsMDnQBBsP3BEV3HQzzJdKopDWwPA878XQa3BL9x/Eb5w4N0EctdHhnRcHKQts=\\\",\\\"bidCode\\\":\\\"CXGw3yu81t8zX0gpEi92EbwGv14Y/QoyzzPTm46tVkk=\\\",\\\"projectInfoId\\\":\\\"27407e24-7d14-4437-87be-890141990794\\\",\\\"bidOpenTime\\\":null,\\\"bidCloseTime\\\":null,\\\"tenderDay\\\":60,\\\"fileId\\\":\\\"0\\\",\\\"publishStatus\\\":true,\\\"status\\\":false,\\\"publishDate\\\":null,\\\"verifyCode\\\":\\\"982751\\\",\\\"payStartDate\\\":null,\\\"payEndDate\\\":null,\\\"bidStartDate\\\":null,\\\"bidEndDate\\\":null,\\\"createDate\\\":1624329450000,\\\"updateDate\\\":1624329453000,\\\"delete\\\":false,\\\"tendereeUserInfoId\\\":\\\"2ad65163-08ab-4879-b4ca-83634d689c40\\\",\\\"bidderUserInfoId\\\":\\\"5c5d1075-eb7d-456c-99a7-38fed03acff5\\\",\\\"cityCode\\\":\\\"650100\\\",\\\"quitType\\\":null,\\\"quitDate\\\":null,\\\"salt\\\":\\\"zF9M97iOdYGPum1Nj9qp5sXthMvYcCBDeInAdNJhFaGV3yPU94vNl4GlJGBoduM/xdT9h2JyqIFg5kOZaheuzYvdM/USvPcGbv9KY42uFyVqu0mPSPiP+H2VqxFUcSTAvkXAty5td/h48TZodc2qy/Pn19vDBrsKOPEuyAN6WIQ=\\\",\\\"rowId\\\":1242,\\\"cancelType\\\":null,\\\"ext\\\":null,\\\"projectInfo\\\":{\\\"id\\\":\\\"27407e24-7d14-4437-87be-890141990794\\\",\\\"projectName\\\":\\\"iUUta6jT+3GT+E9DwswH4KLr4jqnwJXUio0MzwsEXrpRiPsMDnQBBsP3BEV3HQzzJdKopDWwPA878XQa3BL9x/Eb5w4N0EctdHhnRcHKQts=\\\",\\\"projectCode\\\":null,\\\"projectType\\\":1,\\\"projectTypeName\\\":null,\\\"createDate\\\":1624329450000,\\\"updateDate\\\":1624329453000,\\\"delete\\\":false,\\\"cityCode\\\":\\\"650100\\\",\\\"rowId\\\":1307,\\\"ext\\\":null,\\\"salt\\\":null,\\\"application\\\":null},\\\"tendereeUserInfo\\\":{\\\"id\\\":\\\"2ad65163-08ab-4879-b4ca-83634d689c40\\\",\\\"name\\\":\\\"uJl6qFrsy6ArBuMFhfhqy6zxPimPaoxbauPteJLZcZQ=\\\",\\\"creditCode\\\":\\\"TYi3ozGkMDouUHngcRW1+GihBhCvO4ULwtuc0ldur+A=\\\",\\\"contact\\\":null,\\\"contactAddress\\\":null,\\\"address\\\":null,\\\"telephone\\\":null,\\\"phone\\\":null,\\\"basicBankAccount\\\":null,\\\"basicBankName\\\":null,\\\"basicAccountName\\\":null,\\\"basicFileId\\\":null,\\\"createDate\\\":1624329450000,\\\"updateDate\\\":1624329449000,\\\"delete\\\":false,\\\"cityCode\\\":\\\"650100\\\",\\\"userType\\\":\\\"0\\\",\\\"type\\\":\\\"TENDERER\\\",\\\"status\\\":null,\\\"salt\\\":\\\"qFOjjZklU90L29HIx0z4ysEMTIz9czM/J5sSwImBpQPDUxpTZJ3sISSA7ixwt+3XVtTEKFutpMJJBrL8F/AnIy2EtWn9SIq1U2nnhm+s+r0vUMlTK18JVCCaaZLNjgZzwv/DAt4ePVLefbvNq544iapyhvfD1dasyorMKh5+QfM=\\\",\\\"rowId\\\":2528,\\\"ext\\\":null,\\\"basicFile\\\":null,\\\"application\\\":null,\\\"email\\\":null,\\\"caSerialNo\\\":null,\\\"caStartDate\\\":null,\\\"caEndDate\\\":null,\\\"caAuthor\\\":null,\\\"srcData\\\":null,\\\"signData\\\":null,\\\"certData\\\":null,\\\"certificateSN\\\":null},\\\"bidderUserInfo\\\":{\\\"id\\\":\\\"5c5d1075-eb7d-456c-99a7-38fed03acff5\\\",\\\"name\\\":\\\"工保科技（浙江）有限公司\\\",\\\"creditCode\\\":\\\"91430105MA4Q4UU10E\\\",\\\"contact\\\":null,\\\"contactAddress\\\":null,\\\"address\\\":null,\\\"telephone\\\":null,\\\"phone\\\":\\\"15026994738\\\",\\\"basicBankAccount\\\":\\\"36888123455566442\\\",\\\"basicBankName\\\":\\\"兴业银行股份有限公司上海大华支行\\\",\\\"basicAccountName\\\":\\\"工保科技（浙江）有限公司\\\",\\\"basicFileId\\\":\\\"7a258973-588d-4ba4-b5ad-2a0ccd8d0f8c\\\",\\\"createDate\\\":1624329450000,\\\"updateDate\\\":1624329455000,\\\"delete\\\":false,\\\"cityCode\\\":\\\"650100\\\",\\\"userType\\\":\\\"0\\\",\\\"type\\\":\\\"BIDDERS\\\",\\\"status\\\":null,\\\"salt\\\":\\\"uQTdf6b1OyVRoUmGLNZbI4oYaquQn37S4n/kZ7odDJvSuPjMELsSBww/Lid6vZ/58+Ehn9SgPEoFINE3/gpNUmmhebIsDnhUNDUWb60+d3wMpaXxhe61Y+MBmKf3731JnF2XLIssX9YzLKPL3Jp9W/DgO+WrUD2HlWGneYkGAac=\\\",\\\"rowId\\\":2529,\\\"ext\\\":null,\\\"basicFile\\\":{\\\"id\\\":\\\"7a258973-588d-4ba4-b5ad-2a0ccd8d0f8c\\\",\\\"name\\\":\\\"WechatIMG10.png\\\",\\\"md5\\\":null,\\\"downloadUrl\\\":\\\"/upload/20201217_3555411AD7CE44E98DBF625BB4DC019D.png\\\",\\\"createDate\\\":1608170631000,\\\"updateDate\\\":1608170630000,\\\"delete\\\":false,\\\"cityCode\\\":\\\"650100\\\",\\\"rowId\\\":774,\\\"ext\\\":null,\\\"application\\\":null,\\\"gongBaoDownloadUrl\\\":null},\\\"application\\\":null,\\\"email\\\":null,\\\"caSerialNo\\\":null,\\\"caStartDate\\\":null,\\\"caEndDate\\\":null,\\\"caAuthor\\\":null,\\\"srcData\\\":null,\\\"signData\\\":null,\\\"certData\\\":null,\\\"certificateSN\\\":null},\\\"application\\\":null},\\\"payment\\\":{\\\"id\\\":null,\\\"amount\\\":1.00,\\\"premium\\\":0.01,\\\"minPremium\\\":null,\\\"insuranceRate\\\":0.80,\\\"type\\\":\\\"OFFLINE\\\",\\\"systemType\\\":\\\"PAY_PLATFORM\\\",\\\"accountName\\\":null,\\\"bankAccount\\\":null,\\\"payDate\\\":null,\\\"bankName\\\":null,\\\"status\\\":\\\"PAY\\\",\\\"node\\\":null,\\\"message\\\":null,\\\"basic\\\":null,\\\"goodsDescription\\\":null,\\\"insCode\\\":\\\"00005\\\",\\\"insName\\\":\\\"中国大地财产保险股份有限公司\\\",\\\"dealCode\\\":null,\\\"tradeCode\\\":null,\\\"memo\\\":null,\\\"proposalNo\\\":null,\\\"payAmount\\\":0.01,\\\"dealAmount\\\":null,\\\"payUrl\\\":null,\\\"brokerage\\\":0.00,\\\"refundReason\\\":null,\\\"refundDate\\\":null,\\\"refundBrokerage\\\":null,\\\"refundAmount\\\":null,\\\"refundType\\\":null,\\\"createDate\\\":null,\\\"updateDate\\\":null,\\\"delete\\\":false,\\\"cityCode\\\":null,\\\"salt\\\":null,\\\"rowId\\\":null,\\\"ext\\\":null,\\\"application\\\":null,\\\"orderSerialNo\\\":null,\\\"policyNo\\\":null,\\\"logVo\\\":null,\\\"payStatus\\\":null,\\\"mobile\\\":null,\\\"orderNo\\\":null,\\\"newPaymentPlatform\\\":null,\\\"paymentNotAllow\\\":null},\\\"application\\\":\\\"wulumuqi\\\",\\\"insCode\\\":\\\"00005\\\",\\\"insName\\\":\\\"中国大地财产保险股份有限公司\\\",\\\"policySerialNo\\\":null,\\\"policyInfo\\\":null,\\\"refundSerialNo\\\":null,\\\"policyRefundInfo\\\":null,\\\"insuranceBasicInfoVo\\\":null,\\\"chainInfoList\\\":[],\\\"confirmOrder\\\":false}\",\"alertLevelName\":\"严重告警\",\"result\":\"false\",\"cityName\":\"乌鲁木齐市\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?>\\n<insureRequest>   <requestHead>  <requestUUID>650100-A2293893C6744DC8974D8A9BFD293BD0</requestUUID>      <sign>CA3C3AD7900461DACAD035EA40B358A6</sign>   </requestHead>    <requestBody>     <applicantInfo>       <name>工保科技（浙江）有限公司</name>        <mobile>15026994738</mobile>        <idNumber>91430105MA4Q4UU10E</idNumber>        <ProjectName>098F6BCD462</ProjectName>    <ProjectType>1</ProjectType>        <BidSectionCode>098F6BCD462</BidSectionCode>        <TendereeName>098F6BCD462</TendereeName>        <TendereeCode>098F6BCD462</TendereeCode>        <TendereeAddress>098F6BCD462</TendereeAddress>      <TendereeContactPhoneNumber>098F6BCD462</TendereeContactPhoneNumber>     </applicantInfo>  <dateInfo>    <startDate>2021-06-23 00:00:00</startDate>       <endDate>2021-10-20 23:59:59</endDate>     </dateInfo>       <policyInfo>       <sumPremium>0.01</sumPremium>        <sumAmount>1.00</sumAmount>       <endorseText>一、本特别约定，作为投标保证保险保单的有效组成部分，与保险合同、保单或其它保险凭证具有同等法律效力。二、保险单生效时间为投保项目投标截止时间，保险期间为投保项目《招标文件》中载明的投标有效期。三、投保人违反所投项目《招标文件》规定要求导致投标保证金不予退还或罚没情形的均属于本保单保险责任。四、退保处理1.开标前投保人自愿放弃投保或项目发生中止、暂停的，可进行退保；2.开标前项目发生流标、终止的，可进行退保；3.开标后项目发生流标的，可进行退保；4.除上述 3 种情形外均不予退保。5.投保人办理退保事宜，满足退保条件的，保险费全额退还。五、线下理赔材料提供如下：1.索赔申请书；2.招标文件和投标文件；3.投保人违约证明材料。六、保险公司应在收到索赔申请书和相关材料后 10 个工作日内完成理赔。七、保险人向被保险人赔偿后，保险人享有向投保人追偿的权利。八、项目类型：建设工程</endorseText>     </policyInfo>   </requestBody> </insureRequest>\",\"alertName\":\"保险公司_投保\",\"requestUrl\":\"https://mule-iopen-uat.ccic-net.com.cn/gongbao/v1/proposal\",\"@version\":\"1\",\"alertTimes\":1.0,\"id\":\"oPKUMXoB_ZQKuUmgw0KS\",\"alertTime\":\"2021-06-22 10:37:50\",\"createDate\":\"2021-06-22 10:37:50\",\"traceId\":\"0cc35525-d892-44d0-9fc2-9f8ab316ec98\",\"requester\":\"\",\"alertStatusName\":\"\",\"alertType\":\"POLICY\",\"orderNo\":\"TEST-TBaoHanGB20210622103729702\",\"receiver\":\"中国大地财产保险股份有限公司\",\"alertSource\":\"电子保函\",\"alertLevel\":\"SEVERE\",\"tradeCode\":\"\",\"alertIp\":\"gbj_test02/172.16.76.53\",\"tags\":[\"monitor\"],\"@timestamp\":\"2021-06-22 10:37:50\",\"application\":\"IC_SERVICE\"}";
        Map<String, Object> map = JacksonUtils.jsonString2Obj(temp, Map.class);
        System.out.println(getMd5StrLabels(map));


        String temp1 = "{\"alertArea\":\"wulumuqi\",\"alertLevel\":\"HIGH\",\"alertSource\":\"电子保函\",\"alertname\":\"HIGH-ALERT\",\"cityName\":\"乌鲁木齐市\",\"detailInfo\":\"0cc35525-d892-44d0-9fc2-9f8ab316ec98\",\"emailCode\":\"EM000001\",\"errorCode\":\"IC00001\",\"group\":\"saas_agent\",\"instance\":\"1019910650100202106221037294392\",\"job\":\"huadong\",\"orderNo\":\"TEST-TBaoHanGB20210622103729702\",\"orderSerialNo\":\"1019910650100202106221037294392\",\"pushGatewayAddress\":\"172.16.76.69:9091\",\"status\":\"High\",\"team\":\"operations\",\"traceId\":\"0cc35525-d892-44d0-9fc2-9f8ab316ec98\",\"id\":\"8ce18d22d08a49f68c6451ccd7b44808\"}";
        Map<String, Object> map1 = JacksonUtils.jsonString2Obj(temp1, Map.class);
        System.out.println(getMd5StrLabels(map1));
    }
}
