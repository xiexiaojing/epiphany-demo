package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.LeThesaurus;

@DB
public interface LeThesaurusDao {
    @SQL("SELECT id,name,type FROM le_thesaurus WHERE status=1")
    public List<LeThesaurus> getAll();
    
    @SQL("SELECT id,name,type FROM le_thesaurus WHERE status=1 AND id=:1")
    public LeThesaurus getById(int id);
    
//    @SQL("SELECT id,name,type FROM le_thesaurus WHERE status=1")
//    public List<LeThesaurus> getByUpdateTime();
}