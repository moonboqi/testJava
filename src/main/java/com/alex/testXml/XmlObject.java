/**
 * 
 */
package com.alex.testXml;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**  
* Title: XmlObject  
* Description:   
* @author wangzi  
* @date 2019年6月4日  
*/
public class XmlObject
{
    private int[]                 counts;
    private List<String>          phones;
    private Map<String, Date>     calendar;
    
    public XmlObject(int[] counts, List<String> phones, Map<String, Date> calendar)
    {
        this.counts = counts;
        this.phones = phones;
        this.calendar = calendar;
    }

    public String toString()
    {
        return "count = " + counts + ", phones = " + phones + ", calendar = " + calendar;
    }
}
