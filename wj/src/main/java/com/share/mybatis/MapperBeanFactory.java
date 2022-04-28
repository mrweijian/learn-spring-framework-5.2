package com.share.mybatis;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MapperBeanFanctory
 * @Author weijian
 * @Date 2021/6/4
 */
public class MapperBeanFactory implements FactoryBean {

	private Class mapperClass;

	public MapperBeanFactory(Class mapperClass){
		this.mapperClass = mapperClass;
	}

	@Override
	public Object getObject() {
		return Proxy.newProxyInstance(MapperBeanFactory.class.getClassLoader(),
				new Class[]{mapperClass}, new MyInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return mapperClass;
	}
}
