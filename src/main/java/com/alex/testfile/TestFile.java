/**
 * 
 */
package com.alex.testfile;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**  
* Title: TestFile  
* Description:   
* @author wangzi  
* @date 2018年10月22日  
*/
public class TestFile {
	
	@Test
	public void testDelete() throws Exception {
		File file = new File("E:\\test\\temp\\20170727\\loan_contract\\cba.zip");
		file.delete();
//		FileUtils.deleteDirectory(file);
	}
	
	@Test
	public void testCreate() throws Exception {
		File file = new File("E:\\tmp\\tmp2");
		if(!file.exists()) {
			file.mkdirs();
		}
	}
}
