/**
 * 
 */
package com.alex.xmlandjson;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**  
* Title: TestJsonPojo  
* Description:   
* @author wangzi  
* @date 2018年6月4日  
*/
public class TestJsonPojo {
	@Test
	public void testPojo2Json1() throws Exception {
		XmlPojo xmlPojo = new XmlPojo();
		xmlPojo.setName("张三");
		xmlPojo.setAge(42);
		xmlPojo.setAddress("广州东站");
		InnerPojo innerPojo = new InnerPojo();
		innerPojo.setInnerName("张小");
		innerPojo.setInnerAge(18);
		xmlPojo.setInnerPojo(innerPojo);
		String jsonString = JSON.toJSONString(xmlPojo);
		System.out.println(jsonString);
	}
	@Test
	public void testPojo2Json2() throws Exception {
		XmlPojo xmlPojo = new XmlPojo();
		xmlPojo.setName("张三");
		xmlPojo.setAge(42);
		xmlPojo.setAddress("广州东站");
		xmlPojo.setContent("\"innerPojo\":{\"innerAge\":18,\"innerName\":\"张小\"}");
		String jsonString = JSON.toJSONString(xmlPojo);
		System.out.println(jsonString);
	}
	
	@Test
	public void testJson2Pojo1() throws Exception {
		String str1 = "{\"address\":\"广州东站\",\"age\":42,\"innerPojo\":{\"innerAge\":18,\"innerName\":\"张小\"},\"name\":\"张三\"}";
		XmlPojo parseObject = JSON.parseObject(str1, XmlPojo.class);
		System.out.println(parseObject);
	}
	@Test
	public void testJson2Pojo2() throws Exception {
		String str2 = "{\"address\":\"广州东站\",\"age\":42,\"content\":\"\\\"innerPojo\\\":{\\\"innerAge\\\":18,\\\"innerName\\\":\\\"张小\\\"}\",\"name\":\"张三\"}";
		XmlPojo parseObject = JSON.parseObject(str2, XmlPojo.class);
		System.out.println(parseObject);
	}
}
