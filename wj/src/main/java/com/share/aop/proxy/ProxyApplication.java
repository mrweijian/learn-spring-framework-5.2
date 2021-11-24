package com.share.aop.proxy;

/**
 * @ClassName ProxyApplication
 * @Author weijian
 * @Date 2021/11/11
 */
public class ProxyApplication {

	public static void main(String[] args) throws Exception{

		//需要代理的对象
		ProxyDemo proxyDemo = new ProxyDemo();

		// 增强逻辑
		MyHandler myHandler = new MyHandler(proxyDemo);

		// 生成代理类
		ProxyInterface proxyInstance = (ProxyInterface)Proxy.newProxyInstance(ProxyApplication.class.getClassLoader(),
				proxyDemo.getClass().getInterfaces(),
				myHandler);
		System.out.println(proxyInstance.getClass().getName());
		proxyInstance.test("weijian");
		proxyInstance.test1("张三",25);

//		java.lang.reflect.Proxy.newProxyInstance();
		int a = 0xCAFEBABE;
		System.out.println(a);
	}

}
