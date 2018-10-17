
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
class Solution{
	public int[] twoSum_brute_force(int[] nums, int target){
		int[] res = new int[2];
		for(int i = 0; i < nums.length; i++){
			for(int j = i+1; j < nums.length; j++){
				if(nums[i]+nums[j] == target){
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}

	public int[] twoSum_hashmap(int[] nums, int target){
		int[] res = new int[2];
		Map<Integer, Integer> hm = new HashMap<>(nums.length);
		hm.put(nums[0], 0);
		for(int i = 1; i < nums.length; i++){
			if(hm.containsKey(target - nums[i])){
				res[0] = hm.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			hm.put(nums[i], i);
		}
		return res;
	}

}