package com.share.mybatis;

import com.share.mybatis.domain.UserInfo;
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

	public UserInfo select(String id) {
		return userMapper.selectById(id);
	}

	public void insert(UserInfo userInfo) {
		userMapper.insertUser(userInfo);
	}
}
