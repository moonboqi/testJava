/**
 * 
 */
package com.alex.testlambda.strategy;

/**  
* Title: DollDog  
* Description:   
* @author alexw  
* @date 2020年3月26日  
*/
public class DollDog extends Dog {

	@Override
	public void run() {
	    System.out.println("玩具狗不会跑");
	}

	@Override
	public void jump() {
	    System.out.println("玩具狗不会跳");
	}
	
    @Override
    public void color() {
        System.out.println("五颜六色");
    }
    
    public static void main(String[] args) {
    	DollDog dollDog = new DollDog();
    	dollDog.run();
    	dollDog.jump();
    	dollDog.color();
	}
}




