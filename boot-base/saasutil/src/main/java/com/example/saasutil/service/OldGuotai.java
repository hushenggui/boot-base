package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;

/**
 * @program: boot-base
 * @description: 老国泰
 * @author: hushenggui
 * @create: 2021-06-29 17:17
 **/
public class OldGuotai {

  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<root>\n"
        + "    <body>\n"
        + "        <BidSectionCode>p3Szu8ka4w72w1setJXfTssmR1OimuYTrV3fJav7ptA=</BidSectionCode>\n"
        + "        <RequestId>2008</RequestId>\n"
        + "        <BidderCode>91620521MA74N4KX7T</BidderCode>\n"
        + "        <ProjectName>a4Da73jnCV1k5ebwBNrLCVMtX9rGf02oR/urIA7LBAGwJNrWgleCiZPc67EjFheA686bU5ZXUb5kBlNcmk4R37Xw7uTvpcRpsa5kCd7RUhPCEwr2zdq2Zl2qyTh0o8CbTSpQjsYiLgQAvb1H9nGxID1h9lFnPAWereFwwEYcxkw=</ProjectName>\n"
        + "        <TendereeName>mfvLvNeHnIDRGkdACaIRYW8BGj54gQRPmxF+kgirOtwZTGzL9W6tu4s43TUmiKVh</TendereeName>\n"
        + "        <TendereeAddress>PWH2UWc8BZ6t4XDARhzGTA==</TendereeAddress>\n"
        + "        <TendereeContactPhoneNumber>xRwqFeDp9Zzqcflz+Hr3wA==</TendereeContactPhoneNumber>\n"
        + "        <Amount>19000.0</Amount>\n"
        + "        <OrderNo>TS20211201DB67SH333</OrderNo>\n"
        + "        <OpenTime>2021-12-08 09:30:00</OpenTime>\n"
        + "        <InsuranceCode>91440300100012316L</InsuranceCode>\n"
        + "        <TendereeCode>oe4Z3Sow+Z3pnD9myYc9zGZy7waa68jV91gDa0SiYHA=</TendereeCode>\n"
        + "        <BidderName>天水轩通建筑工程有限公司</BidderName>\n"
        + "        <Bidtender>90</Bidtender>\n"
        + "        <CloseTime>2021-12-08 09:30:00</CloseTime>\n"
        + "        <IsCALogin>1</IsCALogin>\n"
        + "    </body>\n"
        + "    <Sign>0b3ece90cab6803c2d60bbb81b46535f</Sign>\n"
        + "</root>";

    String key = "bCsOgA3Py48necNPY4o2/Q==";
    System.out.println(SignUtil.sign(xml, "Sign","body", key));
  }

}
