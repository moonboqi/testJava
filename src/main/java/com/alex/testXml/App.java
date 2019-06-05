/**
 * 
 */
package com.alex.testXml;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年6月4日  
*/
public class App {
	public static void main(String[] args)
	{
	    int[] counts = {10, 11, 12};
	    List<String> phones = new ArrayList<String>();
	    phones.add("110");
	    phones.add("119");
	    phones.add("120");
	    Map<String, Date> calendar = new HashMap<String, Date>();
	    calendar.put("1", new Date());
	    calendar.put("2", new Date());
	    XStream xs = new XStream();
	    XmlObject xo = new XmlObject(counts, phones, calendar);
	    xs.alias("XmlObject", XmlObject.class);
	    xs.aliasField("Count", XmlObject.class, "counts");
	    xs.aliasField("Phones", XmlObject.class, "phones");
	    xs.aliasField("Calendar", XmlObject.class, "calendar");
	    String str = xs.toXML(xo);
	    System.out.println(str);
	}
}
