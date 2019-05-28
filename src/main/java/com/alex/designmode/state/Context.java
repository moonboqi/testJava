/**
 * 
 */
package com.alex.designmode.state;

/**  
* Title: Context  
* Description:   
* @author wangzi  
* @date 2019年1月23日  
*/
public class Context {
    private State state;
      private String name;
      public Context(String name) {
        this.name = name;
    }
      
      public String getName() {
    	  return this.name;
      }

      public void setState(State state) {
        this.state = state;
    }
      public State getState() {
        return this.state;
    }
}
