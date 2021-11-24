package com.share.mybatis;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MapperBeandefinirionRegistar
 * @Author weijian
 * @Date 2021/6/4
 */
@Component
public class MapperBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		List<Class> list = new ArrayList<>();
		list.add(UserMapper.class);
		list.add(OderMapper.class);
		for (Class aClass : list) {
			AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
			beanDefinition.setBeanClass(MapperBeanFactory.class);
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(aClass);
			registry.registerBeanDefinition(aClass.getName(),beanDefinition);
		}

	}
}
