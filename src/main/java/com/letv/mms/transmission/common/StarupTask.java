package com.letv.mms.transmission.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.brmayi.epiphany.common.Startup;
import com.letv.mms.transmission.cache.thread.DicConfigCacheThread;
import com.letv.mms.transmission.cache.thread.DictionaryCacheThread;
import com.letv.mms.transmission.cache.thread.LeThesaurusThread;
import com.letv.mms.transmission.cache.thread.StarCacheThread;
import com.letv.mms.transmission.cache.thread.TvCacheThread;

public class StarupTask {
	public static void startup() {
		ExecutorService service = Executors.newCachedThreadPool();
		DicConfigCacheThread dicConfigCacheThread = (DicConfigCacheThread)Startup.context.getBean("dicConfigCacheThread");
		service.execute(dicConfigCacheThread);
		DictionaryCacheThread dictionaryCacheThread = (DictionaryCacheThread)Startup.context.getBean("dictionaryCacheThread");
		service.execute(dictionaryCacheThread);
		TvCacheThread tvCacheThread = (TvCacheThread)Startup.context.getBean("tvCacheThread");
		service.execute(tvCacheThread);
		StarCacheThread starCacheThread = (StarCacheThread)Startup.context.getBean("starCacheThread");
		service.execute(starCacheThread);	
		LeThesaurusThread leThesaurusThread = (LeThesaurusThread)Startup.context.getBean("leThesaurusThread");
		service.execute(leThesaurusThread);	
	}
}
