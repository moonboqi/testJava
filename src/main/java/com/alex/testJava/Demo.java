/**
 * 
 */
package com.alex.testJava;

import static org.junit.Assert.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Title: Demo Description:
 * 
 * @author wangzi
 * @date 2018年11月1日
 */
public class Demo {

	public Demo() {
		System.out.println("Demo:" + this.getClass().getClassLoader());
	}
	@Test
	public void test1() throws Exception {
		ReentrantLock lock = new ReentrantLock();
//		Condition con1 = lock.newCondition("c1");
		Condition con2 = lock.newCondition();
		try {
			lock.lock();
//			con
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}

	@Test
	public void test2() throws Exception {
		try {
			System.out.println("------------------------方法开始，执行try");
			throw new RuntimeException("------------------------异常发生");
		} catch (Exception e) {
			System.out.println("------------------------执行catch块");
			return;
		} finally {
			System.out.println("------------------------执行finally块");
			return;
		}
	}
	
	@Test
	public void test3() throws Exception {
		System.out.println(System.getProperty("java.vm.name"));
	}
}
