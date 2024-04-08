package com.example.saasutil.service;

import com.example.saasutil.util.RSAUtil;

/**
 * @program: boot-base
 * @description: RSA
 * @author: hushenggui
 * @create: 2021-11-03 17:48
 **/
public class RsaBaseService1 {
  public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLImOdTrAzcBISTQd9yGkE3ix2vT5ztbgRHQ/wcIqXnDMMFyhUISuitmXACuhKu1bjJCtkUlohzzI+oQ9Ault0Tkrx7Q6RKYn2yeP0wRT+PlRc3GFwtVmFNwAjl8SN5wSuNZZcGTfjmKBOK9mvmHEVYK4yF0pJprWzkjGRTTcbYwIDAQAB";
  //永嘉生产key
  public static final String privateKey = "MIICXQIBAAKBgQDLImOdTrAzcBISTQd9yGkE3ix2vT5ztbgRHQ/wcIqXnDMMFyhUISuitmXACuhKu1bjJCtkUlohzzI+oQ9Ault0Tkrx7Q6RKYn2yeP0wRT+PlRc3GFwtVmFNwAjl8SN5wSuNZZcGTfjmKBOK9mvmHEVYK4yF0pJprWzkjGRTTcbYwIDAQABAoGBAK00iG3Ub6eccrxKFA4reWieLJmeaYbuNqHY/wNMYtA9bsVrZYa+td9K2V2zrzgxnzeUWq9zDMlxS21dlYzimiD91iPtACWXrXyAefb0abkJ9UEWuTccCBlRGmgVXBG72S0Q86Md3Wi8NqB96QB+3ahkJaI0KO5WHe6A5/BpDRfJAkEA/EE1r8f7U0khaAo42FL4aBZLXJ2kB60F9Tvnl0yPW4C51w2/QtfO4bBINraCsbZAWBzGVQOBr8B4BbSmh1+4fQJBAM4meobI5M7NzeRnArNAWwCOrHiFR/mHG87eHfpbVF1Cha7l1HD22nna84ZsEtbzmvfWaDWdpsT0DD6S9vtOSV8CQDR5WDKt1iE4KEPdRH/zmosEgD7O6C1Ul9Ww1XdKzNOLDp2m1W+RNw8JvavsAXn4YKAztCpBJXwq/IyrTK0Cg30CQD5/wfPtIhlkocBWTqZDo5NWrglX9ws6n/6mrpYBbGFd0qPEwBSDcpcw/1XInCmY72mmEi/3HOFnT/MEoWZtRKcCQQCDjdExIcNKXcOtcqnYCYzOd/naizfjF0bJr3D8+H0q0yO3sqLrXdE6DfyhFA6FV01+/2Pz1pI6bmwnAyXjTcZo";

