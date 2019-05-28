/**
 * 
 */
package com.alex.testZookeeper.zkdist;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**  
* Title: DistributedClinet  
* Description:   
* @author wangzi  
* @date 2019年2月1日  
*/
public class DistributedClinet {
	private static final String connectString = "11.111.16.34:2181,11.111.16.35:2181,11.111.16.36:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/eclipse";

	private volatile List<String> serverList;
	ZooKeeper zk = null;
	
	public void getConnect() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// 收到事件通知的回调处理动作
				System.out.println("事件类型：" + event.getType() + "=====事件发生的节点名称：" + event.getPath());
				// 打印之后再次注册事件
				try {
					getServerList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void getServerList() throws Exception{
		List<String> children = zk.getChildren(parentNode, true);
		List<String> servers = new ArrayList<>();
		for(String child: children) {
			byte[] data = zk.getData(parentNode+"/"+child, false, null);
			servers.add(new String(data));
		}
		serverList = servers;
		System.out.println(serverList);
	}
	
	public void handleBussiness() throws Exception {
		System.out.println("client start working......");
		Thread.sleep(Long.MAX_VALUE);
	}
	
	public static void main(String[] args) throws Exception {
		DistributedClinet client = new DistributedClinet();
		client.getConnect();
		client.handleBussiness();
	}
}
