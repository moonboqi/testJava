/**
 * 
 */
package com.alex.testlambda;

/**  
* Title: CommandTest  
* Description:   
* @author alexw  
* @date 2020年3月24日  
*/
public class CommandTest {
    public CommandTest() {
    }
 
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] array = new int[]{3, -4, 6, 4};
        pa.process(array, new Command() {
            public void process(int[] target) {
                int sum = 0;
                int[] var3 = target;
                int var4 = target.length;
 
                for(int var5 = 0; var5 < var4; ++var5) {
                    int tmp = var3[var5];
                    sum += tmp;
                }
 
                System.out.println("数组元素的总和是:" + sum);
            }
        });
    }
}
