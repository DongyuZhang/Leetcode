
/*
  THe idea is that when we use binary search for this rotated array, we know
  that either left or right part of the array is in order. If the target is
  in the interval of the in-order part, we search it in that part. Otherwise,
  we search it in the other part.

  Note: a middle element should be smaller than(or equal to) the start and the end
  or bigger than(or equal to) the start and the end because end->start is in ascending order
*/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
          int middle = (start+end)/2;
          if(target == nums[middle])
            return middle;
          // left part in order
          if(nums[middle] >= nums[start]){
            // target in left part
            if(nums[start] <= target && target < nums[middle])
              end = middle - 1;
            else
              start = middle + 1;
          }
          // right part in order
          else{
            if(nums[middle] < target && target <= nums[end])
              start = middle + 1;
            else
              end = middle - 1;
          }
        }
        return -1;
    }
}
