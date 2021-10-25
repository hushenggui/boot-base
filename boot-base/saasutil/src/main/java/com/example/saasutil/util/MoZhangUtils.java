package com.example.saasutil.util;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;

@Slf4j
public class MoZhangUtils {


    private static void configureSSLOnTheClient(Client client,String sslKey) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");

        File file = new File(sslKey);

        //Client client = ClientProxy.getClient(obj);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        try {
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setDisableCNCheck(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            KeyStore trustStore = KeyStore.getInstance("JKS");
            String password = "123456";
            String storePassword = "123456";

            trustStore.load(new FileInputStream(file), storePassword.toCharArray());
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(trustStore);
            TrustManager[] trustManagers = trustFactory.getTrustManagers();
            tlsParams.setTrustManagers(trustManagers);

            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyFactory.init(keyStore, password.toCharArray());
            KeyManager[] keyManagers = keyFactory.getKeyManagers();
            tlsParams.setKeyManagers(keyManagers);
            tlsParams.setSecureSocketProtocol("SSL");

            /*FiltersType filtersTypes = new FiltersType();
            filtersTypes.getInclude().add(".*_EXPORT_.*");
            filtersTypes.getInclude().add(".*_EXPORT1024_.*");
            filtersTypes.getInclude().add(".*_WITH_DES_.*");
            filtersTypes.getInclude().add(".*_WITH_NULL_.*");
            filtersTypes.getExclude().add(".*_DH_anon_.*");
            tlsParams.setCipherSuitesFilter(filtersTypes);*/

            httpConduit.setTlsClientParameters(tlsParams);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    /**
     * webservice方式调用
     * @param url 调用地址
     * @param xmlStr 调用参数
     * @param pathName 方法名
     * @return
     */
    public static String wsdlClient(String url,String xmlStr,String pathName,String sslKey) throws Exception {
        //trustAllHttpsCertificates();
        //HttpsURLConnection.setDefaultHostnameVerifier(hv);
        System.setProperty("javax.net.ssl.trustStore",sslKey); //key路径
        System.setProperty("javax.net.ssl.trustStorePassword","123456");//密码
        System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        /*JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient(url);*/
        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client = factory.createClient(url);
        //configureSSLOnTheClient(client,sslKey);
        // url为调用webService的wsdl地址
        QName name = new QName("http://service.webServices.com/", pathName);
        // namespace是命名空间，methodName是方法名
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, xmlStr);
            System.out.println(objects[0].toString());
            return objects[0].toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    /**
     * 获取授权码验证
     * @param xmlStr
     * @return
     */
    public static String getAuthorization(String xmlStr, String key){
        try {
            //数据转换
            JSONObject jsonObject = JSONObject.parseObject(xmlStr);
            //不排序参数
            List<String> removeKey = new ArrayList<>();
            removeKey.add("authorization");
            //参数排序
            String res = StringFormatterUtils.jsonCovertString(jsonObject, removeKey, "&", "=");
            //生成授权码
            String sign = Md5Utils.MD5(res + key);
            return sign;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

/*    private void configureSSLOnTheClient(Object obj) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");

        File file = new File(sslKey);

        Client client = ClientProxy.getClient(obj);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        try {
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setDisableCNCheck(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            KeyStore trustStore = KeyStore.getInstance("JKS");
            String password = "123456";
            String storePassword = "123456";

            trustStore.load(new FileInputStream(file), storePassword.toCharArray());
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(trustStore);
            TrustManager[] trustManagers = trustFactory.getTrustManagers();
            tlsParams.setTrustManagers(trustManagers);

            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyFactory.init(keyStore, password.toCharArray());
            KeyManager[] keyManagers = keyFactory.getKeyManagers();
            tlsParams.setKeyManagers(keyManagers);
            tlsParams.setSecureSocketProtocol("SSL");

            *//*FiltersType filtersTypes = new FiltersType();
            filtersTypes.getInclude().add(".*_EXPORT_.*");
            filtersTypes.getInclude().add(".*_EXPORT1024_.*");
            filtersTypes.getInclude().add(".*_WITH_DES_.*");
            filtersTypes.getInclude().add(".*_WITH_NULL_.*");
            filtersTypes.getExclude().add(".*_DH_anon_.*");
            tlsParams.setCipherSuitesFilter(filtersTypes);*//*

            httpConduit.setTlsClientParameters(tlsParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/



/*    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        @Override
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        @Override
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    public static HostnameVerifier hv = new HostnameVerifier() {
        @Override
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. "+ session.getPeerHost());
            return true;
        }
    };*/

    public static void main(String[] args) throws Exception {
        //trustAllHttpsCertificates();
        //HttpsURLConnection.setDefaultHostnameVerifier(hv);
        //System.out.println(wsdlClient("https://api.whzbtb.com/V2PRTS/services/letterGuarantee?wsdl","202001131027490001","throughAuthorization"));
    }
}
