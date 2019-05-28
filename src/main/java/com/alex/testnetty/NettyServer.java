/**
 * 
 */
package com.alex.testnetty;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**  
* Title: NettyServer  
* Description:   
* @author wangzi  
* @date 2018年12月19日  
*/
public class NettyServer {
	public static void main(String[] args) {
		//服务启动类
		ServerBootstrap bootstrap = new ServerBootstrap();
		//Boss线程监听端口和客户端分发
		ExecutorService boss = Executors.newCachedThreadPool();
		//Worker线程负责处理客户端数据的读写
		ExecutorService worker = Executors.newCachedThreadPool();
		//设置NioServerSocketChannelFactory工厂
		bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		//设置管道的工厂
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				//设置过滤器
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("decoder", new StringDecoder());
				pipeline.addLast("encoder", new StringEncoder());
				pipeline.addLast("myServerMessageHandler", new MyServerMessageHandler());
				return pipeline;
			}
		});
		
		bootstrap.bind(new InetSocketAddress(7777));
		System.out.println("Netty服务端启动了...");
	}
}
