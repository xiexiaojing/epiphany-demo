package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import com.letv.mms.transmission.model.ConAlbumInfoModel;

@DB
public interface ConAlbumInfoDao {
    @SQL("SELECT MAX(ID) FROM con_album_info")
    public long getMaxId();
 
    @SQL("SELECT MIN(ID) FROM con_album_info")
    public long getMinId();
    
    @SQL("SELECT ID FROM con_album_info WHERE ID NOT IN (:1)")
    public List<Long> getIds(List<Long> ids);
    
    @SQL("SELECT PID FROM con_video_info WHERE PID IS NOT NULL GROUP BY PID having count(*)>500")
    public List<Long> getLargeVideosIds();
   
    @SQL("SELECT *,650001 as siteId, 700004 as lang FROM con_album_info WHERE ID in(:1)")
    public List<ConAlbumInfoModel> getByIds(List<Long> ids);
    
    @SQL("SELECT *,650001 as siteId, 700004 as lang FROM con_album_info WHERE ID>=:1 AND ID<:2")
    public List<ConAlbumInfoModel> getByStartEnd(long startId, long endId);

    @SQL("SELECT ID FROM con_album_info WHERE ID>=:1 AND ID<:2")
    public List<Long> getIdsByStartEnd(long startId, long endId);
    
