package com.letv.mms.transmission.cache.thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.letv.mms.transmission.dao.DbDictionaryInfoDao;
import com.letv.mms.transmission.model.DbDictionaryInfoModel;

/**
 * 
 * **************************************************************
 * @ClassName: DictionaryService 
 * @Description: 装配字典信息进json 
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:22:56
 *  
 * **************************************************************
 */
@Component
public class DictionaryCacheThread implements Runnable {
	private static Map<String, String> cnDicts = null;
	private static Map<String, String> enDicts = null;
	private static Map<String, String> hkDicts = null;
	
	@Resource
	private DbDictionaryInfoDao dbDictionaryInfoDao;
    @Resource
    private RedisTemplate<String, ?> redisTemplate;
    
	private Logger LOGGER = LoggerFactory.getLogger(DictionaryCacheThread.class);
	
	/**
	 * 字典数据不过几千条，只存一个字典key和字典value，全部加载到内存中。如果字典值不存在，则重新加载
	 * @param key 字典key
	 * @return 字段value
	 */
	private String getDictionaryInfo(String key, Integer lang) {
		if(cnDicts==null) {
			run();
			return getValue(key, lang);
		}
		String value = getValue(key, lang);
		return value;
	}
	
	private String getValue(String key, Integer lang) {
		if(lang==null || lang==700004)
    		return (String) cnDicts.get(key);
    	if(lang==700001) 
    		return (String) enDicts.get(key);
    	return (String) hkDicts.get(key);
	}
	
	@Override
	public void run() {
		HashOperations<String, String, String> ops = redisTemplate.opsForHash();
		cnDicts = ops.entries("cnDicts");
		enDicts = ops.entries("enDicts");
		hkDicts = ops.entries("hkDicts");
		if(cnDicts==null || enDicts==null || hkDicts==null) {
			cnDicts = new HashMap<String, String>();
			enDicts = new HashMap<String, String>();
			hkDicts = new HashMap<String, String>();
			
	        List<DbDictionaryInfoModel> dictInfo = dbDictionaryInfoDao.getDict();
	        for(DbDictionaryInfoModel dict : dictInfo) {
	        	String dictId = String.valueOf(dict.getId());
	        	cnDicts.put(dictId, dict.getValue());
	        	ops.put("cnDicts", dictId, dict.getValue());
	        	enDicts.put(dictId, StringUtils.isEmpty(dict.getValueEn())?dict.getValue():dict.getValueEn());
	        	ops.put("enDicts", dictId, StringUtils.isEmpty(dict.getValueEn())?dict.getValue():dict.getValueEn());
	        	hkDicts.put(dictId, StringUtils.isEmpty(dict.getValueHk())?dict.getValue():dict.getValueHk());
	        	ops.put("hkDicts", dictId, StringUtils.isEmpty(dict.getValueHk())?dict.getValue():dict.getValueHk());
	        }
		}
        LOGGER.info("LOAD cnDicts SIZE:{}",cnDicts.size());
	}
	
	/**
	 * 根据key查出多个字典值值拼起来
	 * @param json 要被放入的json
	 * @param key json的key
	 * @param originalKeys 需要查字典的key
	 */
	public void putMultiToJson(JSONObject json, String key, String originalKeys, Integer lang) {
    	if(StringUtils.isNotEmpty(originalKeys)) {
    		JSONObject subJson = new JSONObject();
    		String[] keys = StringUtils.split(originalKeys,",");
    		for(String k : keys) {
    			if(k.isEmpty()) {
    				continue;
    			}
    			subJson.put(k, getDictionaryInfo(k, lang));
    		}
    		json.put(key, subJson);
    	}
	}
	
	/**
	 * 根据key查出字典值拼起来
	 * @param json 要被放入的json
	 * @param key json的key
	 * @param originalKey 需要查字典的key
	 */
	public void putSingleToJson(JSONObject json, String key, Integer originalKey, Integer lang) {
		if(originalKey!=null) { 
			JSONObject subJson = new JSONObject();
			String originKey = String.valueOf(originalKey);
			subJson.put(originKey, getDictionaryInfo(originKey, lang));
			json.put(key, subJson);
		}
	}
	
	
	/**
	 * 从category_ext字段中取得的值：play_mark，is_vip_download，is_push_child
	 * 从categoryExt字段中取得的值：childCate，ageSection，funcProperty
	 * @param json
	 * @param cid 视频或专辑ID
	 * @param ctype 1是专辑 3是视频
	 */
	public void putCategoryExtToJson(JSONObject json, String[] keys, String extData, Integer lang) {
		try {
			if(!StringUtils.isEmpty(extData)) {
				net.sf.json.JSONObject j = net.sf.json.JSONObject.fromObject(extData);
				for(String key : keys) {
					if(j.containsKey(key)) {
						String extValue = j.getString(key);
						if(StringUtils.isNotEmpty(extValue)) {
							putMultiToJson(json, key, extValue, lang);
						}
					}
				}
			}
		} catch(Exception e) {
			LOGGER.error("json组装错误", e);
		}
	}
}
