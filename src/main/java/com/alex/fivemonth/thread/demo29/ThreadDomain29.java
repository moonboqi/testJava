/**
 * 
 */
package com.alex.fivemonth.thread.demo29;

import java.util.concurrent.atomic.AtomicInteger;

/**  
* Title: aa  
* Description:   
* @author alexw  
* @date 2020年5月28日  
*/
public class ThreadDomain29
{
    public static AtomicInteger aiRef = new AtomicInteger();
    
    public void addNum()
    {
        System.out.println(Thread.currentThread().getName() + "加了100之后的结果：" + 
                aiRef.addAndGet(100));
        aiRef.getAndAdd(1);
    }
}
