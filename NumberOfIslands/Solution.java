class Solution{
	public int numIslands(char[][] grid){
		if(grid == null || grid.length == 0)
			return 0;
		int res = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] != '0'){
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}


	private void dfs(char[][] grid, int x, int y){
		if(grid.length == 0)
			return;
		int m = grid.length, n = grid[0].length;
		if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0')
			return;
		grid[x][y] = '0';
		dfs(grid, x-1, y);
		dfs(grid, x, y-1);
		dfs(grid, x+1, y);
		dfs(grid, x, y+1);
	}


	public int numIsLands_BFS(char[][] grid){
		if(grid == null || grid.length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		int res = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] != '0'){
					res++;
					grid[i][j] = '0';
					Queue<Integer> nodes = new LinkedList<>();
					nodes.add(i * n + j);
					while(!nodes.isEmpty()){
						int id = nodes.remove();
						int row = id/n;
						int col = id%n;
						if(row >= 1 && grid[row-1][col] == '1'){
							nodes.add((row-1)*n+col);
							grid[row-1][col] = '0';
						}
						if(row < m-1 && grid[row+1][col] == '1'){
							nodes.add((row+1)*n+col);
							grid[row+1][col] = '0';
						}
						if(col >= 1 && grid[row][col-1] == '1'){
							nodes.add(id-1);
							grid[row][col-1] = '0';
						}
						if(col < n-1 && grid[row][col+1] == '1'){
							nodes.add(id+1);
							grid[row][col+1] = '0';
						}
					}
				}
			}
		}
		return res;
	}




    public int numIslands_UnionFind(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    int index = i*n+j;
                    if(i+1<m && grid[i+1][j] == '1')
                        uf.union(index, index+n);
                    if(j+1<n && grid[i][j+1] == '1')
                        uf.union(index, index+1);
                }
            }
        }
        return uf.getCount();
    }
    class UnionFind{
		int count;
		int[] parent;
		int[] rank;

		public UnionFind(char[][] grid){
			count = 0;
			if(grid != null && grid.length != 0){
				int m = grid.length, n = grid[0].length;
				parent = new int[m * n];
				rank = new int[m * n];
				for(int i = 0; i < m; i++){
					for(int j = 0; j < n; j++){
						int index = i * n + j;
						if(grid[i][j] == '1'){
							parent[index] = index;
							count++;
						}
						rank[index] = 0;
					}
				}
			}
		}

		public int find(int i){
			if(parent[i] != i)
				parent[i] = find(parent[i]);
			return parent[i];
		}

		public void union(int x, int y){
			int rootx = find(x);
			int rooty = find(y);
			if(rooty != rootx){
				if(rank[rootx] > rank[rooty])
					parent[rooty] = rootx;
				else if(rank[rootx] < rank[rooty])
					parent[rootx] = rooty;
				else{
					parent[rooty] = rootx;
					rank[rootx] += 1;
				}
				count--;
			}
		}

		public int getCount(){
			return count;
		}
	}


}