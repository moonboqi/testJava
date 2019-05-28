/**
 * 
 */
package com.alex.testredis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**  
* Title: TestLua  
* Description:   
* @author wangzi  
* @date 2019年3月5日  
*/
public class TestLua {
	private static Jedis jedis;		//单实例[]
    private static ShardedJedis shard;		//分片[]
    private static ShardedJedisPool pool;	//池化[apache common - pool2]
 
    private static JedisCluster jedisCluster;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //单个节点
        jedis = new Jedis("11.111.16.37", 6379);
        //分片
        List<JedisShardInfo> shards = Arrays.asList(
                new JedisShardInfo("11.111.16.37",6379));
        //集群
        jedisCluster = new JedisCluster(new HostAndPort("11.111.16.37", 6379));
        
//        shard = new ShardedJedis(shards);
//        //池化
//        GenericObjectPoolConfig goConfig = new GenericObjectPoolConfig();
//        goConfig.setMaxTotal(100);
//        goConfig.setMaxIdle(20);
//        goConfig.setMaxWaitMillis(-1);
//        goConfig.setTestOnBorrow(true);
//        pool = new ShardedJedisPool(goConfig, shards);
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        jedis.disconnect();
        jedisCluster.close();
//        shard.disconnect();
//        pool.destroy();
    }
 
 
    
    /**
     * <B>方法名称：</B>Redis使用Lua执行应用程序<BR>
     * <B>概要说明：</B>
     * 我们可以使用Redis+Lua的方式，实现一个完整的事务、保证事务的原子性。
     * 如何使用Redis+Lua?
     * 我们使用scriptLoad方法，把我们写好的lua脚本加载到Redis的内存中（注意是内存，每次重启则失效）。
     * scriptLoad方法会返回一个索引Key，我们只需要通过这个索引Key就可以找到我们之前放到Redis里的脚本。
     * 调用evalsha方法，传入索引key，以及操作键、参数值。进行返回 <BR>
     */
    /**
     * lua script：
	 *		local t1 = redis.call('hgetall',KEYS[1]);
	 *		if type(t1) == 'table' then 
	 *			return t1;
	 *		end;
     */
    public static final String SCRIPT = 
    		"local t1 = redis.call('hgetall',KEYS[1]);" + "\n" +
    		"if type(t1) == 'table' then" + "\n" +
    		"return t1;" + "\n" +
    		"end;" + "\n" ;
    @Test
    public void  testLua(){
    	String shakey = jedis.scriptLoad(SCRIPT);//加载脚本，获取sha索引 
    	System.out.println("shakey: " + shakey);
    	//要获取的key值
    	List<String> keys = new ArrayList<>();
    	keys.add("myhash");
    	//传入的参数
    	List<String> args = new ArrayList<>();
    	// /usr/local/bin/redis-cli -h 192.168.1.115 -p 6379 --eval /usr/local/luadir/03.lua name age , baihezhuo
    	List<String> ret = (List<String>)jedis.evalsha(shakey, keys, args);
    	
    	System.out.println(ret);
    	jedis.close();
    }
    
    @Test
	public void testAdd() throws Exception {
    	jedisCluster.set("alextest", "abc");
    	String str = jedisCluster.get("alextest");
    	System.out.println(str);
	}
    
    @Test
	public void testCluster() throws Exception {
    	String shakey = jedisCluster.scriptLoad(SCRIPT,"abc");//加载脚本，获取sha索引 
    	System.out.println("shakey: " + shakey);
    	//要获取的key值
    	List<String> keys = new ArrayList<>();
    	keys.add("myhash");
    	//传入的参数
    	List<String> args = new ArrayList<>();
    	// /usr/local/bin/redis-cli -h 192.168.1.115 -p 6379 --eval /usr/local/luadir/03.lua name age , baihezhuo
    	List<String> ret = (List<String>)jedisCluster.evalsha(shakey, keys, args);
    	
    	System.out.println(ret);
    	jedis.close();
	}
}
