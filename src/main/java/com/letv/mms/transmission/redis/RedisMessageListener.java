package com.letv.mms.transmission.redis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import com.letv.mms.transmission.cache.subscribe.StarSubscriber;

public class RedisMessageListener implements MessageListener{
	private static Logger logger = LoggerFactory.getLogger(StarSubscriber.class);
	
	@Resource
	RedisTemplate<String, String> redisTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		logger.info(new String(message.getBody()));
	}

}
