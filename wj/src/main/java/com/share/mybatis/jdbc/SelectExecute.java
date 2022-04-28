package com.share.mybatis.jdbc;

import com.share.mybatis.domain.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName SelectExecute
 * @Author weijian
 * @Date 2022/4/24
 */
public class SelectExecute implements Execute {

	@Override
	public Object execute(String sql, Object o) {

		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,(String) o);

			ResultSet resultSet = pstmt.executeQuery();

			UserInfo userInfo = new UserInfo();
			while (resultSet.next()) {
				userInfo.setId(resultSet.getString(1));
				userInfo.setUserName(resultSet.getString(2));
				userInfo.setSex(resultSet.getString(3));
			}
			return userInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
