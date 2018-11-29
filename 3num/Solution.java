class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      for(int i = 0; i < nums.length - 2; i++){
        if(i == 0 || i != 0 && nums[i]!=nums[i-1]){
          int start = i+1, end = nums.length-1, target = -nums[i];
          while(start < end){
            if(start == (i+1) || start != (i+1) && nums[start-1] != nums[start]){
              if(nums[start]+nums[end] == target){
                List<Integer> t = new ArrayList<>();
                t.add(-target);
                t.add(nums[start]);
                t.add(nums[end]);
                res.add(t);
                start++;
                end--;
              }
              else if(nums[start]+nums[end] < target)
                start++;
              else
                end--;
            }
            else
              start++;
          }
        }
      }
      return res;
    }
}
