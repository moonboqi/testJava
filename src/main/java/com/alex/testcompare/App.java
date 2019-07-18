/**
 * 
 */
package com.alex.testcompare;

/**  
* Title: App  
* Description:   
* @author alexw  
* @date 2019年6月19日  
*/
public class App {
	public static void main(String[] args)
    {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("c");
        Domain d3 = new Domain("b");
        Domain d4 = new Domain("d");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d4));
        
        
        DomainComparator dc = new DomainComparator();
        System.out.println(dc.compare(d1, d2));
        System.out.println(dc.compare(d1, d3));
        System.out.println(dc.compare(d1, d4));
    }
}
