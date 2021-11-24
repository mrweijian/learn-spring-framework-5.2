package com.share.springbean;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName Confing
 * @Author weijian
 * @Date 2021/5/25
 */
@ComponentScan("com.share.springbean")
@PropertySource("classpath:application.properties")
@Configuration(proxyBeanMethods = false)
//@Import(User.class)
public class AppConfig {


}
