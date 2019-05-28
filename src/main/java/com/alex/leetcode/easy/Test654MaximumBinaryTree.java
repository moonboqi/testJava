/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: Test654MaximumBinaryTree  
* Description:   
* @author wangzi  
* @date 2018年8月2日  
* Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
*/
public class Test654MaximumBinaryTree {
	
	@Test
	public void test1() throws Exception {
		int[] nums = new int[] {3,2,1,6,0,5};
		TreeNode max = constructMaximumBinaryTree(nums);
		System.out.println(max.val);
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Integer maxIndex = getMax(nums);
		if(maxIndex == null) {
			return null;
		}
		TreeNode root = new TreeNode(nums[maxIndex]);
		int[] leftArr = getArray(nums, 0, maxIndex);
		int[] rightArr = getArray(nums, maxIndex+1, nums.length);
		setNeighbNodes(root, leftArr, rightArr);
        return root;
    }
	private void setNeighbNodes(TreeNode root, int[] leftArr, int[] rightArr) {
		//设置左节点
		if(leftArr!=null && leftArr.length>0) {
			Integer leftIndex = getMax(leftArr);
			if(leftIndex!=null) {
				TreeNode left = new TreeNode(leftArr[leftIndex]);
				root.left = left;
				int[] leftsubL = getArray(leftArr, 0, leftIndex);
				int[] rightsubL = getArray(leftArr, leftIndex+1, leftArr.length);
				setNeighbNodes(left, leftsubL, rightsubL);
			}
			
		}
		//设置左节点
		if(rightArr!=null && rightArr.length>0) {
			Integer rightIndex = getMax(rightArr);
			if(rightIndex!=null) {
				TreeNode right = new TreeNode(rightArr[rightIndex]);
				root.right = right;
				int[] leftsubR = getArray(rightArr, 0, rightIndex);
				int[] rightsubR = getArray(rightArr, rightIndex+1, rightArr.length);
				setNeighbNodes(right, leftsubR, rightsubR);
			}
			
		}
	}

	private Integer getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		Integer index = null;
		if(nums!=null && nums.length>0) {
			for(int i=0; i<nums.length; i++) {
				if(nums[i]>max) {
					max = nums[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	private int[] getArray(int[] nums, int start, int end) {
		if(end == start) {
			return null;
		}
		int[] arr = new int[end - start];
		for(int i=0; i<end-start; i++) {
			arr[i] = nums[start+i];
		}
		return arr;
	}
}
