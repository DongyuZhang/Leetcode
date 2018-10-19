/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	int pop = 0, toAdd = 0, temp_sum = 0;
    	ListNode head1 = ListNode(0), head2 = ListNode(0);
    	head1.next = l1;
    	head2.next = l2;
    	ListNode res = l1;
    	while(head1.next != null && head2.next != null){
    		temp_sum = head1.next.val + head2.next.val + toAdd;
    		pop = temp_sum % 10;
    		toAdd = temp_sum / 10;
    		head1.next.val = pop;
    		head1 = head1.next;
    		head2 = head2.next;
    	}
    	if(head1.next == null){
    		head1.next = head2.next;
    	}
    	while(head1.next != null && toAdd != 0){
    		temp_sum = head1.next.val + toAdd;
    		pop = temp_sum % 10;
    		toAdd = temp_sum / 10;
    		head1.next.val = pop;
    		head1 = head1.next;
    	}
    	if(toAdd != 0)
    		head1.next = new ListNode(toAdd);
    	return res;
    }

    public ListNode addTwoNumbers_newList(ListNode l1, ListNode l2){
    	ListNode dummyHead = new ListNode(0);
    	ListNode curr = dummyHead;
    	int carry = 0;
    	while(l1!=null || l2!=null){
    		int x = l1 == null? 0 : l1.val;
    		int y = l2 == null? 0 : l2.val;
    		int sum = x + y + carry;
    		int pop = sum % 10;
    		curr.next = new ListNode(pop);
    		curr = curr.next;
    		carry = sum / 10;
    		if(l1 != null)
    			l1 = l1.next;
    		if(l2 != null)
    			l2 = l2.next;
    	}
    	if(carry != 0){
    		curr.next = new ListNode(carry);
    	}
    	return dummyHead.next;
    }

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

}

