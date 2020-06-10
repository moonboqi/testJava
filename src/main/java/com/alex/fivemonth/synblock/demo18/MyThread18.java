/**
 * 
 */
package com.alex.fivemonth.synblock.demo18;

/**  
* Title: abc  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/
public class MyThread18 extends Thread
{
    private ThreadDomain18 td;
    
    public MyThread18(ThreadDomain18 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        try
        {
            td.doLongTimeTask();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
