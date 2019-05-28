/**
 * 
 */
package com.alex.algorithm;

/**  
* Title: QuickSorting  
* Description:   
* @author wangzi  
* @date 2019年2月26日  
*/
public class QuickSorting {
	public static void main(String[] args) {
		int[] array = new int[] { 45, 38, 65, 97, 76, 13, 27, 49, 20, 54,47 };
		sort(array, 0, array.length - 1);
		for (int ele : array)
			System.out.print(ele + "  ");
	}
	public static void sort(int[] array, int begin, int end) {
		if(begin<end) {
			int partition = quickSort(array, begin, end);
			sort(array, 0, partition-1);
			sort(array, partition+1, end);
		}
		
		
	}
	public static int quickSort(int[] array, int begin, int end) {
		int base = array[begin];
		//标记base所在的坐标
		int index = begin;
		while(begin<end) {
			while(array[end]>base && begin<end) {
				end--;
			}
			index = changeNum(array, index, end);
//			array[begin] = array[end];
			while(array[begin]<base && begin<end) {
				begin++;
			}
			index = changeNum(array, index, begin);
//			array[end]=array[begin];
		}
//		array[begin]=base;
		return index;
	}
	
	public static int changeNum(int[] array, int index, int other) {
		int temp = array[index];
		array[index] = array[other];
		array[other] = temp;
		return other;
	}
}
