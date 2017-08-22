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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brmayi.epiphany.util.EpiphanyFileUtil;
import com.brmayi.epiphany.util.GzCompressUtil;
import com.letv.mms.transmission.cache.thread.DictionaryCacheThread;
import com.letv.mms.transmission.cache.thread.LeThesaurusThread;
import com.letv.mms.transmission.cache.thread.StarCacheThread;
import com.letv.mms.transmission.cache.thread.TvCacheThread;
import com.letv.mms.transmission.common.Params;
import com.letv.mms.transmission.common.TaskUtilService;
import com.letv.mms.transmission.dao.ConAlbumLangInfoDao;
import com.letv.mms.transmission.dao.ConAlbumSiteInfoDao;
import com.letv.mms.transmission.dao.ConVideoInfoDao;
import com.letv.mms.transmission.dao.ConVideoLangInfoDao;
import com.letv.mms.transmission.dao.ConVideoSiteInfoDao;
import com.letv.mms.transmission.model.ConAlbumInfoModel;
import com.letv.mms.transmission.model.ConAlbumLangInfoModel;
import com.letv.mms.transmission.model.ConAlbumSiteInfoModel;
import com.letv.mms.transmission.model.ConVideoLangInfoModel;
import com.letv.mms.transmission.model.ConVideoSiteInfoModel;
import com.letv.mms.transmission.model.VideoListModel;
import com.letv.mms.transmission.service.util.PutUtilsService;

/**
 * 
 * **************************************************************
 * @ClassName: AlbumService 
 * @Description: 将专辑信息存成json
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:16:08
 *  
 * **************************************************************
 */
@Component
@Scope("prototype")
public class AlbumService {
	private Logger LOGGER = LoggerFactory.getLogger(AlbumService.class);
	
    @Resource
	private ConVideoInfoDao conVideoInfoDao;
    
    @Resource
   	private DictionaryCacheThread dictionaryService;
    
    @Resource
   	private StarCacheThread starCacheThread;
    
    @Resource
   	private PutUtilsService putUtilsService;
    
    @Resource
	private ConAlbumSiteInfoDao conAlbumSiteInfoDao;
    
    @Resource
	private ConAlbumLangInfoDao conAlbumLangInfoDao;
    
    @Resource
	private ConVideoSiteInfoDao conVideoSiteInfoDao;
    
    @Resource
	private ConVideoLangInfoDao conVideoLangInfoDao;
    
    @Resource
	private LeThesaurusThread leThesaurusThread;
    
    @Resource
    private TaskUtilService taskUtilService;
    
    @Resource
    private TvCacheThread tvService;

