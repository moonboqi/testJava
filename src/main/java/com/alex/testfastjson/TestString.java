/**
 * 
 */
package com.alex.testfastjson;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**  
* Title: TestString  
* Description:   
* @author wangzi  
* @date 2019年1月9日  
*/
public class TestString {
	@Test
	public void test1() throws Exception {
		String str = "abc, ";
		String[] split = str.split(",");
		System.out.println(ArrayUtils.isEmpty(split));
		System.out.println(split[0]);
		System.out.println(split.length);
	}
	
	@Test
	public void test2() throws Exception {
		String str = "abc:ef,hijk:lmn,op:qrst";
		List<String> result = getSubByRgex(str, "^,$");
		for(String s: result) {
			System.out.println(s);
		}
	}
	
	public static List<String> getSubByRgex(String soap,String rgex){          
		List<String> list = new ArrayList<String>();          
		Pattern pattern = Pattern.compile(rgex);// 匹配的模式          
		Matcher m = pattern.matcher(soap);          
		while (m.find()) {              
			int i = 1;              
			list.add(m.group(i));              
			i++;          
		}          
		return list;      
	}  
}
