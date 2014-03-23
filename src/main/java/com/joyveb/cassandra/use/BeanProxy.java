package com.joyveb.cassandra.use;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanProxy implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		applicationContext = arg0;
	}
	
	public Object getBean(Class<?> clazz){
		return applicationContext.getBean(clazz);
	}

	public Object getBean(String className){
		return applicationContext.getBean(className);
	}
}
