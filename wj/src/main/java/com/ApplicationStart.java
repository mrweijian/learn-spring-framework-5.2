package com;

import com.event.MyEventPublisher;
import com.share.aop.AServer;
import com.share.aop.AServerInterface;
import com.share.aop.AopConfig;
import com.share.aop.BServer;
import com.share.aop.proxy.MyHandler;
import com.share.aop.proxy.ProxyApplication;
import com.share.aop.proxy.ProxyDemo;
import com.share.aop.proxy.ProxyInterface;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.security.action.GetBooleanAction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;


/**
 * @ClassName Test
 * @Author weijian
 * @Date 2021/5/25
 */
public class ApplicationStart {


	@Autowired
	private MyEventPublisher myEventPublisher;


	public static void main(String[] args) throws Exception {


		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		AServerInterface aServer = (AServerInterface)context.getBean("AServer");
		System.out.println(aServer.getClass().getName());
		aServer.testA();
		// spring结合mybatis
//		 UserServer userServer = context.getBean(UserServer.class);
//	     userServer.test();

		// bean的生命周期
//		System.out.println("1111"+context.getBean("shareFactoryBean"));
//		System.out.println("2222"+context.getBean("&shareFactoryBean"));
//		User user = (User) context.getBean("user");
//		System.out.println(user.getBeanDemo());
//		System.out.println(context.getBean("appConfig"));
//
//		// bean的销毁
//		context.close();
//		context.registerShutdownHook();

		// 循环依赖

		// aop



	}
}
