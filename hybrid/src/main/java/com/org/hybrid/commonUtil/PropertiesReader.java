package com.org.hybrid.commonUtil;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private Properties prop = null;



	public PropertiesReader(String filePath) throws Exception{
		try{
			prop = new Properties();
			
			InputStream inp = new FileInputStream(filePath);
			prop.load(inp);

		}catch(IOException e){
			throw new Exception(">>> Exception from Properties Reader:  " +e.getMessage()+" <<<");
		}
	}



	public Properties loadPropertyFile(){
		return this.prop;
	}

	public String getPropertyValue(String key){
		return prop.getProperty(key);
	}

	/*public static void main(String args[]){

		PropertiesReader p = new PropertiesReader("/home/sunil/TestWorkSpace/JustDialMobAppAutomation/src/test/java/org/justdial/repository/ApplicationObject.properties");

		Properties or = p.getProperty();
		System.out.println(or.getProperty("bingUrl"));
	}*/


}
