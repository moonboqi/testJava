/**
 * 
 */
package com.alex.designmode.decorator;

/**  
* Title: BlackTea  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
public class BlackTea extends Beverage {
    public String getDescription() {
      return "红茶";
  }
    public double cost() {
      return 10;
  }
}
