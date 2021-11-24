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
	public Object getObject() throws Exception {
		Object proxyInstance = Proxy.newProxyInstance(MapperBeanFactory.class.getClassLoader(),
				new Class[]{mapperClass}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName());
						return null;
					}
				});

		return proxyInstance;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperClass;
	}
}