	public String dealAlbums(List<ConAlbumInfoModel> albums, boolean isRealtime,String path) {
    	StringBuffer content = new StringBuffer();
    	try {
			Map<Long, List<ConAlbumInfoModel>> albumMaps = new HashMap<Long, List<ConAlbumInfoModel>>();
			for(ConAlbumInfoModel album : albums) {
				if(StringUtils.isEmpty(album.getSite())) {
					content.append(albumFieldInput(album, null, null, isRealtime, path));//被删除的 
				} else {
					List<ConAlbumInfoModel> albumList = new ArrayList<ConAlbumInfoModel>();
					albumList.add(album);//主表里是中国站的中文数据
					albumMaps.put(album.getId(), albumList);
				}
			}
			albums = null;
			Set<Long> pidSmallers = albumMaps.keySet();
			if(pidSmallers.isEmpty()) return content.toString();
			for(Long id : pidSmallers) {
				ConAlbumInfoModel album = albumMaps.get(id).get(0);
				album.setSiteId(650001);
				album.setLang(700004);
				content.append(albumFieldInput(album, 650001, 700004, isRealtime, path));
			}
			ConAlbumSiteInfoModel[] sites = conAlbumSiteInfoDao.getByIds(pidSmallers);
			for(ConAlbumSiteInfoModel albumSite : sites) {
				ConAlbumInfoModel album = new ConAlbumInfoModel();
				BeanUtils.copyProperties(album, albumMaps.get(albumSite.getPid()));
				album.setId(albumSite.getPid());
				album.setDeleted(albumSite.getDeleted());
				album.setAlbumPic(albumSite.getAlbumPic());
				album.setPlayPlatform(albumSite.getPlayPlatform());
				album.setDownloadPlatform(albumSite.getDownloadPlatform());
				album.setPayPlatform(albumSite.getPayPlatform());
				album.setIsPay(albumSite.getIsPay());
				album.setPicOriginal(albumSite.getPicOriginal());
				album.setPicCollections(albumSite.getPicCollections());
				album.setContentRating(albumSite.getContentRating());
				album.setReleaseDate(albumSite.getReleaseDate());
				album.setCanSearch(albumSite.getCanSearch());
				album.setVideoFollowTime(albumSite.getVideoFollowTime());
				album.setUserId(albumSite.getUserId());
				album.setUpdateUid(albumSite.getUpdateUid());
				album.setCreateTime(albumSite.getCreateTime());
				album.setUpdateTime(albumSite.getUpdateTime());
				album.setExtData(albumSite.getExtData());
				album.setSubCategory(albumSite.getSubCategory());
				album.setCategoryExt(albumSite.getCategoryExt());
				album.setAutoCdnSize(albumSite.getAutoCdnSize());
				album.setAutoCdnOri(albumSite.getAutoCdnOri());
				album.setSiteId(albumSite.getSiteId());
				content.append(albumFieldInput(album, album.getSiteId(), 700004, isRealtime, path));
				List<ConAlbumInfoModel> siteList = albumMaps.get(albumSite.getPid());
				siteList.add(album);
				albumMaps.put(album.getId(), siteList);
			}
			sites = null;
			ConAlbumLangInfoModel[] langAlbums = conAlbumLangInfoDao.geByIds(pidSmallers);
			pidSmallers=null;
			for(ConAlbumLangInfoModel albumLang : langAlbums) {
				List<ConAlbumInfoModel> siteList = albumMaps.get(albumLang.getRelationId());
				if(siteList==null) {
					continue;
				}
				for(ConAlbumInfoModel a : siteList) {
					ConAlbumInfoModel album = new ConAlbumInfoModel();
					BeanUtils.copyProperties(album, a);
					album.setId(a.getId());
					album.setSubTitle(albumLang.getSubTitle());//   副标题
					album.setAlias(albumLang.getAlias());//   别名
					album.setTag(albumLang.getTag());//   标签
					album.setLang(albumLang.getLang());
					album.setShortDesc(albumLang.getShortDesc());//   简略描述
					album.setDescription(albumLang.getDescription());//   描述
					album.setVipWatchingFocus(albumLang.getVipWatchingFocus());// 看点
					album.setNameCn(albumLang.getName());//需要覆盖多语言表的name字段
					content.append(albumFieldInput(album, album.getSiteId(), albumLang.getLang(), isRealtime, path));
				}
			}
			albumMaps = null;
			langAlbums = null;
			if(!isRealtime) {
				EpiphanyFileUtil.writeToFile(path, content.toString()); //写入磁盘
				content = new StringBuffer();
			}
		} catch(Exception e) {
			LOGGER.error("数据处理错误", e);
			System.exit(0);
		}
    	return content.toString();
    }

	public void dealRealtimeMainAlbums(ConAlbumInfoModel album, String path) {
    	try {
			albumFieldInput(album, album.getSiteId(), album.getLang(), true, path);
		} catch(Exception e) {
			LOGGER.error("数据处理错误", e);
		}
    }
    
	public void dealRealtimeLangAlbums(ConAlbumInfoModel a, String path) {
    	try {
    		albumFieldInput(a, a.getSiteId(), a.getLang(), true, path);
    		ConAlbumSiteInfoModel[] sites = conAlbumSiteInfoDao.getById(a.getId());
			for(ConAlbumSiteInfoModel albumSite : sites) {
				ConAlbumInfoModel album = new ConAlbumInfoModel();
				BeanUtils.copyProperties(album, a);
				album.setId(albumSite.getPid());
				album.setDeleted(albumSite.getDeleted());
				album.setAlbumPic(albumSite.getAlbumPic());
				album.setPlayPlatform(albumSite.getPlayPlatform());
				album.setDownloadPlatform(albumSite.getDownloadPlatform());
				album.setPayPlatform(albumSite.getPayPlatform());
				album.setIsPay(albumSite.getIsPay());
				album.setPicOriginal(albumSite.getPicOriginal());
				album.setPicCollections(albumSite.getPicCollections());
				album.setContentRating(albumSite.getContentRating());
				album.setReleaseDate(albumSite.getReleaseDate());
				album.setCanSearch(albumSite.getCanSearch());
				album.setVideoFollowTime(albumSite.getVideoFollowTime());
				album.setUserId(albumSite.getUserId());
				album.setUpdateUid(albumSite.getUpdateUid());
				album.setCreateTime(albumSite.getCreateTime());
				album.setUpdateTime(albumSite.getUpdateTime());
				album.setExtData(albumSite.getExtData());
				album.setSubCategory(albumSite.getSubCategory());
				album.setCategoryExt(albumSite.getCategoryExt());
				album.setAutoCdnSize(albumSite.getAutoCdnSize());
				album.setAutoCdnOri(albumSite.getAutoCdnOri());
				album.setSiteId(albumSite.getSiteId());
				albumFieldInput(album, album.getSiteId(), album.getLang(), true, path);
			}
			
		} catch(Exception e) {
			LOGGER.error("数据处理错误", e);
		}
    }
	
