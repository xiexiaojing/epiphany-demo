package com.letv.mms.transmission.cache.subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

public class StarSubscriber extends JedisPubSub{
	private static Logger logger = LoggerFactory.getLogger(StarSubscriber.class);
	
	@Override
	public void onMessage(String channel, String message) {
		logger.info("channel:{},message:{}", channel, message);
		
	}
}
