package com.share.aop.proxy;

/**
 * @ClassName ProxyDemo
 * @Author weijian
 * @Date 2021/11/11
 */
public class ProxyDemo implements ProxyInterface {
	@Override
	public void test(String name) {
		System.out.println("this is ProxyDemo-------test--" + name);
	}

	@Override
	public void test1(String name, int age) {
		System.out.println("this is ProxyDemo-------test1---" + name+"---"+age);
	}
}
