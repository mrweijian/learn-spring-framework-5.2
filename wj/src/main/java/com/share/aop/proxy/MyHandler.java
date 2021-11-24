package com.share.aop.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MyHandler
 * @Author weijian
 * @Date 2021/11/11
 */
public class MyHandler implements InvocationHandler {

	private Object targetObject;

	public MyHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public void invoke(Object proxy, Method method, Object[] args) {
		System.out.println("代理前逻辑！----------");

		try {
			method.invoke(targetObject, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();

		}
		System.out.println("代理后逻辑！----------------");
	}
}
