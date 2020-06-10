/**
 * 
 */
package com.alex.testlambda.demo2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Title: TestDemo1 Description:
 * 
 * @author alexw
 * @date 2020年3月26日
 */
public class TestRunnalble {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();

		new Thread(() -> 
		{System.out.println("In Java8, Lambda expression rocks !!");}
		).start();
	}
	
	@Test
	public void testMap() throws Exception {
		List<Integer> list =  Arrays.asList(100,200,300,400);
		
	}
}
