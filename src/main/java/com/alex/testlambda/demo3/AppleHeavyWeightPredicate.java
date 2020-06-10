/**
 * 
 */
package com.alex.testlambda.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: aa Description:
 * 
 * @author alexw
 * @date 2020年3月26日
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

	public static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : apples) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
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
		// 使用匿名类
		List<Apple> redApples = filterApples(apples, new ApplePredicate() {
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});

		List<Apple> result = filterApples(apples, (Apple apple) -> "red".equals(apple.getColor()));
	}
}
