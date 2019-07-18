/**
 * 
 */
package com.alex.testclassloader;

/**  
* Title: TestMyClassLoader  
* Description:   
* @author alexw  
* @date 2019年6月19日  
*/
public class TestMyClassLoader
{
    public static void main(String[] args) throws Exception
    {
        MyClassLoader mcl = new MyClassLoader();   
        
//    	MyClassLoader mcl = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Class<?> c1 = Class.forName("com.alex.testclassloader.Person", true, mcl); 
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}
