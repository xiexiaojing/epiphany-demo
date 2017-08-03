package com.letv.mms.transmission.dao;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface DateDao {
	@SQL("SELECT now()")
	public String getNow();
}
