package com.alex.testJava;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    @Test
	public void test1() throws Exception {
		Map<String,String> map = new HashMap<>();
	}
    
    @Test
	public void test2() throws Exception {
    	String str = "";
    	StringBuffer sb1 = new StringBuffer();
    	StringBuilder sb2 = new StringBuilder();
    	
    	final char value[] = new char[] {'a','b','c'};
    	value[0] = 'd';
    	System.out.println(value[0]);
	}
}	
