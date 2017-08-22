package com.letv.mms.transmission.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xerces.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.brmayi.epiphany.util.EpiphanyFileUtil;
import com.brmayi.epiphany.util.GzCompressUtil;
import com.letv.mms.transmission.cache.thread.DictionaryCacheThread;
import com.letv.mms.transmission.cache.thread.LeThesaurusThread;
import com.letv.mms.transmission.cache.thread.StarCacheThread;
import com.letv.mms.transmission.cache.thread.TvCacheThread;
import com.letv.mms.transmission.common.Params;
import com.letv.mms.transmission.common.TaskUtilService;
import com.letv.mms.transmission.dao.ConVideoLangInfoDao;
import com.letv.mms.transmission.dao.ConVideoSiteInfoDao;
import com.letv.mms.transmission.model.ConVideoInfoModel;
import com.letv.mms.transmission.model.ConVideoLangInfoModel;
import com.letv.mms.transmission.model.ConVideoSiteInfoModel;
import com.letv.mms.transmission.service.util.PutUtilsService;

/**
 * 
 * **************************************************************
 * @ClassName: VideoService 
 * @Description: 将视频信息存成json
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:16:00
 *  
 * **************************************************************
 */
@Component
@Scope("prototype")
public class VideoService {  
    private final static Logger LOGGER = LoggerFactory.getLogger(VideoService.class);
    @Resource
   	private DictionaryCacheThread dictionaryService;
    
    @Resource
   	private StarCacheThread starCacheThread;
    
    @Resource
   	private PutUtilsService putUtilsService;  
    
    @Resource
	private ConVideoSiteInfoDao conVideoSiteInfoDao;
    
    @Resource
	private ConVideoLangInfoDao conVideoLangInfoDao;
    
    @Resource
    private TaskUtilService taskUtilService;
    
    @Resource
	private LeThesaurusThread leThesaurusThread;
    
    @Resource
    private TvCacheThread tvService;
    
