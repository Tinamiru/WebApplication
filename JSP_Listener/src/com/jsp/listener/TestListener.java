package com.jsp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event)  { 
    	
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext ctx = event.getServletContext();
    	String message = ctx.getInitParameter("massage");
    	System.out.println(message);
    }
	
}
