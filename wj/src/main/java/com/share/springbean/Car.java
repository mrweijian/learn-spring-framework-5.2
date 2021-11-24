package com.share.springbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Car
 * @Author weijian
 * @Date 2021/6/2
 */
@Component
public class Car implements InitializingBean, DisposableBean {

	@PostConstruct
	public void init(){
		System.out.println("car PostConstruct 初始化");
	}

//	@PreDestroy
//	public void destroy(){
//		System.out.println("car 销毁！");
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean 的销毁方法");
	}

	@Bean
	public BeanDemo beanDemo(){
		return new BeanDemo();
	}
}
