package com.letv.mms.transmission.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * **************************************************************
 * @ClassName: TaskUtilService 
 * @Description: 非静态工具service，避免并发问题
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月8日 下午3:11:46
 *  
 * **************************************************************
 */
@Component("taskUtilService")
public class TaskUtilService {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaskUtilService.class); 
    
    @Resource
	private JmsTemplate jmsTemplate;
	
    @Resource
	private Destination videoDestination;
    
    @Resource
	private Destination albumDestination;

    public static final int ALBUM_VIDEO_LIMIT_DEAL_ONE_TIME = 1000;
    
    public static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(80); 
    /**
     * 通过SwiftQ传输
     * @param content 传输内容
     */
	public void swiftSendMsg(final String content, boolean needDelay) {
		try {
			Destination transDestination;
			if(needDelay) {
				jmsTemplate.setReceiveTimeout(10000);
				transDestination = albumDestination;
			} else {
				transDestination = videoDestination;
			}
	        jmsTemplate.send(transDestination, new MessageCreator() {
	            public Message createMessage(Session session)throws JMSException {
	            	TextMessage msg = null;
					try {
						msg = session.createTextMessage(content);
					} catch (Exception e) {
						LOGGER.error("消息队列"+content, e);
					}
	                return msg;
	            }
	        });
		} catch(Exception e) {
			LOGGER.error("send msg error, size:{}, data:{}",content.length(), content.substring(0, Math.min(content.length()-1, 80)),e);
		}
    }
}
