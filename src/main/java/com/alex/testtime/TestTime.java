/**
 * 
 */
package com.alex.testtime;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Title: TestTime Description:
 * 
 * @author alexw
 * @date 2019年10月14日
 */
public class TestTime {
	@Test
	public void testDateTimestamp() throws Exception {
		// date转timestamp
		Timestamp ts = new Timestamp(new Date().getTime());
		System.out.println(ts);
		// timestamp转date
		Date date = new Timestamp(System.currentTimeMillis());
		System.out.println(date);
	}

	@Test
	public void test2() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(1 == 2 ? "1" : "2");
		String str = "";
		str = (1 == 1 ? "1" : "2");
		System.out.println(sb);
	}

	@Test
	public void testCalendar() throws Exception {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(new Date());
		Thread.sleep(10000);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(new Date());
		System.out.println(endCalendar.getTime().getTime());
		System.out.println(startCalendar.getTime().getTime());
		System.out.println("过了多少秒？" + ((endCalendar.getTime().getTime() - startCalendar.getTime().getTime()) / 1000));

	}
}
