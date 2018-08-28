/* 
611. Knight Shortest Path

Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
Return -1 if knight can not reached.
Example

[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1

Clarification

If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)

Notice

source and destination must be empty.
Knight can not enter the barrier.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Memory exceed limit: Memory limit exceeded usually caused by you create a 2D-array which is unnecessary.
		It's not necessary to keep a is_visited array. 
		2. After push a next point into queue, mark it as visited in case of repeat counting.  
*/ 

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
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
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here 
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; 
        } 
        
        Queue<Point> queue = new LinkedList(); 
        queue.add(source); 
        
        Point[] steps = new Point[8]; 
        steps[0] = new Point(1, 2);  
        steps[1] = new Point(1, -2); 
        steps[2] = new Point(-1, 2); 
        steps[3] = new Point(-1, -2); 
        steps[4] = new Point(2, 1); 
        steps[5] = new Point(2, -1); 
        steps[6] = new Point(-2, 1); 
        steps[7] = new Point(-2, -2); 
        
        int depth = -1; 
        while (! queue.isEmpty()) { 
            int level_size = queue.size(); 
            depth ++; 
            for (int i = 0;i < level_size;i ++) {
                Point current = queue.poll(); 
                grid[current.x][current.y] = true; 
            
                if (current.x == destination.x && current.y == destination.y) {
                    return depth; 
                } 
                
                for (int j = 0;j < steps.length;j ++) {
                    Point next = new Point(current.x + steps[j].x, current.y + steps[j].y); 
                    if (0 <= next.x && next.x < grid.length && 0 <= next.y && next.y < grid[0].length && ! grid[next.x][next.y]) {
                        queue.offer(next); 
                        grid[next.x][next.y] = true; 
                    } 
                }
            } 
        } 
        
        return -1; 
    } 
} 
