/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: T938RangeSumofBST  
* Description:   
* @author wangzi  
* @date 2019年6月4日  
* Given the root node of a binary search tree, return the sum of values of all nodes with value 
* between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.
*/
public class T938RangeSumofBST {
	@Test
	public void test1() throws Exception {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(7);
		TreeNode t7 = new TreeNode(18);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t7;
		System.out.println(rangeSumBST(t1, 7, 15));
	}
	
	@Test
	public void test2() throws Exception {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(13);
		TreeNode t7 = new TreeNode(18);
		TreeNode t8 = new TreeNode(1);
		TreeNode t10 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		t5.left = t10;
		System.out.println(rangeSumBST(t1, 6, 10));
	}
	
	int sum = 0;
	public int rangeSumBST(TreeNode root, int L, int R) {
		if(root!=null) {
			if(root.val>=L && root.val<=R) {
				sum += root.val;
				rangeSumBST(root.left, L, R);
				rangeSumBST(root.right, L, R);
			}else if(root.val < L) {
				rangeSumBST(root.right, L, R);
			}else {
				rangeSumBST(root.left, L, R);
			}
		}
        return sum;
    }
}
