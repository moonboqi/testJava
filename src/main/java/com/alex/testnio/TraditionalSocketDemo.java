/**
 * 
 */
package com.alex.testnio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**  
* Title: TraditionalSocketDemo  
* Description:   
* @author wangzi  
* @date 2018年12月14日  
*/
public class TraditionalSocketDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("服务端启动...");
		
		while(true) {
			//阻塞点1
			Socket socket = serverSocket.accept();
			System.out.println("有新客户端上来了....");
			InputStream is = socket.getInputStream();
			byte[] b = new byte[1024];
			while(true) {
				//阻塞点2
				int data = is.read(b);
				if(data != -1) {
					String info = new String(b, 0, data);
					System.out.println(info);
					System.out.println(new String(b,0,data,"gbk"));
				}else {
					break;
				}
			}
		}
	}
	
	@Test
	public void test1() throws Exception {
		String str = new String("中国");
		byte[] b_utf8 = str.getBytes("utf-8");
		byte[] b_gbk = str.getBytes("gbk");
		byte[] b_iso88591  = str.getBytes("iso8859-1");
//		System.out.println(new String(b_utf8,"utf-8"));
//		System.out.println(new String(b_gbk,"gbk"));
//		System.out.println(new String(b_iso88591,"iso8859-1"));
//		System.out.println(new String(b_iso88591));
//		System.out.println("完成");
		String s_iso88591 = new String("中".getBytes("UTF-8"),"ISO8859-1");
		System.out.println(s_iso88591);
		String s_utf8 = new String(s_iso88591.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(s_utf8);
		System.out.println(Integer.toBinaryString(121));
	}
}
