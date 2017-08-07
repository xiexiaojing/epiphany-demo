//package com.letv.mms.transmission.cache.subscribe;
//
//import java.net.InetSocketAddress;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.otter.canal.client.CanalConnector;
//import com.alibaba.otter.canal.client.CanalConnectors;
//import com.alibaba.otter.canal.protocol.CanalEntry.Column;
//import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
//import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
//import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
//import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
//import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
//import com.alibaba.otter.canal.protocol.Message;
//
//@Component
//public class CanalSubscribe implements Runnable {  
//	// 创建链接  
//    private static final CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("10.183.96.194",  11111), "example", "", "");  
//    private static final int BATCH_SISE = 1000;
//    @Resource
//    private RedisTemplate<String, ?> redisTemplate;
//    
//    private static final Logger logger = LoggerFactory.getLogger(CanalSubscribe.class);
//    
//    public CanalSubscribe() {
//        connector.connect();  
//        connector.subscribe("..*\\..*"); 
//    }
//    
//	@Override
//	public void run() {
//       Message message = connector.getWithoutAck(BATCH_SISE); // 获取指定数量的数据  
//       long batchId = message.getId();  
//       int size = message.getEntries().size();  
//       if (batchId> -1 || size> 0) {  
//           printEntry(message.getEntries());  
//       }  
//       connector.ack(batchId); // 提交确认  
//	}
// 
//   private void printEntry(List<Entry> entrys) {  
//       for (Entry entry : entrys) {  
//           if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {  
//               continue;  
//           }  
// 
//           RowChange rowChage = null;  
//           try {  
//               rowChage = RowChange.parseFrom(entry.getStoreValue());  
//           } catch (Exception e) {  
//               throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);  
//           }  
// 
//           EventType eventType = rowChage.getEventType();  
//           String tableName = entry.getHeader().getTableName();
//           if("db_dictionary_info".equals(tableName)) {
//               for (RowData rowData : rowChage.getRowDatasList()) {  
//                   if (eventType == EventType.DELETE) {  
//                	   redisDelete(rowData.getBeforeColumnsList());  
//                   } else if (eventType == EventType.INSERT) {  
//                	   redisInsert(rowData.getAfterColumnsList());  
//                   } else {  
//                       printColumn(rowData.getBeforeColumnsList());  
//                       redisUpdate(rowData.getAfterColumnsList());  
//                   }  
//               }
//           } else if("db_tv".equals(tableName)) {
//               for (RowData rowData : rowChage.getRowDatasList()) {  
//                   if (eventType == EventType.DELETE) {  
//                	   redisDelete(rowData.getBeforeColumnsList());  
//                   } else if (eventType == EventType.INSERT) {  
//                	   redisInsert(rowData.getAfterColumnsList());  
//                   } else {  
//                       printColumn(rowData.getBeforeColumnsList());  
//                       redisUpdate(rowData.getAfterColumnsList());  
//                   }  
//               }        	   
//           } else if("dic_config".equals(tableName)) {
//               for (RowData rowData : rowChage.getRowDatasList()) {  
//                   if (eventType == EventType.DELETE) {  
//                	   redisDelete(rowData.getBeforeColumnsList());  
//                   } else if (eventType == EventType.INSERT) {  
//                	   redisInsert(rowData.getAfterColumnsList());  
//                   } else {  
//                       printColumn(rowData.getBeforeColumnsList());  
//                       redisUpdate(rowData.getAfterColumnsList());  
//                   }  
//               }   
//           } else if("dic_config".equals(tableName)) {
//               for (RowData rowData : rowChage.getRowDatasList()) {  
//                   if (eventType == EventType.DELETE) {  
//                	   redisDelete(rowData.getBeforeColumnsList());  
//                   } else if (eventType == EventType.INSERT) {  
//                	   redisInsert(rowData.getAfterColumnsList());  
//                   } else {  
//                       printColumn(rowData.getBeforeColumnsList());  
//                       redisUpdate(rowData.getAfterColumnsList());  
//                   }  
//               } 
//           }
//       }  
//   }  
// 
//   private static void printColumn( List<Column> columns) {  
//       for (Column column : columns) {  
//           logger.info(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());  
//       }  
//   }  
//   
//	  private static void redisInsert( List<Column> columns){
//		  JSONObject json=new JSONObject();
//		  for (Column column : columns) {  
//			  json.put(column.getName(), column.getValue());  
//	       }  
//		  if(columns.size()>0){
//			  logger.info("user:"+ columns.get(0).getValue()+json.toJSONString());
//		  }
//	   }
//	  
//	  private static  void redisUpdate( List<Column> columns){
//		  JSONObject json=new JSONObject();
//		  for (Column column : columns) {  
//			  json.put(column.getName(), column.getValue());  
//	       }  
//		  if(columns.size()>0){
//			  logger.info("user:"+ columns.get(0).getValue()+json.toJSONString());
//		  }
//	  }
//  
//	   private static  void redisDelete( List<Column> columns){
//		   JSONObject json=new JSONObject();
//			  for (Column column : columns) {  
//				  json.put(column.getName(), column.getValue());  
//		       }  
//			  if(columns.size()>0){
//				  logger.info("user:"+ columns.get(0).getValue());
//			  }
//	   }
//}  
//
