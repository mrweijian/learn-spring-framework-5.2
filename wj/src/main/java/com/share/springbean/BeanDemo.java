package com.share.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanDemo
 * @Author weijian
 * @Date 2021/6/4
 */
public class BeanDemo {

	public void close(){
		System.out.println("执行BeanDemo的close方法");
	}
}
