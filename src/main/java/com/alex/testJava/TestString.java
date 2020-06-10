/**
 * 
 */
package com.alex.testJava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;



/**  
* Title: TestString  
* Description:   
* @author alexw  
* @date 2020年4月21日  
*/
public class TestString {
	
	@Test
	public void test1() throws Exception {
		String str = "123.456.789";
		String[] split = str.split("[.]");
		System.out.println(split[0]+"---"+split[1]+"---"+split[2]);
	}
	
	public static void main(String[] args) {
//		if (insertNum > 0 && insertNum % 100 == 0) {
//			if (CollectionUtils.isNotEmpty(listInsert)) {
//				// 批量获取staffId
//				try {
//					queryStaffid(listInsert);
//					if(CollectionUtils.isNotEmpty(listInsert)) {
//						List<MostUsedLinkDto> listInsert2 = new ArrayList<>();
//						for(MostUsedLinkVo vo: listInsert) {
//							MostUsedLinkDto dto = new MostUsedLinkDto();
//							BeanUtils.copyProperties(dto, vo);
//							listInsert2.add(dto);
		List<String> list= new ArrayList<>();
		List<String> listInsert = new ArrayList<>();
		for(int i=0;i<list.size(); i++) {
			if(i%500==0 && i!=0) {
				//insert
			}else {
				//添加元素
				listInsert.add("");
			}
		}
		//insert
	}
}
