/**
 * 
 */
package com.alex.testnetty;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Title: MyServerMessageHandler Description:
 * 
 * @author wangzi
 * @date 2018年12月20日
 */
public class MyServerMessageHandler extends SimpleChannelHandler {

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		System.out.println("***messageReceived***");
		String s = (String) e.getMessage();
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//	    objectOutputStream.writeObject(e.getMessage());
//		byteArrayOutputStream.toByteArray();
		System.out.println("服务端收到消息：" + s);

		// 回写数据
		ctx.getChannel().write("hello...");
		super.messageReceived(ctx, e);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		System.out.println("***exceptionCaught***");
		super.exceptionCaught(ctx, e);
	}

}
