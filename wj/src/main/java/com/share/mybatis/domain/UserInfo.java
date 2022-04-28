package com.share.mybatis.domain;

/**
 * @ClassName UserInfo
 * @Author weijian
 * @Date 2022/4/24
 */
public class UserInfo {

	private String id;

	private String userName;

	private String sex;

	public UserInfo(String userName, String sex) {
		this.userName = userName;
		this.sex = sex;
	}
	public UserInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
