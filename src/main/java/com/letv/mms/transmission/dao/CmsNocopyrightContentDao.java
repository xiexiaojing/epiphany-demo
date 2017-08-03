package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.CmsNocopyrightContent;

@DB
public interface CmsNocopyrightContentDao {
    @SQL("SELECT id,contentid,title,externalUrl,cityBlackList,cityLevel,btime,etime,operator,status,mtime,ctime,shieldCityList,channel FROM cms.CMS_NOCOPYRIGHT_CONTENT WHERE contentid=:1 AND status=1")
    public CmsNocopyrightContent getByPidStatus(String pid);
    
    @SQL("SELECT contentid FROM cms.CMS_NOCOPYRIGHT_CONTENT WHERE mtime BETWEEN :1 AND :2")
    public List<Long> getByUpdatetime(String begin, String end);
}
