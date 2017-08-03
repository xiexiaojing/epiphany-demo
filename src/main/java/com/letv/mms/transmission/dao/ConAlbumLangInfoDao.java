package com.letv.mms.transmission.dao;

import java.util.Set;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.ConAlbumLangInfoModel;

@DB
public interface ConAlbumLangInfoDao {
    @SQL("SELECT * FROM con_album_lang_info WHERE relation_id=:1")
    public ConAlbumLangInfoModel[] geById(long id);
    
    @SQL("SELECT * FROM con_album_lang_info WHERE relation_id in(:1)")
    public ConAlbumLangInfoModel[] geByIds(Set<Long> ids);
}
