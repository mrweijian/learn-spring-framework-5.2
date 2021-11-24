package com.share.aop.proxy;

import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * @ClassName Proxy
 * @Author weijian
 * @Date 2021/11/11
 */
public class Proxy {

	public static Object newProxyInstance(ClassLoader loader,
										  Class<?>[] interfaces,
										  InvocationHandler h) throws Exception {

		DynamicCompileDemo dynamicCompileDemo = new DynamicCompileDemo();
		Class<?> aClass = dynamicCompileDemo.eval(interfaces);
		Constructor<?> constructor = aClass.getConstructor(InvocationHandler.class, Map.class);
		Object obj = constructor.newInstance(h, dynamicCompileDemo.getMethodMap());
		return obj;
	}
}
