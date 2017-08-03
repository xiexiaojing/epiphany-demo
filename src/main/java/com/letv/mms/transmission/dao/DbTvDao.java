package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.DbTv;

@DB
public interface DbTvDao {
	@SQL("SELECT ID as id,TV as tv,TV_HK as tvHk,tv_en as tvEn FROM db_tv WHERE DELETED=0")
    public List<DbTv> getAll();
    
    @SQL("SELECT ID as id,TV as tv,TV_HK as tvHk,tv_en as tvEn FROM db_tv WHERE DELETED=0 AND ID=:1")
    public DbTv getById(long id);
}
