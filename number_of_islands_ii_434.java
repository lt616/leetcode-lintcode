/* 
434. Number of Islands II

Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.
Example

Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

return [1,1,2,2].
Notice

0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
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

/* 
	EASY WRONG POINTS: 
		1. In union-find, when connecting two distinct unions, make sure that connect 
		ROOT of one union to the other. 
		2. Bound case: repeat elements. 
		3. Counting isolated unions: 
			count ++ when add a new element; 
			count -- when connect two distinct unions. 
*/ 

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */ 
    
    int num_island = 0; 
    int num_surroundings = 0; 
    int num_column; 
    
    int[] roots; 
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here 
        
        List<Integer> res = new ArrayList(); 
        
        if ((n == 0 && m == 0) || operators == null || operators.length == 0) {
            return res; 
        } 
        
        num_column = m; 
        
        Point[] directions = new Point[4]; 
        directions[0] = new Point(0, -1); 
        directions[1] = new Point(0, 1); 
        directions[2] = new Point(-1, 0); 
        directions[3] = new Point(1, 0); 
        
        Set<Integer> set = new HashSet(); 
        
        roots = new int[n * m]; 
        
        for (Point p : operators) { 
            int current_index = twodTo1d(p.x, p.y); 
            if (set.contains(current_index)) { 
                res.add(num_island); 
                continue; 
            }
            
            roots[current_index] = current_index; 
            
            num_island ++; 
            
            for (int i = 0;i < 4;i ++) { 
                int x = p.x + directions[i].x; 
                int y = p.y + directions[i].y; 
                
                int index = twodTo1d(x, y); 
                if (x < 0 || x >= n || y < 0 || y >= m || ! set.contains(index)) {
                    continue; 
                } 
                
                connect(current_index, index); 
            } 
            
            res.add(num_island); 
            set.add(current_index); 
        } 
        
        return res; 
    } 
    
    private int twodTo1d(int x, int y) {
        return x * num_column + y; 
    }
    
    private void connect(int a, int b) {
        int root_a = find(a); 
        int root_b = find(b); 
        
        if (root_a == root_b) {
            return; 
        } 
        
        num_island --; 
        
        roots[root_a] = root_b; 
    } 
    
    private int find(int index) {
        if (roots[index] == index) {
            return index; 
        } 
        
        return roots[index] = find(roots[index]); 
    } 
} 
