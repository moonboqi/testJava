/**
 * 
 */
package com.alex.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* Title: T867TransposeMatrix  
* Description:   
* @author wangzi  
* @date 2018年8月7日  
* Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column 
indices of the matrix.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
*/
public class T867TransposeMatrix {
	@Test
	public void test1() throws Exception {
//		int[][] A = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] A = new int[][] {{1,2,3},{4,5,6}};
		int[][] tran = transpose(A);
		tran.getClass();
	}
	public int[][] transpose(int[][] A) {
		if(A==null) {
			return null;
		}
		int[][] B = new int[A[0].length][A.length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				B[j][i] = A[i][j];
			}
		}
        return B; 
    }
}
