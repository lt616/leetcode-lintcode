/* 
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50. 
*/ 

class Solution { 
    
    int[] roots; 
    int[] areas; 
    int num_row, num_column; 
    int max_area; 
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        } 
        
        num_row = grid.length; 
        num_column = grid[0].length; 
        max_area = 0;  
        
        roots = new int[num_row * num_column]; 
        areas = new int[num_row * num_column]; 
        
        int[] direction_x = {0, -1}; 
        int[] direction_y = {-1, 0}; 
        
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == 1) { 
                    max_area = (1 > max_area) ? 1 : max_area; 
                    
                    int pos = twoToOne(i, j); 
                    roots[pos] = pos; 
                    areas[pos] = 1; 
                    for (int m = 0;m < 2;m ++) {
                        int x = i + direction_x[m]; 
                        int y = j + direction_y[m]; 
                        if (isValid(x, y) && grid[x][y] == 1) { 
                            union(pos, twoToOne(x, y)); 
                        } 
                    } 
                } 
            } 
        } 
        
        return max_area; 
    } 
    
    private boolean isValid(int x, int y) {
        if (x < 0 || x >= num_row || y < 0 || y >= num_column) {
            return false; 
        } 
        
        return true; 
    }
    
    private int twoToOne(int x, int y) {
        return x * num_column + y; 
    }
    
    private void union(int a, int b) { 
        int root_a = find(a); 
        int root_b = find(b); 
        
        if (root_a == root_b) {
            return; 
        } 
        
        roots[root_a] = root_b; 
        areas[root_b] += areas[root_a]; 
        
        max_area = (areas[root_b] > max_area) ? areas[root_b] : max_area; 
    } 
    
    private int find(int a) {
        if (a == roots[a]) {
            return a; 
        } 
        
        return roots[a] = find(roots[a]); 
    }
} 
