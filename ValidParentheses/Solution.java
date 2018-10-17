/*
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
*/

import java.util.*;
class Solution{

	public boolean isValid_map(String s){
		if(s.length() % 2 != 0)
			return false;
		//Init Map
		Map<Character, Character> hm = new HashMap<>(s.length());
		hm.put(')', '(');
		hm.put(']', '[');
		hm.put('}', '{');
		//Init Stack
		Stack<Character> st = new Stack<>();
		char[] ch_arr = s.toCharArray();
		for(char c : ch_arr){
			if(!hm.containsKey(c))
				st.push(c);
			else if(!st.empty() && hm.get(c) == st.peek())
				st.pop();
			else
				return false;
		}
		return st.empty();
	}

	public boolean isValid_set(String s){
		Stack<Character> st = new Stack<>();
		if(s.length() % 2 != 0)
			return false;
		char[] ch_arr = s.toCharArray();
		for(int i = 0; i < ch_arr.length; i++){
			if(isLeftPart(ch_arr[i]))
				st.push(ch_arr[i]);
			else if(isRightPart(ch_arr[i]) && !st.empty() && complement(st.peek(), ch_arr[i]))
				st.pop();
			else
				return false;
		}
		return st.empty();
	}

	private boolean complement(char a, char b){
		return a=='(' && b==')' ||
			   a=='[' && b==']' ||
			   a=='{' && b=='}';
	}

	private boolean isLeftPart(char c){
		return c=='(' ||
			   c=='[' ||
			   c=='{';
	}

	private boolean isRightPart(char c){
		return c==')' ||
			   c==']' ||
			   c=='}';
	}

}