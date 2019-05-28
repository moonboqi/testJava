/**
 * 
 */
package com.alex.algorithm;

/**  
* Title: MergeSort  
* Description:   
* @author wangzi  
* @date 2019年2月28日  
*/
public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 4, 3, 6, 10, 8, 7, 5, 11, 14, 13, 20,
				19 };
		// 这里，考虑把每一次都要用的数组，用一个早就定义好的数组来定义
		// 这样，可以很大程度减少递归调用过程中的内存占用
		int[] newArray = new int[array.length];
 
		sort(newArray, array, 0, array.length - 1);
		for (int ele : array) {
			System.out.print(ele + " ");
		}
	}
	
	public static void sort(int[] newArray, int[] array, int low, int high) {
		// 按照拆分的逻辑，现在先把整个数组拆成两部分，mid作为数组的中间值，作为划分标准
		int mid = (low + high) / 2;
		// 这个限定条件是什么意思呢？因为low肯定不会大于high的，最多是等于，等于意味着什么呢，那就是单个元素
		// 到这个时候，就是拆分到了最底层，接下来，就开始归并了
		// 而如果没拆分到单个元素，那就继续拆分。
		if (low < high) {
			// 如果还可以继续拆分的话，递归调用本逻辑，先对左边的数据进行排序
			sort(newArray, array, low, mid);
			// 递归调用右侧的排序逻辑
			sort(newArray, array, mid + 1, high);
			// 左右归并
			mergeSort(low, high, mid, newArray, array);
		}
	}

	public static void mergeSort(int begin, int end, int mid, int[] tempArray,
			int[] array) {
		// 这里,不需要新建数组了，直接用最先前创建的新数组
		// 然后把两个序列融合在一起;采用遍历的方式
		int index = begin;
		int i = begin;
		int j = mid + 1;
		// 如果两个数列都没有遍历到末尾，谁小谁就先进入temp中
		// 注意，同时temp的索引也要移动
		while (i <= mid && j <= end) {
			if (array[i] < array[j]) {
				tempArray[index++] = array[i++];
			} else {
				tempArray[index++] = array[j++];
			}
		}
		while (i <= mid) {
			tempArray[index++] = array[i++];
		}
		while (j <= end) {
			tempArray[index++] = array[j++];
		}
		for (int k = begin; k <= end; k++) {
			array[k] = tempArray[k];
		}
	}

}
