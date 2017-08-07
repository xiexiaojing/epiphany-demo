package com.letv.mms.transmission.http;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brmayi.epiphany.business.IncrementBusinessTask;
import com.brmayi.epiphany.business.socket.ManuallyHttpServer;
import com.brmayi.epiphany.common.Startup;
import com.letv.mms.transmission.common.StarupTask;
import com.letv.mms.transmission.service.impl.VideoDataServiceImpl;
/**
 * 
 * 
 *            
 *            .==.       .==.
 *           //'^\\     //^'\\
 *          // ^^\(\__/)/^ ^^\\
 *         //^ ^^ ^/6  6\ ^^^ \\
 *        //^ ^^ ^/( .. )\^ ^^ \\
 *       // ^^  ^/\|v""v|/\^^ ^ \\
 *      // ^^/\/  / '~~' \ \/\^ ^\\
 *      ----------------------------------------
 *      HERE BE DRAGONS WHICH CAN CREATE MIRACLE
 *       
 *      @author 静儿(987489055@qq.com)
 *
 */
public class VideoServerBootstrap{
	private static final String VIDEO_TIME = "transmission_video_time";
	private static final Logger logger = LoggerFactory.getLogger(VideoServerBootstrap.class);
    
	public static void main(String[] args) {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		StarupTask.startup();
		
		ScheduledExecutorService increaseService = Executors.newScheduledThreadPool(6);
    	VideoDataServiceImpl videoDataServiceImpl = (VideoDataServiceImpl)Startup.context.getBean("videoDataServiceImpl");

    	IncrementBusinessTask incrementVideoSearchTask = (IncrementBusinessTask)Startup.context.getBean("incrementBusinessTask");
    	incrementVideoSearchTask.setDataService(videoDataServiceImpl);
    	incrementVideoSearchTask.setTimeCacheKey(VIDEO_TIME);
    	increaseService.scheduleWithFixedDelay((Runnable)incrementVideoSearchTask, 0, 60, TimeUnit.SECONDS);
		
    	ManuallyHttpServer manuallyHttpServerVideo = (ManuallyHttpServer)Startup.context.getBean("manuallyHttpServer");
		manuallyHttpServerVideo.setServer(2121);
		manuallyHttpServerVideo.setDataService(videoDataServiceImpl);
		increaseService.execute(manuallyHttpServerVideo);

		logger.info("video increment and manully start!");
    }
}