package com.dao.proxy;

import com.dao.TuserDao;
import com.dao.impl.TuserDaoImpl;
import com.entity.Tuser;
import com.jdbc.DataBaseConnection;

public class TuserDaoProxy implements TuserDao {
	private DataBaseConnection dbc = null;
	private TuserDao dao = null;
	
	public TuserDaoProxy(){
		this.dbc = new DataBaseConnection();
		this.dao = new TuserDaoImpl(this.dbc.getConn());
	}

	public boolean findLogin(Tuser user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
