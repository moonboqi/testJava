/**
 * 
 */
package com.alex.fivemonth.thread.exceptionlock;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2019年9月16日  
*/
public class MyThread17 extends Thread
{
    private ThreadDomain17 td;
    
    public MyThread17(ThreadDomain17 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.testMethod();
    }
}
