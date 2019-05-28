/**
 * 
 */
package com.alex.leetcode.easy;

import org.junit.Test;

/**
 * Title: T814BinaryTreePruning Description:
 * 
 * @author wangzi
 * @date 2018年8月6日 We are given the head node root of a binary tree, where
 *       additionally every node's value is either a 0 or a 1.
 * 
 *       Return the same tree where every subtree (of the given tree) not
 *       containing a 1 has been removed.
 * 
 *       (Recall that the subtree of a node X is X, plus every node that is a
 *       descendant of X.)
 * 
 *       Example 1: Input: [1,null,0,0,1] Output: [1,null,0,null,1]
 */
public class T814BinaryTreePruning {
	@Test
	public void test1() throws Exception {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(0);
		root.left = left;
		TreeNode pruneTree = pruneTree(root);
		System.out.println(root);
		System.out.println(left);
	}

	public TreeNode pruneTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if(getResultOfNode(root.left)) {
			root.left = null;
		}
		if(getResultOfNode(root.right)) {
			root.right = null;
		}
		return root;
	}
	public boolean getResultOfNode(TreeNode root) {
		if((root!=null) && (root.left==null) && (root.right==null) && (root.val == 0)) {
			return true;
		}
		return false;
	}
}
