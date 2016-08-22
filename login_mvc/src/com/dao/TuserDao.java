package com.dao;

import com.entity.Tuser;

public interface TuserDao {
	public boolean findLogin(Tuser user)throws Exception;
}
