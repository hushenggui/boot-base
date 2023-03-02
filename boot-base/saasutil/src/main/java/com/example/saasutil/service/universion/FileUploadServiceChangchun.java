package com.example.saasutil.service.universion;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.GsonUtil;
import com.example.saasutil.util.RSAUtil;
import com.example.saasutil.util.UUIDGenUtil;
import java.io.File;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-09-21 15:42
 *
 * {"publicKey":"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5+oSBrJJFZpa1Qs8ycLQYnrB2wnxyNclAWrrIEyicrKl+uAFcjTDZZGxX8UKHmshO/9KdtminQCR+IwrKUtmuXDjBnLozQzhFI0POyAyIdFo4Ko4ApzonCxqvmMNQa3h4l+7lx23J9Zj3lsPaWvbQgJg0j/zYRenstdXdXigr3QIDAQAB"}
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 **/
public class FileUploadServiceChangchun {


  public static void main(String[] args) {
    String json = "{\n"
        + "\t\"cityCode\": \"220100\",\n"
        + "\t\"cityName\": \"长春市\",\n"
        + "\t\"insCode\": \"00019\",\n"
        + "\t\"source\": \"安华农业保险股份有限公司\",\n"
        + "\t\"reqTime\": \"1667878005000\",\n"
        + "\t\"reqType\": \"BAOXIAN\",\n"
        + "\t\"sign\": \"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\"\n"
        + "}";

    String pdfName = "PBBU202222018400000433.pdf";
    String orderId = "10110102201002022112810385189777";


    String uuid = UUIDGenUtil.createUUID();
    String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALn6hIGskkVmlrVC\n"
        + "zzJwtBiesHbCfHI1yUBausgTKJysqX64AVyNMNlkbFfxQoeayE7/0p22aKdAJH4j\n"
        + "CspS2a5cOMGcujNDOEUjQ87IDIh0WjgqjgCnOicLGq+Yw1BreHiX7uXHbcn1mPeW\n"
        + "w9pa9tCAmDSP/NhF6ey11d1eKCvdAgMBAAECgYEAr7KGYGOCRGJo2pFlYYer/N5e\n"
        + "Y7PVEajSmiOc9ctzwKA1+GspjiAtGBORb3uTmLyXpFp2xVxAflFQqIG+fenLjxsC\n"
        + "qIpSxpesW+IH1Ik0YZCbtgBptFbRHZfXmBK07u4y/BD7MBTboS6vI8CL1Qb56+Jc\n"
        + "3UzGXeY3GV1eOZ1MHVkCQQDkn6/XdvQXf7eAInDTjzuC+xFp6d64G/7M91qHhBDH\n"
        + "FMxleW4rMR8XVUzKh9sLZ9cB9MbdDP/1WjB6sehJvzIHAkEA0D+R8b0zu27oGJeN\n"
        + "iJ4rNRPOHGBV9rx+BuSCTOyUXfudsUZ3kZqCjY1lhFUdGCPyW12gc1qTu6f1Xx92\n"
        + "ghkp+wJAXdU0hIhr8mEW3V5FVG9LC50kLoYwRPwofdNfspL/l9Xvdg56qvuEOT1n\n"
        + "QRC1VF8QHdtq6zr0qqyTjSgLoIj6bQJAInXyk7tIfULMG42wuSPbaIwfdmimsQ7e\n"
        + "GAvmWA5qOucxYC2WCb00z3HPk8d16hHAwEfNDmm1ur7/hr8xIDRD0wJBAN6RBpLw\n"
        + "cHibzaxu7Mt6uKS6pN/wHytKzr6e6Ku/oy7WNVDFlBpVqncfHgCQvdRUXHDTh7dt\n"
        + "2th1A5DF9oTfcGk=";
    GongbaoChannelReqBaseVo<FileUploadRequestVo> reqBaseVo = GsonUtil.parseObject(json, GongbaoChannelReqBaseVo.class);
    File tempFile = new File("E:\\hengyang/" + pdfName);
    FileUploadRequestVo vo = FileUploadRequestVo.builder()
        .fileMD5(uuid)
        .filename(pdfName)
        .fileSize(5)
        .orderId(orderId)
        .build()
        ;

    String sign = RSAUtil.encrypt(GsonUtil.toJsonSort(vo), privateKey);
    reqBaseVo.setReqBody(vo);
    vo.setFileUrl("https://changchun-jy.gongbao.cn/upload/" + pdfName);
    vo.setFileBase64(Base64Util.fileToBase64(tempFile));
    reqBaseVo.setSign(sign);
   // System.out.println(GsonUtil.toJsonSort(reqBaseVo));

    FileVo fileVo = FileVo.builder().cityCode(reqBaseVo.getCityCode())
        .downloadUrl(vo.getFileUrl())
        .fileBase64(vo.getFileBase64())
        .name(vo.getFilename())
        .md5(vo.getFileMD5())
        .fileSize(vo.getFileSize())
        .insCode(reqBaseVo.getInsCode())
        .orderNo(vo.getOrderId())
        .build();

    System.out.println(GsonUtil.toJsonSort(fileVo));

  }

}
