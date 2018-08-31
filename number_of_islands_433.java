/* 
433. Number of Islands

Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.
Example

Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]

return 3.
*/ 


/* Solution 01: BFS */ 
class Pair {
    int x; 
    int y; 
    public Pair(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here 
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        } 
        
        Queue<Pair> queue = new LinkedList(); 
        int[] direction_x = new int[4]; 
        direction_x[0] = 0; 
        direction_x[1] = 0; 
        direction_x[2] = 1; 
        direction_x[3] = -1; 
        
        int[] direction_y = new int[4]; 
        direction_y[0] = 1; 
        direction_y[1] = -1; 
        direction_y[2] = 0; 
        direction_y[3] = 0; 
        
        int num_of_island = 0; 
        while (true) { 
            Pair next_island = searchNextIsland(grid); 
            
            if (next_island == null) {
                return num_of_island; 
            } else {
                queue.offer(next_island); 
            } 
            num_of_island ++;    
            
            while (! queue.isEmpty()) {
                Pair current = queue.poll(); 
                for (int i = 0;i < 4;i ++) {
                    int x = current.x + direction_x[i]; 
                    int y = current.y + direction_y[i]; 
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || ! grid[x][y]) { 
                        continue; 
                    } 
                    grid[x][y] = false; 
                    queue.offer(new Pair(x, y)); 
                } 
            } 
        } 
    } 
    
    private Pair searchNextIsland(boolean[][] grid) {
        Pair res = null; 
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j]) { 
                    grid[i][j] = false; 
                    return new Pair(i, j);
                }  
            } 
        } 
        
        return res; 
    }
} 


/* Solution 02: union-find */ 
