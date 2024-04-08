package com.example.saasutil.service;

import static com.example.saasutil.util.RSAUtil.decrypt;
import static com.example.saasutil.util.RSAUtil.encrypt;

import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.vo.CreateOrderRequestBodyVo;
import java.util.Arrays;

/**
 * @program: boot-base
 * @description: RSA
 * @author: hushenggui
 * @create: 2021-11-03 17:48
 **/
public class RsaBaseService {
  public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZkpPtGSRku0c4r0pWvVITFIYOgOlbrKVhuIIYW1CVWTv7VlbztZb14r0Wx1C++d7HZgnHNorGjKE7mTtTUqpjtV5KNaJF/nu8dg5iShyKeK7KmIitsBT5UIJb5x9/uj/8q88dUlJewubPE1HJNf6/0R2yuAdOKOkslGn37k/M+wIDAQAB";
  public static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANmSk+0ZJGS7RzivSla9UhMUhg6A6VuspWG4ghhbUJVZO/tWVvO1lvXivRbHUL753sdmCcc2isaMoTuZO1NSqmO1Xko1okX+e7x2DmJKHIp4rsqYiK2wFPlQglvnH3+6P/yrzx1SUl7C5s8TUck1/r/RHbK4B04o6SyUaffuT8z7AgMBAAECgYEAoISKzG8zMXoV9pUktE/i4J7QtJyZDgCW1zzIBm5ASp9WKH0vk4gSgwAwX0DXqr4whU4bwrTTt96DCbRoV3XyrFb1DlYm3yEm2cgYukxNMtxhlL3Tpu7bL3YdGYaAIYYtgbwzvvMvT7omKI85iztweKRWQ0VjR8sdT8oE9gAsSykCQQDzrVvH6MEayi2rsesmg2Fd0bJYCp3zUuv6kbeXy+mANYbeePjPTbu/kmir/HZn4fnJfoGxCW/o0LxW56ubb0v1AkEA5JNE9RoEbRAA5SDJpRi/1u/KFH35BU88lVGixXDNaS8YFWjZAswIUViyC7ms2cs8bHgKNt4zOhSJbM1DtsePLwJAWntBvE5Z/eea48kx5uAb9GlcDsMKeYKN60HWaUAnWRsHFG7Y/KkBkRX9VfdtxA8t4DrgT2uQqWNwu9hUaWf/TQJBAIwFl2GafYmeGx5BtqUXgzWVETL6dJkHEDLcnpza3EqKGfPLldz7xkCm1/MM3FFTCgHci01PUwxKVmE7YTbQCusCQHwyerbP/DaI/eUkyE06yzbrvAJXmFR3ck+AZaQi3eiS5WGXeOMKBlVTOShsLdn82v6vKzfRggkEWeVkB+mcDaU=";

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
    /* String salt = "YKy4ZWTZJtFe9DbmU/EgyYTAZtCeyCPrwj9xx6B720OemYjYL8+7TNR279Ay20uuqnNO15T2HdnJ9r6ybRBLrnnTeAkPJBQiBVxiY3deyguR8q4xcZi1cOSKYHgFxauv70/fs7/1bV1utxCYjgv7Pmkr1/+9qtW4M/O3M4hugHg=";
     System.out.println("name>>>" + RSAUtil.decrypt(salt, publicKey));*/
    String str = "'TtidLW4Tg99k0wPbYQEzvqofMg1BtzEIWFgxottUv0CiR+K5EbpJr3O0Z6mDdRvkuJIWkW7VdFf0L7d7vMWRlAS/Ri0dU45L1XxAz4dTL+StOj/nRxWPHrC5ZOl4LtLAklAbVIs7bVAKjuadC2NPt9rtPperZIe3fDla+gnpMyc=',\n"
        + "'RGHDqL0gI9lpnRotSTtseYuzFHqzDzP+ALMiH9ETWi1PR4AeHBeEEUD8EUkB+tQ6J/SHjwqE0VZfa8zf9cMexkz1OXAETQk7jESLQCiY9GHzdo4EAzvzQxpLlFbewdFF/fGRUJS2LDwprQxvxY9xUf9I392F/Ovip03OWELYlYo=',\n"
        + "'uCYFBi6wQQwyRa7RNKcugHMXci3Bxx0JOkhIjFkUJ/7Zs4M3Ld/YaPbmPodN0tbT+RlfoTmAH+jQWGCEJV8XH1tYsEvDzWy3Cc77dh1gXQDtu31D87WCpGh7n8yguEm1tfxd66pEk7sddHSxtk30BM++hlQFmirNXhx9XNj3N7o=',\n"
        + "'uCYFBi6wQQwyRa7RNKcugHMXci3Bxx0JOkhIjFkUJ/7Zs4M3Ld/YaPbmPodN0tbT+RlfoTmAH+jQWGCEJV8XH1tYsEvDzWy3Cc77dh1gXQDtu31D87WCpGh7n8yguEm1tfxd66pEk7sddHSxtk30BM++hlQFmirNXhx9XNj3N7o=',\n"
        + "'n2N9uKM9ZB4MxhoIVB22WNuMdp4cVE1MiS6thtpWyjGBi8Xw+68qktVcIFtxMeoH6ltEUOlqN3RLuRvIebv0wfSjFHcJOsVwVp3psEF3wbHJ36A0jmo8+HKi3gnz36lQeBYxTEc0TmQWD6aFhY+eWO38Wy6dCoGEHyXkga9oFGQ=',\n"
        + "'n2N9uKM9ZB4MxhoIVB22WNuMdp4cVE1MiS6thtpWyjGBi8Xw+68qktVcIFtxMeoH6ltEUOlqN3RLuRvIebv0wfSjFHcJOsVwVp3psEF3wbHJ36A0jmo8+HKi3gnz36lQeBYxTEc0TmQWD6aFhY+eWO38Wy6dCoGEHyXkga9oFGQ=',\n"
        + "'svaHODp4ZGNG3qV3q+pBgDu/Ff6pmkPCAW+htLz2Xsa024pjlVsRp52OYmBjizlYRgWTe1jVhVOTyiIQ1o6D+SWEL/7pGTObhOcNNo58jQGhaLwXA/j419tmiebXCRzJYE5ho1TC66y4uJQD9Ei7vAbP3ydpUKEZGVRVBpbzwGs=',\n"
        + "'qu3KMarvyIuR/4EASbtneh6Mjm5cYvBzBr4aIIEUdXAHkvc32AlN0kG5wJREEZGtTM23RAEO+fdg1GXBelBPfXCf8I6Hk9Wc/ST4WKNavx3d5d9yLv5x/j5hqYGN2swh6Ay2cdVfRb1FWyViiGNZ4Plen2oGCgi1ynz6irpH/H8=',\n"
        + "'m3bjIvc2HwHxJZJ8LNUQRr4/5dbIPa2QtfM76FWITzKMaJBFLDAddBJU7PxdKtFpZNZ/jG8fSBgEBlClSfjPla74KWeACfx8ErJoWnZdKALnYt3K6HoavA6WKUvxmcJe75SmIjwbbVeq4V9jcHi9gnPowDoB0e3eiXNNiT9ZdzE=',\n"
        + "'WDDZVoOfEeAapovnFLvk4X6kDWu5+nRS/eQ4Ol+XzNG4E4MXAj9xm/CXh26dZoeLc997gaoBXqWYUNvfx4gfz6yaOYrUh8GX6lePlzPemVEONH6GCQz7xZ4H1W+M7tKODR450BAJ5LEoC1jSQPSPJG7VyFtqdAXzzZq5yZqvcF0=',\n"
        + "'okUxR6gQ9EDahllVncX5CQ82FDh1inWsY1DyY3rXImePmCrFf1oMmeEVIpg4Ms40OJrF7khhJ/9d3qCuvNkiNucUBWVGNRYT04GiAMvqHSArTRdJrGP8DJ/CAkotBJnHHSfYNdMnhDM5V2J0vCwWUwL43jy9cQUa35AcYbYPHSU=',\n"
        + "'lh/FB6w4erjwflf3kI7apKFEtZ4QAyWxRzkVkgQDj0vo+BUXFzLwGWcCDsPcBhelWpb5Cx5l8WhM/xukxbgfN1rVEUPEzYsiawB3rkdkYYLgjKmnpT7dZe5dl8hDctpBtxrKTvYV8vRgRaN0XeJmZqzgytczGa6T7hB3Fa/qd0U=',\n"
        + "'svaHODp4ZGNG3qV3q+pBgDu/Ff6pmkPCAW+htLz2Xsa024pjlVsRp52OYmBjizlYRgWTe1jVhVOTyiIQ1o6D+SWEL/7pGTObhOcNNo58jQGhaLwXA/j419tmiebXCRzJYE5ho1TC66y4uJQD9Ei7vAbP3ydpUKEZGVRVBpbzwGs=',\n"
        + "'XswGJnztww40BJYMH9PsBLBtMXnH/EyZEQGO9w8izG7PzQvSs2+/m3puJcjFnh44B2fmfc9qZRsVITCWSOtgVBm9VJgwvNytZrNyBGaPROP0GdwvXh231jml9FsbOUS2/mJTAIt7WyZbcjqp3mGJQ3xW4otudINwGMR/tRW/Vbg=',\n"
        + "'lh/FB6w4erjwflf3kI7apKFEtZ4QAyWxRzkVkgQDj0vo+BUXFzLwGWcCDsPcBhelWpb5Cx5l8WhM/xukxbgfN1rVEUPEzYsiawB3rkdkYYLgjKmnpT7dZe5dl8hDctpBtxrKTvYV8vRgRaN0XeJmZqzgytczGa6T7hB3Fa/qd0U=',\n"
        + "'BHVcEqFJ6Pi7i9hFhviydGW2+Hr8n7KVmhoJ8OCsct6rHKrTX+sfGcEpDUH8EgXXT7yY4BKhYJ4LGvEIKAAuJHM8za/W6Bn3gr1+xL/Sy/i2xIuwa1v+O5zXIMW8HDwwVWPO+puwDxgaauf8T5fh+Y4MepapHnJTINGD77Tsb0M=',\n"
        + "'BHVcEqFJ6Pi7i9hFhviydGW2+Hr8n7KVmhoJ8OCsct6rHKrTX+sfGcEpDUH8EgXXT7yY4BKhYJ4LGvEIKAAuJHM8za/W6Bn3gr1+xL/Sy/i2xIuwa1v+O5zXIMW8HDwwVWPO+puwDxgaauf8T5fh+Y4MepapHnJTINGD77Tsb0M=',\n"
        + "'DzOqJbAyA5DQjAXz91oLjKXt7zTRAhLmD7vK6cJNZ9vnvhbiQZjufbXHrvt9zOtIn30NHGhQFRiCCF+F3/BYjUsO3nJcB0Slg4cViw/0hdBrQu4pxfjkKXHHBU6y32mIUDKFIGkSeqgF0LxW3MhB23ZLPPJ/WrryzFG3fn+jK3M=',\n"
        + "'dE0iDTN/OwLJsihlS9eX3sAw5Mny6ze3WYuw3tbcRI+P/sCVU2RtxQC38UsuRc3daZrfouKHtxrMx92d/wThIoWRZL30LOKXQNm3JoGhUHeBVeVd+Dz4zX2UQOyOa5ykbpp/moUsl1irn2iU2qHWWE40sC+Nq6LSUt/Q2s2b14g=',\n"
        + "'dE0iDTN/OwLJsihlS9eX3sAw5Mny6ze3WYuw3tbcRI+P/sCVU2RtxQC38UsuRc3daZrfouKHtxrMx92d/wThIoWRZL30LOKXQNm3JoGhUHeBVeVd+Dz4zX2UQOyOa5ykbpp/moUsl1irn2iU2qHWWE40sC+Nq6LSUt/Q2s2b14g=',\n"
        + "'ACviffUOX69mEf6QZHmFpBZfg00RUIfPaDInbUIRIIl9doWHPpzcf68XCwVpM8n/77Bpn61TVBE8H5CKYuYVQ4229z4ZebuVR21LFIvh3duiJ+jR639rKZOCCUqg3BlchfWLg1LdA7VoWj0Bgn9+k5AhdJrynkGJIQ8cex7gV9U=',\n"
        + "'GX8nYjEXNiqIPlQfoMa7Ac/hEdecTHtx58tOi5Ye/HO8JxeBn+BUmK6x4le5yBKYgUP+Ekej5XcV6WciY1Fvks0Ga4vlbfjf+Om7KYvWIjGQLrZDac+2lIKWHkT//IWcPEvMSN9RRjdmtekafrwBmMdmkz1hM/UceD76f/GdvPA=',\n"
        + "'GX8nYjEXNiqIPlQfoMa7Ac/hEdecTHtx58tOi5Ye/HO8JxeBn+BUmK6x4le5yBKYgUP+Ekej5XcV6WciY1Fvks0Ga4vlbfjf+Om7KYvWIjGQLrZDac+2lIKWHkT//IWcPEvMSN9RRjdmtekafrwBmMdmkz1hM/UceD76f/GdvPA=',\n"
        + "'n8VsSJP7pGxovn1sWD2agUiKaYACm+NyySTe39vChdWkKvmKdwDEgyt89fR/59eZWIHePQcgpRWQFnsHpA1BAyYEefp4utYwaSvmCEIQE8WAk6Xty9ywa3MAo/REtjXUPYGM2TT+AnLG8W52EnatFcf6eF/mp3YE7uH3ZsLbs6w=',\n"
        + "'eDWDucCvIeDDFIVwQHGz6TmPQ7XYIBTvcGebX7DpkqtCl2Vlb44QymlMdnUFEQczXv7gSCu4BdkjVm9bKEwa4aIozi33RplecJloP3e5As5YF44VsJV4Jb2XImJXHYQ/UCNgjCJNIDGdX+pIIAFdz2wMQGr6MPZwugWEJ5Be/l4=',\n"
        + "'opMUzLDljKmCbwPGKEKMpw1JKLp6GAr3qn3EQ4jBmQVeMd5Ixu+sPwaXw0/zJoWxT4d/qTx8iFnogdJiqan/TBm4t/Ibq3xNa/6PE+X2OG3RTHO/AhXJTt2N5PPbiH0UEtEHPuvlD09JbVF6mKdfCDAMRUMOkTGHZBvR8QPHByE=',\n"
        + "'n8VsSJP7pGxovn1sWD2agUiKaYACm+NyySTe39vChdWkKvmKdwDEgyt89fR/59eZWIHePQcgpRWQFnsHpA1BAyYEefp4utYwaSvmCEIQE8WAk6Xty9ywa3MAo/REtjXUPYGM2TT+AnLG8W52EnatFcf6eF/mp3YE7uH3ZsLbs6w=',\n"
        + "'cRC+nbCCQ0+L4m7vGcD1iLqgNxwK+MUQP8bybnxTXplEHAYwvxsV8gDs5bgCFq2bXEDRfgh0d3ilZPLgCsIrL2LF1GNntVziAREfFT2QzlqfPdlCKXjSujedU+2wwvP1+VErPVJs8KbSkzQ3QbkBeB7qXKUFdIdeCr/1q1xz+w8=',\n"
        + "'cRC+nbCCQ0+L4m7vGcD1iLqgNxwK+MUQP8bybnxTXplEHAYwvxsV8gDs5bgCFq2bXEDRfgh0d3ilZPLgCsIrL2LF1GNntVziAREfFT2QzlqfPdlCKXjSujedU+2wwvP1+VErPVJs8KbSkzQ3QbkBeB7qXKUFdIdeCr/1q1xz+w8=',\n"
        + "'HXwEu+Y2a1ArawLDjGKmpeLpgxxWPkxcMo9LIKETPkjzeKT6TL+hFZb5UNiNjNGvxR1ALaSENm1RsS1fLCiN/WA/Y9jFtH2hbACzhS6pf0GrF5HChW3C/+Eg3x++BWgSTBHJUdYFXR+/5qDoM1+EryQ27K3D7PnWay/vxnysNCw=',\n"
        + "'Agu7d5VUb9lR1+FX/ylVzCIUeovdVIFNHbmGIEOnVh59DAqtdrRdLLGWv/UgTYnflVi9F3pufxcFhGFGSO+hcRjI4Jgm+ID6etqWWPnoRzT4brc8eRP5kdziJYbC3QWKd67z/Q9xG3Ul1VLOeF26dCF48L3DpZQ0CvKFmyKBKcg=',\n"
        + "'nXCA4VYbyth9pn9iaqYkZ1JdwrGV0+AQpEmgwBWsOIIBtFf0UdHCBemQGLOoaUhX+Z77DNWeGEZxj2msK6TmSJzcY9CdU7wQ5vISsa9+z6/Prm/gIEONorWee5aJHaexyOfQknugvTR8xZN/dZxLz5udU8FZA9YwyNhUOLYM7VE=',\n"
        + "'Agu7d5VUb9lR1+FX/ylVzCIUeovdVIFNHbmGIEOnVh59DAqtdrRdLLGWv/UgTYnflVi9F3pufxcFhGFGSO+hcRjI4Jgm+ID6etqWWPnoRzT4brc8eRP5kdziJYbC3QWKd67z/Q9xG3Ul1VLOeF26dCF48L3DpZQ0CvKFmyKBKcg=',\n"
        + "'nXCA4VYbyth9pn9iaqYkZ1JdwrGV0+AQpEmgwBWsOIIBtFf0UdHCBemQGLOoaUhX+Z77DNWeGEZxj2msK6TmSJzcY9CdU7wQ5vISsa9+z6/Prm/gIEONorWee5aJHaexyOfQknugvTR8xZN/dZxLz5udU8FZA9YwyNhUOLYM7VE=',\n"
        + "'Klva5M3mOEqPgFvnHQunimoX0tpx+aqTJiOg91ZzAePyfJqCObbNnySqfqp14JL+u0WP3mAStWQRRIz+VwHhBtKcderOgkiyuaahzyJPMo2nrsroLgAMr4hEVRWoeRL1fR8lewMswFUPNhmsh1gx9zVBF5BvuIY7P1+rO66SGEg=',\n"
        + "'uZV0z1zoLb4N8N26ntmc3BpZmLXiH2L02NRYRryi2okHg+ol8ZhUFeOc75wqIE3bCJUnsnR9VhLNX+SZe5nvqmx5PYqYo0bY3r0mhytrpbxD++Z0qHWKxieYzDQZIX6fgHZmuJx6tWcW39gqO6yuY+SIRo4DhMjtIQ7SY1+m2l0=',\n"
        + "'uZV0z1zoLb4N8N26ntmc3BpZmLXiH2L02NRYRryi2okHg+ol8ZhUFeOc75wqIE3bCJUnsnR9VhLNX+SZe5nvqmx5PYqYo0bY3r0mhytrpbxD++Z0qHWKxieYzDQZIX6fgHZmuJx6tWcW39gqO6yuY+SIRo4DhMjtIQ7SY1+m2l0=',\n"
        + "'j7cfadSLwJt3SRTgef2ZMM2UIkhGj71pEzD9fGRYtrLxl50L64063dKKzfAMyjHh9QHXhyCOVDhs42hIy6gtARx2NGxYxTY9x1u+5IxJ+wAhsQn44Ufk9WHdgWcvD8hy8qqqMJSHg2VIv+OWmlL1gHWQVNowdoFvNNc3kvZ9Lic=',\n"
        + "'j7cfadSLwJt3SRTgef2ZMM2UIkhGj71pEzD9fGRYtrLxl50L64063dKKzfAMyjHh9QHXhyCOVDhs42hIy6gtARx2NGxYxTY9x1u+5IxJ+wAhsQn44Ufk9WHdgWcvD8hy8qqqMJSHg2VIv+OWmlL1gHWQVNowdoFvNNc3kvZ9Lic=',\n"
        + "'yGgExAG0eflfcxsLH+dKyGg8PMxN1ZJKX1945CRwbNS1tdVIIEVSeOx2QsTrLsG1VNwovAgjTHJOFFRAJP5kQ7UVW1t/TYRnw+uO/HYna6q93hFumEqKOdtkjANxo7elSyDiDpaILhowPICvwiRL8xcCyc5s13Xy54I8u7YDEBU=',\n"
        + "'UcOq03zWb1Dqfe1xNQlaTblVqblUdYpe2K8fZZdEvPj4TIueU7HQIx3pPUrweprlov5LyaZbkfDJOeQsMEI/0job1ZKvUH37KvZzJ8Afqtt4+ZG8K6+v1KbDl8k3DXOYmF0G+eF4PE04k/8PFVPbz7wIwBRCj3ccXbdsD7Q0ZV0=',\n"
        + "'YWjXekARtF400QavhqJDT3xRK71VQoVDYP3EqA+MRW58rSoFa8kZGuWRmBzcISpbMWLw5tAY3uE2sRM3nMFqxmFjvz8YMwbHgkgChRM87S7NrBIEwRbWi7MMl9J5rFW8BHMU+wKoTlhKKW4cWTyYz5Lj8SP9gcNmo3MgtOvZu8s=',\n"
        + "'YWjXekARtF400QavhqJDT3xRK71VQoVDYP3EqA+MRW58rSoFa8kZGuWRmBzcISpbMWLw5tAY3uE2sRM3nMFqxmFjvz8YMwbHgkgChRM87S7NrBIEwRbWi7MMl9J5rFW8BHMU+wKoTlhKKW4cWTyYz5Lj8SP9gcNmo3MgtOvZu8s=',\n"
        + "'ax7gywHKnHD7GG7A8wTCQLw0EKK3DzJ1nxxRa9pD68z4uLAz4YzbWZDy5YCZ4FI2a/88Aby7CXyWY2+pGiViOUNhtV8+0fFa7e7/zVNwZFAguiSlhpsrVX2dXCunI1r/JJUYHVrJ8y2cwq37A1doifFXuR+Bj2yTLQy3NtA9uNI=',\n"
        + "'ax7gywHKnHD7GG7A8wTCQLw0EKK3DzJ1nxxRa9pD68z4uLAz4YzbWZDy5YCZ4FI2a/88Aby7CXyWY2+pGiViOUNhtV8+0fFa7e7/zVNwZFAguiSlhpsrVX2dXCunI1r/JJUYHVrJ8y2cwq37A1doifFXuR+Bj2yTLQy3NtA9uNI=',\n"
        + "'VCv8cIzgTKipJpa4PRJ3w+WgKq+Eyfn3ZiwagXx22kzWZB+9YE0aDLGrZJGHqAEpN4UwWLGP0zHjdeKJSaa0706Asug9qP/Hwiis13Qnu8lwFlaqplrs4xWgppTbpCnesktJb5MZMPLKShvH+TADobzW/bfE1Bf+6NAKQdmOKp4=',\n"
        + "'sDXSSFVjGTtVfWPG0UvQOFiKIGK8FcX0DG2kvOPQha4j6jqlo77/PDpyjSAS5NvR5BFa2s3miK3rQKGfaPBtOyQST2hRtG7jbA8BTo6fC9pKbO4XqTtR3JZxpSeTeEaGcLWfxVckKZhxCW+tDPd1iFZx+Yn3F44oLqGr1L/lYoA=',\n"
        + "'jTb5ZHsR+WejFTAci5AWH0R7SZPV5hPoN1J57SK7fOtSjCfKxfsHuZfsxdLUZNVoZsoNLBqAZGxCU8fkxhu7oCxeGxSrJcqWu/pXk1vh8dPkx045b3MASoYobkevmZh7122XALJhk1E4+z6nL2NfAYveGNeF+2E5oj286HGFZHU=',\n"
        + "'jTb5ZHsR+WejFTAci5AWH0R7SZPV5hPoN1J57SK7fOtSjCfKxfsHuZfsxdLUZNVoZsoNLBqAZGxCU8fkxhu7oCxeGxSrJcqWu/pXk1vh8dPkx045b3MASoYobkevmZh7122XALJhk1E4+z6nL2NfAYveGNeF+2E5oj286HGFZHU=',\n"
        + "'VCv8cIzgTKipJpa4PRJ3w+WgKq+Eyfn3ZiwagXx22kzWZB+9YE0aDLGrZJGHqAEpN4UwWLGP0zHjdeKJSaa0706Asug9qP/Hwiis13Qnu8lwFlaqplrs4xWgppTbpCnesktJb5MZMPLKShvH+TADobzW/bfE1Bf+6NAKQdmOKp4='";
    Arrays.stream(str.split("\n")).forEach(tradeSerialNo -> {
      System.out.println(decrypt(tradeSerialNo, publicKey));

        });
   /* String encrypt = encrypt("330324111202307173539001", privateKey);
    System.out.println(encrypt);*/
    //System.out.println(decrypt(encrypt, publicKey));


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
