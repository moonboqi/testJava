/**
 * 
 */
package com.alex.testnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Title: NioSocketDemo Description:
 * 
 * @author wangzi
 * @date 2018年12月19日
 */
public class NioSocketDemo {

	private Selector selector;

	public static void main(String[] args) throws Exception {
		NioSocketDemo nio = new NioSocketDemo();
		nio.initServer(8888);
		nio.listenSelector();
	}
	
	public void initServer(int port) throws Exception {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		serverChannel.socket().bind(new InetSocketAddress(port));

		this.selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务启动了...");
	}

	public void listenSelector() throws Exception {
		// 轮询监听selector
		while (true) {
			// 等待客户连接：select模型，多路复用
			this.selector.select();
			
			Iterator<SelectionKey> iteKey = this.selector.selectedKeys().iterator();
			while (iteKey.hasNext()) {
				SelectionKey key = iteKey.next();
				iteKey.remove();
				// 处理请求
				handler(key);
			}
		}
	}

	private void handler(SelectionKey key) throws Exception {
		if (key.isAcceptable()) {
			// 处理客户端连接请求事件
			ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
			SocketChannel socketChannel = serverChannel.accept();
			System.out.println("有新客户端连接上来了!!!");
			// 接收客户端发送信息时，需要给通道设置读的权限
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
			
		} else if (key.isReadable()) {
			// 处理读的事件
			SocketChannel socketChannel = (SocketChannel) key.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int readData = socketChannel.read(buffer);
			if (readData > 0) {
				String info = new String(buffer.array(), "gbk").trim();
				System.out.println("服务端收到数据：" + info);
			} else {
				System.out.println("服务端关闭了...");
				key.cancel();
			}
		}
	}
}
