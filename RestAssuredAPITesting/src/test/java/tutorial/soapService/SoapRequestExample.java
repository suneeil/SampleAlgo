package tutorial.soapService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import static io.restassured.path.xml.XmlPath.*;

import org.testng.annotations.Test;

public class SoapRequestExample {

	
	@Test
	public void test001(){
		String wsdlURL = "http://holidaywebservice.com//HolidayService_v2/HolidayService2.asmx?wsdl";
		
		String payload = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hs=\"http://www.holidaywebservice.com/HolidayService_v2/\">"
				+" <soap:Body>"
				+" <hs:GetHolidaysAvailable xmlns=\"http://www.holidaywebservice.com/HolidayService_v2/\">"
				+ "<hs:countryCode>UnitedStates</hs:countryCode>"
				+ "</hs:GetHolidaysAvailable>"
				+ "</soap:Body>"
				+ "</soap:Envelope>";
		
		
		String xmlResponse = RestAssured
			.given()
			.contentType("text/xml")
			.body(payload)
			.post(wsdlURL)
			.asString();
		
		System.out.println(xmlResponse);
		System.out.println("-----------");
		System.out.println(with(xmlResponse).getList("HolidayCode"));
		
		XmlPath path = new XmlPath(xmlResponse);
		String str = path.getString("soap:Body");
		System.out.println("----------------");
		System.out.println(str);
		System.out.println("----------------");
		
		System.out.println(path.getNodeChildren("soap:Body.GetHolidaysAvailableResponse.GetHolidaysAvailableResult.HolidayCode.Code").size());
	}
	
}
