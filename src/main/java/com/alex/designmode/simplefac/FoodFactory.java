/**
 * 
 */
package com.alex.designmode.simplefac;

/**  
* Title: FoodFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class FoodFactory {

    public static Food makeFood(String name) {
        if (name.equals("noodle")) {
            Food noodle = new LanZhouNoodle();
            noodle.addSpicy("more");
            return noodle;
        } else if (name.equals("chicken")) {
            Food chicken = new HuangMenChicken();
            chicken.addCondiment("potato");
            return chicken;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
		Food f1 = makeFood("noodle");
		System.out.println(f1.getClass().getName());
		f1.print();
		Food f2 = makeFood("chicken");
		System.out.println(f2.getClass().getName());
		f2.print();
	}
}
