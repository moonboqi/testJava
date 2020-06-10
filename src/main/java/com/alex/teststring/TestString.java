/**
 * 
 */
package com.alex.teststring;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Title: TestString Description:
 * 
 * @author alexw
 * @date 2019年9月18日
 */
public class TestString {
	@Test
	public void testGetUrl() throws Exception {
		String str = "<p><img class=\"wscnph\" src=\"http://test.ntshc.oa.com/oaAdminFileApi/file/download?fileName=FILE20190918111350BLPSFXKYRJSO.png\" /><img class=\"wscnph\" src=\"http://test.ntshc.oa.com/oaAdminFileApi/file/download?fileName=FILE20190918111205OPMHZBKVMWXD.jpg\" /></p>";
				
		String pattern = "src=\".*?\"";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(str);
		List<String> links = new ArrayList<>();
		if (m.find()) {
			System.out.println(m.group());
		}
	}
	
	@Test
	public void test2() throws Exception {
		String str = "johnsonyang(杨俊森)";
//		System.out.println(str.substring(0,str.indexOf("(")));
		System.out.println("0".equals(null));
	}
	
	@Test
	public void test3() throws Exception {
		String str = "aa.bb.";
		String[] split = str.split("\\.");
		System.out.println(split.length);
	}
	@Test
	public void test4() throws Exception {
		String str = null;
		System.out.println(str+"abc");
	}
	
	@Test
	public void test5() throws Exception {
		byte[] b = new byte[] {1,2};
	}
	
	@Test
	public void test6() throws Exception {
		String str = "OA000001.00000956.00015576.00005520.00005701.00015667.00015672";
		String unit = "00005520";
		System.out.println(str.substring(0, str.indexOf(unit))+unit);
	}
}
