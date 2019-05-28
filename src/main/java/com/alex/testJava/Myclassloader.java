/**
 * 
 */
package com.alex.testJava;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**  
* Title: Myclassloader  
* Description:   
* @author wangzi  
* @date 2018年11月1日  
*/
public class Myclassloader extends ClassLoader {
	
	private String path;
	private String name1;
	
	/**
	 * @param path
	 * @param name
	 */
	public Myclassloader(String path, String name1) {
		super();
		this.path = path;
		this.name1 = name1;
	}

	public Myclassloader(ClassLoader parent, String path, String name1) {
		super(parent);
		this.path = path;
		this.name1 = name1;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = readClassFileToByteArray(name);
		return this.defineClass(name, data, 0, data.length);
	}

	private byte[] readClassFileToByteArray(String name) {
		InputStream is = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] returnData = null;
		name = name.replaceAll("\\.", "/");
		String filePath = this.path + name + ".class";
		File file = new File(filePath);
		try {
			is = new FileInputStream(file);
			int tmp = 0;
			while((tmp=is.read()) != -1) {
				bos.write(tmp);
			}
			returnData = bos.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(is!=null) {
					is.close();
				}
				if(bos!=null) {
					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnData;
	}
	
}
