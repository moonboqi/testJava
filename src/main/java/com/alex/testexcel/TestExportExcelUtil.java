/**
 * 
 */
package com.alex.testexcel;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
* Title: aaa  
* Description:   
* @author alexw  
* @date 2019年11月6日  
*/

public class TestExportExcelUtil {
	
	public static void main(String[] args) throws Exception{
		ExportExcelUtil<Student> util = new ExportExcelUtil<Student>();
		 // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        	 list.add(new Student(111,"张三asdf","男"));
             list.add(new Student(111,"李四asd","男"));
             list.add(new Student(111,"王五","女"));
        }
        String[] columnNames = { "ID", "姓名", "性别" };
        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:\\test\\excel\\test2.xlsx"), ExportExcelUtil.EXCEl_FILE_2007);
//        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:\\test\\excel\\test1.xls"), ExportExcelUtil.EXCEL_FILE_2003);
	}
	@Test
	public void test1() throws Exception {
		System.out.println("启动成功");
	}
}