	public void dealRealtimeSiteAlbums(ConAlbumInfoModel a, String path) {
    	try {
			ConAlbumLangInfoModel[] langAlbums = conAlbumLangInfoDao.geById(a.getId());
			for(ConAlbumLangInfoModel albumLang : langAlbums) {
				ConAlbumInfoModel album = new ConAlbumInfoModel();
				BeanUtils.copyProperties(album, a);
				album.setId(a.getId());
				album.setSubTitle(albumLang.getSubTitle());//   副标题
				album.setAlias(albumLang.getAlias());//   别名
				album.setTag(albumLang.getTag());//   标签
				album.setLang(albumLang.getLang());
				album.setShortDesc(albumLang.getShortDesc());//   简略描述
				album.setDescription(albumLang.getDescription());//   描述
				album.setVipWatchingFocus(albumLang.getVipWatchingFocus());// 看点
				album.setNameCn(albumLang.getName());//需要覆盖多语言表的name字段
				albumFieldInput(album, album.getSiteId(), albumLang.getLang(), true, path);
			}
		} catch(Exception e) {
			LOGGER.error("数据处理错误", e);
		}
    }
	
    private StringBuffer toMsg(JSONObject o, Long id, boolean isRealtime, String path) {
    	StringBuffer content = new StringBuffer();
    	try {
	    	content.append(id).append("\t");
	    	if(isRealtime) {
	    		content.append("album").append("\t");
	    		try {
	    			content.append(Base64.encode(GzCompressUtil.compress(o.toString().getBytes())));
	    			final String msg = content.toString();
	    			TaskUtilService.fixedThreadPool.execute(new Runnable() {  
	    				public void run() {  
	    					taskUtilService.swiftSendMsg(msg, true);
	    			}});
	    			LOGGER.info("id:{},site:{},lang:{}", id, o.get("siteId"), o.get("lang"));
				} catch (Exception e) {
					LOGGER.error("to msg error", e);
				}
	    		return new StringBuffer();
	    	}
	    	content.append(o.toString()).append("\r\n");
	    	JSONArray jsonArray = o.getJSONArray("videoList");
			if(!isRealtime && jsonArray!=null && jsonArray.size()>1000) {
				EpiphanyFileUtil.writeToFile(path, content.toString()); //写入磁盘
			}
    	} catch(Exception e) {
    		LOGGER.error("数据处理错误", e);
    	}
    	return content;
    }
    
