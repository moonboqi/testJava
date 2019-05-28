/**
 * 
 */
package com.alex.testfastjson;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**  
* Title: TestFastJson  
* Description:   
* @author wangi  
* @date 2018年4月13日  
*/
public class TestFastJson {
	@Test
	public void test1() throws Exception {
		//测试list<Map<String,String>>的fastJson转化
		Map<String,String> map11 = new HashMap<>();
		map11.put("customSmsId","2017010709302912");
		map11.put("mobile","15538867822");
		Map<String,String> map22 = new HashMap<>();
		map22.put("customSmsId","2017010709302913");
		map22.put("mobile","15538867823");
		List<Map<String,String>> list11 = new ArrayList<>();
		list11.add(map11);
		list11.add(map22);
		String str11 = JSON.toJSONString(list11);
		System.out.println("-----------------------------------------");
		System.out.println(str11);
		List<Map> list22 = JSON.parseArray(str11, Map.class);
		System.out.println(list22.get(0).get("mobile"));
	}
	@Test
	public void test2() throws Exception {
		Object obj = "abc";
		String str = new String(""+obj);
		Person p = new Person();
		p.setAge(10);
		p.setName("张三");
		System.out.println(""+JSON.toJSONString(p));
		System.out.println(""+JSON.toJSONString(obj));
		System.out.println(""+JSON.toJSONString(str));
	}
	@Test
	public void test3() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("abc", "dd");
		System.out.println(""+map.get("aa"));
	}
	
	@Test
	public void testjsontopojo() throws Exception {
		JsonPojo Tjson = JSON.parseObject("{\"requestNo\": \"000\",\"requestTime\": null,\"channelCode\": null,\"version\": null,\"sign\": null,\"requestData\": {\"caseNo\": \"001\",\"approveStatus\": \"审批通过\",\"approveAmount\": null}}",JsonPojo.class);
		System.out.println(Tjson);
	}
	
	
}
class Person{
	int age;
	String name;
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}


