package com.letv.mms.transmission.http;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brmayi.epiphany.business.FullStartupTask;
import com.brmayi.epiphany.common.Startup;
import com.brmayi.epiphany.util.TimerUtil;
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
public class VideoFullServerBootstrap{
	private static final int VIDEO_LIMIT_DEAL_ONE_TIME = 800;
	private static final Logger logger = LoggerFactory.getLogger(VideoFullServerBootstrap.class);
    
	public static void main(String[] args) {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		StarupTask.startup();
			VideoDataServiceImpl videoDataServiceImpl = (VideoDataServiceImpl)Startup.context.getBean("videoDataServiceImpl");
			FullStartupTask fullVideoStartupTask = (FullStartupTask)Startup.context.getBean("fullStartupTask");
			fullVideoStartupTask.setDataService(videoDataServiceImpl);
			fullVideoStartupTask.setFullPath("/letv/mms/search/transmission/video");
			fullVideoStartupTask.setRedisNoKey("fullVideoNo");
			fullVideoStartupTask.setDealOneTime(VIDEO_LIMIT_DEAL_ONE_TIME);
			fullVideoStartupTask.setThreadTotal(15);
			TimerUtil.runEveryday(fullVideoStartupTask, 12,0,1);
			logger.info("full task initialization completes!");
	}
}