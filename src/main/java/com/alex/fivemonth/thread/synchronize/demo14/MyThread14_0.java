/**
 * 
 */
package com.alex.fivemonth.thread.synchronize.demo14;

/**  
* Title: abbc  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread14_0 extends Thread
{
    private ThreadDomain14_0 td;
    
    public MyThread14_0(ThreadDomain14_0 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.methodA();
    }
}
