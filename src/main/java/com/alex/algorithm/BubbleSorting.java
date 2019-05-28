/**
 * 
 */
package com.alex.algorithm;

/**  
* Title: BubbleSorting  
* Description:   
* @author wangzi  
* @date 2019年2月26日  
*/
public class BubbleSorting {
	public static void main(String[] args) {
		int a[] = new int[] { 38, 49, 65, 97, 76, 13, 27, 49, 20 };
		bubbleSort(a);
		for(int i:a) {
			System.out.println(i);
		}
	}
 
	public static void bubbleSort(int a[]) {
		for(int i=0;i<a.length;i++) {
			for(int j=i;j>0;j--) {
				if(a[j]<a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
}
