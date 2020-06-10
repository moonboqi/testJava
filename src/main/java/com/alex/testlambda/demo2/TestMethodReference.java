/**
 * 
 */
package com.alex.testlambda.demo2;

import java.io.File;
import java.io.FileFilter;

/**  
* Title: TestMethodReference  
* Description:   
* @author alexw  
* @date 2020年3月26日  
*/
public class TestMethodReference {
	public static void main(String[] args) {
		File[] hiddenFiles1 = new File("E:\\test").listFiles(new FileFilter() {
		    public boolean accept(File file) {
		        return !file.isHidden();
		    }
		}); 
		
		
		File[] hiddenFiles2 = new File("E:\\test").listFiles(File::isHidden);
	}
	
}
