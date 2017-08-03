package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.StarInfo;

@DB
public interface StarInfoDao {
    @SQL("SELECT le_id as id,name,name_en,name_hk FROM star_info WHERE deleted=0")
    public List<StarInfo> getAll();
    
    @SQL("SELECT le_id as id,name,name_en,name_hk FROM star_info WHERE deleted=0 AND le_id=:1")
    public StarInfo getById(long id);
    
    @SQL("SELECT le_id as id,name,name_en,name_hk FROM star_info WHERE update_time>=:1")
    public List<StarInfo> getByUpdateTime(String time);
}