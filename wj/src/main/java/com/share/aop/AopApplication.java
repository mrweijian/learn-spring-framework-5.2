package com.share.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

/**
 * @ClassName AopApplication
 * @Author weijian
 * @Date 2021/11/16
 */
public class AopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		ProxyFactory proxyFactory = new ProxyFactory();


//		proxyFactory.setTarget(new AServer());
//		// proxyFactory.setTargetClass(AServer.class);
//		proxyFactory.addAdvice((AfterReturningAdvice) (returnValue, method, args1, target) -> System.out.println(method.getName()+"_返回后"));
//		AServer proxy = (AServer)proxyFactory.getProxy();
//		proxy.testA();

		proxyFactory.setTarget(new AServer());
		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new StaticMethodMatcherPointcut(){

					@Override
					public boolean matches(Method method, Class<?> targetClass) {
						if("testB".equals(method.getName())){
							return true;
						}
						return false;
					}
				};
			}

			@Override
			public Advice getAdvice() {
				return new MethodInterceptor() {
					@Override
					public Object invoke(MethodInvocation invocation) throws Throwable {
						System.out.println("代理逻辑前！");
						invocation.proceed();
						System.out.println("代理逻辑后！");
						return null;
					}
				};
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});
		AServer proxy = (AServer)proxyFactory.getProxy();
		proxy.testA();
		proxy.testB();
	}
}
