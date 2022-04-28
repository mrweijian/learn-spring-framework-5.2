package com;

import com.share.mybatis.MapperConfig;
import com.share.mybatis.UserServer;
import com.share.mybatis.domain.UserInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ApplicationMybatis
 * @Author weijian
 * @Date 2022/4/24
 */
public class ApplicationMybatis {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MapperConfig.class);

		// 业务代码
		UserServer userServer = context.getBean(UserServer.class);
		UserInfo userInfo = new UserInfo("weijian1111","男");
		userServer.insert(userInfo);
		System.out.println(userServer.select("e4aa8da0-3349-4868-a8eb-6a3e05de888d").toString());
	}

}
