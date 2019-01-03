class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
          return res;
        int width = matrix[0].length;
        int height = matrix.length;
        int top = 0, bottom = heigh - 1, left = 0, right = width - 1;

        while(left<=right && top <= bottom){
          for(int i = left; i < right; i++){
            res.add(matrix[top][i]);
          }
          top++;
          for(int i = top; i < bottom; i++){
            res.add(matrix[i][right]);
          }
          right--;
          for(int i = right; i > left; i--){
            res.add(matrix[bottom][i]);
          }
          bottom--;
          for(int i = bottom; i > top; i--){
            res.add(matrix[i][left]);
          }
          left++;
        }
        return res;
    }
}
