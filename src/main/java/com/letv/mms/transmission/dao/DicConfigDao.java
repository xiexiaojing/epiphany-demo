package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.DicConfig;

@DB
public interface DicConfigDao {
    @SQL("SELECT a.id, a.dic_name, a.dic_name_hk, b.dic_name as dicNameEn FROM dic_config as a INNER JOIN dic_config_lang as b ON a.id=b.relation_id")
    public List<DicConfig> getDict();
    
    @SQL("SELECT a.id, a.dic_name, a.dic_name_hk, b.dic_name as dicNameEn FROM dic_config as a INNER JOIN dic_config_lang as b ON a.id=b.relation_id WHERE a.id=:1")
    public DicConfig getById(long id);
}
