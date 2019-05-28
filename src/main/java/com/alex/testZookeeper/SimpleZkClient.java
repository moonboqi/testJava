/**
 * 
 */
package com.alex.testZookeeper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 * Title: SimpleZkClient Description:
 * 
 * @author wangzi
 * @date 2019年2月1日
 */
public class SimpleZkClient {

	private static final String connectString = "11.111.16.34:2181,11.111.16.35:2181,11.111.16.36:2181";
	private static final int sessionTimeout = 2000;
	
	ZooKeeper zkClient = null;
	
	@Before
	public void init() throws Exception {
		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// 收到事件通知的回调处理动作
				System.out.println("事件类型：" + event.getType() + "=====事件发生的节点名称：" + event.getPath());
				//打印之后再次注册事件
				try {
					zkClient.getChildren("/", true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	@Test
	public void testCreate() throws Exception {
		// 创建一个目录节点
		String nodeCreated = zkClient.create("/eclipse", "hellozk".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
	}
	
	@Test
	public void testExist() throws Exception {
		Stat stat = zkClient.exists("/eclipse", false);
		if(stat!=null)
			System.out.println(stat.getCzxid());
		else
			System.out.println("not exist");
	}
	
	@Test
	public void getChildren() throws Exception {
		List<String> children = zkClient.getChildren("/", true);
		for(String child: children) {
			System.out.println(child);
		}
		Thread.sleep(Long.MAX_VALUE);
	}
	
	@Test
	public void getData() throws Exception {
		byte[] data = zkClient.getData("/eclipse", false, null);
		System.out.println(new String(data));
	}
	
	@Test
	public void deleteZnode() throws Exception {
		zkClient.delete("/eclipse", -1);
	}
	
	@Test
	public void setData() throws Exception {
		zkClient.setData("/eclipse", "testtesttest".getBytes(), -1);
		byte[] data = zkClient.getData("/eclipse", false, null);
		System.out.println(new String(data));
	}
}
