/**
 * 
 */
package com.alex.testlambda.strategy;

/**  
* Title: TestDog  
* Description:   
* @author alexw  
* @date 2020年3月26日  
*/
public class TestDog {
	public static void main(String[] args){
        WhiteDog whiteDog = new WhiteDog();
        whiteDog.run();
        whiteDog.jump();
        whiteDog.color();
        BlackDog blackDog = new BlackDog();
        blackDog.run();
        blackDog.jump();
        blackDog.color();
    }
}
