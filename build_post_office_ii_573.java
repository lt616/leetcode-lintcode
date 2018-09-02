/* 


    LintCode-Logo
    Home
    Algorithms
    AI
    VIP

    Language
    avataraxjllt

Back573. Build Post Office II

Description

Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

    You cannot pass through wall and house, but can pass through empty.
    You only build post office on an empty.

Have you met this question in a real interview?  
Example

Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0

return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
Challenge

Solve this problem within O(n^3) time.

    DifficultyHard
    Total Accepted5700
    Total Submitted20086
    Accepted Rate28%

 Show Tags
 Company
Leaderboard - Java
chris71
347ms
i_found_love
354ms
derekz2001
376ms
sezedai
377ms
wenyihu91
385ms
Discuss
No topic
Related Problems
Hard
803. Shortest Distance from All Buildings
49%
Medium
663. Walls and Gates
38%
Medium
598. Zombie in Matrix
30%
Hard
574. Build Post Office
20%
573. Build Post Office II

Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.
Example

Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0

return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
Challenge

Solve this problem within O(n^3) time.
Notice

    You cannot pass through wall and house, but can pass through empty.
    You only build post office on an empty.

[[0,1,0,0],[1,0,2,1],[0,1,0,0]]
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
     * @param grid: a 2D grid
     * @return: An integer
     */ 
    
    int min_sum = Integer.MAX_VALUE; 
    Pair[] direction = new Pair[4]; 
    
    public int shortestDistance(int[][] grid) {
        // write your code here 
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; 
        } 
        
        direction[0] = new Pair(0, -1); 
        direction[1] = new Pair(0, 1); 
        direction[2] = new Pair(-1, 0); 
        direction[3] = new Pair(1, 0); 
        
        /* if no place to put offic, return -1 */ 
        int num_houses = 0; 
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == 1) {
                    num_houses ++; 
                } 
            } 
        } 
        
        boolean is_valid = false; 
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    continue; 
                } 
                
                int[][] grid_temp = copyArray(grid); 
                int sum = searchDistanceBFS(grid_temp, i, j, num_houses); 
                if (sum == -1) {
                    continue; 
                } 
                is_valid = true; 
                min_sum = (sum < min_sum) ? sum : min_sum; 
            } 
        } 
        
        if (is_valid) {
            return min_sum; 
        } else {
            return -1;    
        } 
    } 
    
    private int searchDistanceBFS(int[][] grid, int pos_x, int pos_y, int n) {
        Queue<Pair> queue = new LinkedList(); 
        queue.offer(new Pair(pos_x, pos_y)); 
        grid[pos_x][pos_y] = 2; 
        
        int depth = 0, sum = 0; 
        while (! queue.isEmpty()) { 
            int level_size = queue.size(); 
            depth ++; 
            
            for (int i = 0;i < level_size;i ++) {
            
                Pair current = queue.poll(); 

            
                for (int j = 0;j < direction.length;j ++) {
                    int x = current.x + direction[j].x; 
                    int y = current.y + direction[j].y; 
                    
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                        continue; 
                    }
                
                    if (grid[x][y] == 0) {
                        grid[x][y] = 2; 
                        queue.offer(new Pair(x, y)); 
                    } else if (grid[x][y] == 1) {
                        grid[x][y] = 2; 

                        sum += depth; 
                        // System.out.println(pos_x + ", " + pos_y + ", " + n + ", " + sum); 
                        
                        n --; 
                        if (n == 0) {
                            return sum; 
                        } 
                        
                        /* Early terminate */ 
                        if (sum > min_sum) {
                            return sum; 
                        } 
                    }
                }
            } 
        }
        
        return -1; 
    } 
    
    private int[][] copyArray(int[][] src) {
        int[][] dst = new int[src.length][src[0].length]; 
        for (int i = 0;i < src.length;i ++) {
            for (int j = 0;j < src[0].length;j ++) {
                dst[i][j] = src[i][j]; 
            } 
        } 
        
        return dst; 
    }
} 
