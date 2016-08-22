package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.TuserDao;
import com.entity.Tuser;

public class TuserDaoImpl implements TuserDao {
	private Connection conn = null;

	public TuserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean findLogin(Tuser user) throws Exception {
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT name FROM tuser WHERE userid=? AND password=?";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				user.setName(rs.getString(1));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				throw e2;
			}
		}
		return flag;
	}
}
