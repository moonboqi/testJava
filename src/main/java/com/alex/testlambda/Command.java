/**
 * 
 */
package com.alex.testlambda;

/**  
* Title: Command  
* Description:   
* @author alexw  
* @date 2020年3月24日  
*/

public interface Command
{
   // 接口里定义的process()方法用于封装“处理行为”
   void process(int[] target);
}
