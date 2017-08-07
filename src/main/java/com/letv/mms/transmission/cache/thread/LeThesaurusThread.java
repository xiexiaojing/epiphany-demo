package com.letv.mms.transmission.cache.thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.letv.mms.transmission.dao.LeThesaurusDao;
import com.letv.mms.transmission.model.LeThesaurus;
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
public class LeThesaurusThread implements Runnable {
	private static Map<String, LeThesaurus> leThesauruses = null;
	@Resource
	private LeThesaurusDao leThesaurusDao;
	@Resource
	private DicConfigCacheThread dicConfigService;
	private static final Logger logger = LoggerFactory.getLogger(TvCacheThread.class);
    
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private RedisTemplate<String, ?> objectRedisTemplate;
    private static volatile  boolean isRunning = false;
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
	    		JSONArray lewordArray = new JSONArray();
	    		String[] keys = StringUtils.split(originalKeys,",");
	    		for(String k : keys) {
	    			if(k.isEmpty()) {
	    				continue;
	    			}
	    			JSONObject subJson = new JSONObject();
	    			JSONObject leWord = new JSONObject();
	    			LeThesaurus star = getStarName(NumberUtils.toInt(k));
	    			if(star!=null) {
	    				subJson.put(k, star.getName());
	    				leWord.put("name", star.getName());
	    				leWord.put("typecode", star.getType());
	    				dicConfigService.putMultiToJson(leWord, "type", star.getType(), lang);
	    			}
	    			j.add(subJson);
	    			if(!leWord.isEmpty()) {
	    				lewordArray.add(leWord);
	    			}
	    		}
	    		if(key!=null) {
	    			json.put(key, j);
	    		}
	    		json.put("leword", lewordArray);
	    	}
		} catch(Exception e) {
			logger.error("leword error", e);
		}
	}
	
	/**
	 * 从数据库里取名字
	 * @param key 人员ID
	 * @param site 站点ID
	 * @return 名字
	 */
	public LeThesaurus getStarName(int key) {
		if(leThesauruses==null) {
			run();
			return leThesauruses.get(key);
		}
		LeThesaurus value = leThesauruses.get(key);
		if(value==null) {
			LeThesaurus star = leThesaurusDao.getById(key);
			if(star != null) {
				leThesauruses.put(String.valueOf(star.getId()), star);
	        	return leThesauruses.get(key);
			}
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		isRunning=true;
		ValueOperations<String, Object> ops = (ValueOperations<String, Object>) objectRedisTemplate.opsForValue();
		StopWatch stopWatch = new Slf4JStopWatch("leThesauruses");
		leThesauruses= (Map<String, LeThesaurus>) ops.get("leThesauruses");
		stopWatch.stop();
		if(leThesauruses==null) {
			leThesauruses = new HashMap<String, LeThesaurus>();
			stopWatch = new Slf4JStopWatch("leThesaurusDao");
	        List<LeThesaurus> words = leThesaurusDao.getAll();
	        for(LeThesaurus word: words) {
	        	leThesauruses.put(String.valueOf(word.getId()), word);
	        }
	        stopWatch.stop();
	        stopWatch = new Slf4JStopWatch("let");
	        ops.set("leThesauruses", leThesauruses);
	        stopWatch.stop();
		}
        logger.info("thread load  leThesauruses SIZE:{}",leThesauruses.size());
	}
	
	@Scheduled(fixedDelay=1000)
	public void fleshData() {
		if(isRunning) {
			return;
		}
	}
}