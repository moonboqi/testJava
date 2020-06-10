/**
 * 
 */
package com.alex.fivemonth.thread.synchronize;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread13_0 extends Thread
{
    private ThreadDomain13 td;
    
    public MyThread13_0(ThreadDomain13 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.addNum("a");
    }
}
