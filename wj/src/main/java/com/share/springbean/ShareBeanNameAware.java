package com.share.springbean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ShareShare
 * @Author weijian
 * @Date 2021/6/3
 */
@Component
public class ShareBeanNameAware implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("aware__"+name);
	}
}
