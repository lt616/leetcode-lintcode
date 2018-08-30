/* 
598. Zombie in Matrix

Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
Example

Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0

return 2
*/ 


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
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here 
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        } 
        
        Pair[] direction = new Pair[4]; 
        direction[0] = new Pair(-1, 0); 
        direction[1] = new Pair(1, 0); 
        direction[2] = new Pair(0, -1); 
        direction[3] = new Pair(0, 1); 
        
        Queue<Pair> queue = new LinkedList(); 
        int num_row = grid.length, num_column = grid[0].length; 
        int non_people = 0; 
        
        for (int i = 0;i < num_row;i ++) {
            for (int j = 0;j < num_column;j ++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Pair(i, j)); 
                    grid[i][j] = 2;  
                } 
                if (grid[i][j] == 2) { 
                    non_people ++; 
                }
            } 
        } 
        
        int num_days = -1; 
        while (! queue.isEmpty()) { 
            int level_size = queue.size(); 
            num_days ++; 
            
            for (int i = 0;i < level_size;i ++) {
                Pair current = queue.poll(); 
                for (int j = 0;j < direction.length;j ++) {
                    int x = current.x + direction[j].x; 
                    int y = current.y + direction[j].y; 
                    
                    if (x >= 0 && x < num_row && y >= 0 && y < num_column && grid[x][y] != 2) {
                        queue.offer(new Pair(x, y)); 
                        grid[x][y] = 2; 
                        non_people ++; 
                    } 
                } 
            } 
        } 
        
        /* Check if any people survive */ 
        return (non_people == num_row * num_column) ? num_days : -1; 
    } 
} 
