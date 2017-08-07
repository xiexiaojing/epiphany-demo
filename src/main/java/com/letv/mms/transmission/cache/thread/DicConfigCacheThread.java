package com.letv.mms.transmission.cache.thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.letv.mms.transmission.dao.DicConfigDao;
import com.letv.mms.transmission.model.DicConfig;

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
public class DicConfigCacheThread implements Runnable {
	private static Map<String, String> cnDicts = null;
	private static Map<String, String> hkDicts = null;
	private static Map<String, String> enDicts = null;
    @Resource
    private RedisTemplate<String, ?> redisTemplate;
	
	@Resource
	private DicConfigDao dbConfigDao;
	
	private Logger logger = LoggerFactory.getLogger(DicConfigCacheThread.class);
	
	/**
	 * 字典数据不过几千条，只存一个字典key和字典value，全部加载到内存中。如果字典值不存在，则重新加载
	 * @param key 字典key
	 * @return 字段value
	 */
	private String getDic(int key, Integer lang) {
		if(cnDicts==null) {
			run();
			return getValue(key, lang);
		}
		return getValue(key, lang);
	}
	
	public String getValue(int key, Integer lang) {
		if(lang==null || lang==700004)
    		return (String) cnDicts.get(String.valueOf(key));
		if(lang==700001) 
    		return (String) enDicts.get(String.valueOf(key));
    	return (String) hkDicts.get(String.valueOf(key));
	}
	
	@Override
	public void run() {
		HashOperations<String, String, String> ops = redisTemplate.opsForHash();
		cnDicts = ops.entries("cnDicConf");
		enDicts = ops.entries("enDicConf");
		hkDicts = ops.entries("hkDicConf");
		if(cnDicts==null || enDicts==null || hkDicts==null) {
			cnDicts = new HashMap<String, String>();
			enDicts = new HashMap<String, String>();
			hkDicts = new HashMap<String, String>();
			List<DicConfig> dictInfo = dbConfigDao.getDict();
	        for(DicConfig dict : dictInfo) {
	        	String dictId = String.valueOf(dict.getId());
	        	cnDicts.put(dictId, dict.getDicName());
	        	ops.put("cnDicConf", dictId, dict.getDicName());
	        	hkDicts.put(dictId, StringUtils.isEmpty(dict.getDicNameHk())?dict.getDicName():dict.getDicNameHk());
	        	ops.put("enDicConf", dictId, StringUtils.isEmpty(dict.getDicNameHk())?dict.getDicName():dict.getDicNameHk());
	        	enDicts.put(dictId, StringUtils.isEmpty(dict.getDicNameEn())?dict.getDicName():dict.getDicNameEn());
	        	ops.put("hkDicConf", dictId, StringUtils.isEmpty(dict.getDicNameEn())?dict.getDicName():dict.getDicNameEn());
	        }
		}
        logger.info("LOAD dict config SIZE:{}",cnDicts.size());
	}
	
	/**
	 * 根据key查出多个字典值值拼起来
	 * @param json 要被放入的json
	 * @param key json的key
	 * @param originalKeys 需要查字典的key
	 */
	public void putMultiToJson(JSONObject json, String key, String originalKeys, Integer lang) {
    	if(StringUtils.isNotEmpty(originalKeys)) {
    		StringBuffer value = new StringBuffer();
    		String[] keys = StringUtils.split(originalKeys,",");
    		for(String k : keys) {
    			if(k.isEmpty()) {
    				continue;
    			}
    			if(value.length()>0) {
    				value.append(",");
    			}
    			value.append(getDic(NumberUtils.toInt(k), lang));
    		}
    		json.put(key, value);
    	}
	}
}
