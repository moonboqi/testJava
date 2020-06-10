/**
 * 
 */
package com.alex.testlambda;

/**  
* Title: ProcessArray  
* Description:   
* @author alexw  
* @date 2020年3月24日  
*/

public class ProcessArray {
    public ProcessArray() {
    }
 
    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }
}
