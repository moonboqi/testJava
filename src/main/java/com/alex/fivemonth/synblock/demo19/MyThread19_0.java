/**
 * 
 */
package com.alex.fivemonth.synblock.demo19;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread19_0 extends Thread
{
    private ThreadDomain19 td;
    
    public MyThread19_0(ThreadDomain19 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.serviceMethodA();
    }
}
