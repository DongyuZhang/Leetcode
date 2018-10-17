/*
Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution{
	/*
	Denote: dp[i] is the max sum of subarray ending with nums[i]
	What we want is now: Max{dp[i]} 0<=i<nums.length
	dp[0] = nums[0]
	dp[i] = max{dp[i-1]+nums[i], nums[i]}
	*/
	public int maxSubArray_DP(int[] nums){
		if(nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = dp[0];
		for(int i = 1; i < nums.length; i++){
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}