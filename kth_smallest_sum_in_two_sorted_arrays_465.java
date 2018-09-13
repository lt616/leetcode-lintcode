/* 
465. Kth Smallest Sum In Two Sorted Arrays

Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
Example

Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.
Challenge

Do it in either of the following time complexity:

    O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
    O( (m + n) log maxValue). where maxValue is the max number in A and B.
*/ 

class Point {
    int val; 
    int x; 
    int y; 
    
    public Point(int val, int x, int y) {
        this.val = val; 
        this.x = x; 
        this.y = y; 
    } 
} 

public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here 
        
        if (A == null || A.length == 0 || B == null || B.length == 0 || k == 0) {
            return -1; 
        } 
        
        int[][] sum_matrix = new int[A.length][B.length]; 
        boolean[][] visited = new boolean[A.length][B.length]; 
        
        Queue<Point> pq = new PriorityQueue(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.val - p2.val; 
            } 
        }); 
        
        pq.offer(new Point(A[0] + B[0], 0, 0)); 
        visited[0][0] = true; 

        Point current = null;         
        while (k > 0) {
            current = pq.poll(); 
            
            int i = current.x + 1, j = current.y; 
            if (isValid(A, B, visited, i, j) && ! isValid(A, B, visited, i - 1, j) && ! isValid(A, B, visited, i, j - 1)) {
                pq.offer(new Point(A[i] + B[j], i, j)); 
                visited[i][j] = true; 
            } 
            
            i = current.x;
            j = current.y + 1; 
            if (isValid(A, B, visited, i, j) && ! isValid(A, B, visited, i - 1, j) && ! isValid(A, B, visited, i, j - 1)) {
                pq.offer(new Point(A[i] + B[j], i, j)); 
                visited[i][j] = true; 
            } 
            
            k --; 
        } 
        
        return (current != null) ? current.val : -1; 
    } 
    
    private boolean isValid(int[] A, int[] B, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= B.length || visited[i][j]) {
            return false; 
        } 
        
        return true; 
    }
} 