    private StringBuffer albumFieldInput(ConAlbumInfoModel album, Integer site, Integer lang, boolean isRealtime, String path) {
    	try {
	    	SimpleDateFormat sdf = new SimpleDateFormat(Params.DATE_FORMAT);
	    	JSONObject albumJson = new JSONObject();
	        albumJson.put("id", album.getId());//专辑ID
	        albumJson.put("docCreateTime", sdf.format(new Date()));
	        albumJson.put("deleted", album.getDeleted()?1:0);//删除标记
	        if(site==null) {
	        	return toMsg(albumJson, album.getId(), isRealtime, path);
	        }
	        if(album.getAlbumType() != null) {
	        	dictionaryService.putSingleToJson(albumJson, "albumType", album.getAlbumType(), lang);//专辑类型
	        }
	        dictionaryService.putSingleToJson(albumJson, "sourceId", album.getSourceId(), lang);//所属渠道
	        albumJson.put("nameCn", album.getNameCn());//中文名称
	        albumJson.put("nameEn", album.getNameEn());//英文名称
	        albumJson.put("subTitle", album.getSubTitle());//副标题
	        albumJson.put("alias", album.getAlias());//别名
	        albumJson.put("shortDesc", album.getShortDesc());//简要描述
	        albumJson.put("description", album.getDescription()==null?null:album.getDescription().replace("\r\n", ""));//描述
	        albumJson.put("tag", album.getTag());//标签
	        albumJson.put("score", album.getScore());//评分
	        dictionaryService.putSingleToJson(albumJson, "category", album.getCategory(), lang);//电影、电视剧、综艺、动漫
	        dictionaryService.putMultiToJson(albumJson, "subCategory", album.getSubCategory(), lang);//动作 言情
	        dictionaryService.putMultiToJson(albumJson, "downloadPlatform", album.getDownloadPlatform(), lang);//允许下载平台
	        dictionaryService.putMultiToJson(albumJson, "playPlatform", album.getPlayPlatform(), lang);//允许播放平台
	        dictionaryService.putMultiToJson(albumJson, "payPlatform", album.getPayPlatform(), lang);//收费平台
	        albumJson.put("status", album.getStatus());//发布状态： 0,未发布 1已发布2发布失败
	        putUtilsService.putWhiteListToAlbumJson(albumJson, album.getId());//所有可以播放的国家
	        albumJson.put("isEnd", album.getIsEnd());//是否完结
	        albumJson.put("isHeight", album.getIsHeight());//是否高清
	        dictionaryService.putMultiToJson(albumJson, "area", album.getArea(), lang);//地区
	        dictionaryService.putSingleToJson(albumJson, "copyrightType", album.getCopyrightType(), lang);//版权类型
	        albumJson.put("duration", album.getDuration());//时长
	        albumJson.put("releaseDate", album.getReleaseDate());//上映时间
	        albumJson.put("doubanId", album.getDoubanId());//豆瓣ID
	        albumJson.put("episode", album.getEpisode());//总集数
	        albumJson.put("playStatus", album.getPlayStatus());//跟播状态
	        albumJson.put("makerCompany", album.getMakerCompany());//出品公司
	        starCacheThread.putMultiToJson(albumJson, "directory", album.getDirectory(), lang);//导演
	        starCacheThread.putMultiToJson(albumJson, "actor", album.getActor(), lang);//演员
	        starCacheThread.putMultiToJson(albumJson, "starring", album.getStarring(), lang);//主演
	        albumJson.put("starringPlay", album.getStarringPlay());//主演饰演角色
	        albumJson.put("picCollections", album.getPicCollections());//图片集
	        albumJson.put("screenWriter", album.getScreenWriter());//编剧
	        albumJson.put("maker", album.getMaker());//制片人
	        dictionaryService.putSingleToJson(albumJson, "filmBaseType", album.getFilmBaseType(), lang);//电影频道分类  1.电影 2.微电影
	        albumJson.put("rCompany", album.getrCompany());//陈氏传媒
	        dictionaryService.putSingleToJson(albumJson, "language", album.getLanguage(), lang);//内容语言
	        dictionaryService.putMultiToJson(albumJson, "fitAge", album.getFitAge(), lang);//适应年龄
	        starCacheThread.putMultiToJson(albumJson, "cast", album.getCast(), lang);//动漫频道的声优
	        starCacheThread.putMultiToJson(albumJson, "compere", album.getCompere(), lang);//主持人
	        starCacheThread.putMultiToJson(albumJson, "supervise", album.getSupervise(), lang);//动漫监督
	        starCacheThread.putMultiToJson(albumJson, "originator", album.getOriginator(), lang);//原作
	        albumJson.put("isPay", album.getIsPay());//是否付费
	        albumJson.put("relationId", album.getRelationId());//专辑关联ID
	        albumJson.put("isHomemade", album.getIsHomemade());//是否是自制剧
	        albumJson.put("playControlPlatformCntv", album.getPlayControlPlatformCntv());//CNTV播控方
	        albumJson.put("playControlPlatformHuashu", album.getPlayControlPlatformHuashu());//华数播放平台
	        albumJson.put("playControlPlatformGuoguang", album.getPlayControlPlatformGuoguang());//国广播放平台
	        albumJson.put("createTime", album.getCreateTime()==null?StringUtils.EMPTY:sdf.format(album.getCreateTime()));//创建时间
	        albumJson.put("updateTime", album.getUpdateTime()==null?StringUtils.EMPTY:sdf.format(album.getUpdateTime()));//修改时间
	        albumJson.put("varietyShow", album.getVarietyShow());//是否属于综艺频道
	        albumJson.put("appid", album.getAppid());//应用场景
	        albumJson.put("videoFollowTime", album.getVideoFollowTime()==null?StringUtils.EMPTY:sdf.format(album.getVideoFollowTime()));//视频跟播时间
	        dictionaryService.putSingleToJson(albumJson, "contentRating", album.getContentRating(), lang);//内容分级
	        albumJson.put("canSearch", album.getCanSearch());//能否被站内搜索：1站内可搜索，0站内搜索屏蔽，默认为1
	        albumJson.put("cloneSource", album.getCloneSource());//专辑克隆id来源
	        dictionaryService.putSingleToJson(albumJson, "siteId", site, lang);//站点标识
	        dictionaryService.putMultiToJson(albumJson, "style", album.getStyle(), lang);//风格
	        dictionaryService.putMultiToJson(albumJson, "coopPlatform", album.getCoopPlatform(), lang);//合作平台
	        albumJson.put("albumPic", album.getAlbumPic());//动态截图前缀
	        dictionaryService.putSingleToJson(albumJson, "riskLevel", album.getRiskLevel(), lang);//盗播风险(搜索用)
	        putUtilsService.putExtDataToJson(albumJson, new String[]{"play_mark", "is_vip_download", "is_push_child"}, album.getExtData());//"play_mark", "is_vip_download", "is_push_child"字段在 category_ext的Json字符串中
			putUtilsService.putExtDataByIntToJson(albumJson, new String[]{"pay_type", "is_coupon"}, album.getExtData());
	        dictionaryService.putCategoryExtToJson(albumJson, new String[]{"secondCate", "thirdCate", "childCate", "ageSection", "funcProperty"}, album.getCategoryExt(), lang);//"childCate", "ageSection", "funcProperty"字段在 category_ext的Json字符串中
	        albumJson.put("extData", album.getExtData());
	        albumJson.put("categoryExt", album.getCategoryExt());
	        albumJson.put("lang", lang);//多语言信息
	        putUtilsService.putCmsNocopyrightToJson(albumJson, album.getId());//cms版权信息
	        putUtilsService.putAddonToJson(albumJson, String.valueOf(album.getId()), 1);//专辑对应的Boss系统的addonid
	        putUtilsService.putPayendToJson(albumJson, String.valueOf(album.getId()), 1);//专辑对应的Boss系统的付费终端
	        albumJson.put("videoList", putToJsonArray(album.getId(), site, lang));//专辑包含的视频列表信息列表
	        leThesaurusThread.putMultiToJson(albumJson, "subLeId", album.getSubLeId(), lang);//乐词ID
	        albumJson.put("playTv", album.getPlayTv());
	        tvService.putMultiToJson(albumJson, "playTvMap", album.getPlayTv(), lang);
	        albumJson.put("userId", album.getUserId());
	        return toMsg(albumJson, album.getId(), isRealtime, path);
    	}catch(Exception e) {
    		LOGGER.error("album input error：{}", album.toString());
    	}
    	return null;
    }
	
