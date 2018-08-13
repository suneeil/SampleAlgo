package com.selenium.Webdriver.dataproviderTests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.DataProvider;

public class DataProvideClass {

	@DataProvider(name = "auth")
	public static Object[][] credentials(){
		return new Object[][]{{"name1","pwd1"},{"name2","pwd2"},{"name3","pwd3"},
				{"name4","pwd4"},{"name5","pwd5"},{"name6","pwd6"}};
	}

	
}
