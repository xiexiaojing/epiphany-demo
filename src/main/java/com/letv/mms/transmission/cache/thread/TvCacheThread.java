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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.letv.mms.transmission.dao.DbTvDao;
import com.letv.mms.transmission.model.DbTv;
/**
 * 
 * **************************************************************
 * @ClassName: StarService 
 * @Description: 装配人员信息进json 
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:23:30
 *  
 * **************************************************************
 */
@Component
public class TvCacheThread implements Runnable {
	private static Map<String, String> tvs = null;
	private static Map<String, String> tvHks = null;
//	private static Map<Integer, String> tvEns = null;
	@Resource
	private DbTvDao dbTvDao;
    @Resource
    private RedisTemplate<String, ?> redisTemplate;
	private static final Logger logger = LoggerFactory.getLogger(TvCacheThread.class);
	
	/**
	 * 根据key查出多个人名值值拼起来
	 * @param json 要被放入的json
	 * @param key json的key
	 * @param originalKeys 需要查字典的key
	 * @param site 站点值
	 */
	public void putMultiToJson(JSONObject json, String key, String originalKeys, Integer lang) {
		try {
	    	if(StringUtils.isNotEmpty(originalKeys)) {
	    		JSONArray j = new JSONArray();
	    		String[] keys = StringUtils.split(originalKeys,",");
	    		for(String k : keys) {
	    			if(k.isEmpty()) {
	    				continue;
	    			}
	    			JSONObject subJson = new JSONObject();
	    			String tv = getTv(k, lang);
	    			if(tv!=null) {
	    				subJson.put(k, tv);
	    			}
	    			j.add(subJson);
	    		}
	    		if(key!=null) {
	    			json.put(key, j);
	    		}
	    	}
		} catch(Exception e) {
			logger.error("tv error", e);
		}
	}
	
	/**
	 * 从数据库里取名字
	 * @param key 人员ID
	 * @param site 站点ID
	 * @return 名字
	 */
	public String getTv(String key, Integer lang) {
		if(tvs==null) {
			run();
			return getValue(key, lang);
		}
		return getValue(key, lang);
	}
	
	public String getValue(String key, Integer lang) {
		if(lang==null || lang==700004)
    		return (String) tvs.get(key);
    	if(lang==700002) 
    		return (String) tvHks.get(key);
    	return null;
	}
	
	@Override
	public void run() {
		HashOperations<String, String, String> ops = redisTemplate.opsForHash();
		tvs = ops.entries("tvs");
		tvHks = ops.entries("tvHks");
		
		if(tvs==null || tvHks==null) {
			tvs = new HashMap<String, String>();
			tvHks = new HashMap<String, String>();
//			tvEns = Maps.newHashMap();
	        List<DbTv> words = dbTvDao.getAll();
	        for(DbTv word: words) {
	        	String wordId = String.valueOf(word.getId());
	        	tvs.put(wordId, word.getTv());
	        	ops.put("tvs", wordId, word.getTv());
	        	tvHks.put(wordId, word.getTvHk());
	        	ops.put("tvHks", wordId, word.getTvHk());
//	        	tvEns.put(word.getId(), word.getTvEn());
	        }
		}

        logger.info("LOAD TV SIZE:{}", tvs.size());
	}
}