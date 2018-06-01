package com.andersen.borisovExample;

import java.lang.reflect.Field;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class InjectRandomSpeedAnnotationBeanPostProcessor  implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {

		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			InjectRandomSpeed annotation = field.getAnnotation(InjectRandomSpeed.class);
			if (annotation != null) {
				int min = annotation.min();
				int max = annotation.max();
				Random random = new Random();
				int i = min+random.nextInt(max+1);
				field.setAccessible(true);
				ReflectionUtils.setField(field, bean, i);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		return bean;
	}



}
