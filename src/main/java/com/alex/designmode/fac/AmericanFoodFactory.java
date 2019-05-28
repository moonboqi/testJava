/**
 * 
 */
package com.alex.designmode.fac;

import com.alex.designmode.fac.obj.AmericanFoodA;
import com.alex.designmode.fac.obj.AmericanFoodB;
import com.alex.designmode.fac.obj.Food;

/**  
* Title: AmericanFoodFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class AmericanFoodFactory implements FoodFactory {

    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}