    public String dealVideos(ConVideoInfoModel[] videos, boolean isRealtime, String path) {
    	StringBuffer content = new StringBuffer();
    	try {
			Map<Long, List<ConVideoInfoModel>> videoMaps = new HashMap<Long, List<ConVideoInfoModel>>();
			for(ConVideoInfoModel video : videos) {
				if(StringUtils.isEmpty(video.getSite())) {
					content.append(videoFieldInput(video, null, null, isRealtime));//被删除的 
				} else {
					List<ConVideoInfoModel> videoList = new ArrayList<ConVideoInfoModel>();
					videoList.add(video);
					videoMaps.put(video.getId(), videoList);//主表里是中国站的中文数据
				}
			}
			Set<Long> ids = videoMaps.keySet();
			if(ids.isEmpty()) return content.toString();
			
			for(Long id : ids) {
				try {
					ConVideoInfoModel video = videoMaps.get(id).get(0);
					video.setSiteId(650001);
					video.setLang(700004);
					content.append(videoFieldInput(video, 650001, 700004, isRealtime));
				} catch (Exception e) {
					LOGGER.error("数据处理错误", e);
				}
			}
			if(!isRealtime) {
				EpiphanyFileUtil.writeToFile(path, content.toString()); //写入磁盘
				content = new StringBuffer();
			}
			ConVideoSiteInfoModel[] sites = conVideoSiteInfoDao.getByIds(ids);
			for(ConVideoSiteInfoModel videoSite : sites) {
				ConVideoInfoModel video = new ConVideoInfoModel();
				BeanUtils.copyProperties(video, videoMaps.get(videoSite.getVid()));
				video.setId(videoSite.getVid());
				video.setDeleted(videoSite.getDeleted());
				video.setPlayPlatform(videoSite.getPlayPlatform());
				video.setDownloadPlatform(videoSite.getDownloadPlatform());
				video.setPayPlatform(videoSite.getPayPlatform());
				video.setIsPay(videoSite.getIsPay());
				video.setPicOriginal(videoSite.getPicOriginal());
				video.setContentRating(videoSite.getContentRating());
				video.setReleaseDate(videoSite.getReleaseDate());
				video.setCanSearch(videoSite.getCanSearch());
				video.setUserId(videoSite.getUserId());
				video.setUpdateUid(videoSite.getUpdateUid());
				video.setCreateTime(videoSite.getCreateTime());
				video.setUpdateTime(videoSite.getUpdateTime());
				video.setExtData(videoSite.getExtData());
				video.setSubCategory(videoSite.getSubCategory());
				video.setCategoryExt(videoSite.getCategoryExt());
				video.setAutoCdnSize(videoSite.getAutoCdnSize());
				video.setAutoCdnOri(videoSite.getAutoCdnOri());
				video.setPicUpload(videoSite.getPicUpload());
				video.setAutoVideoPic(videoSite.getAutoVideoPic());
				video.setIsBigPic(videoSite.getIsBigPic());
				video.setSiteId(videoSite.getSiteId());
				List<ConVideoInfoModel> siteList = videoMaps.get(video.getId());
				if(siteList==null) {
					siteList = new ArrayList<ConVideoInfoModel>();
				}
				siteList.add(video);
				videoMaps.put(video.getId(), siteList);
			}
			sites = null;
			List<ConVideoLangInfoModel> videoLangs = conVideoLangInfoDao.getByIds(ids);
			for(ConVideoLangInfoModel videoLang : videoLangs) {
				List<ConVideoInfoModel> videoSiteList = videoMaps.get(videoLang.getRelationId());
				for(ConVideoInfoModel v : videoSiteList) {
					ConVideoInfoModel video = new ConVideoInfoModel();
					try {
						BeanUtils.copyProperties(video, v);
					} catch(Exception e) {
						LOGGER.error("数据转化错误:{}", v, e);
					}
					video.setId(v.getId());
					video.setSubTitle(videoLang.getSubTitle());//   副标题
					video.setAlias(videoLang.getAlias());//   别名
					video.setLang(videoLang.getLang());
					video.setTag(videoLang.getTag());//   标签
					video.setShortDesc(videoLang.getShortDesc());//   简略描述
					video.setDescription(videoLang.getDescription());//   描述
					video.setWatchingFocus(videoLang.getWatchingFocus());// 看点
					video.setNameCn(videoLang.getName());//需要覆盖多语言表的name字段
					content.append(videoFieldInput(video, video.getSiteId(), videoLang.getLang(), isRealtime));
				}
			}
			if(!isRealtime) {
				EpiphanyFileUtil.writeToFile(path, content.toString()); //写入磁盘
				content = new StringBuffer();
			}
			videoLangs = null;
			ids = null;
			videoMaps = null;
    	}catch(Exception e) {
    		LOGGER.error("数据处理错误", e);
    	}
    	return content.toString();
    }
    
    private StringBuffer toMsg(JSONObject o, Long id, boolean isRealtime) {
    	StringBuffer content = new StringBuffer();
    	content.append(id).append("\t");
    	if(isRealtime) {
    		content.append("video").append("\t");
    		try {
    			content.append(Base64.encode(GzCompressUtil.compress(o.toString().getBytes())));
    			LOGGER.info("id:{},site:{},lang:{}", id, o.get("siteId"), o.get("lang"));
    			taskUtilService.swiftSendMsg(content.toString(),false);
			} catch (Exception e) {
				LOGGER.error("数据压缩错误", e);
			}
    		return new StringBuffer();
    	}
    	return content.append(o.toString()).append("\r\n");
    }
    
