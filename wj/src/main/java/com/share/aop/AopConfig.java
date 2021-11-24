package com.share.aop;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AopConfig
 * @Author weijian
 * @Date 2021/6/8
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan("com.share.aop")
public class AopConfig {

//	@Bean
//	public BeanNameAutoProxyCreator creator(){
//		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//		beanNameAutoProxyCreator.setBeanNames("AServer");
//		beanNameAutoProxyCreator.setInterceptorNames("aopDemo");
//		return beanNameAutoProxyCreator;
//	}
}
