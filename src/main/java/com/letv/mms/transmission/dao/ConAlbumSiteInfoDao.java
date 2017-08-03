package com.letv.mms.transmission.dao;

import java.util.Set;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.ConAlbumSiteInfoModel;

@DB
public interface ConAlbumSiteInfoDao {
    @SQL("SELECT * FROM con_album_site_info WHERE pid in(:1)")
    public ConAlbumSiteInfoModel[] getByIds(Set<Long> ids);
    
    @SQL("SELECT * FROM con_album_site_info WHERE pid=:1")
    public ConAlbumSiteInfoModel[] getById(long id);
}
