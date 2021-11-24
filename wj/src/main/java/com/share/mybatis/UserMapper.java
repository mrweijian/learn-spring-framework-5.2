package com.share.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserMapper
 * @Author weijian
 * @Date 2021/6/4
 */
public interface UserMapper {


	void selectById();

	@Insert("")
	void insertUser();
}
