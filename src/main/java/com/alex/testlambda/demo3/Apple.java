/**
 * 
 */
package com.alex.testlambda.demo3;

import java.util.ArrayList;
import java.util.List;

/**  
* Title: Apple  
* Description:   
* @author alexw  
* @date 2020年3月26日  
*/
public class Apple {
    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
    
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        Apple apple1 = new Apple("red", 100);
        Apple apple2 = new Apple("green", 200);
        Apple apple3 = new Apple("red", 300);
        Apple apple4 = new Apple("red", 150);
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
    }
}


