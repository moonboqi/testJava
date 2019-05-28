/**
 * 
 */
package com.alex.designmode.decorator;

/**  
* Title: Mango  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class Mango extends Condiment {
    private Beverage bevarage;
      public Mango(Beverage bevarage) {
        this.bevarage = bevarage;
    }
      public String getDescription() {
        return bevarage.getDescription() + ", 加芒果";
    }
      public double cost() {
        return bevarage.cost() + 3; // 加芒果需要 3 元
    }
}
