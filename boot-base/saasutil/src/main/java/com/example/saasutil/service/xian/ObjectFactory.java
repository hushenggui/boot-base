
package com.example.saasutil.service.xian;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the glodon.gtm.deposit.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateGuaranteeInfoResponse_QNAME = new QName("http://service.deposit.gtm.glodon/", "updateGuaranteeInfoResponse");
    private final static QName _GetProjectInfo_QNAME = new QName("http://service.deposit.gtm.glodon/", "getProjectInfo");
    private final static QName _SubmitGuaranteeInfoResponse_QNAME = new QName("http://service.deposit.gtm.glodon/", "submitGuaranteeInfoResponse");
    private final static QName _SubmitGuaranteeInfo_QNAME = new QName("http://service.deposit.gtm.glodon/", "submitGuaranteeInfo");
    private final static QName _GetEnterpriseInfo_QNAME = new QName("http://service.deposit.gtm.glodon/", "getEnterpriseInfo");
    private final static QName _GetEnterpriseInfoResponse_QNAME = new QName("http://service.deposit.gtm.glodon/", "getEnterpriseInfoResponse");
    private final static QName _GetProjectInfoResponse_QNAME = new QName("http://service.deposit.gtm.glodon/", "getProjectInfoResponse");
    private final static QName _UpdateGuaranteeInfo_QNAME = new QName("http://service.deposit.gtm.glodon/", "updateGuaranteeInfo");
    private final static QName _GetProjectInfoResponseReturn_QNAME = new QName("http://service.deposit.gtm.glodon/", "return");
    private final static QName _SubmitGuaranteeInfoArg0_QNAME = new QName("http://service.deposit.gtm.glodon/", "arg0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: glodon.gtm.deposit.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEnterpriseInfo }
     * 
     */
    public GetEnterpriseInfo createGetEnterpriseInfo() {
        return new GetEnterpriseInfo();
    }

    /**
     * Create an instance of {@link GetEnterpriseInfoResponse }
     * 
     */
    public GetEnterpriseInfoResponse createGetEnterpriseInfoResponse() {
        return new GetEnterpriseInfoResponse();
    }

    /**
     * Create an instance of {@link GetProjectInfoResponse }
     * 
     */
    public GetProjectInfoResponse createGetProjectInfoResponse() {
        return new GetProjectInfoResponse();
    }

    /**
     * Create an instance of {@link UpdateGuaranteeInfo }
     * 
     */
    public UpdateGuaranteeInfo createUpdateGuaranteeInfo() {
        return new UpdateGuaranteeInfo();
    }

    /**
     * Create an instance of {@link SubmitGuaranteeInfo }
     * 
     */
    public SubmitGuaranteeInfo createSubmitGuaranteeInfo() {
        return new SubmitGuaranteeInfo();
    }

    /**
     * Create an instance of {@link SubmitGuaranteeInfoResponse }
     * 
     */
    public SubmitGuaranteeInfoResponse createSubmitGuaranteeInfoResponse() {
        return new SubmitGuaranteeInfoResponse();
    }

    /**
     * Create an instance of {@link GetProjectInfo }
     * 
     */
    public GetProjectInfo createGetProjectInfo() {
        return new GetProjectInfo();
    }

    /**
     * Create an instance of {@link UpdateGuaranteeInfoResponse }
     * 
     */
    public UpdateGuaranteeInfoResponse createUpdateGuaranteeInfoResponse() {
        return new UpdateGuaranteeInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGuaranteeInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "updateGuaranteeInfoResponse")
    public JAXBElement<UpdateGuaranteeInfoResponse> createUpdateGuaranteeInfoResponse(UpdateGuaranteeInfoResponse value) {
        return new JAXBElement<UpdateGuaranteeInfoResponse>(_UpdateGuaranteeInfoResponse_QNAME, UpdateGuaranteeInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "getProjectInfo")
    public JAXBElement<GetProjectInfo> createGetProjectInfo(GetProjectInfo value) {
        return new JAXBElement<GetProjectInfo>(_GetProjectInfo_QNAME, GetProjectInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitGuaranteeInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "submitGuaranteeInfoResponse")
    public JAXBElement<SubmitGuaranteeInfoResponse> createSubmitGuaranteeInfoResponse(SubmitGuaranteeInfoResponse value) {
        return new JAXBElement<SubmitGuaranteeInfoResponse>(_SubmitGuaranteeInfoResponse_QNAME, SubmitGuaranteeInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitGuaranteeInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "submitGuaranteeInfo")
    public JAXBElement<SubmitGuaranteeInfo> createSubmitGuaranteeInfo(SubmitGuaranteeInfo value) {
        return new JAXBElement<SubmitGuaranteeInfo>(_SubmitGuaranteeInfo_QNAME, SubmitGuaranteeInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEnterpriseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "getEnterpriseInfo")
    public JAXBElement<GetEnterpriseInfo> createGetEnterpriseInfo(GetEnterpriseInfo value) {
        return new JAXBElement<GetEnterpriseInfo>(_GetEnterpriseInfo_QNAME, GetEnterpriseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEnterpriseInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "getEnterpriseInfoResponse")
    public JAXBElement<GetEnterpriseInfoResponse> createGetEnterpriseInfoResponse(GetEnterpriseInfoResponse value) {
        return new JAXBElement<GetEnterpriseInfoResponse>(_GetEnterpriseInfoResponse_QNAME, GetEnterpriseInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "getProjectInfoResponse")
    public JAXBElement<GetProjectInfoResponse> createGetProjectInfoResponse(GetProjectInfoResponse value) {
        return new JAXBElement<GetProjectInfoResponse>(_GetProjectInfoResponse_QNAME, GetProjectInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGuaranteeInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "updateGuaranteeInfo")
    public JAXBElement<UpdateGuaranteeInfo> createUpdateGuaranteeInfo(UpdateGuaranteeInfo value) {
        return new JAXBElement<UpdateGuaranteeInfo>(_UpdateGuaranteeInfo_QNAME, UpdateGuaranteeInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "return", scope = GetProjectInfoResponse.class)
    public JAXBElement<String> createGetProjectInfoResponseReturn(String value) {
        return new JAXBElement<String>(_GetProjectInfoResponseReturn_QNAME, String.class, GetProjectInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "arg0", scope = SubmitGuaranteeInfo.class)
    public JAXBElement<String> createSubmitGuaranteeInfoArg0(String value) {
        return new JAXBElement<String>(_SubmitGuaranteeInfoArg0_QNAME, String.class, SubmitGuaranteeInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "return", scope = GetEnterpriseInfoResponse.class)
    public JAXBElement<String> createGetEnterpriseInfoResponseReturn(String value) {
        return new JAXBElement<String>(_GetProjectInfoResponseReturn_QNAME, String.class, GetEnterpriseInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "return", scope = SubmitGuaranteeInfoResponse.class)
    public JAXBElement<String> createSubmitGuaranteeInfoResponseReturn(String value) {
        return new JAXBElement<String>(_GetProjectInfoResponseReturn_QNAME, String.class, SubmitGuaranteeInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "arg0", scope = GetProjectInfo.class)
    public JAXBElement<String> createGetProjectInfoArg0(String value) {
        return new JAXBElement<String>(_SubmitGuaranteeInfoArg0_QNAME, String.class, GetProjectInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "arg0", scope = UpdateGuaranteeInfo.class)
    public JAXBElement<String> createUpdateGuaranteeInfoArg0(String value) {
        return new JAXBElement<String>(_SubmitGuaranteeInfoArg0_QNAME, String.class, UpdateGuaranteeInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "return", scope = UpdateGuaranteeInfoResponse.class)
    public JAXBElement<String> createUpdateGuaranteeInfoResponseReturn(String value) {
        return new JAXBElement<String>(_GetProjectInfoResponseReturn_QNAME, String.class, UpdateGuaranteeInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.deposit.gtm.glodon/", name = "arg0", scope = GetEnterpriseInfo.class)
    public JAXBElement<String> createGetEnterpriseInfoArg0(String value) {
        return new JAXBElement<String>(_SubmitGuaranteeInfoArg0_QNAME, String.class, GetEnterpriseInfo.class, value);
    }

}
