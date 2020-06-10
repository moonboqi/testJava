/**
 * 
 */
package com.alex.fivemonth.synblock.demo20;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread20_1 extends Thread
{
    private ThreadDomain20 td;
    
    public MyThread20_1(ThreadDomain20 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.otherMethod();
    }
}
