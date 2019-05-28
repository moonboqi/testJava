/**
 * 
 */
package com.alex.designmode.proxy;

import com.alex.designmode.proxy.obj.Chicken;
import com.alex.designmode.proxy.obj.Food;
import com.alex.designmode.proxy.obj.Noodle;

/**  
* Title: FoodServiceImpl  
* Description:   
* @author wangzi  
* @date 2019年1月14日  
*/
public class FoodServiceImpl implements FoodService {
    public Food makeChicken() {
		Food f = new Chicken();
		f.setChicken("1kg");
		f.setSpicy("1g");
		f.setSalt("3g");
		return f;
    }
    public Food makeNoodle() {
        Food f = new Noodle();
        f.setNoodle("500g");
        f.setSalt("5g");
        return f;
    }
}
