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
import com.letv.mms.transmission.cache.subscribe.CanalSubscribe;
import com.letv.mms.transmission.common.StarupTask;
import com.letv.mms.transmission.service.impl.AlbumDataServiceImpl;
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
public class AlbumServerBootstrap{
	private static final String ALBUM_TIME = "transmission_album_time";
	private static final Logger logger = LoggerFactory.getLogger(AlbumServerBootstrap.class);
    
	public static void main(String[] args) {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		StarupTask.startup();
		ScheduledExecutorService increaseService = Executors.newScheduledThreadPool(6);
		CanalSubscribe canalSubscribe = (CanalSubscribe)Startup.context.getBean("canalSubscribe");
		increaseService.scheduleWithFixedDelay(canalSubscribe, 0, 2, TimeUnit.MINUTES);
		
		AlbumDataServiceImpl albumDataServiceImpl = (AlbumDataServiceImpl)Startup.context.getBean("albumDataServiceImpl");

		IncrementBusinessTask incrementAlbumSearchTask = (IncrementBusinessTask)Startup.context.getBean("incrementBusinessTask");
		incrementAlbumSearchTask.setDataService(albumDataServiceImpl);
		incrementAlbumSearchTask.setTimeCacheKey(ALBUM_TIME);
		increaseService.scheduleWithFixedDelay((Runnable)incrementAlbumSearchTask, 0, 60, TimeUnit.SECONDS);
		
		ManuallyHttpServer manuallyHttpServerAlbum = (ManuallyHttpServer)Startup.context.getBean("manuallyHttpServer");
		manuallyHttpServerAlbum.setServer(2122);
		manuallyHttpServerAlbum.setDataService(albumDataServiceImpl);
		increaseService.execute(manuallyHttpServerAlbum);
		logger.info("album increment and manully start!");
    }
}