/**
 * 
 */
package com.alex.testmap;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.alex.util.JacksonUtil;

/**  
* Title: TestMap  
* Description:   
* @author wangzi  
* @date 2018年7月9日  
*/
public class TestMap {
	@Test
	public void test1() throws Exception {
		Map<String, String> map = new HashMap<>();
		String str = map.get(null);
		map.put("abc", null);
		String str2 = map.get("abc");
		System.out.println(str+":"+str2);
		System.out.println(str == str2);
		
		Map<String, String> map2 = new LinkedHashMap<>();
		map2.hashCode();
		
		Map<String, String> map3 = new TreeMap<>();
	}
	@Test
	public void test2() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("abc", "123");
		map.put("你好","开始");
		map.put("!!!", "---");
		String str = String.valueOf(map);
		System.out.println(str);
		String str2 = JacksonUtil.obj2json(map);
		System.out.println(str2);
		Map<String, Object> json2map = JacksonUtil.json2map(str2);
		System.out.println(json2map.get("abc"));
		System.out.println(json2map.get("你好"));
		System.out.println(json2map.get("!!!"));
	}
	
	@Test
	public void test3() throws Exception {
		Map<String, String> map = new HashMap<>();
		String str = map.get("a");
		if(str==null) {
			str = "b";
//			map.put("a", "b");
		}
		System.out.println(map.get("a"));
	}
}
