package com.share.aop;

import org.springframework.stereotype.Component;

/**
 * @ClassName AServer
 * @Author weijian
 * @Date 2021/6/8
 */
@Component
public class AServer implements AServerInterface{
	public void  testA(){
		System.out.println("----------testA---------");
	}

	@Override
	public void testB() {
		System.out.println("-------testB-------");
	}

}
