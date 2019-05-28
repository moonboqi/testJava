/**
 * 
 */
package com.alex.testkafka;

import java.util.Date;

/**  
* Title: IpranAlarm  
* Description:   
* @author wangi  
* @date 2018年4月26日  
*/
public class IpranAlarm {
	private Long id;
	private String content;
	private Date sendTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
}
