/**
 * 
 */
package com.alex.testmulthread.lock.idgenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**  
* Title: OrderServerImpl  
* Description:   
* @author wangzi  
* @date 2018年11月5日  
*/
public class OrderServerImpl implements OrderServerInterface {

	static int num = 0;
	
	@Override
	public synchronized String getOrderNo() {
		SimpleDateFormat date = new SimpleDateFormat("YYYYMMDDHHMMSS");
		return date.format(new Date()) + num++;
	}
	
}
