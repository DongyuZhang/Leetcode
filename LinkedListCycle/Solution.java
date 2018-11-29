/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
      if(head == null || head.next == null)
        return false;
      ListNode slow = head.next, fast = head.next.next;
      while(fast != null && fast != slow){
        slow = slow.next;
        fast = fast.next;
        if(fast != null)
          fast = fast.next;
      }
      return fast != null;
    }
}
