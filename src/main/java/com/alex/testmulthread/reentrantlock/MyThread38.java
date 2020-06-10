/**
 * 
 */
package com.alex.testmulthread.reentrantlock;

/**  
* Title: MyThread38  
* Description:   
* @author alexw  
* @date 2019年10月21日  
*/
public class MyThread38 extends Thread
{
    private ThreadDomain38 td;
    
    public MyThread38(ThreadDomain38 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.testMethod();
    }
    
    /*
     	* 测试类
     */
    public static void main(String[] args)
    {
        ThreadDomain38 td = new ThreadDomain38();
        MyThread38 mt0 = new MyThread38(td);
        MyThread38 mt1 = new MyThread38(td);
        MyThread38 mt2 = new MyThread38(td);
        mt0.start();
        mt1.start();
        mt2.start();
    }
}
