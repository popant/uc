package com.popant.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpsDemo {
    void testPost(String sendxml) throws Exception {
        try {
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					System.out.println("Warning: URL Host: " + urlHostName + " vs. "
							+ session.getPeerHost());
					return true;
				}
			};
        	String u="https://ywtest.ccic-net.com.cn:8912/cargeneral";
        	System.setProperty("javax.net.ssl.trustStore", "E:\\青牛工作\\2016-01-14 车险比价网站\\大地车险对外接口_V2.9\\大地证书使用说明\\测试环境/test.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "123456");
            System.setProperty("javax.net.ssl.keyStoreType", "JKS");
            System.setProperty("javax.net.ssl.keyStore", "E:\\青牛工作\\2016-01-14 车险比价网站\\大地车险对外接口_V2.9\\大地证书使用说明\\测试环境/test.jks") ;
            System.setProperty("javax.net.ssl.keyStorePassword", "123456") ;
//			trustAllHttpsCertificates();
//			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			URL url = new URL(u);
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestProperty("GW_CH_CODE", "tst334");//渠道代码
            http.setRequestProperty("GW_CH_TX", "105");//交易代码
            http.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream(),"gbk");
            String xmlInfo = sendxml;
//            System.out.println("xmlInfo=" + xmlInfo);
            out.write(xmlInfo);
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(http
                    .getInputStream(),"gbk"));
            String line = "";
            for (line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
				.getSocketFactory());
	}
	private String getXmlInfo() {
    	//测试报文，换成相应渠道方报文。
    	String xml=
    		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:prop=\"http://proposalgenerateNingBo.ecargo.gwservice.ccic.com/\">\n" + 
    		"   <soapenv:Header/>\n" + 
    		"   <soapenv:Body>\n" + 
    		"      <prop:ProposalGenerateRequest>\n" + 
    		"         <prop:requestHead>\n" + 
    		"            <prop:channelCode>000003</prop:channelCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:channelName>nbhss</prop:channelName>\n" + 
    		"            <prop:channelComCode>000003</prop:channelComCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:channelComName>nbhss</prop:channelComName>\n" + 
    		"            <prop:channelProductCode>YDG</prop:channelProductCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:operator>1</prop:operator>\n" + 
    		"            <prop:trxCode>001</prop:trxCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:channelSeqNo>1</prop:channelSeqNo>\n" + 
    		"            <prop:trxDate>2013-11-01</prop:trxDate>\n" + 
    		"            <prop:regionCode>1</prop:regionCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:makeChannel>1</prop:makeChannel>\n" + 
    		"            <!--Optional:-->\n" + 
    		"            <prop:passWord>1</prop:passWord>\n" + 
    		"         </prop:requestHead>\n" + 
    		"         <prop:requestBody>\n" + 
    		"            <prop:tradeType>1</prop:tradeType>\n" + 
    		"            <prop:tradeTime>2013-11-01 15:40:30</prop:tradeTime>\n" + 
    		"            <prop:classCode>Y</prop:classCode>\n" + 
    		"            <prop:riskCode>YDG</prop:riskCode>\n" + 
    		"            <!--Optional:-->\n" + 
    		"\n" + 
    		"            <prop:main>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:businessNature2>0101</prop:businessNature2>\n" + 
    		"               <prop:operateDate>2013-11-01</prop:operateDate>\n" + 
    		"               <prop:startDate>2013-12-30</prop:startDate>\n" + 
    		"               <prop:startHour>0</prop:startHour>\n" + 
    		"               <prop:endDate>2014-12-30</prop:endDate>\n" + 
    		"               <prop:endHour>24</prop:endHour>\n" + 
    		"               <prop:currency>CNY</prop:currency>\n" + 
    		"               <prop:sumAmount>100000</prop:sumAmount>\n" + 
    		"               <prop:sumPremium>0</prop:sumPremium>\n" + 
    		"               <prop:payTimes>1</prop:payTimes>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <!--<prop:arbitBoardName>22</prop:arbitBoardName>-->\n" + 
    		"               <prop:inputDate>2013-11-20</prop:inputDate>\n" + 
    		"               <prop:inputHour>0</prop:inputHour>\n" + 
    		"               <prop:coinsOriginRate>100</prop:coinsOriginRate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <!--<prop:argiPolicySort>02</prop:argiPolicySort>-->\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:vocationCode>11111111</prop:vocationCode>\n" + 
    		"               <prop:salePolicyAddr/>\n" + 
    		"            </prop:main>\n" + 
    		"            <prop:mainPlus>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:salesmanName>山东销售</prop:salesmanName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:occupationId>1212121</prop:occupationId>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:mobile/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:intermediaryAddr/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:intermediaryContNumb/>\n" + 
    		"   \t\t<!--Optional:-->\n" + 
    		"            </prop:mainPlus>\n" + 
    		"\n" + 
    		"\n" + 
    		"\n" + 
    		"\n" + 
    		"\n" + 
    		"            <prop:cargo>\n" + 
    		"               <prop:riskKind>90</prop:riskKind>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:priceCondition/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:ladingNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:invoiceNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:invoiceCurrency/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:invoiceAmount>22</prop:invoiceAmount>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:kilometre>22</prop:kilometre>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:plusRate>22</prop:plusRate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:creditNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:bargainNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:conveyance>0303</prop:conveyance>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:carryBillNo>111</prop:carryBillNo>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:blName>taitannike</prop:blName>\n" + 
    		" \t\t <!--Optional:-->\n" + 
    		"               <prop:voyageNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:blNo>888888</prop:blNo>\n" + 
    		"\n" + 
    		"               <prop:startSiteCode>33</prop:startSiteCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:startSiteName>中科软</prop:startSiteName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:viaSiteCode>32</prop:viaSiteCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:viaSiteName>中科软</prop:viaSiteName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:endSiteCode>31</prop:endSiteCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:endSiteName>阿里山</prop:endSiteName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:endDetailName>tiantang</prop:endDetailName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:checkAgentCode/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:claimSite/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:originalCount>2</prop:originalCount>\n" + 
    		"            </prop:cargo>\n" + 
    		"            <!--1 or more repetitions:-->\n" + 
    		"            <prop:addressList>\n" + 
    		"               <prop:addressNo>1</prop:addressNo>\n" + 
    		"               <prop:addressCode>271200</prop:addressCode>\n" + 
    		"               <prop:addressName>山东省</prop:addressName>\n" + 
    		"               <prop:provinceCode>37</prop:provinceCode>\n" + 
    		"               <prop:prefectureCode>3701</prop:prefectureCode>\n" + 
    		"               <prop:countyCode>370104</prop:countyCode>\n" + 
    		"            </prop:addressList>\n" + 
    		"            <!--1 or more repetitions:-->\n" + 
    		"            <prop:itemkindList>\n" + 
    		"               <prop:itemkindNo>1</prop:itemkindNo>\n" + 
    		"               <prop:kindCode>003</prop:kindCode>\n" + 
    		"               <prop:kindName>一切险</prop:kindName>\n" + 
    		"               <prop:kindType>1</prop:kindType>\n" + 
    		"               <prop:itemNo>1</prop:itemNo>\n" + 
    		"               <prop:itemCode>A03</prop:itemCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:itemDetailName>货物明细列表1</prop:itemDetailName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:cargoTicketNo>111</prop:cargoTicketNo>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:modeCode>001</prop:modeCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:modeName>木箱</prop:modeName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:model>10</prop:model>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:quantity>10</prop:quantity>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:unit/>\n" + 
    		"               <prop:currency>CNY</prop:currency>\n" + 
    		"               <prop:amount>100000</prop:amount>\n" + 
    		"               <prop:calculateFlag>Y</prop:calculateFlag>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:rate>20</prop:rate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:shortRateFlag>2</prop:shortRateFlag>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:shortRate>100</prop:shortRate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:deductible>10</prop:deductible>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:premium>0</prop:premium>\n" + 
    		"            </prop:itemkindList>\n" + 
    		"            <!--Zero or more repetitions:-->\n" + 
    		"\n" + 
    		"\n" + 
    		"            <prop:insuredList>\n" + 
    		"               <prop:serialNo>1</prop:serialNo>\n" + 
    		"               <prop:insuredType>2</prop:insuredType>\n" + 
    		"               <prop:insuredCode>9999999999999999</prop:insuredCode>\n" + 
    		"               <prop:insuredName>投保人</prop:insuredName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:custNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:language>C</prop:language>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:insuredAddress>修改投保人地址</prop:insuredAddress>\n" + 
    		"               <prop:insuredNature>3</prop:insuredNature>\n" + 
    		"               <prop:insuredFlag>2</prop:insuredFlag>\n" + 
    		"               <prop:identifyType>03</prop:identifyType>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyNumber>56948651X</prop:identifyNumber>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyValidDate>2012-6-19</prop:identifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:bank>法人开户樱花</prop:bank>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:accountName>法人11111</prop:accountName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:account>343434343</prop:account>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerName>YDH法人</prop:linkerName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postAddress>联系人地址</prop:postAddress>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postCode>200120</prop:postCode>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:phoneNumber>1111</prop:phoneNumber>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:email>123@qq.com</prop:email>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:workType>1111</prop:workType>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:nationality>2222</prop:nationality>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorFlag/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorLevel/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:sex/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:age>17</prop:age>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:birthDay/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyValidDate>2012-6-19</prop:linkerIdentifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:businessScope/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:revenueRegistNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateValidDate>2012-6-19</prop:certificateValidDate>\n" + 
    		"            </prop:insuredList>\n" + 
    		"            <!--Zero or more repetitions:-->\n" + 
    		"     <prop:insuredList>\n" + 
    		"               <prop:serialNo>2</prop:serialNo>\n" + 
    		"               <prop:insuredType>2</prop:insuredType>\n" + 
    		"               <prop:insuredCode>9999999999999999</prop:insuredCode>\n" + 
    		"               <prop:insuredName>散户</prop:insuredName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:custNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:language>C</prop:language>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:insuredAddress>上海浦东新区卡园</prop:insuredAddress>\n" + 
    		"               <prop:insuredNature>4</prop:insuredNature>\n" + 
    		"               <prop:insuredFlag>1</prop:insuredFlag>\n" + 
    		"               <prop:identifyType>19</prop:identifyType>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyNumber>88880002</prop:identifyNumber>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyValidDate>2012-6-19</prop:identifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:bank/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:accountName/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:account/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerName/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postAddress/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postCode/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:phoneNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:email/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:workType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:nationality/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorFlag/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorLevel/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:sex/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:age>17</prop:age>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:birthDay/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyValidDate>2012-6-19</prop:linkerIdentifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:businessScope/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:revenueRegistNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateValidDate>2012-6-19</prop:certificateValidDate>\n" + 
    		"            </prop:insuredList>\n" + 
    		"  <prop:insuredList>\n" + 
    		"               <prop:serialNo>3</prop:serialNo>\n" + 
    		"               <prop:insuredType>1</prop:insuredType>\n" + 
    		"               <prop:insuredCode>9999999999999999</prop:insuredCode>\n" + 
    		"               <prop:insuredName>第二被保险人散户</prop:insuredName>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:custNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:language>C</prop:language>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:insuredAddress>上海浦东新区卡园111</prop:insuredAddress>\n" + 
    		"               <prop:insuredNature>3</prop:insuredNature>\n" + 
    		"               <prop:insuredFlag>1</prop:insuredFlag>\n" + 
    		"               <prop:identifyType>03</prop:identifyType>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyNumber>188880004</prop:identifyNumber>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:identifyValidDate>2012-6-20</prop:identifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:bank/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:accountName/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:account/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerName/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postAddress/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:postCode/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:phoneNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:email/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:workType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:nationality/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorFlag/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:majorLevel/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:sex/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:age>17</prop:age>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:birthDay/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:linkerIdentifyValidDate>2012-6-19</prop:linkerIdentifyValidDate>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:businessScope/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:revenueRegistNo/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateType/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateNumber/>\n" + 
    		"               <!--Optional:-->\n" + 
    		"               <prop:certificateValidDate>2012-6-19</prop:certificateValidDate>\n" + 
    		"            </prop:insuredList>\n" + 
    		"         </prop:requestBody>\n" + 
    		"      </prop:ProposalGenerateRequest>\n" + 
    		"   </soapenv:Body>\n" + 
    		"</soapenv:Envelope>";
        StringBuffer sb = new StringBuffer();
        sb.append(xml);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String xml = new HttpsDemo().getXmlInfo();
        new HttpsDemo().testPost(xml);
    }
}


class miTM implements javax.net.ssl.TrustManager,
		javax.net.ssl.X509TrustManager {
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

	public void checkServerTrusted(
			java.security.cert.X509Certificate[] certs, String authType)
			throws java.security.cert.CertificateException {
		return;
	}

	public void checkClientTrusted(
			java.security.cert.X509Certificate[] certs, String authType)
			throws java.security.cert.CertificateException {
		return;
	}
}