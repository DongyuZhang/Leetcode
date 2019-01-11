class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      if(grid.length == 0)
        return 0;
      int max = 0;
      for(int x = 0; x < grid.length; x++){
        for(int y = 0; y < grid[x].length; y++){
          if(grid[x][y] == 1){
            int temp = dfs(grid, x, y);
            max = Math.max(max, temp);
          }
        }
      }
      return max;
    }

    private int dfs(int[][] grid, int x, int y){
      if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length)
        return 0;
      if(grid[x][y] == 0)
        return 0;
      int res = 1;
      grid[x][y] = 0;
      res += dfs(grid, x-1, y);
      res += dfs(grid, x+1, y);
      res += dfs(grid, x, y-1);
      res += dfs(grid, x, y+1);
      return res;
    }
}
