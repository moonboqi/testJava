/**
 * 
 */
package com.alex.testZookeeper.zkdist;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 * Title: DistributedServer Description:
 * 
 * @author wangzi
 * @date 2019年2月1日
 */
public class DistributedServer {

	private static final String connectString = "11.111.16.34:2181,11.111.16.35:2181,11.111.16.36:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/eclipse";

	ZooKeeper zk = null;

	public void getConnect() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// 收到事件通知的回调处理动作
				System.out.println("事件类型：" + event.getType() + "=====事件发生的节点名称：" + event.getPath());
				// 打印之后再次注册事件
				try {
					zk.getChildren("/", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void registerServer(String hostname) throws Exception {
		String create = zk.create(parentNode + "/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname + "is online.." + create);
	}
	
	public void handleBussiness(String hostname) throws Exception {
		System.out.println(hostname+"start working......");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		// 获取zk连接
		DistributedServer server = new DistributedServer();
		server.getConnect();
		// 利用zk连接注册服务器信息
		server.registerServer(args[0]);
		// 启动业务功能
		server.handleBussiness(args[0]);
	}
}
