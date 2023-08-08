package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="G:\\EclipseWorkspace\\SeleniumFramework\\Configuration\\config.properties";
	public ReadConfig() {
		
		properties = new Properties();
		try {
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getBaseUrl() {
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("URL not specified in config file");
	}
	public String getBrowser() {
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
	}
	
	
	

}
