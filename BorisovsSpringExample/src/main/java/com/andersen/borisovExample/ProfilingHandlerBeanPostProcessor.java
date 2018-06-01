package com.andersen.borisovExample;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.net.ssl.ManagerFactoryParameters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

	private Map<String, Class> map = new HashMap<>();
	private ProfilingController controller = new ProfilingController();
	
	public ProfilingHandlerBeanPostProcessor() throws Exception {
		MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
		platformMBeanServer.registerMBean(controller, new ObjectName("profiling","name","controller"));
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Class<? extends Object> beanClass = bean.getClass();
		if (beanClass.isAnnotationPresent(Profiling.class)) {
			map.put(beanName, beanClass);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class beanClass = map.get(beanName);
		if (beanClass != null) {
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

							if (controller.isEnabled()) {
								System.out.println("Profiling...");
								long before = System.nanoTime();
								Object invoked = method.invoke(bean, args);
								long after = System.nanoTime();
								System.out.println("Total time spent : " + (after - before));
								System.out.println("Thats all");
								return invoked;
							} else {
								return method.invoke(bean, args);
							}

						}
					});
		}
		return bean;
	}

}
