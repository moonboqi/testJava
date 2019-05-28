/**
 * 
 */
package com.alex.designmode.fac;

import com.alex.designmode.fac.obj.Food;

/**  
* Title: APP  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class APP {
    public static void main(String[] args) {
        // 先选择一个具体的工厂
        FoodFactory factory = new ChineseFoodFactory();
        // 由第一步的工厂产生具体的对象，不同的工厂造出不一样的对象
        Food fc1 = factory.makeFood("A");
        System.out.println(fc1.getClass().getName());
        Food fc2 = factory.makeFood("B");
        System.out.println(fc2.getClass().getName());
        
        // 先选择一个具体的工厂
        FoodFactory factory2 = new AmericanFoodFactory();
        // 由第一步的工厂产生具体的对象，不同的工厂造出不一样的对象
        Food fa1 = factory2.makeFood("A");
        System.out.println(fa1.getClass().getName());
        Food fa2 = factory2.makeFood("B");
        System.out.println(fa2.getClass().getName());
        
    }
}
