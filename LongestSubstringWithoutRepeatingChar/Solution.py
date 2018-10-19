class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        non_repeat_list = []
        max_length = 0
        for x in s:
        	if x in non_repeat_list:
        		non_repeat_list = non_repeat_list[non_repeat_list.index(x)+1:]
        	non_repeat_list.append(x)
        	max_length = max(max_length, len(non_repeat_list))
        return max_length