    private JSONArray putToJsonArray(long pid, int site, int lang) {
    	JSONArray videoJson = new JSONArray();
    	int curBegin = 0;
		while(true) {
			List<VideoListModel> videos = conVideoInfoDao.getByPid(pid, curBegin);
			if(videos.isEmpty()) {
				break;
			}
			curBegin += videos.size();
			if(videos!=null) {
				for(VideoListModel video : videos) {
					video.setSiteId(site);
					video.setLang(lang);
					if(site==650001 && lang==700004) {
						videoJson.add(videoFieldInput(video.getPid(), video, 650001, 700004));
					} else {
						if(site!=650001) {
							ConVideoSiteInfoModel videoSite = conVideoSiteInfoDao.getByIdSite(video.getId(), site);
							if(videoSite==null || videoSite.getDeleted()) {
								continue;
							}
							video.setDeleted(videoSite.getDeleted()?1:0);
							video.setPlayPlatform(videoSite.getPlayPlatform());
							video.setDownloadPlatform(videoSite.getDownloadPlatform());
//							video.setPayPlatform(videoSite.getPayPlatform());
							video.setIsPay(videoSite.getIsPay());
//							video.setPicOriginal(videoSite.getPicOriginal());
//							video.setContentRating(videoSite.getContentRating());
//							video.setReleaseDate(videoSite.getReleaseDate());
							video.setCanSearch(videoSite.getCanSearch());
							video.setReleaseDate(videoSite.getReleaseDate());
//							video.setUserId(videoSite.getUserId());
//							video.setUpdateUid(videoSite.getUpdateUid());
//							video.setCreateTime(videoSite.getCreateTime());
//							video.setUpdateTime(videoSite.getUpdateTime());
//							video.setExtData(videoSite.getExtData());
//							video.setSubCategory(videoSite.getSubCategory());
//							video.setCategoryExt(videoSite.getCategoryExt());
//							video.setAutoCdnSize(videoSite.getAutoCdnSize());
//							video.setAutoCdnOri(videoSite.getAutoCdnOri());
							video.setPicUpload(videoSite.getPicUpload());
							video.setAutoVideoPic(videoSite.getAutoVideoPic());
//							video.setIsBigPic(videoSite.getIsBigPic());
							video.setSiteId(videoSite.getSiteId());
						}
						ConVideoLangInfoModel videoLang = conVideoLangInfoDao.getByIdLang(video.getId(), lang);
						if(videoLang != null) {
							video.setSubTitle(videoLang.getSubTitle());//   副标题
//							video.setAlias(videoLang.getAlias());//   别名
							video.setLang(videoLang.getLang());
//							video.setTag(videoLang.getTag());//   标签
//							video.setShortDesc(videoLang.getShortDesc());//   简略描述
//							video.setDescription(videoLang.getDescription());//   描述
//							video.setWatchingFocus(videoLang.getWatchingFocus());// 看点
							video.setNameCn(videoLang.getName());//需要覆盖多语言表的name字段
						}
						try {
							videoJson.add(videoFieldInput(video.getPid(), video, site, lang));
						} catch(Exception e) {
							LOGGER.error("专辑视频错误", e);
						}
					}
				}
			}
			if(videos.size()<TaskUtilService.ALBUM_VIDEO_LIMIT_DEAL_ONE_TIME) {
				break;
			}
			videos = null;
		}
		return videoJson;
    }
    
