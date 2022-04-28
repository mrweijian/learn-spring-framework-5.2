package com.share.mybatis;

import com.share.mybatis.annotation.Insert;
import com.share.mybatis.annotation.Select;
import com.share.mybatis.jdbc.DBUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Author weijian
 * @Date 2022/4/24
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().isAssignableFrom(Insert.class)) {
				System.out.println("插入方法");
				Insert insert = (Insert) annotation;
				DBUtil.execute(insert.value(), args[0], "insert");
			} else if (annotation.annotationType().isAssignableFrom(Select.class)) {
				Select select = (Select) annotation;
				System.out.println("查询方法方法");
				return DBUtil.execute(select.value(), args[0], "select");
			}

		}
		return null;
	}
}
