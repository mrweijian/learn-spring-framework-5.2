package com.share.mybatis.jdbc;

import com.share.mybatis.domain.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

/**
 * @ClassName InsertExecute
 * @Author weijian
 * @Date 2022/4/24
 */
public class InsertExecute<T> implements Execute {
	@Override
	public Object execute(String sql, Object o) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			// 实际的解析xml获取
			UserInfo userInfo = (UserInfo) o;
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, userInfo.getUserName());
			pstmt.setString(3, userInfo.getSex());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
			e.printStackTrace();
			}

		}

		return null;
	}
}
