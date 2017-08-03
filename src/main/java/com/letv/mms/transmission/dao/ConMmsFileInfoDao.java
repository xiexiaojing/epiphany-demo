package com.letv.mms.transmission.dao;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.TableShardingBy;
import org.jfaster.mango.sharding.TableShardingStrategy;

@DB(table = "con_mms_file_info")
@Sharding(tableShardingStrategy = ConMmsFileInfoDao.OrderTableShardingStrategy.class)
public interface ConMmsFileInfoDao {
    @SQL("SELECT DISTINCT CODE_RATE FROM #table WHERE MID=:1 and deleted=0 and status=300006")
    public List<String> getCodeRate(@TableShardingBy long mid);
    class OrderTableShardingStrategy implements TableShardingStrategy<Long> {
        @Override
        public String getTargetTable(String table, Long shardingParameter) {
            return table + "_" + (shardingParameter % 128);
        }
    }
}
