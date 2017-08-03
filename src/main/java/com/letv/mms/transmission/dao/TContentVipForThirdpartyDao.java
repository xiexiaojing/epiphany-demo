package com.letv.mms.transmission.dao;

import java.util.Date;
import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface TContentVipForThirdpartyDao {
	@SQL("SELECT vips FROM letv_boss.t_content_vip_for_thirdparty WHERE cid=:1 AND ctype=:2")
    public String getVipsByCidCtype(String cid,int ctype);
	
    @SQL("SELECT cid FROM letv_boss.t_content_vip_for_thirdparty WHERE updatetime > :1 AND createtime=updatetime AND ctype=:2")
    public List<String> getCreatedByUpdatetime(String begin, int ctype);
    
    @SQL("SELECT cid FROM letv_boss.t_content_vip_for_thirdparty WHERE updatetime > :1 AND createtime!=updatetime AND ctype=:2")
    public List<String> getUpdatedByUpdatetime(String begin, int ctype);
    
    @SQL("SELECT updatetime FROM letv_boss.t_content_vip_for_thirdparty WHERE ctype=:1 order by updatetime desc limit 1")
    public Date getLastUpdateTime(int ctype);
    
    @SQL("SELECT cid FROM letv_boss.t_content_vip_for_thirdparty WHERE ctype=3 AND updatetime BETWEEN :1 AND :2")
    public List<Long> getVidByUpdatetime(String begin, String end);
    
    @SQL("SELECT cid FROM letv_boss.t_content_vip_for_thirdparty WHERE ctype=1 AND updatetime BETWEEN :1 AND :2")
    public List<Long> getPidByUpdatetime(String begin, String end);
}