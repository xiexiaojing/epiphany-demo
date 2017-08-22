package com.letv.mms.transmission.service.util;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.letv.mms.transmission.cache.thread.DictionaryCacheThread;
import com.letv.mms.transmission.common.Params;
import com.letv.mms.transmission.dao.CmsNocopyrightContentDao;
import com.letv.mms.transmission.dao.ConAlbumLangInfoDao;
import com.letv.mms.transmission.dao.ConMmsFileInfoDao;
import com.letv.mms.transmission.dao.ConVideoFileCodeDao;
import com.letv.mms.transmission.dao.ConVideoShieldDao;
import com.letv.mms.transmission.dao.TContentVipForThirdpartyDao;
import com.letv.mms.transmission.model.CmsNocopyrightContent;
import com.letv.mms.transmission.model.KeyValue;

/**
 * 
 * **************************************************************
 * @ClassName: PutUtilsService 
 * @Description: 把需要从另外数据库中查询的都在这里装配进json,保证专辑和视频service一个语句装配一个对象到json. 
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:20:54
 *  
 * **************************************************************
 */
@Component
public class PutUtilsService {
    
    @Resource
   	private DictionaryCacheThread dictionaryService;
	
    @Resource
   	private ConAlbumLangInfoDao conAlbumLangInfoDao;
    
    @Resource
   	private ConMmsFileInfoDao conMmsFileInfoDao;
    
    @Resource
   	private ConVideoShieldDao conVideoShieldDao;
    
    @Resource
   	private CmsNocopyrightContentDao cmsNocopyrightContentDao;
    
    @Resource
   	private TContentVipForThirdpartyDao tContentVipForThirdpartyDao;

//    @Resource
//   	private TContentPayStrategyForThirdpartyDao tContentPayStrategyForThirdpartyDao;
    
    @Resource
   	private ConVideoFileCodeDao conVideoFileCodeDao;
    
    private Logger LOGGER = LoggerFactory.getLogger(PutUtilsService.class);
    
	/**
	 * 所有可以播放的国家
	 * @param json
	 * @param pid
	 * @param site
	 */	
	public void putWhiteListToAlbumJson(JSONObject json, Long pid) {
		try {
			String[] whiteLists = conVideoShieldDao.getAlbumWhiteList(pid);
			StringBuffer whiteList = new StringBuffer();
			for(String w : whiteLists) {
				if(StringUtils.isNotEmpty(w)) {
					whiteList.append(w).append(",");
				}
			}
			if(whiteList.length()>0) {
				whiteList.deleteCharAt(whiteList.length()-1);
			}
	        json.put("whiteList", whiteList.toString());//所有可以播放的国家
		} catch(Exception e) {
			LOGGER.error("json组装错误", e);
		}
	}

	/**
	 * 所有可以播放的国家
	 * @param json
	 * @param id
	 * @param site
	 */
	public void putWhiteListToVideoJson(JSONObject json, Long id) {
		String[] whiteLists = conVideoShieldDao.getVideoWhiteList(id);
		StringBuffer whiteList = new StringBuffer();
		for(String w : whiteLists) {
			if(StringUtils.isNotEmpty(w)) {
				whiteList.append(w).append(",");
			}
		}
		if(whiteList.length()>0) {
			whiteList.deleteCharAt(whiteList.length()-1);
		}
        json.put("whiteList", whiteList.toString());//所有可以播放的国家
	}
	
	/**
	 * 码流特征
	 * @param json
	 * @param sMid
	 * @param site
	 */
	public void putPlayStreamsToJson(JSONObject json, String sMid, int site) {
		if(StringUtils.isEmpty(sMid)) {
			return;
		}
		String[] mids = org.apache.commons.lang3.StringUtils.split(sMid, ",");
		StringBuffer playStreams = new StringBuffer();
		try {
			for(String mid : mids) {
				List<String> results = conMmsFileInfoDao.getCodeRate(NumberUtils.toLong(mid));
				for(String r : results) {
					playStreams.append(r).append(",");
				}
			}
			if(playStreams.length()>0) {
				playStreams.deleteCharAt(playStreams.length()-1);
			}
	    	dictionaryService.putMultiToJson(json, "playStreams", playStreams.toString(), site);//码流特征
		} catch(Exception e) {
			LOGGER.error("json组装错误", e);
		}
	}
	
