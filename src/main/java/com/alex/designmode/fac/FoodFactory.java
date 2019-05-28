/**
 * 
 */
package com.alex.designmode.fac;

import com.alex.designmode.fac.obj.Food;

/**  
* Title: FoodFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public interface FoodFactory {
    Food makeFood(String name);
}