    private StringBuffer videoFieldInput(ConVideoInfoModel video, Integer site, Integer lang, boolean isRealtime) {
    	JSONObject videoJson = new JSONObject();
    	try {
	    	SimpleDateFormat sdf = new SimpleDateFormat(Params.DATE_FORMAT);
	        videoJson.put("id", video.getId());//专辑ID
	        videoJson.put("docCreateTime", sdf.format(new Date()));
	        videoJson.put("deleted", video.getDeleted()?1:0);//删除标记
	        if(site==null) {
	        	return toMsg(videoJson, video.getId(), isRealtime);
	        }
	        dictionaryService.putSingleToJson(videoJson, "sourceId", video.getSourceId(), lang);//所属渠道
	        dictionaryService.putSingleToJson(videoJson, "videoType", video.getVideoType(), lang);//视频类型
	        videoJson.put("pid", video.getPid());//专辑ID
	        videoJson.put("porder", video.getPorder());//在专辑顺序
	        videoJson.put("mid", video.getMid());
	        videoJson.put("nameCn", video.getNameCn());//中文名称
	        videoJson.put("nameEn", video.getNameEn());//英文名称
	        videoJson.put("alias", video.getAlias());//别名
	        videoJson.put("subTitle", video.getSubTitle());//副标题
	        videoJson.put("shortDesc", video.getShortDesc());//简要描述
	        videoJson.put("description", video.getDescription()==null?null:video.getDescription().replace("\r\n", ""));//描述
	        videoJson.put("tag", video.getTag());//标签
	        dictionaryService.putSingleToJson(videoJson, "category", video.getCategory(), lang);//电影、电视剧、综艺、动漫
	        dictionaryService.putMultiToJson(videoJson, "subCategory", video.getSubCategory(), lang);//动作 言情
	        videoJson.put("episode", video.getEpisode());//总集数
	        videoJson.put("watchingFocus", video.getWatchingFocus());//看点
	        dictionaryService.putSingleToJson(videoJson, "copyrightType", video.getCopyrightType(), lang);//版权类型
	        videoJson.put("copyrightCompany", video.getCopyrightCompany());//版权公司
	        dictionaryService.putMultiToJson(videoJson, "downloadPlatform", video.getDownloadPlatform(), lang);//允许下载平台
	        dictionaryService.putMultiToJson(videoJson, "playPlatform", video.getPlayPlatform(), lang);//允许播放平台
	        dictionaryService.putMultiToJson(videoJson, "payPlatform", video.getPayPlatform(), lang);//收费平台
	        videoJson.put("duration", video.getDuration());//时长
	        videoJson.put("status", video.getStatus());//发布状态： 0,未发布 1已发布2发布失败
	        videoJson.put("score", video.getScore());//评分
	        videoJson.put("relativeContent", video.getRelativeContent());//关联内容
	        videoJson.put("releaseDate", video.getReleaseDate());//上映时间
	        dictionaryService.putMultiToJson(videoJson, "area", video.getArea(), lang);//地区
	        starCacheThread.putMultiToJson(videoJson, "starring", video.getStarring(), lang);//主演
	        videoJson.put("startringPlay", video.getStartringPlay());//主演饰演角色
	        starCacheThread.putMultiToJson(videoJson, "directory", video.getDirectory(), lang);//导演
	        starCacheThread.putMultiToJson(videoJson, "actor", video.getActor(), lang);//演员
	        starCacheThread.putMultiToJson(videoJson, "compere", video.getCompere(), lang);//主持人
	        videoJson.put("actorPlay", video.getActorPlay());//饰演角色
	        dictionaryService.putSingleToJson(videoJson, "language", video.getLanguage(), lang);//内容语言
	        dictionaryService.putMultiToJson(videoJson, "style", video.getStyle(), lang);//风格
	        starCacheThread.putMultiToJson(videoJson, "guest", video.getGuest(), lang);//嘉宾
	        dictionaryService.putMultiToJson(videoJson, "singerType", video.getSingerType(), lang);//歌手类型
	        videoJson.put("musicAuthors", video.getMusicAuthors());//音乐作词人
	        videoJson.put("recordCompany", video.getRecordCompany());//唱片公司
	        videoJson.put("isHomemade", video.getIsHomemade());//是否是自制剧
	        videoJson.put("playControlPlatformCntv", video.getPlayControlPlatformCntv());//CNTV播控方
	        videoJson.put("playControlPlatformHuashu", video.getPlayControlPlatformHuashu());//华数播放平台
	        videoJson.put("playControlPlatformGuoguang", video.getPlayControlPlatformGuoguang());//国广播放平台
	        videoJson.put("createTime", video.getCreateTime()==null?StringUtils.EMPTY:sdf.format(video.getCreateTime()));//创建时间
	        videoJson.put("updateTime", video.getUpdateTime()==null?StringUtils.EMPTY:sdf.format(video.getUpdateTime()));//修改时间
	        videoJson.put("appid", video.getAppid());//应用场景
	        videoJson.put("videoPic", video.getVideoPic());//动态截图前缀
	        dictionaryService.putMultiToJson(videoJson, "fitAge", video.getFitAge(), lang);//适应年龄
	        videoJson.put("cloneSource", video.getCloneSource());//专辑克隆id来源
	        videoJson.put("canSearch", video.getCanSearch());//能否被站内搜索：1站内可搜索，0站内搜索屏蔽，默认为1
	        videoJson.put("picUpload", video.getPicUpload());//上传图片
	        videoJson.put("picOriginal", video.getPicOriginal());
	        dictionaryService.putSingleToJson(videoJson, "siteId", site, lang);//站点标识
	        videoJson.put("autoVideoPic", video.getAutoVideoPic());//动态截图前缀
	        videoJson.put("isPay", video.getIsPay());//是否付费
	        putUtilsService.putWhiteListToVideoJson(videoJson, video.getId());//所有可以播放的国家
	        putUtilsService.putPlayStreamsToJson(videoJson, video.getMid(), lang);//码流特征
	        videoJson.put("lang", lang);//多语言信息
	        putUtilsService.putCmsNocopyrightContentToJson(videoJson, video.getPid());//是否为CMS非版权运营视频
	        putUtilsService.putAddonToJson(videoJson, String.valueOf(video.getId()), 3);//对应的Boss系统的addonid
//	        putUtilsService.putPayendToJson(videoJson, String.valueOf(video.getId()), 3);//专辑对应的Boss系统的付费终端
	        dictionaryService.putSingleToJson(videoJson, "contentRating", video.getContentRating(), lang);//内容分级
	        videoJson.put("extData", video.getExtData());
	        videoJson.put("categoryExt", video.getCategoryExt());
			//注意：is_vip_download字段值wiki中定义为string类型，extData中是int类型，搜索对接已按string类型解析。
	    	putUtilsService.putExtDataToJson(videoJson, new String[]{"is_vip_download", "is_push_child", "vtype_flag"}, video.getExtData());//"play_mark", "is_vip_download", "is_push_child", vtype_flag字段在 category_ext的Json字符串中
			putUtilsService.putExtDataByIntToJson(videoJson, new String[]{"pay_type", "is_coupon"}, video.getExtData());
	        dictionaryService.putCategoryExtToJson(videoJson, new String[]{"childCate", "funcProperty"}, video.getCategoryExt(), lang);//"childCate", "ageSection", "funcProperty"字段在 category_ext的Json字符串中
	        
	        videoJson.put("playTv", video.getPlayTv());
	        tvService.putMultiToJson(videoJson, "playTvMap", video.getPlayTv(), lang);
	        videoJson.put("userId", video.getUserId());
	        videoJson.put("copyrightCompany", video.getCopyrightCompany());
	        putUtilsService.putVideoSizeToJson(videoJson, video.getMid());//视频时长
	        leThesaurusThread.putMultiToJson(videoJson, null, video.getLeId(), lang);//乐词ID
    	}catch(Exception e) {
    		LOGGER.error("数据处理错误", e);
    	}
    	return toMsg(videoJson, video.getId(), isRealtime);
    }
}
