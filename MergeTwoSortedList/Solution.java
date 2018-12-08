class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
          return l1 == null ? l2 : l1;
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead, curr1 = l1, curr = l2;
        while(curr1 != null && curr2 != null){
          if(curr1.val < curr2.val){
            prev.next = curr1;
            curr1 = curr1.next;
          }
          else{
            prev.next = curr2;
            curr2 = curr2.next;
          }
          prev = prev.next;
        }
        if(curr1 != null){
          prev.next = curr1;
        }
        if(curr2 != null){
          prev.next = curr2;
        }
        return fakeHead.next;
    }


    class ListNode{
      int val;
      ListNode next;
      ListNode(int val){ this.val = val;}
    }
}
