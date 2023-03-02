package com.example.saasutil.service;

import static com.example.saasutil.util.RSAUtil.decrypt;
import static com.example.saasutil.util.RSAUtil.encrypt;

import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.util.RSAUtil_SaaS;
import java.util.Random;

/**
 * @program: boot-base
 * @description: RSA
 * @author: hushenggui
 * @create: 2021-11-03 17:48
 **/
public class RsaService {
  public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCz2nLfMhMjXoltHLsJ/LEzVJ5RM6QsfxKRoh416YBqTJGWy8I3ukzV+SPmMI1tkQAmmr9IBDMIZfB41dv33tqRStbGi7dsHy/NX2+V8kbyBe2zUjR+kap+04PLes6Q7U5FjDIRYB9F1NsuR3xp02yJxbdMVoRT5fK3AFTb8U/3HwIDAQAB";
  public static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALPact8yEyNeiW0cuwn8sTNUnlEzpCx/EpGiHjXpgGpMkZbLwje6TNX5I+YwjW2RACaav0gEMwhl8HjV2/fe2pFK1saLt2wfL81fb5XyRvIF7bNSNH6Rqn7Tg8t6zpDtTkWMMhFgH0XU2y5HfGnTbInFt0xWhFPl8rcAVNvxT/cfAgMBAAECgYBxNIfnixpWwfOYdWQZdi+HUrTQAcRNqbJjbnq7jn0g648cLqbR8vbYHBiHlHoAxCsnIXJS/ymsGJYTSPFLBL/ncm1VMcmslik1AIGaHXIfpdMm8yFjK7UmxJ+Pt49I9qLFy3q7LxAiiE8MwJQtULpLGCfzXU91kFD4Sfg5Cl9SGQJBAO40Oamih4OzQ7miLt64NWUpdBZxV/+HZiAQL843rLKMQKQi0eUZ2QBipgzJ6p7eQlYKyeRj9NsZL1xjYAdGgnMCQQDBSjyCd8zroYFaJggWo/KzTgz2vPL31mnOsx+cb3fkuIV9yuEqFoMzE4lquz91cnvflbMZOL+1AAPgfCewqtGlAkEAtvuXcCBSSXFkDS3xI1YObm+xpavcFYdFhEvq7VcHawEihvPYmU2JzSn6tMhHW1MRUldnT/MZHVXzc91C31Pi0QJAU1bPyi0fRMVpAVZ+jEx6G4denZAQbn2bN00SJyAEoLBSlk9AUCZOwVn+GO/NR7Vp5ZglFY3bUo5EHalKb6jnJQJAfIS/yO2Iv87moZBoVr+rRIrowvSqDKOfAG1tztUdfmj5KLy7eRcdNy64zAEB4lgG5jK/SxQJQsBqL0kgOrbkJQ==";


  public static void main(String[] args) {
    //String str = "{\"phone\":\"15029919573\",\"enterpriseInfoVo\":{\"creditCode\":\"911101123579518966\"},\"loginType\":\"EMBEDDED\",\"expireTime\":1655881333348}";
    //String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    //System.out.println(RSAUtil_SaaS.encrypt("2022-06-16 15:00:00", privateKey));
    //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+TaUwZdCVjfSpcH2SnnHZPTqWc0tUMUlX6zWSoe7otRFLEpRsBVUiGjor2hlBaouFd2lqV0Vvbp4JXO2OgvUitBElkTdUNX/8eGSwlIC1u2kRMCrXuMlSfY8f6PfOLj0GSCMbFc1qpXX/IPQ9dVPdSFHATr94LAVDzGjV3Gqc5wIDAQAB";
    //System.out.println(RSAUtil_SaaS.encryptPublic(str, publicKey));
    //String a = "zF9M97iOdYGPum1Nj9qp5sXthMvYcCBDeInAdNJhFaGV3yPU94vNl4GlJGBoduM/xdT9h2JyqIFg5kOZaheuzYvdM/USvPcGbv9KY42uFyVqu0mPSPiP+H2VqxFUcSTAvkXAty5td/h48TZodc2qy/Pn19vDBrsKOPEuyAN6WIQ=";
    //String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM6GF50mgaLrtsfOxyJsPqMq533A1ARBj0gtywxnrkCNjwPt4q7dc8jIlLt4FyrXDJ8kPsSp9THCn9YWYRfsd+UOjFapDDN10UqnOhbNrn7/UpIpoY9690bahtYSaW6bUIoETAuN/24eZUMAnrcLrRZo3j3+WDDbRDLwq/VLugV/AgMBAAECgYEAtlm7u+xmBn5uExpGxeQholydrXF3QpLIeojEgh2BxEm5f1SqFJBATYadnLG6cv8Si+mq6mbOsrMQAi4caM1IRgXbY4Dn46dmjx9bkvgPkC3z5HUUXDx6cGiGFxtW13NbjFgdUh1H6id93bF2nza1P6Uz9zvkBvA3WF35hRc+KXECQQD7Wfwb846EHM15PalhnWzVIGGN8/GSSM9FLG5Rv1iES7i4X/Lfem5WYXwMT1NBYJPDco5OwGfY41Pyf4+Q4PP9AkEA0lffR3TEe08CNclz1qyZvIiErYMfbnXxJqvDuLXS+gvDu+nJO4xRp5z5vHN8nKZcSbiuDLZ782N6iQ11wBJSKwJBAKD/IGbe+LhSoqI4BtiJt35EQXhleqSSkoDiVr9x6sbCoc0nWDAhAa++vXA9FzzXGY6lP9XdlCbuZYT8g/7uuBkCQEx4adI+n1f9B16qmJSJN3MVZrb2Hq03764RcBxs7gC92jEs813Uy7LWHOzoR3tj99VNcOlqRnHbzqaY4CAuCPUCPy1Uh//KcDCgmhjtSAjkUCtKMGZYN+cG8JWQIlGj8gxZ/5CxQ0E6cEWsaHNRQvn0/sahzYFBe4CInxHPxFSUYQ==";


    //String ss = RSAUtil_SaaS.encrypt("00006", privateKey);
   /*  String str = "VBJ3ASx0EzwHxheTgxnG9W8tg91Wu8f2sYSqpbqMguOkd2OV8l0tuWNdIa0n4o6eNnTrUFN3o4ru4sw9MoJUVgiYyy7eMxe5WpnNzYjnlGGr3g+d3OTXLpzYaEpldQQJL0+Y/HZTAnVbPDpLKOIdsBdRvUDDpK9j+q4VLMOXqbA=";
     System.out.println(RSAUtil_SaaS.decrypt(str, publicKey));*/
        //System.out.println("basicBankAccount>>>" + encrypt("", privateKey));
    String priveat =  encrypt("51050188083609123456", privateKey);
        System.out.println("name>>>" + priveat);
    System.out.println("name>>>" + decrypt(priveat, publicKey));
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
