package com.share.aop.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	void invoke(Object proxy, Method method, Object[] args);
}
