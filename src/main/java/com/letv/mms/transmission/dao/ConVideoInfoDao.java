package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.common.TaskUtilService;
import com.letv.mms.transmission.model.ConVideoInfoModel;
import com.letv.mms.transmission.model.VideoListModel;

@DB
public interface ConVideoInfoDao {
    @SQL("SELECT MAX(ID) FROM con_video_info")
    public long getMaxId();
 
    @SQL("SELECT MIN(ID) FROM con_video_info")
    public long getMinId();
    
    @SQL("SELECT * FROM con_video_info WHERE ID>=:1 AND ID<:2")
    public ConVideoInfoModel[] getByStartEnd(long startId, long endId);
    
    @SQL("SELECT * FROM con_video_info WHERE ID in(:1)")
    public ConVideoInfoModel[] getByIds(List<Long> ids);
    
    @SQL("SELECT count(*) FROM con_video_info WHERE ID>=:1 AND ID<:2")
    public int getCountByStartEnd(long startId, long endId);
    
    @SQL("SELECT ID,SOURCE_ID,VIDEO_TYPE,PID,PORDER,MID,NAME_CN,NAME_PINYIN_ABB,NAME_EN,ALIAS,SUB_TITLE,SHORT_DESC,DESCRIPTION,TAG,CATEGORY,SUB_CATEGORY,CATEGORY_EXT,EPISODE,BTIME,ETIME,WATCHING_FOCUS,AD_POINT,COPYRIGHT_TYPE,COPYRIGHT_START,COPYRIGHT_END,COPYRIGHT_COMPANY,DOWNLOAD_PLATFORM,PLAY_PLATFORM,PAY_PLATFORM,IS_PAY,DURATION,STATUS,VIKI,DELETED,REMARK,SCORE,PIC_ORIGINAL,RELATIVE_CONTENT,RELEASE_DATE,FIRST_PLAY_TIME,AREA,SCHOOL,STARRING,STARTRING_PLAY,DIRECTORY,ACTOR,AUDIO_INFO,ACTOR_PLAY,OFFICIAL_URL,LANGUAGE,SINGLE_NAME,STYLE,INSTRUCTOR,COMPERE,GUEST,SINGER,SINGER_TYPE,MUSIC_AUTHORS,MAKER,RECORD_COMPANY,ISSUE_COMPANY,TEAM,PRE,QUALITY,IS_HOMEMADE,DIRECTION,LOGO_NUM,TRANSCODE_TAG,PLAY_TV,ON_TIME,OFF_TIME,PLAY_CONTROL_PLATFORM_CNTV,PLAY_CONTROL_PLATFORM_HUASHU,PLAY_CONTROL_PLATFORM_GUOGUANG,CREATE_TIME,UPDATE_TIME,USER_ID,UPDATE_UID,TEMP_PLAY_PLATFORM,PARAM1,PARAM2,APPID,FOLKART_TYPE,VIDEO_PIC,FIT_AGE,CONTENT_RATING,CLONE_SOURCE,CAN_SEARCH,PIC_UPLOAD,RECOMMEND,NAME_TW,ACTIVITY_ID,DRM_FLAG,SITE,IS_FIRST_LOOK,EXT_DATA,SOURCE_SITE,COOP_PLATFORM,LE_ID,AUTO_VIDEO_PIC,COPYRIGHT_CODE,SHARE_COPY,COPYRIGHT_SITE, 650001 FROM con_video_info WHERE pid=:1 limit :2,"+TaskUtilService.ALBUM_VIDEO_LIMIT_DEAL_ONE_TIME)
    public List<VideoListModel> getByPid(long pid, int begin);
    
    @SQL("SELECT ID FROM con_video_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getIdsByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_video_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public ConVideoInfoModel[] getByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_video_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND CREATE_TIME=UPDATE_TIME AND site=650004")
    public List<ConVideoInfoModel> getCreatedByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_video_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND CREATE_TIME!=UPDATE_TIME AND site=650004")
    public List<ConVideoInfoModel> getUpdatedByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_video_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND DELETED=1 AND site=650004")
    public List<ConVideoInfoModel> getDeletedByUpdatetime(String begin, String end);
}