	/**
	 * 专辑对应的Boss系统的addonid
	 * @param json
	 * @param cid 视频或专辑ID
	 * @param ctype 1是专辑 3是视频
	 */
	public void putAddonToJson(JSONObject json, String cid, int ctype) {
		String vips = tContentVipForThirdpartyDao.getVipsByCidCtype(cid, ctype);
		json.put("addOnId", vips);//专辑对应的Boss系统的addonid
	}

//	public void putPayendToJson(JSONObject json, String cid, int ctype) {
//		String payDetail = tContentPayStrategyForThirdpartyDao.getPayDetail(cid, ctype);
//		json.put("payDetail", payDetail);
//	}
	
	/**
	 * 从ext_data字段中取得的值：play_mark，is_vip_download，is_push_child
	 * 从categoryExt字段中取得的值：childCate，ageSection，funcProperty
	 * @param json
	 * @param keys
	 * @param extData
	 */
	public void putExtDataToJson(JSONObject json, String[] keys, String extData) {
		try {
			if(!StringUtils.isEmpty(extData)) {
				net.sf.json.JSONObject j = net.sf.json.JSONObject.fromObject(extData);
				for(String key : keys) {
					if(j.containsKey(key)) {
						json.put(camelName(key), j.getString(key));
					}
				}
			}
		} catch(Exception e) {
			LOGGER.error("error, json:{}, key:{}, extData:{}", json, keys, extData);
		}
	}

	/**
	 * 扩展字段中字段值为int类型的解析
	 *
	 * @param json
	 * @param keys
	 * @param extData
	 */
	public void putExtDataByIntToJson(JSONObject json, String[] keys, String extData) {
		try {
			if(!StringUtils.isEmpty(extData)) {
				net.sf.json.JSONObject j = net.sf.json.JSONObject.fromObject(extData);
				for(String key : keys) {
					if (j.containsKey(key)) {
						if(NumberUtils.isNumber(j.getString(key))) {
							json.put(camelName(key), j.getInt(key));
						}
					}
				}
			}
		} catch(Exception e) {
			LOGGER.error("error, json:{}, key:{}, extData:{}", json, keys, extData);
		}
	}

	/**
	 * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HELLO_WORLD->HelloWorld
	 * @param name 转换前的下划线大写方式命名的字符串
	 * @return 转换后的驼峰式命名的字符串
	 */
	private String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // 快速检查
	    if (name == null || name.isEmpty() || !name.contains("_")) {
	        // 没必要转换
	        return name;
	    }
	    // 用下划线将原始字符串分割
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // 跳过原始字符串中开头、结尾的下换线或双重下划线
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // 处理真正的驼峰片段
	        if (result.length() == 0) {
	            // 第一个驼峰片段，全部字母都小写
	            result.append(camel.toLowerCase());
	        } else {
	            // 其他的驼峰片段，首字母大写
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
	/**
	 * 是否为CMS非版权运营视频
	 * @param json
	 * @param pid 专辑ID
	 */
	public void putCmsNocopyrightContentToJson(JSONObject json, Long pid) {
		if(pid==null) {
			return;
		}
		int cmsNocopyrightContent = 1;
		CmsNocopyrightContent content = cmsNocopyrightContentDao.getByPidStatus(String.valueOf(pid));
		if(content==null) {
			cmsNocopyrightContent = 0;
		}
		json.put("cmsNocopyrightFlag", cmsNocopyrightContent);//是否为CMS非版权运营视频
	}
	
	/**
	 * cms版权信息
	 * @param json
	 * @param pid 专辑ID
	 */
	public void putCmsNocopyrightToJson(JSONObject json, long pid) {
		CmsNocopyrightContent content = cmsNocopyrightContentDao.getByPidStatus(String.valueOf(pid));
		if(content!=null) {
			json.put("cmsExternalUrl", content.getExternalUrl());//第三方url
			json.put("cmsShieldCityList", content.getShieldCityList());
			
			json.put("cmsBtime", content.getBtime());
			json.put("cmsEtime", content.getEtime());
			SimpleDateFormat sdf = new SimpleDateFormat(Params.DATE_FORMAT);
			json.put("cmsMtime", content.getMtime()==null? "":sdf.format(content.getMtime()));
		}
	}
	
	public void putVideoSizeToJson(JSONObject json, String sMid) {
		if(StringUtils.isEmpty(sMid)) {
			return;
		}
		String[] mids = org.apache.commons.lang3.StringUtils.split(sMid, ",");
		try {
			JSONObject subJson = new JSONObject();
			for(String mid : mids) {
				List<KeyValue> results = conVideoFileCodeDao.getGize(NumberUtils.toLong(mid));
				for(KeyValue r : results) {
					subJson.put((String) r.getKey(), r.getValue());
				}
			}
			json.put("videoSize", subJson);
		} catch(Exception e) {
			LOGGER.error("json组装错误", e);
		}
	}
}