class Solution {


    public int maxArea(int[] height) {
      int left = 0, right = height.length - 1, res = 0;
      while(left < right){
        res = Math.max(res, Math.min(height[i], height[j])*(right - left));
        if(height[left] < height[right])
          left++;
        else
          right--;
      }
      return res;
    }



    public int maxArea_brutesearch(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++){
          for(int j = i+1; j < height.length; j++){
            res = Math.max(res, (j-i)*Math.min(height[i], height[j]));
          }
        }
        return res;
    }
}
