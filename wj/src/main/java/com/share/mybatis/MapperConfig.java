package com.share.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @ClassName MapperConfig
 * @Author weijian
 * @Date 2021/6/4
 */
@ComponentScan("com.share.mybatis")
@Import(MapperBeanDefinitionRegistry.class)
@MapperScan("com.share.mybatis")
@Configuration
//@Transactional(propagation = Propagation.MANDATORY)
//@EnableTransactionManagement
public class MapperConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://116.62.223.130:3306/mybatis-test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&useSSL=false&serverTimezone=Hongkong&allowMultiQueries=true");
		dataSource.setUsername("root");
		dataSource.setPassword("Wj@123..*");
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean;
	}

//	@Bean
//	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
//		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//		transactionManager.setDataSource(dataSource);
//		return transactionManager;
//	}
}
