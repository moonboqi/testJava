/**
 * 
 */
package com.alex.designmode.decorator;

/**  
* Title: GreenTea  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class GreenTea extends Beverage {
    public String getDescription() {
        return "绿茶";
    }
      public double cost() {
        return 11;
    }
}
