package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface ConVideoShieldDao {
    @SQL("SELECT white_list FROM con_video_shield WHERE PID=:1 AND TYPE=1")
    public String[] getAlbumWhiteList(long pid);
    
    @SQL("SELECT white_list FROM con_video_shield WHERE VID=:1 AND TYPE=2")
    public String[] getVideoWhiteList(long vid);
    
    @SQL("SELECT VID FROM con_video_shield WHERE TYPE=2 AND UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getVidByUpdatetime(String begin, String end);
    
    @SQL("SELECT PID FROM con_video_shield WHERE TYPE=1 AND UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getPidByUpdatetime(String begin, String end);
}
