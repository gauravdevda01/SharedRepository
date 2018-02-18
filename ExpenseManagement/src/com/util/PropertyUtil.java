package com.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	private static PropertyUtil propertyUtil=null;
	public static PropertyUtil getInstance()
	{
		if(propertyUtil==null)
		{
			propertyUtil=new PropertyUtil();
			
		}
		return propertyUtil;
	}
	private PropertyUtil()
	{
		initProperties();
	}
	private Properties properties=null;
	public void initProperties()
	{
		if(properties==null)
		{
			properties=new Properties();
			try{
				  InputStream inputStream = MailUtil.class.getResourceAsStream("expenseconfig.properties");
				  properties.load(inputStream);
				  System.out.println("properties Loaded successfully: "+properties);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		
	}
	
	public  Properties getAllProperties()
	{
		return properties;
	}
	
	public String getProperty(String propertyName)
	{
		return properties.getProperty(propertyName);
	}
}
