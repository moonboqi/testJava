/**
 * 
 */
package com.alex.fivemonth.synblock.demo19;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread19_1 extends Thread
{
    private ThreadDomain19 td;
    
    public MyThread19_1(ThreadDomain19 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.serviceMethodB();
    }
}
