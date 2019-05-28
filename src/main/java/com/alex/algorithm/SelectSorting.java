/**
 * 
 */
package com.alex.algorithm;

/**  
* Title: SelectSorting  
* Description:   
* @author wangzi  
* @date 2019年2月26日  
*/
public class SelectSorting {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 13, 15, 11 };
		selectSort(array);
		for (int ele : array) {
			System.out.print(ele + " ");
		}
	}
	public static void selectSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int min = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j]<array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
