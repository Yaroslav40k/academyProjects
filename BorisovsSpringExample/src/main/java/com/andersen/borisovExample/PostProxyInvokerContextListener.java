package com.andersen.borisovExample;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired 
	private ConfigurableListableBeanFactory factory ;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			BeanDefinition beanDefinition = factory.getBeanDefinition(name);
			String beanOriginalClassName = beanDefinition.getBeanClassName();
			try {
				Class<?> originalBean = Class.forName(beanOriginalClassName);
				Method[] methods = originalBean.getMethods();
				for (Method method : methods) {
					if(method.isAnnotationPresent(PostProxy.class)) {
						Object bean = applicationContext.getBean(name);
						Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
						currentMethod.invoke(bean);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
