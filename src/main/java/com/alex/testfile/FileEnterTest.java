/**
 * 
 */
package com.alex.testfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alex.util.JacksonUtil;

/**  
* Title: FileEnterTest  
* Description:   
* @author wangzi  
* @date 2019年2月20日  
*/
public class FileEnterTest {
	@Test
	public void testWrite() throws Exception {
		FileWriter fw;
		Map<String, String> map = new HashMap<>();
		//TODO 测试10万个数的情况
		for(int i=0; i<10; i++) {
			map.put(Integer.toString(i), Integer.toString(i));
		}
		try {
			fw = new FileWriter(new File("E:\\test\\temp\\abc.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(JacksonUtil.obj2json(map));
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("写入成功！");
		} catch (IOException e) {
			System.out.println("txt清单文件写入失败:{}");
		}
	}
	//测试二次写入
	@Test
	public void testWrite2() throws Exception {
		File file = new File("E:\\test\\temp\\abc.txt");
		Map<String, Object> stringObjectMap = readTxtUtil(file);
		//TODO 测试10万个数的情况
		Map<String, String> map = new HashMap<>();
		for(int i=11; i<20; i++) {
			map.put(Integer.toString(i), Integer.toString(i));
		}
		stringObjectMap.putAll(map);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(JacksonUtil.obj2json(stringObjectMap));
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("写入成功！");
		} catch (IOException e) {
			System.out.println("txt清单文件写入失败:{}");
		}
	}
	public static Map<String, Object> readTxtUtil(File file) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String encoding = "UTF-8";
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				System.out.println(lineTxt);
				map = JacksonUtil.json2map(lineTxt);
			}
			read.close();
		} else {
			System.out.println("txt文件不存在，需要新建空文件");
		}
		return map;
	}
	//测试文件读取
	@Test
	public void testRead() throws Exception {
		String encoding = "UTF-8";
		File file = new File("E:\\test\\temp\\abc.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
		BufferedReader bufferedReader = new BufferedReader(read);
		System.out.println(bufferedReader.readLine());
		read.close();
	}
}
