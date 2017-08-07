package com.letv.mms.transmission.http;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brmayi.epiphany.business.FullStartupTask;
import com.brmayi.epiphany.common.Startup;
import com.brmayi.epiphany.util.TimerUtil;
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
public class AlbumFullServerBootstrap{
	private static final int ALBUM_LIMIT_DEAL_ONE_TIME = 30;
	private static final Logger logger = LoggerFactory.getLogger(AlbumFullServerBootstrap.class);
    
	public static void main(String[] args) {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		StarupTask.startup();

		AlbumDataServiceImpl albumDataServiceImpl = (AlbumDataServiceImpl)Startup.context.getBean("albumDataServiceImpl");
		FullStartupTask fullAlbumStartupTask = (FullStartupTask)Startup.context.getBean("fullStartupTask");
		fullAlbumStartupTask.setDataService(albumDataServiceImpl);
		fullAlbumStartupTask.setFullPath("/letv/mms/search/transmission/album");
		fullAlbumStartupTask.setRedisNoKey("fullAlbumNo");
		fullAlbumStartupTask.setDealOneTime(ALBUM_LIMIT_DEAL_ONE_TIME);
		fullAlbumStartupTask.setThreadTotal(23);
		TimerUtil.runEveryday(fullAlbumStartupTask, 11,34,1);
		logger.info("full task initialization completes!");
    }
}