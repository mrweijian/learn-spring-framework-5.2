package com.share.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName ShareInstantiationAwareBeanPostProcessor
 * @Author weijian
 * @Date 2021/6/3
 */
@Component
public class ShareInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	//实例化前
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("实例化前_"+beanClass.getName());
		return null;
	}

	// 实例化后
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("实例化后_"+bean.getClass().getName());
		// 返回true才会进行属性填充
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println("填充属性后--"+beanName);
		return null;
	}
}
