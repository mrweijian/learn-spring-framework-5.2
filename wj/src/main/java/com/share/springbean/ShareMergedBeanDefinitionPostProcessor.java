package com.share.springbean;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName ShareMergedBeanDefinitionPostProcessor
 * @Author weijian
 * @Date 2021/6/3
 */
@Component
public class ShareMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		if (beanType.isAssignableFrom(User.class)) {
			beanDefinition.setInitMethodName("init");
		}
		System.out.println("BeanDefinition的后置处理器");
	}

}
