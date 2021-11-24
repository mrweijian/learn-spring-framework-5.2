package com.share.springbean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName WFactoryBean
 * @Author weijian
 * @Date 2021/6/2
 */
//@Component
public class ShareFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		//return new User(new BeanDemo());
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
