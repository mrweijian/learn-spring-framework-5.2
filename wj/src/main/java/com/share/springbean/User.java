package com.share.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @ClassName User
 * @Author weijian
 * @Date 2021/6/2
 */
@Component
public class User implements ImportSelector {

//	@Value("#{beanDemo}")
//	private BeanDemo beanDemo;
//	@Autowired
//	public User(Car car){
//		System.out.println("无参构造");
//	}
//	public User(BeanDemo beanDemo){
//		this.beanDemo = beanDemo;
//	}
//
//	public BeanDemo getBeanDemo() {
//		return beanDemo;
//	}
//
//	public void init(){
//		System.out.println("User init");
//	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
	}
}
