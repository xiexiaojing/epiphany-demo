package com.letv.mms.transmission.cache.thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import com.letv.mms.transmission.dao.DateDao;
import com.letv.mms.transmission.dao.StarInfoDao;
import com.letv.mms.transmission.model.StarInfo;
/**
 * 
 * **************************************************************
 * @ClassName: StarCacheThread 
 * @Description: 装配人员信息进json 
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:23:30
 *  
 * **************************************************************
 */
@Component
public class StarCacheThread implements Runnable {
	private static Map<String, String> cnStars = null;
	private static Map<String, String> enStars = null;
	private static Map<String, String> hkStars = null;
	@Resource
	private StarInfoDao starInfoDao;
    @Resource
    private RedisTemplate<String, ?> objectRedisTemplate;
    
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    
    @Resource
    private DateDao dateDao;
    
	private Logger LOGGER = LoggerFactory.getLogger(StarCacheThread.class);
	
	private static volatile  boolean isRunning = false;
	
	/**
	 * 根据key查出多个人名值值拼起来
	 * @param json 要被放入的json
	 * @param key json的key
	 * @param originalKeys 需要查字典的key
	 * @param site 站点值
	 */
	public void putMultiToJson(JSONObject json, String key, String originalKeys, Integer lang) {
    	if(StringUtils.isNotEmpty(originalKeys)) {
    		JSONArray j = new JSONArray();
    		String[] keys = StringUtils.split(originalKeys,",");
    		for(String k : keys) {
    			if(k.isEmpty()) {
    				continue;
    			}
    			JSONObject subJson = new JSONObject();
    			String star = getStarName(NumberUtils.toLong(k), lang);
    			if(star!=null) {
    				subJson.put(k, star);
    			}
    			j.add(subJson);
    		}
    		json.put(key, j);
    	}
	}
	
	/**
	 * 从数据库里取名字
	 * @param key 人员ID
	 * @param site 站点ID
	 * @return 名字
	 */
	public String getStarName(long key, Integer lang) {
		if(cnStars==null) {
			run();
			return getValue(key, lang);
		}
		return getValue(key, lang);
	}
	
	private String getValue(long key, Integer lang) {
		if(lang==null || lang==700004)
    		return (String) cnStars.get(String.valueOf(key));
    	if(lang==700001) 
    		return (String) enStars.get(String.valueOf(key));
    	return (String) hkStars.get(String.valueOf(key));
	}

    
    /**
     * 更新明星哈希表，只有在不跑全量的时候执行，避免并发
     */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		isRunning=true;
		ValueOperations<String, Object> ops = (ValueOperations<String, Object>) objectRedisTemplate.opsForValue();
		StopWatch stopWatch = new Slf4JStopWatch("cnStarsStr");
		cnStars= (Map<String, String>) ops.get("cnStars");
		stopWatch.stop();
		stopWatch = new Slf4JStopWatch("enStarsStr");
		enStars = (Map<String, String>) ops.get("enStars");
		stopWatch.stop();
		stopWatch = new Slf4JStopWatch("hkStarsStr");
		hkStars = (Map<String, String>) ops.get("hkStars");
		stopWatch.stop();
		if(cnStars==null || enStars==null || hkStars==null) {
			if(cnStars==null) {
				cnStars = new HashMap<String, String>();
			}
			if(enStars==null) {
				enStars = new HashMap<String, String>();
			}
			if(hkStars==null) {
				hkStars = new HashMap<String, String>();
			}
			stopWatch = new Slf4JStopWatch("starInfoDao");
	        List<StarInfo> starInfos = starInfoDao.getAll();
	        redisTemplate.opsForValue().set("starTime", dateDao.getNow()); 
	        for(StarInfo star: starInfos) {
	        	String starId = String.valueOf(star.getId());
	        	String starName = star.getName();
	        	cnStars.put(starId, starName);
	        	starName = StringUtils.isEmpty(star.getNameEn())?star.getName():star.getNameEn();
	        	enStars.put(starId, starName);
	        	starName = StringUtils.isEmpty(star.getNameHk())?star.getName():star.getNameHk();
	        	hkStars.put(starId, starName);
	        }
	        stopWatch.stop();
	       
	        stopWatch = new Slf4JStopWatch("cnStars");
	        ops.set("cnStars", cnStars);
	        stopWatch.stop();
	        stopWatch = new Slf4JStopWatch("enStars");
	        ops.set("enStars", enStars);
	        stopWatch.stop();
	        stopWatch = new Slf4JStopWatch("hkStars");
	        ops.set("hkStars", hkStars);
	        stopWatch.stop();
		}
        LOGGER.info("thread load cnStars SIZE:{}", cnStars.size());
        isRunning=false;
	}
	
	@SuppressWarnings("unchecked")
	@Scheduled(fixedDelay=1000)
	public void fleshData() {
		if(isRunning|| cnStars==null || enStars==null || hkStars==null) {
			return;
		}
		ValueOperations<String, String> strOps = redisTemplate.opsForValue();
//		ValueOperations<String, Object> byteOps = (ValueOperations<String, Object>) objectRedisTemplate.opsForValue();
		String starTime = strOps.get("starTime");
		List<StarInfo> stars = starInfoDao.getByUpdateTime(starTime);
		if(!stars.isEmpty()) {
			for(StarInfo star : stars) {
				String starId = String.valueOf(star.getId());
	        	String starName = star.getName();
	        	cnStars.put(starId, starName);
//	        	strOps.set("cnStar"+starId, starName, 1, TimeUnit.DAYS);
	        	starName = StringUtils.isEmpty(star.getNameEn())?star.getName():star.getNameEn();
	        	enStars.put(starId, starName);
//	        	strOps.set("enStar"+starId, starName, 1, TimeUnit.DAYS);
	        	starName = StringUtils.isEmpty(star.getNameHk())?star.getName():star.getNameHk();
	        	hkStars.put(starId, starName);
//	        	strOps.set("hkStar"+starId, starName, 1, TimeUnit.DAYS);
	        	redisTemplate.convertAndSend("star", starId);
			}
			strOps.set("starTime", dateDao.getNow()); 
			LOGGER.info("thread cnStars UPDATE SIZE:{}", stars.size());
		}
	}
}
