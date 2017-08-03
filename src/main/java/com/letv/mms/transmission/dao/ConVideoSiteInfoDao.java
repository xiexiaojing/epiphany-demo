package com.letv.mms.transmission.dao;

import java.util.List;
import java.util.Set;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.ConVideoSiteInfoModel;

@DB
public interface ConVideoSiteInfoDao {
    @SQL("SELECT * FROM con_video_site_info WHERE vid in(:1)")
	public ConVideoSiteInfoModel[] getByIds(Set<Long> ids);
    
    @SQL("SELECT * FROM con_video_site_info WHERE vid =:1 and site_id=:2")
	public ConVideoSiteInfoModel getByIdSite(long id, int siteId);
    
    @SQL("SELECT site_id FROM con_video_site_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getByUpdatetime(String begin, String end);
}
