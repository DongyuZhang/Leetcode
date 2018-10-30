class Solution:
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        def sink(grid, i, j):
        	if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
        		grid[i][j] = '0'
        		map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
        		return 1
        	return 0
        return sum(sink(grid, i, j) for i in range(len(grid)) for j in range(len(grid[i])))
def numIslands(self, grid):
    def sink(i, j):
        if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
            grid[i][j] = '0'
            #https://stackoverflow.com/questions/13623634/python-3-map-function-is-not-calling-up-function
            # map() in python3 returns iterator. Won't be executed until you call each item
            # change map() -> list(map())
            list(map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1)))
            return 1
        return 0
    return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))