    @SQL("SELECT ID FROM con_album_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public List<Long> getIdsByUpdatetime(String begin, String end);
    
    @SQL("SELECT *,650001 as siteId, 700004 as lang FROM con_album_info WHERE UPDATE_TIME BETWEEN :1 AND :2")
    public List<ConAlbumInfoModel> getByUpdatetime(String begin, String end);
    
    @SQL("SELECT s.video_follow_time,s.release_date,s.content_rating,s.pic_original,s.pic_collections,s.site_id,a.ID,a.ALBUM_TYPE,a.SOURCE_ID,a.NAME_CN,a.NAME_PINYIN_ABB,a.NAME_EN,a.SUB_TITLE,a.VERSION_TITLE,a.ALIAS,a.SHORT_DESC,a.DESCRIPTION,a.TAG,a.SCORE,a.CATEGORY,s.sub_category,s.download_platform,s.play_platform,s.pay_platform,a.STATUS,s.deleted,a.REMARK,a.IS_END,a.IS_HEIGHT,a.AREA,a.COPYRIGHT_TYPE,a.COPYRIGHT_START,a.COPYRIGHT_END,a.COPYRIGHT_COMPANY,a.DURATION,a.LETV_RELEASE_DATE,a.DOUBAN_ID,a.IMDB,a.EPISODE,a.PLAY_STATUS,a.vip_watching_focus,a.MAKER_COMPANY,a.DIRECTORY,a.ACTOR,a.STARRING,a.STARRING_PLAY,a.STARRING_PLAY_PIC,a.STARRING_DESC,a.SCREEN_WRITER,a.MAKER,a.LETV_MAKE_STYLE,a.LETV_PRODUCE_STYLE,a.FILM_BASE_TYPE,a.R_COMPANY,a.OFFICIAL_URL,a.LANGUAGE,a.FIT_AGE,a.CAST,a.DUB,a.PRODUCER,a.COMPERE,a.INSTRUCTOR,a.MUSIC_AUTHORS,a.ISSUE_COMPANY,a.MUSIC_COMPOSE,a.PLAY_TV,a.SUPERVISE,a.ORIGINATOR,a.FIRST_PLAY_TIME,a.SCHOOL,s.is_pay,a.RELATION_ID,a.IS_HOMEMADE,a.ON_TIME,a.OFF_TIME,a.PLAY_CONTROL_PLATFORM_CNTV,a.PLAY_CONTROL_PLATFORM_HUASHU,a.PLAY_CONTROL_PLATFORM_GUOGUANG,s.USER_ID,s.UPDATE_UID,s.CREATE_TIME,s.UPDATE_TIME,a.VARIETY_SHOW,a.APPID,a.CLONE_SOURCE,s.can_search,a.FIRST_PLAY_TV,a.REPEAT_PLAY_TV,s.EXT_DATA,a.STYLE,a.AUDIO_INFO,a.COOP_PLATFORM,a.LE_ID,s.album_pic,a.SUB_LE_ID,a.RISK_LEVEL,s.CATEGORY_EXT,a.COPYRIGHT_CODE,a.COPYRIGHT_SITE FROM con_album_info AS a INNER JOIN con_album_site_info AS s ON a.id=s.pid WHERE s.UPDATE_TIME BETWEEN :1 AND :2")
    public ConAlbumInfoModel[] getSiteByUpdatetime(String begin, String end);

    @SQL("SELECT l.vip_watching_focus, 650001 as siteId,l.lang,a.video_follow_time,a.release_date,a.content_rating,a.pic_original,a.pic_collections,a.ID,a.ALBUM_TYPE,a.SOURCE_ID,l.name as nameCn,a.NAME_PINYIN_ABB,a.NAME_EN,l.SUB_TITLE,a.VERSION_TITLE,l.ALIAS,l.SHORT_DESC,l.DESCRIPTION,l.TAG,a.SCORE,a.CATEGORY,a.SUB_CATEGORY,a.download_platform,a.play_platform,a.pay_platform,a.STATUS,a.deleted,a.REMARK,a.IS_END,a.IS_HEIGHT,a.AREA,a.COPYRIGHT_TYPE,a.COPYRIGHT_START,a.COPYRIGHT_END,a.COPYRIGHT_COMPANY,a.DURATION,a.LETV_RELEASE_DATE,a.DOUBAN_ID,a.IMDB,a.EPISODE,a.PLAY_STATUS,a.MAKER_COMPANY,a.DIRECTORY,a.ACTOR,a.STARRING,a.STARRING_PLAY,a.STARRING_PLAY_PIC,a.STARRING_DESC,a.SCREEN_WRITER,a.MAKER,a.LETV_MAKE_STYLE,a.LETV_PRODUCE_STYLE,a.FILM_BASE_TYPE,a.R_COMPANY,a.OFFICIAL_URL,a.LANGUAGE,a.FIT_AGE,a.CAST,a.DUB,a.PRODUCER,a.COMPERE,a.INSTRUCTOR,a.MUSIC_AUTHORS,a.ISSUE_COMPANY,a.MUSIC_COMPOSE,a.PLAY_TV,a.SUPERVISE,a.ORIGINATOR,a.FIRST_PLAY_TIME,a.SCHOOL,a.IS_PAY,a.RELATION_ID,a.IS_HOMEMADE,a.ON_TIME,a.OFF_TIME,a.PLAY_CONTROL_PLATFORM_CNTV,a.PLAY_CONTROL_PLATFORM_HUASHU,a.PLAY_CONTROL_PLATFORM_GUOGUANG,a.USER_ID,a.UPDATE_UID,a.CREATE_TIME,a.UPDATE_TIME,a.VARIETY_SHOW,a.APPID,a.CLONE_SOURCE,a.CAN_SEARCH,a.FIRST_PLAY_TV,a.REPEAT_PLAY_TV,a.EXT_DATA,a.STYLE,a.AUDIO_INFO,a.COOP_PLATFORM,a.LE_ID,a.ALBUM_PIC,a.SUB_LE_ID,a.RISK_LEVEL,a.CATEGORY_EXT,a.COPYRIGHT_CODE,a.COPYRIGHT_SITE FROM con_album_info AS a INNER JOIN con_album_lang_info AS l ON a.id=l.relation_id WHERE l.UPDATE_TIME BETWEEN :1 AND :2")
    public ConAlbumInfoModel[] getLangByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_album_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND CREATE_TIME=UPDATE_TIME AND site=650004")
    public List<ConAlbumInfoModel> getCreatedByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_album_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND CREATE_TIME!=UPDATE_TIME AND site=650004")
    public List<ConAlbumInfoModel> getUpdatedByUpdatetime(String begin, String end);
    
    @SQL("SELECT * FROM con_album_info WHERE UPDATE_TIME BETWEEN :1 AND :2 AND DELETED=1 AND site=650004")
    public List<ConAlbumInfoModel> getDeletedByUpdatetime(String begin, String end);
}
