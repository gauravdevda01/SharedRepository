package com.config;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.util.PropertyUtil;
public class Initializer implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(".... Initializing Context....");
		PropertyUtil.initProperties();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
