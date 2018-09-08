/* 
401. Kth Smallest Number in Sorted Matrix

Find the kth smallest number in at row and column sorted matrix.
Example

Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]

return 5
Challenge

Solve it in O(k log n) time where n is the bigger one between row size and column size.
*/ 

class Point {
    int val; 
    int x; 
    int y; 
    
    public Point(int x, int y, int val) {
        this.val = val; 
        this.x = x; 
        this.y = y; 
    } 
} 

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here 
        
        Queue<Point> pq = new PriorityQueue(new Comparator<Point>() {
                            public int compare(Point p1, Point p2) {
                                return p1.val - p2.val; 
                            } 
                        }); 
        int current_x = 0, current_y = 0; 
        pq.offer(new Point(current_x, current_y, matrix[current_x][current_y])); 
        
        boolean[][] is_visited = new boolean[matrix.length][matrix[0].length]; 
        is_visited[current_x][current_y] = true; 
        
        int[] direction_x = new int[2]; 
        int[] direction_y = new int[2]; 
        
        direction_x[0] = 0; 
        direction_x[1] = 1; 
        direction_y[0] = 1; 
        direction_y[1] = 0; 
        
        while (k > 0) { 
            Point current = pq.poll(); 
            if (k == 1) {
                return current.val; 
            }
            
            for (int i = 0;i < 2;i ++) {
                int x = current.x + direction_x[i]; 
                int y = current.y + direction_y[i]; 
                
                if(! validatePoint(matrix, is_visited, x, y)) {
                    continue; 
                } 
                
                if (validatePoint(matrix, is_visited, x, y - 1) || validatePoint(matrix, is_visited, x - 1, y)) { 
                    continue; 
                }

                pq.offer(new Point(x, y, matrix[x][y])); 
                is_visited[x][y] = true; 
            } 
            
            k --; 
        } 
        
        return -1; 
    } 
    
    private boolean validatePoint(int[][] matrix, boolean[][] is_visited, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || is_visited[x][y]) {
            return false; 
        } 
        
        return true; 
    }
} 
