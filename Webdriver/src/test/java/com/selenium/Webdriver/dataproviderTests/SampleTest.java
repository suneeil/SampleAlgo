package com.selenium.Webdriver.dataproviderTests;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class SampleTest {

	/*@Test(groups={"smoke2"},dataProviderClass=DataProvideClass.class,dataProvider="auth")
	public void someTest(String name, String pwd){
		System.out.println("Name: "+name + " & Password: " + pwd);
	}
	*/
	
	@Test(dataProviderClass=DataProvideClass.class, dataProvider="mapAuth", groups="smoke")
	public void someTest2(Integer num, String name ){
		System.out.println(num + " " + name);
		 
	}
	
}
