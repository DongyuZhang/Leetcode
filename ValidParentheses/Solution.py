'''
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
'''
class Solution:
    def isValid(self, s: str) -> bool:
        """
        :type s: str
        :rtype: bool
        """
        dict = {')': '(', ']': '[', '}': '{'}
        stack = []
        for c in s:
        	if c in dict.values():
        		stack.append(c)
        	elif c in dict.keys() and stack != [] and dict[c] == stack[-1]:
        		stack.pop()
        	else:
        		return False
        return stack == []