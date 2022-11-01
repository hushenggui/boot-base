package com.example.saasutil.enums;

/**
 * Created by AnthonyPark on 2018/5/24.
 */
public enum Company {
    GLOBAL("全局通用","00000"),
    GGZY("公共资源交易中心","00001"),
    TIANAN("天安财产保险股份有限公司","00002"),
    YATAI("亚太财产保险有限公司","00003"),
    ZIJIN("紫金财产保险股份有限公司","00004"),
    DADI("中国大地财产保险股份有限公司","00005"),
    TAIBAO("中国太平洋财产保险股份有限公司","00006"),
    PINGAN("中国平安财产保险股份有限公司","00007"),
    TAIPING("太平财产保险有限公司","00008"),
    YANGGUANG("阳光财产保险股份有限公司","00009"),
    YONGAN("永安财产保险股份有限公司","00010"),
    ANBANG("安邦财产保险股份有限公司","00011"),
    YONGCHENG("永诚财产保险股份有限公司","00012"),
    HUAAN("华安财产保险股份有限公司","00013"),
    HUANONG("华农财产保险股份有限公司","00014"),
    RENBAO("中国人民财产保险股份有限公司","00015"),
    YINGDA("英大泰和财产保险股份有限公司","00016"),
    CHANGAN("长安责任保险股份有限公司","00017"),
    ZHONGHUA("中华联合财产保险股份有限公司","00018"),
    ANHUA("安华农业保险股份有限公司","00019"),
    GUOREN("国任财产保险股份有限公司","00020"),
    JINGTAI("锦泰财产保险股份有限公司","00021"),
    DAJIA("大家财产保险股份有限公司","00022"),
    ZHESHANG("浙商财产保险股份有限公司","00023"),
    ZHONGHANG("中航安盟财产保险有限公司","00025"),
    GUOSHOUCAI("中国人寿财产保险股份有限公司","00027"),


    HUIYOU("汇友建工财产相互保险社","00026"),
    GUOYUAN("国元农业保险股份有限公司","00029"),
    YANGGUANG_XB("阳光信用保证保险有限公司","00030"),
    GBY("工保网","10000"),
    CHANGYIN("湖南长银融资担保有限公司湘潭分公司","10005"),
    PAYMENT("支付平台(旧)","20000"),
    PAY("支付平台(新)","20001"),
    CHANGSHA("长沙银行", "20003"),
    TSBANK("天山农商行", "20005"),
    XINGYE("兴业银行", "20002"),
    ;

    private String name;
    private String code;

    Company(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static Company getCompanyByCode(String code){
        for(Company c : Company.values()){
            if(c.getCode().equals(code)){
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
