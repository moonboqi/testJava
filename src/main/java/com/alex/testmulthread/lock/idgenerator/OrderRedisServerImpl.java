/**
 * 
 */
package com.alex.testmulthread.lock.idgenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**  
* Title: OrderServerImpl  
* Description:   
* @author wangzi  
* @date 2018年11月5日  
*/
public class OrderRedisServerImpl implements OrderServerInterface {

	static JedisPool jedisPool;
	static {
		jedisPool = new JedisPool(new JedisPoolConfig(), "", 6379 , 1, "root");
	}
	
	@Override
	public String getOrderNo() {
		try {
			SimpleDateFormat date = new SimpleDateFormat("YYYYMMDDHHMMSS");
			Jedis jedis = jedisPool.getResource();
			return date.format(new Date()) + jedis.incr("order_keys");
		} finally {
			jedisPool.close();
		}
	}
	
}
