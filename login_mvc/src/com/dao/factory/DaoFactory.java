package com.dao.factory;

import com.dao.TuserDao;
import com.dao.proxy.TuserDaoProxy;

public class DaoFactory {
	public static TuserDao getTuserDaoInstance(){
		return new TuserDaoProxy();
	}
}