  public static void main(String[] args) {
    //String str = "{\"phone\":\"15029919573\",\"enterpriseInfoVo\":{\"creditCode\":\"911101123579518966\"},\"loginType\":\"EMBEDDED\",\"expireTime\":1655881333348}";
    //String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    //System.out.println(RSAUtil_SaaS.encrypt("2022-06-16 15:00:00", privateKey));
    //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+TaUwZdCVjfSpcH2SnnHZPTqWc0tUMUlX6zWSoe7otRFLEpRsBVUiGjor2hlBaouFd2lqV0Vvbp4JXO2OgvUitBElkTdUNX/8eGSwlIC1u2kRMCrXuMlSfY8f6PfOLj0GSCMbFc1qpXX/IPQ9dVPdSFHATr94LAVDzGjV3Gqc5wIDAQAB";
    //System.out.println(RSAUtil_SaaS.encryptPublic(str, publicKey));
    //String a = "zF9M97iOdYGPum1Nj9qp5sXthMvYcCBDeInAdNJhFaGV3yPU94vNl4GlJGBoduM/xdT9h2JyqIFg5kOZaheuzYvdM/USvPcGbv9KY42uFyVqu0mPSPiP+H2VqxFUcSTAvkXAty5td/h48TZodc2qy/Pn19vDBrsKOPEuyAN6WIQ=";
    //String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM6GF50mgaLrtsfOxyJsPqMq533A1ARBj0gtywxnrkCNjwPt4q7dc8jIlLt4FyrXDJ8kPsSp9THCn9YWYRfsd+UOjFapDDN10UqnOhbNrn7/UpIpoY9690bahtYSaW6bUIoETAuN/24eZUMAnrcLrRZo3j3+WDDbRDLwq/VLugV/AgMBAAECgYEAtlm7u+xmBn5uExpGxeQholydrXF3QpLIeojEgh2BxEm5f1SqFJBATYadnLG6cv8Si+mq6mbOsrMQAi4caM1IRgXbY4Dn46dmjx9bkvgPkC3z5HUUXDx6cGiGFxtW13NbjFgdUh1H6id93bF2nza1P6Uz9zvkBvA3WF35hRc+KXECQQD7Wfwb846EHM15PalhnWzVIGGN8/GSSM9FLG5Rv1iES7i4X/Lfem5WYXwMT1NBYJPDco5OwGfY41Pyf4+Q4PP9AkEA0lffR3TEe08CNclz1qyZvIiErYMfbnXxJqvDuLXS+gvDu+nJO4xRp5z5vHN8nKZcSbiuDLZ782N6iQ11wBJSKwJBAKD/IGbe+LhSoqI4BtiJt35EQXhleqSSkoDiVr9x6sbCoc0nWDAhAa++vXA9FzzXGY6lP9XdlCbuZYT8g/7uuBkCQEx4adI+n1f9B16qmJSJN3MVZrb2Hq03764RcBxs7gC92jEs813Uy7LWHOzoR3tj99VNcOlqRnHbzqaY4CAuCPUCPy1Uh//KcDCgmhjtSAjkUCtKMGZYN+cG8JWQIlGj8gxZ/5CxQ0E6cEWsaHNRQvn0/sahzYFBe4CInxHPxFSUYQ==";


    String ss = RSAUtil.encrypt("江苏仪征农村商业银行股份有限公司马集支行", privateKey);
    System.out.println(ss);
    String sign = "eG2khKAkOaDWO2/0e6HrkcAeyZKJDzvDdRZ58JmEF7CDI2JJprfrvoKc71tyP3Q/uOmbK4i5261xKz1xCLSG5047sehZApYJao3rl5Z5c5oDNtG3sb3D47hEF+5HTzVcUsDhyNbZWQtep2X+TUIKxi4++8JUTxWZh42S+rZwgLk=";
    System.out.println(RSAUtil.decrypt(sign, publicKey));
   /*  String str = "VBJ3ASx0EzwHxheTgxnG9W8tg91Wu8f2sYSqpbqMguOkd2OV8l0tuWNdIa0n4o6eNnTrUFN3o4ru4sw9MoJUVgiYyy7eMxe5WpnNzYjnlGGr3g+d3OTXLpzYaEpldQQJL0+Y/HZTAnVbPDpLKOIdsBdRvUDDpK9j+q4VLMOXqbA=";
     System.out.println(RSAUtil_SaaS.decrypt(str, publicKey));*/
    /* String salt = "GiJpM/sctTS0CtPpYc8Xvn8ZY/ji0bcBKD4CjMVOJd14vzLNlA37uE7MFZZA0vAdhe/s1aAogdqZ5HUKeWySD74xhNdjmDvhZ/1lDq+/bXsiubUOZIuq8zCUobrc1FBZ5PupRWrLNQTnmDf3eU6e9XRX+AKlioMqE3Js8vTeUDg=";
     System.out.println("name>>>" + RSAUtil.decrypt(salt, publicKey));*/

    //System.out.println("key>>>" + RSAUtil.encrypt("2023-04-27 10:10:10 ", privateKey));
    //System.out.println("2023-12-09 14:00".length());

       // System.out.println("code>>>" + decrypt("bf7zE8NVa4UBN3KH5ejChIwXLSQQYs7Z67SeMwWQYKar+1rut0P0+hHgs/0r5nt0NF6VNLYZw0Bg8/O3mJwmmfn51yxjO5i77R5PWENu1I6+rMDjCZuSpg2CO8UklvSmV1igKOy7OcHnjl1wzUKjeBzGHaed4IITsomSivIg7Yw=", publicKey));
        //System.out.println("code>>>" + encrypt("E6101123506AP85qMfGf003", privateKey));

    //System.out.println(">>>" + encrypt("BQvw+mK7WH0i4FH4gQ5Of5nRaDWs9UA8DASk4cjreGE=", privateKey));
/*    System.out.println(">>>" + decrypt("ExJQ6LkCwuSoveo3Q3NR+AgxJawPMRW8YU6QzSsqGIkOFYB/fnw2p5U/qaUe03xBY5T8r0mO/GDtpBPOqMRYiYF29nuw6QEbN2vS7WSX3pQPp6xickzL0elmB8JCnS//D72FwePcG24/nncGBmhWswMeR944hFfmjppnbVwN0ng=", publicKey));
    System.out.println(">>>" + decrypt("D2nkU0V6WCRFa+Z4u/9q8NNYBDTjT5h1MaPfkZABTCe5HXwOxjG39MjKUxa6bvGC6M5I5Gfc9J6aYSDQ7FFr4REyPYk/faKRFxIIZn79hsU1LDaYt8TQwv9rhrsAgDrBed1uDeJijMgZvwbQxbBIX/Y3mSjOadoC4r6fH01VfM0=", publicKey));*/

   // System.out.println(encrypt("gHXWAp+jgPBMDmCABCvxNU8m/H8LG79jnhL+A2emreJpuEuv7EtbAElOdANGsoQ/Xs3kAUMS33v/nXILDdrWo0SDoSJLcq3kqI014s8FaZ+KPa11BeaoNbgjAugqb+vhtTFSWGfI1afKAmZxmIdIzpsYOTe6zDt4tJi5ZNvkP1w=", privateKey));

   /* String s1 = "lAq9ExC54Eh+UvpBYH0iW/VOIMaCgCGj/tx7x7BkcE3+AZRYYD4/hTT8R0I8DiLBGc2AIUgXF38mVOOkfS/KgP72Fl5y/ZS4aF5wVu41lEYG9uj7tO23ubGvoBcjYBRnr9idwduZWpxpIMSu7p+6KReT/QTB2oeB3VsUJM4v4Ks=";
    String s2 = "lAq9ExC54Eh+UvpBYH0iW/VOIMaCgCGj/tx7x7BkcE3+AZRYYD4/hTT8R0I8DiLBGc2AIUgXF38mVOOkfS/KgP72Fl5y/ZS4aF5wVu41lEYG9uj7tO23ubGvoBcjYBRnr9idwduZWpxpIMSu7p+6KReT/QTB2oeB3VsUJM4v4Ks=";
    System.out.println(s1.equals(s2));*/

    /*Random ran = new Random();
    Integer weight = ran.nextInt(999999);
    String salt = RSAUtil.encrypt(String.valueOf("12610100791694474Y"), privateKey);
    System.out.println(salt);
    String ss = "r3Jcix5qLBSs/Ukq9QxY/qihwHp1ymMkHk9blmQfgNnD78cXjELbtQxEyRP4ltmnKJ/RhNhjYZ1jOU0rWLDCjRwMU+oKRSn9pooB/voHpDD5CzXPgnzZoXBjV4I3fAzLj18LDmZwQsiA1O2zPKUi1Q/wtboX31SfEr7goT7dxfMhBzD1/UacDpc5YaVEsjj8NA1BAE1QCRVUVWMpgMTGwayMLwl25/pPNu0T6VO+xiHrUPJIMFhBtF3jofBLiWBshdXRUDHk9VUkWRoAjjaOUDiDPIJDTKOpTAJ/ADilvoj8jdv0safJG+wtvxDOYudW23eKaTWlHMpKIr3ZY8vArg==";
    System.out.println(RSAUtil_SaaS.decrypt(ss, publicKey));*/
  }

}
