/**
 * 
 */
package com.alex.testproxy.dynamic2;

/**  
* Title: MonitorUtil  
* Description:   
* @author wangzi  
* @date 2019年6月4日  
*/
public class MonitorUtil {
    
    private static ThreadLocal<Long> tl = new ThreadLocal<>();
    
    public static void start() {
        tl.set(System.currentTimeMillis());
    }
    
    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
