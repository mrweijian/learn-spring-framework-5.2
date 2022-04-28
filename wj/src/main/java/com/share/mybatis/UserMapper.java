package com.share.mybatis;

import com.share.mybatis.annotation.Insert;
import com.share.mybatis.annotation.Select;
import com.share.mybatis.domain.UserInfo;

/**
 * @ClassName UserMapper
 * @Author weijian
 * @Date 2021/6/4
 */
public interface UserMapper {

	@Select("select * from user_info where id=?")
	UserInfo selectById(String id);

	@Insert("insert into user_info values(?,?,?)")
	void insertUser(UserInfo userInfo);
}