	private JSONObject videoFieldInput(Long albumId, VideoListModel video, int site, int lang) {
    	JSONObject videoJson = new JSONObject();
    	videoJson.put("id", video.getId());
    	videoJson.put("deleted", video.getDeleted());
    	if(video.getDeleted()==1) {
    		return videoJson;
    	}
    	videoJson.put("nameCn", video.getNameCn());//需要覆盖多语言表的name字段
    	videoJson.put("subTitle", video.getSubTitle());
    	videoJson.put("pid", albumId);
    	videoJson.put("mid", video.getMid());
    	dictionaryService.putSingleToJson(videoJson, "sourceId", video.getSourceId(), lang);//所属渠道
    	dictionaryService.putSingleToJson(videoJson, "category", video.getCategory(), lang);//频道
    	videoJson.put("isPay", video.getIsPay());
    	videoJson.put("canSearch", video.getCanSearch());
    	
    	dictionaryService.putSingleToJson(videoJson, "videoType", video.getVideoType(), lang);//频道
    	dictionaryService.putMultiToJson(videoJson, "playPlatform", video.getPlayPlatform(), lang);//推送平台
    	dictionaryService.putMultiToJson(videoJson, "downloadPlatform", video.getDownloadPlatform(), lang);//允许下载平台
    	videoJson.put("episode", video.getEpisode());
    	videoJson.put("porder", video.getPorder());
    	SimpleDateFormat sdf = new SimpleDateFormat(Params.DATE_FORMAT);
    	videoJson.put("createTime", sdf.format(video.getCreateTime()));
    	videoJson.put("releaseDate", video.getReleaseDate());
    	videoJson.put("duration", video.getDuration());
    	starCacheThread.putMultiToJson(videoJson, "actor", video.getActor(), lang);//演员
    	starCacheThread.putMultiToJson(videoJson, "starring", video.getStarring(), lang);//主演
    	starCacheThread.putMultiToJson(videoJson, "guest", video.getGuest(), lang);//嘉宾
    	videoJson.put("autoVideoPic", video.getAutoVideoPic());
    	videoJson.put("picUpload", video.getPicUpload());
    	videoJson.put("videoPic", video.getVideoPic());
    	videoJson.put("playControlPlatformGuoguang", video.getPlayControlPlatformGuoguang());//国广播放平台
    	putUtilsService.putWhiteListToVideoJson(videoJson, video.getId());//所有可以播放的国家
    	putUtilsService.putPlayStreamsToJson(videoJson, video.getMid(), site);//码流特征
        putUtilsService.putExtDataToJson(videoJson, new String[]{"vtype_flag"}, video.getExtData());//vtype_flag字段在 category_ext的Json字符串中
		putUtilsService.putExtDataByIntToJson(videoJson, new String[]{"pay_type", "is_coupon"}, video.getExtData());
        putUtilsService.putVideoSizeToJson(videoJson, video.getMid());//视频时长
        return videoJson;
    }
}
