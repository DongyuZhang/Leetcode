class Solution{
	public int lengthOfLongestSubstring(String s){
		Map<Character, Integer> hm = new HashMap<>(s.length());
		char[] arr = s.toCharArray();
		int start = 0, max = 0;
		for(int i = 0; i < arr.length; i++){
			if(hm.containsKey(arr[i])){
                //start can not be less than itself 
                //(case "abba" to retrieve last 'a' can retrieve duplicate b)
				start = Math.max(start, hm.get(arr[i]) + 1);
			}
			hm.put(arr[i], i);
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}