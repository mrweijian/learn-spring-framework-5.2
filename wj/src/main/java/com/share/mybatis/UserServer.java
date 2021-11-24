package com.share.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserServer
 * @Author weijian
 * @Date 2021/6/4
 */
@Component
public class UserServer {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OderMapper oderMapper;

	public void test(){
		userMapper.selectById();
		oderMapper.selectAll();
	}
}
