/**
 * 
 */
package com.alex.testZookeeper.zkdistlock;

import java.util.List;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * Title: DiskLock Description:
 * 
 * @author wangzi
 * @date 2019年2月2日
 */
public class DiskLock {
	private static final String connectString = "11.111.16.34:2181,11.111.16.35:2181,11.111.16.36:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/eclipse";
	private String nodeNum;
	private volatile Integer times = 0;
	ZooKeeper zk = null;

	public void getConnect() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// 收到事件通知的回调处理动作
				System.out.println("事件类型：" + event.getType() + "=====事件发生的节点名称：" + event.getPath());
				// 尝试获取锁并再次注册事件
				try {
					tryGetLock();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void handleBussiness() throws Exception {
		System.out.println("server start working......");
		// 建立临时带序号的节点
		nodeNum = zk.create(parentNode + "/order", "abcd".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		tryGetLock();
		Thread.sleep(Long.MAX_VALUE);
	}

	private void tryGetLock() throws Exception {
		// 获取子节点
		List<String> children = zk.getChildren(parentNode, true);
		TreeSet<String> currentSet = new TreeSet<>();
		if (CollectionUtils.isNotEmpty(children)) {
			System.out.println("当前节点列表为：" + children);
			for (String child : children) {
				currentSet.add(child);
			}
		} else {
			System.out.println("与zookeeper工作出错了，终止本服务");
		}

		// 判断是否获取锁
		if (StringUtils.isNotEmpty(nodeNum) && nodeNum.substring(nodeNum.lastIndexOf("/")+1).equals(currentSet.first())) {
			System.out.println("-----本服务获取到了锁：目前是第" + (++times) + "次尝试获取锁");
			System.out.println("-----本节点序号为：" + nodeNum);
			// 释放节点
			zk.delete(nodeNum, -1);
		} else {
			System.out.println("---------------本服务本次未获取到锁：目前是第" + (++times) + "次尝试获取锁");
			System.out.println("---------------本节点序号为：" + nodeNum);
		}
	}

	public static void main(String[] args) throws Exception {
		DiskLock lock = new DiskLock();
		lock.getConnect();
		lock.handleBussiness();
	}
}
