package com.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	private static Properties properties=null;
	public static void initProperties()
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
	
	public static Properties getAllProperties()
	{
		return properties;
	}
	
	public static String getProperty(String propertyName)
	{
		return properties.getProperty(propertyName);
	}
}
