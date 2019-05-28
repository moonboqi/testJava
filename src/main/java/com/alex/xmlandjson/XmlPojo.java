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
* Title: Pojo  
* Description:   
* @author wangzi  
* @date 2018年5月31日  
*/
@Setter
@Getter
@ToString
@XmlRootElement(name="OutsideElem")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlPojo {
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="address")
	private String address;
	@XmlElement(name="age")
	private Integer age;
	private InnerPojo innerPojo;
	
	private String content;
	
}
