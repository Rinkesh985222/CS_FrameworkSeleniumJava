package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties properties;

	String path="C:\\Users\\admin\\Desktop\\framework\\MyStoreV1\\configuration\\config.properties";

	public Readconfig() {


		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);

			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getbaseurl() {
		
		String value=properties.getProperty("baseurl");
		if(value!=null) 
			return value;
		else
			throw new RuntimeException("baseurl not specified in config file");
		}
	
public String getbrowser() {
		
		String value=properties.getProperty("browser");
		if(value!=null) 
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
		}
	

		
		
	}



