package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.DbDictionaryInfoModel;

@DB
public interface DbDictionaryInfoDao {
    @SQL("SELECT ID,VALUE,VALUE_EN FROM db_dictionary_info")
    public List<DbDictionaryInfoModel> getDict();
    
    @SQL("SELECT ID,VALUE,VALUE_EN FROM db_dictionary_info WHERE ID=:1")
    public DbDictionaryInfoModel getById(long id);
}
