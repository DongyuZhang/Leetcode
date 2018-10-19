# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummyRoot = ListNode(0)
        curr = dummyRoot
        carry = 0
        while l1 != None or l2 != None:
        	x = 0 if l1 == None else l1.val
        	y = 0 if l2 == None else l2.val
        	sum = x + y + carry
        	pop = sum % 10
        	carry = math.floor(sum / 10)
        	curr.next = ListNode(pop);
        	curr = curr.next
        	if l1 != None:
        		l1 = l1.next;
        	if l2 != None:
        		l2 = l2.next;
        if carry != 0:
        	curr.next = ListNode(carry)
        return dummyRoot.next 



class ListNode():
	"""docstring for ListNode"""
	def __init__(self, x):
		self.val = x
		self.next = None
		