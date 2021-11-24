package com.share.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName Demo
 * @Author weijian
 * @Date 2021/6/8
 */
@Aspect
@Component
public class AopDemoAspect {

	@Before("execution(public void com.share.aop.AServer.testA())")
	public void before(){
		System.out.println("代理逻辑执行，方法执行前。。。。。。。。。。。。");
	}


	@After("execution(public void com.share.aop.AServer.testA())")
	public void after(){
		System.out.println("代理逻辑执行方法执行后。。。。。。。。。。。。");
	}
}
