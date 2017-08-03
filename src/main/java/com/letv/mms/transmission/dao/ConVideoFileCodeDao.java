package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.TableShardingBy;
import org.jfaster.mango.sharding.TableShardingStrategy;

import com.letv.mms.transmission.model.KeyValue;

@DB(table = "con_video_file_code_info")
@Sharding(tableShardingStrategy = ConVideoFileCodeDao.OrderTableShardingStrategy.class)
public interface ConVideoFileCodeDao {
    @SQL("SELECT GFMT AS `key`,GSIZE AS `value` FROM #table WHERE MID=:1 AND DELETED=0")
    public List<KeyValue> getGize(@TableShardingBy long mid);
    class OrderTableShardingStrategy implements TableShardingStrategy<Long> {
        @Override
        public String getTargetTable(String table, Long shardingParameter) {
            return table + "_" + (shardingParameter % 128);
        }
    }
}
