/**
 * 
 */
package com.letv.mms.transmission.dao;

import java.util.Date;
import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

/**
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
@DB
public interface TContentPayStrategyForThirdpartyDao {
	@SQL("SELECT pay_detail FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE c_id=:1 AND type=:2")
    public String getPayDetail(String cid,int ctype);
	
    @SQL("SELECT c_id FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE update_time > :1 AND create_time=update_time AND type=:2")
    public List<String> getCreatedByUpdatetime(String begin, int ctype);
    
    @SQL("SELECT c_id FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE update_time > :1 AND create_time!=update_time AND type=:2")
    public List<String> getUpdatedByUpdatetime(String begin, int ctype);
    
    @SQL("SELECT update_time FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE type=:1 order by update_time desc limit 1")
    public Date getLastUpdateTime(int ctype);
    
    @SQL("SELECT c_id FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE type=3 AND update_time BETWEEN :1 AND :2")
    public List<Long> getVidByUpdatetime(String begin, String end);
    
    @SQL("SELECT c_id FROM letv_boss.t_content_pay_strategy_for_thirdparty WHERE type=1 AND update_time BETWEEN :1 AND :2")
    public List<Long> getPidByUpdatetime(String begin, String end);
}