/**
 * 
 */
package com.alex.testfilewriter;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;

/**  
* Title: TestFileWriter  
* Description:   
* @author wangzi  
* @date 2018年10月15日  
*/
public class TestFileWriter {
	@Test
	public void test1() throws Exception {
		FileWriter fw = new FileWriter(new File("E:\\test\\txt\\abc.txt"), true);
		fw.write("abc");
		fw.write("123");
		fw.write("yyy");
		fw.close();
	}
}
