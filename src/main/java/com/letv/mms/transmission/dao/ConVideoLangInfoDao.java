package com.letv.mms.transmission.dao;

import java.util.List;
import java.util.Set;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.ConVideoLangInfoModel;

@DB
public interface ConVideoLangInfoDao {
    @SQL("SELECT * FROM con_video_lang_info WHERE relation_id in(:1)")
    public List<ConVideoLangInfoModel> getByIds(Set<Long> ids);
    
    @SQL("SELECT * FROM con_video_lang_info WHERE relation_id in(:1) and lang=:2")
    public List<ConVideoLangInfoModel> getByIdsLang(Set<Long> ids, int lang);
    
    @SQL("SELECT * FROM con_video_lang_info WHERE relation_id =:1 and lang=:2")
    public ConVideoLangInfoModel getByIdLang(long id, int lang);
    
    @SQL("SELECT relation_id FROM con_video_lang_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getByUpdatetime(String begin, String end);
}
