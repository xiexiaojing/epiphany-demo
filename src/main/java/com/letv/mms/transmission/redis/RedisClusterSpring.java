package com.letv.mms.transmission.redis;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisNode;

/**
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
public class RedisClusterSpring extends RedisClusterConfiguration {
    private Integer maxRedirects;
    RedisClusterSpring(String nodes){
        Set<RedisNode> clusterNodes = null;
        if(StringUtils.isNotEmpty(nodes)){
            clusterNodes = new LinkedHashSet<RedisNode>();
            String item[] = nodes.split(";");
            for(int i = 0;i < item.length;i++){
                String host[] = item[i].split(":");
                String ip = host[0];
                int port = Integer.parseInt(host[1]);
                RedisClusterNode redisClusterNode = new RedisClusterNode(ip,port);
                clusterNodes.add(redisClusterNode);
            }
        }
        super.setClusterNodes(clusterNodes);
    }
}
