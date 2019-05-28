/**
 * 
 */
package com.alex.xmlandjson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**  
* Title: InnerPojo  
* Description:   
* @author wangzi  
* @date 2018年6月4日  
*/
@Setter
@Getter
@ToString
@XmlRootElement(name="InnerElem")
@XmlAccessorType(XmlAccessType.FIELD)
public class InnerPojo {
	@XmlElement(name="innerName")
	private String innerName;
	@XmlElement(name="innerAge")
	private Integer innerAge;
	
	
}
