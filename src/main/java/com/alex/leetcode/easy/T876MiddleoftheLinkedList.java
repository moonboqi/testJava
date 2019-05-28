/**
 * 
 */
package com.alex.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
* Title: T876MiddleoftheLinkedList  
* Description:   
* @author wangzi  
* @date 2018年8月7日  
* Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Note:

The number of nodes in the given list will be between 1 and 100.

*/
public class T876MiddleoftheLinkedList {
	@Test
	public void test1() throws Exception {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		middleNode(head);
	}
	public ListNode middleNode(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode temp = head;
		int i=0;
		while(head.next!=null) {
			if(i%2==0) {
				temp = temp.next;
			}
			i++;
			head = head.next;
		}
        return temp;
    }
}
