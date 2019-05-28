/**
 * 
 */
package com.alex.designmode.fac;

import com.alex.designmode.fac.obj.ChineseFoodA;
import com.alex.designmode.fac.obj.ChineseFoodB;
import com.alex.designmode.fac.obj.Food;

/**  
* Title: ChineseFoodFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class ChineseFoodFactory implements FoodFactory {

    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new ChineseFoodA();
        } else if (name.equals("B")) {
            return new ChineseFoodB();
        } else {
            return null;
        }
    }
}
