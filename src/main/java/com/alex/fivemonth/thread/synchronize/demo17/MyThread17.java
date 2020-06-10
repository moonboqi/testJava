/**
 * 
 */
package com.alex.fivemonth.thread.synchronize.demo17;

/**  
* Title: ab  
* Description:   
* @author alexw  
* @date 2020年5月26日  
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
