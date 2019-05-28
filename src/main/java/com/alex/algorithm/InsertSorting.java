/**
 * 
 */
package com.alex.algorithm;

/**
 * Title: InsertSorting Description:
 * 
 * @author wangzi
 * @date 2019年2月26日
 */
public class InsertSorting {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 5, 4, 6, 2, 7, 9, 8 };
		selectorSort(array);
		for(int i: array) {
			System.out.println(i);
		}
	}

	public static void selectorSort(int array[]) {
		for(int i=1; i<array.length; i++) {
			int num = array[i];
			for(int j=i-1; j>0; j--) {
				if(num<array[j]) {
					array[j+1] = array[j];
				}else {
					break;
				}
				array[j] = num;
			}
		}
	}
}