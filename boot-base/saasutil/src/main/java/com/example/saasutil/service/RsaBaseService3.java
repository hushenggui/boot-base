package com.example.saasutil.service;

import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.util.RSAUtil_SaaS;

/**
 * @program: boot-base
 * @description: RSA
 * @author: hushenggui
 * @create: 2021-11-03 17:48
 **/
public class RsaBaseService3 {
  public static final String privateKey = "MIICXAIBAAKBgQCbifH0iHtYQ7xkaBRxr5dMxpDAwh7qDLZl383XCs8tV0E/OqrwOEH+mJmlam7X+KGcb3pFJtnOpSCdST56HRu7NgdET2o06+7sCUqoZximDanoquPZFc+G94/EE8bEhx/pz+HZUF+X2SqH87tz03/sPq7JAJSF1VswbQ+fefRs6wIDAQABAoGAElYKzhcg42Do3rVeY6Cdp5FpEzBPUKw6/HuL2qQNlHzK1ldmO3eGYCtBQbzwYEmRU83YjjpsRu40kBZIZUD1OcesUHkD2c2js7ywAk6xvHfe0I36bseYsHbp3FhrzVrr0i8oBikHytTCi2Z8QcA4ZNlzzq55KODlJM2Z82fJLsECQQDN/lnjBW9XJJioWxW8Ucourxc525o1zuWcXFCgWOCvy5DC3IEwgWQS6wA+vSvH29sYtQ7qI45K856+bVSgf087AkEAwUwKyQcr/B8KAVEnwC4zfh3+R6WtaXanmUjyahSQ2PJ/QZDdW6UVEr5/Y6Aas39Rb2FvQoQS+XjPJ+HxubHeEQJBAIWD7OL2rNoAwGmu0AHFyZRErHs12VgzCCQ2uZOUx91pxiRnI906oJCafQgtOOlLmVEEWexsq1ftW+D1oDp/Ce0CQEAPy6NEVTeBsfctxlbS+Q3bMuLb7dT+Fh2fJ3gwyLCd7b71G+e7lnhX2jBSZ4cFsx+O0yjgTMmRWFaHc21vnYECQF6hMcS0Rhgf4/dC8rA03nBFE5IhoB/GTtiaK5ColvMatpyAVdnf96tofaXAzyPlIk0TOApoYVWdEx+tYyY+cBg=";
  public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbifH0iHtYQ7xkaBRxr5dMxpDAwh7qDLZl383XCs8tV0E/OqrwOEH+mJmlam7X+KGcb3pFJtnOpSCdST56HRu7NgdET2o06+7sCUqoZximDanoquPZFc+G94/EE8bEhx/pz+HZUF+X2SqH87tz03/sPq7JAJSF1VswbQ+fefRs6wIDAQAB";


  /**
   * 和田生产
   * @param
   */
  //public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5tWaB6/KE8vx7QAW99AAb7JjF+UQbRAW87YxtLIOlbmWDtREVO6iDQ5giuIFjqMOKSGpW4y9v6Y/iHN2lMNmRruGDq+lBpHR6fRvz4ScWCbmPnLUOyVo9wHzNLXuxzLEyoiniaN9HcejrqgNt2+IveDc3sOJ2y5swW/NQP3W1AwIDAQAB";
  //public static final String privateKey = "MIICXAIBAAKBgQC5tWaB6/KE8vx7QAW99AAb7JjF+UQbRAW87YxtLIOlbmWDtREVO6iDQ5giuIFjqMOKSGpW4y9v6Y/iHN2lMNmRruGDq+lBpHR6fRvz4ScWCbmPnLUOyVo9wHzNLXuxzLEyoiniaN9HcejrqgNt2+IveDc3sOJ2y5swW/NQP3W1AwIDAQABAoGASGTazRL5u7Itkq5mjqIr2Lbm52ZAkpB13CyObZDI0Ri0Ih/XxPs4udMD36Ula4BCmgmYyr5No8bc/DxceyUL6wCuvtx+DSKFcMyPbTdF5TjL3CDtqT/Sm/UgiY5ecR3kEWbxECRvJwKdwFk/mezHAQ1HfBBeT7RQnxOYRTrliEECQQDie+Tysi9LOja5u3hdrmsh6ndCvBdLrUF1YtJdboW/eXz/ejckA6AI5VYrjb5soIAIlA0ABpZ3aME6ijeKgsUbAkEA0ekht5pMBRxpLd72LPwMrVwDGbQ+0is0P+nvcMcnre6l7vn9OHCaICNrQhj8Og8qFRaMNd2E1jfFYjBK+i6WOQJBALhqkb5dAM2MlUsfL594ipuPQ5T/eyiP5yEiWpDhkd6bmgCdD5EvsnwL4eKNBGWHOznA8+T1eEe68LwuF5Odb8kCQHWgs8FEWLdAfXw0BjWdJKl890vPIqj5hvUN7ZyALa8dHaU2N30KNIQv9On8QFN0rftVQErrEIZOiHCGaW2a75kCQBxxOYAl1h6/rk952rynYszJ0OdVsscmkHOeNB8ernzqW1DYLPEHptiY26OLr6iKOPKPDL91LqqukoE0HBTr5MM=";

  //public static final String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMAqtECwppyvpQq2ZRAzo4ULsaDCAbfD7zoLXrf5c0b3frAD5pXkT0E6QhI9APY419AEXgV8zadktuIotS0pgGa7lQ4eE/Rdl4AWWN1u2RFt6rST76LDvx4f1d2qL2uUI1EFD0+WKlh8I9/FDyrkoYiMtTGV7wHsJ262Y1prblelAgMBAAECgYEAkB625xlVK4fzkHAwpZEE3yBhDH7UCP0yqmail/nGgf/WDK4wPlRnODU4HjOQSBljicfst9Lc7eDz4/PBxWgtuhAB4nkX9JigGSt+Rl0CS/w0165jTlIRcJ/zEl8M9CHVtbOaQ+gANY4qObOMdC8gyLKPt+sv0mbmzYuxBRkwtwECQQD2hhYekfmK/im5TnHyF3fl4r937ZvM6jaTqrplu83vv8IVhVw/30LEYuQ/sVmzoZzhNW4EEvRzJWCRLJ8J6kxBAkEAx424BIlvRm5ZFEQdT/h8feAiYpppetiT+eFydLNvEG2qRe5x2UOc7/WRTnKoUq14znC5hJmprNtirlQGevXCZQJBALFMkk/+MHj0ftGVR4ITutmNEKOSMkFYGVRur4xHW78YLOAJf+U4Du7rKLleNeNpUkjugmdPspu1wBPpAaDB74ECQFMPC77nrWc1WuJyj3jPxpFmDynXd3voVX82dTtZzCqcWrkMzFpQKCxAnCB43NK83YGfrbghdVw7XFGPK7tWO3kCQQDKB9Cy9IDgTxsN8rX1f4seNjVYhk7O1PfPErmy9Cr2T09dt8TRK2sPibbaA0/+DBHU8X5QYCZfoPFyuWT5yelr";

  public static void main(String[] args) {
    //String str = "{\"phone\":\"15029919573\",\"enterpriseInfoVo\":{\"creditCode\":\"911101123579518966\"},\"loginType\":\"EMBEDDED\",\"expireTime\":1655881333348}";
    //String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";
    //System.out.println(RSAUtil_SaaS.encrypt("2022-06-16 15:00:00", privateKey));
    //String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+TaUwZdCVjfSpcH2SnnHZPTqWc0tUMUlX6zWSoe7otRFLEpRsBVUiGjor2hlBaouFd2lqV0Vvbp4JXO2OgvUitBElkTdUNX/8eGSwlIC1u2kRMCrXuMlSfY8f6PfOLj0GSCMbFc1qpXX/IPQ9dVPdSFHATr94LAVDzGjV3Gqc5wIDAQAB";
    //System.out.println(RSAUtil_SaaS.encryptPublic(str, publicKey));
    //String a = "zF9M97iOdYGPum1Nj9qp5sXthMvYcCBDeInAdNJhFaGV3yPU94vNl4GlJGBoduM/xdT9h2JyqIFg5kOZaheuzYvdM/USvPcGbv9KY42uFyVqu0mPSPiP+H2VqxFUcSTAvkXAty5td/h48TZodc2qy/Pn19vDBrsKOPEuyAN6WIQ=";
    //String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM6GF50mgaLrtsfOxyJsPqMq533A1ARBj0gtywxnrkCNjwPt4q7dc8jIlLt4FyrXDJ8kPsSp9THCn9YWYRfsd+UOjFapDDN10UqnOhbNrn7/UpIpoY9690bahtYSaW6bUIoETAuN/24eZUMAnrcLrRZo3j3+WDDbRDLwq/VLugV/AgMBAAECgYEAtlm7u+xmBn5uExpGxeQholydrXF3QpLIeojEgh2BxEm5f1SqFJBATYadnLG6cv8Si+mq6mbOsrMQAi4caM1IRgXbY4Dn46dmjx9bkvgPkC3z5HUUXDx6cGiGFxtW13NbjFgdUh1H6id93bF2nza1P6Uz9zvkBvA3WF35hRc+KXECQQD7Wfwb846EHM15PalhnWzVIGGN8/GSSM9FLG5Rv1iES7i4X/Lfem5WYXwMT1NBYJPDco5OwGfY41Pyf4+Q4PP9AkEA0lffR3TEe08CNclz1qyZvIiErYMfbnXxJqvDuLXS+gvDu+nJO4xRp5z5vHN8nKZcSbiuDLZ782N6iQ11wBJSKwJBAKD/IGbe+LhSoqI4BtiJt35EQXhleqSSkoDiVr9x6sbCoc0nWDAhAa++vXA9FzzXGY6lP9XdlCbuZYT8g/7uuBkCQEx4adI+n1f9B16qmJSJN3MVZrb2Hq03764RcBxs7gC92jEs813Uy7LWHOzoR3tj99VNcOlqRnHbzqaY4CAuCPUCPy1Uh//KcDCgmhjtSAjkUCtKMGZYN+cG8JWQIlGj8gxZ/5CxQ0E6cEWsaHNRQvn0/sahzYFBe4CInxHPxFSUYQ==";


    //String ss = RSAUtil_SaaS.encrypt("00006", privateKey);
     //String str = "EbWzYD1xDhq4HXqotBK80TDxNMaRkujV9YJoKA4BAOxe5EFQhw+EhnM1MIVORfdfLOxwOninRq4GAMEUwQ/PZFq5tE71jkR7sDSfxevO9R+MrxFc/7O3kRWON45qMWPSyv0ApqcBFMrBxtLgVuVwvqo+5mnJaRLcl1bAr/0RL6k=";
    // System.out.println(RSAUtil_SaaS.decrypt(str, publicKey));
    System.out.println("key>>>" + RSAUtil.encrypt("10825", privateKey));
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
